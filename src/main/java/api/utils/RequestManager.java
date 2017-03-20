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
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class RequestManager extends SignAWSv4{

    //method
    //request url
    //headers
    public void someRequest(){
        String method = "GET";
        String url = "https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev/notification?status=unread";
        Map<String,?> authHeaders = authHeaders(method, url);
        Map<String,?> standardHeaders = standardHeaders();

        createEmptyRequestWithHeaders(authHeaders).addHeaders(standardHeaders).get(url);
        System.out.println(response.asString());
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



    public void checkExpiredCredentials(){
        String method = "GET";
        String url = "https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev/notification?status=unread";
        Map<String,?> standardHeaders = standardHeaders();

        for (int i = 0; i<100; i++) {
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
            System.out.println("Time start: "+startTime);//не подходит, учитывает и время отработки метода
            System.out.println("Time stop: "+endTime);//не подходит, учитывает и время отработки метода
            System.out.println("Time diff: "+(endTime-startTime));//не подходит, учитывает и время отработки метода
            System.out.println("==================================");

            String jsonString = response.asString();

            if (jsonString.contains("\"expired\":true")) {
                parseNewCreds(jsonString);
            }

            try {
                Thread.sleep(20000);//default 20000
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

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
        }

    }

    private void getDashboard(){

    }


}
