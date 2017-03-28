package api.utils;


import com.jayway.restassured.RestAssured;
import com.jayway.restassured.config.SSLConfig;
import load.GatewaySslSocketFactory;
import load.SignAWSv4;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.net.ssl.SSLContext;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class RequestManager extends SignAWSv4{

    //method
    //request url
    //headers
    public void getChart(int repeats, int timeBetweenRequests){
        String method = "GET";
        String url = "https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490189802247&type=2";
        Map<String,?> standardHeaders = standardHeaders();

        for (int i = 0; i<repeats; i++) {
            Map<String, ?> authHeaders = authHeaders(method, url);

            createEmptyRequestWithHeaders(authHeaders).addHeaders(standardHeaders).get(url);

            System.out.println("==================================");
            if (response.statusCode() != 200) {
                System.out.println(response.headers().toString());
            }
            System.out.println(response.statusCode());
            System.out.println(response.asString());
            System.out.println("Time: " + response.timeIn(TimeUnit.MILLISECONDS) + " ms.");
            System.out.println("==================================");

            try {
                Thread.sleep(timeBetweenRequests);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


    public void loadLoginPage(){

    }


    public void setUpBaseApiGateway(){ //это вынести по ходу в listener для api/load тестов
        // Use our custom socket factory
        SSLSocketFactory customSslFactory = null;
        try {
            customSslFactory = new GatewaySslSocketFactory(
                    SSLContext.getDefault(), SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        RestAssured.config = RestAssured.config().sslConfig(
                SSLConfig.sslConfig().sslSocketFactory(customSslFactory));
        RestAssured.config.getHttpClientConfig().reuseHttpClientInstance();
    }



    public void checkExpiredCredentials(int repeats, int timeBetweenRequests){
        String method = "GET";
        String url = "https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev/notification?status=unread";
        Map<String,?> standardHeaders = standardHeaders();

        for (int i = 0; i<repeats; i++) {
            Map<String,?> authHeaders = authHeaders(method, url);

            long startTime = System.currentTimeMillis();
            createEmptyRequestWithHeaders(authHeaders).addHeaders(standardHeaders).get(url);
            long endTime = System.currentTimeMillis();


            System.out.println("==================================");
            if (response.statusCode()!=200){
                System.out.println(response.headers().toString());
            }
            System.out.println(response.statusCode());
            System.out.println(response.asString());
            System.out.println("Time: "+response.timeIn(TimeUnit.MILLISECONDS)+" ms.");
            System.out.println("==================================");



            String jsonString = response.asString();

            if (jsonString.contains("\"expired\":true")) {
                parseNewCreds(jsonString);
            }

            try {
                Thread.sleep(timeBetweenRequests);//default 20000
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    public void canvasDashboardRefreshCycle(){ //creates 1/min 2/min 12/min cycles
        int minutesOfRun = 5;

        long startDate = 1490627550017L;
        String uri = "https://60sglz9l5h.execute-api.us-east-1.amazonaws.com";
        String chartUpdate = uri+"/dev/chart/Thing-000013-i4?channelIdx=1&startDate="+startDate+"&type=2";
        String dashboardInfo = uri+"/dev/dashboard/a36d7666-2e0c-4f01-9663-6d726264dc04";
        String notificationUnread = uri +"/dev/notification?status=unread";

        Map<String,String> standardHeaders = standardHeaders();
        Map<String, String> notificationUnreadHeaders = null;
        Map<String, String> dashboardInfoHeaders = null;
        Map<String, String> chartUpdateHeaders = null;

        System.out.println(LocalDateTime.now()+": Started");
        //2 1min requests on start here
        notificationUnreadHeaders = authHeaders("GET", notificationUnread);
        createEmptyRequestWithHeaders(standardHeaders).options(notificationUnread);
        createEmptyRequestWithHeaders(standardHeaders).addHeaders(notificationUnreadHeaders).get(notificationUnread);
        //2 30 sec requests on start here
        dashboardInfoHeaders = authHeaders("GET", dashboardInfo);
        createEmptyRequestWithHeaders(standardHeaders).options(dashboardInfo);
        createEmptyRequestWithHeaders(standardHeaders).addHeaders(dashboardInfoHeaders).get(dashboardInfo);

        for (int i2 = 0; i2<minutesOfRun; i2++) {
            for (int i1 = 0; i1 < 2; i1++) {
                for (int i = 0; i < 6; i++) {
                    System.out.println(LocalDateTime.now()+": 5 sec cycle");
                    //6 requests every 5 sec here (1 sec cut for response)
                    chartUpdateHeaders = authHeaders("GET", chartUpdate);
                    createEmptyRequestWithHeaders(standardHeaders).options(chartUpdate);
                    createEmptyRequestWithHeaders(standardHeaders).options(chartUpdate);
                    createEmptyRequestWithHeaders(standardHeaders).options(chartUpdate);
                    createEmptyRequestWithHeaders(standardHeaders).addHeaders(chartUpdateHeaders).get(chartUpdate);
                    createEmptyRequestWithHeaders(standardHeaders).addHeaders(chartUpdateHeaders).get(chartUpdate);
                    createEmptyRequestWithHeaders(standardHeaders).addHeaders(chartUpdateHeaders).get(chartUpdate);
                    sleep(4000);
                }
                System.out.println(LocalDateTime.now()+": 30 sec cycle");
                //2requests every 30 sec here
                dashboardInfoHeaders = authHeaders("GET", dashboardInfo);
                createEmptyRequestWithHeaders(standardHeaders).options(dashboardInfo);
                createEmptyRequestWithHeaders(standardHeaders).addHeaders(dashboardInfoHeaders).get(dashboardInfo);
            }
            System.out.println(LocalDateTime.now()+": 1 min cycle");
            //2 requests every 1 min here
            notificationUnreadHeaders = authHeaders("GET", notificationUnread);
            createEmptyRequestWithHeaders(standardHeaders).options(notificationUnread);
            createEmptyRequestWithHeaders(standardHeaders).addHeaders(notificationUnreadHeaders).get(notificationUnread);
        }
    }


    private void sleep(int mills){
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void parseNewCreds(String jsonString){
        //parse new credentials from jsonstring and write to awsCredentials
        if (jsonString.contains("\"expired\":true")) {
            JSONParser parser = new JSONParser();
            JSONObject json = null;
            try {
                json = (JSONObject) parser.parse(jsonString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            JSONObject creds = (JSONObject) json.get("creds");
            //write new creds to credential storage
            awsCredentials.setAccessKeyId(creds.get("accessKeyId").toString());
            awsCredentials.setSecretAccessKey(creds.get("secretAccessKey").toString());
            awsCredentials.setSessionToken(creds.get("sessionToken").toString());

            writeCredsTofile();
        }

    }

    public void writeCredsTofile(){
        PrintWriter out = null;
        try {
            out = new PrintWriter("creds.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        out.write("AccessKeyId,"+awsCredentials.getAccessKeyId()+"\r\n");
        out.write("SecretAccessKey,"+awsCredentials.getSecretAccessKey()+"\r\n");
        out.write("SessionToken,"+awsCredentials.getSessionToken()+"\r\n");
        out.close();
    }


}
