package load;


import com.jayway.restassured.RestAssured;
import com.jayway.restassured.config.SSLConfig;
import org.apache.commons.io.output.TeeOutputStream;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.net.ssl.SSLContext;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.Map;

public class RequestManager extends RequestTemplates{
    private FileOutputStream fos = null;

    public void getChart(int repeats, int timeBetweenRequests){
        String method = "GET";
        String url = "https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490189802247&type=2";
        Map<String,?> standardHeaders = standardHeaders();

        for (int i = 0; i<repeats; i++) {
            Map<String, ?> authHeaders = authHeaders(method, url);

            createEmptyRequestWithHeaders(authHeaders).addHeaders(standardHeaders).get(url);
            sleep(timeBetweenRequests);
        }
    }

    public void notificationRuleCreate(){
        String method = "POST";
        String url = "https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev/rule";
        String jsonBody = "{\"active\":true,\"name\":\"twitter-hitler\",\"description\":\"\",\"notificationType\":0,\"type\":0,\"phones\":[{\"value\":\"+380632517418\",\"name\":\"me\"}],\"emails\":[{\"value\":\"hom.ossystem@gmail.com\",\"name\":\"My email\"}],\"notifications\":{\"alwaysSend\":false,\"triggered\":5,\"acknowledged\":30},\"equipmentIds\":[\"Thing-000013-i3\"],\"channel\":0,\"frq\":0,\"threshold\":0,\"trigger\":\"\",\"operation\":\">=\",\"value\":0,\"period\":0,\"sensor\":1}";
        Map<String, String> standardHeaders = standardHeaders();
        Map<String, String> authHeaders = authHeaders(method, url, jsonBody);

        createRequestWithHeaders(standardHeaders, jsonBody).addHeaders(authHeaders).post(url);
    }

    public void notificationRulesRead(){
        String method = "GET";
        String url = "https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev/rule";


        Map<String, String> standardHeaders = standardHeaders();
        Map<String, String> authHeaders = authHeaders(method, url);

        createEmptyRequestWithHeaders(standardHeaders).addHeaders(authHeaders).get(url);
    }

    public void notificationRuleUpdate(){
        String method = "PUT";
        String url = "https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev/rule";
        String jsonBody = "{\"items\":[{\"id\":\"f1d40e8b-df08-4432-8914-63fccfc9a345\",\"active\":1,\"name\":\"dsfsd\",\"description\":\"\",\"notificationType\":0,\"type\":8,\"phones\":[{\"value\":\"+380632517418\",\"name\":\"me\"}],\"emails\":[{\"value\":\"hom.ossystem@gmail.com\",\"name\":\"My email\"}],\"notifications\":{\"alwaysSend\":false,\"triggered\":5,\"acknowledged\":30,\"globalSettings\":0,\"sms\":0,\"emails\":0},\"equipmentIds\":[\"Thing-090018-0\"],\"channel\":0,\"frq\":0,\"threshold\":0,\"trigger\":\"\",\"operation\":\">=\",\"value\":30,\"period\":0,\"sensor\":\"\"}]}";

        Map<String, String> standardHeaders = standardHeaders();
        Map<String, String> authHeaders = authHeaders(method, url, jsonBody);

        createRequestWithHeaders(standardHeaders, jsonBody).addHeaders(authHeaders).put(url);
    }

    public void notificationRuleDelete(){
        String method = "DELETE";
        String url = "https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev/rule";
        String jsonBody = "{\"items\":[{\"id\":\"fc778741-42e3-410f-bbae-e3c677020628\"}]}";

        Map<String, String> standardHeaders = standardHeaders();
        Map<String, String> authHeaders = authHeaders(method, url, jsonBody);

        createRequestWithHeaders(standardHeaders, jsonBody).addHeaders(authHeaders).delete(url);
    }


    public void notificationRuleCRUD(){

    }


    public void loadDashboardPage(int repeats, int timeBetweenRequests) {
        String url = "https://dashboard.dev.iotsyst.com";
        String urlUseFont = "https://use.fontawesome.com";
        String urlAPIGateWay = "https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev";
        String urlCloudFront = "https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.2.0";

        String url1 = "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css";
        String url2 = "https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.2.0/css/material-design-iconic-font.min.css";
        String url3 = "https://cdn.fontawesome.com/js/stats.js";
        String url4 = "https://assets.zendesk.com/embeddable_framework/main.js";
        String url5 = "https://d30q8hmeeybh67.cloudfront.net/iotLogo_white.png";
        String url12 = "https://d30q8hmeeybh67.cloudfront.net/c0f68f659e74333fd659f0ed158e7bed.svg?457b5ac";

        String url6 = url + "/bundle.js";
        String url7 = url + "/ZenDeskWidgetScript.js";
        String url8 = url + "/paths.json";
        String url22 = url + "/99fc0816a09395454061301fefa42bf1.ttf?457b5ac";
        String url23 = url + "/54a91b0619ccf9373d525109268219dc.ttf?457b5ac";

        String url9 = urlUseFont + "/05f7c8a54f.js";
        String url10 = urlUseFont + "/05f7c8a54f.css";
        String url11 = urlUseFont + "/webfontloader/1.6.24/webfontloader.js";
        String url13 = urlUseFont + "/releases/v4.6.3/css/font-awesome-css.min.css";
        String url14 = urlUseFont + "/releases/v4.6.3/fonts/fontawesome-webfont.woff2";

        String url15 = urlAPIGateWay + "/menu";
        String url16 = urlAPIGateWay + "/global_settings";
        String url17 = urlAPIGateWay + "/profile";
        String url18 = urlAPIGateWay + "/notification?status=unread";
        String url19 = urlAPIGateWay + "/dashboard/48bd96f7-de8a-478b-993e-b6f5af3178a1";
        String url20 = urlAPIGateWay + "/equipment_models?availables=true";

        String url21 = urlCloudFront + "/fonts/Material-Design-Iconic-Font.woff2?v=2.2.0";

        Map<String, ?> standardHeaders = standardHeaders();
        Map<String, ?> authHeaders1 = null;
        Map<String, ?> authHeaders2 = null;
        Map<String, ?> authHeaders3 = null;


        for (int i = 0; i < repeats; i++) {
            authHeaders1 = authHeaders("GET", url18);
            authHeaders2 = authHeaders("GET", url20);
            authHeaders3 = authHeaders("GET", url19);
            createEmptyRequestWithHeaders(standardHeaders).get(url);
            createEmptyRequestWithHeaders(standardHeaders).get(url1);
            createEmptyRequestWithHeaders(standardHeaders).get(url2);
            createEmptyRequestWithHeaders(standardHeaders).get(url6);
            createEmptyRequestWithHeaders(standardHeaders).get(url9);
            createEmptyRequestWithHeaders(standardHeaders).get(url7);
            createEmptyRequestWithHeaders(standardHeaders).get(url8);
            createEmptyRequestWithHeaders(standardHeaders).get(url3);
            createEmptyRequestWithHeaders(standardHeaders).get(url4);
            createEmptyRequestWithHeaders(standardHeaders).get(url10);
            createEmptyRequestWithHeaders(standardHeaders).get(url13);
            createEmptyRequestWithHeaders(standardHeaders).get(url14);
            createEmptyRequestWithHeaders(standardHeaders).options(url15);
            createEmptyRequestWithHeaders(standardHeaders).options(url16);
            createEmptyRequestWithHeaders(standardHeaders).get(url12);
            createEmptyRequestWithHeaders(standardHeaders).get(url5);
            createEmptyRequestWithHeaders(standardHeaders).get(url21);
            createEmptyRequestWithHeaders(standardHeaders).get(url22);
            createEmptyRequestWithHeaders(standardHeaders).get(url23);
            createEmptyRequestWithHeaders(standardHeaders).get(url16);
            createEmptyRequestWithHeaders(standardHeaders).get(url15);
            createEmptyRequestWithHeaders(standardHeaders).options(url17);
            createEmptyRequestWithHeaders(standardHeaders).get(url17);
            createEmptyRequestWithHeaders(standardHeaders).get(url18);
            createEmptyRequestWithHeaders(standardHeaders).get(url19);
            createEmptyRequestWithHeaders(standardHeaders).get(url20);
            createEmptyRequestWithHeaders(standardHeaders).addHeaders(authHeaders1).get(url18);
            createEmptyRequestWithHeaders(standardHeaders).addHeaders(authHeaders2).get(url20);
            createEmptyRequestWithHeaders(standardHeaders).addHeaders(authHeaders3).get(url19);
            sleep(timeBetweenRequests);
        }
    }


    public void checkExpiredCredentials(int repeats, int timeBetweenRequests){
        String method = "GET";
        String url = "https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev/notification?status=unread";
        Map<String,?> standardHeaders = standardHeaders();

        for (int i = 0; i<repeats; i++) {
            Map<String,?> authHeaders = authHeaders(method, url);

            createEmptyRequestWithHeaders(authHeaders).addHeaders(standardHeaders).get(url);
            String jsonString = response.asString();

            if (jsonString.contains("\"expired\":true")) {
                parseNewCreds(jsonString);
            }

            sleep(timeBetweenRequests);
        }

    }

    public void canvasDashboardRefreshCycleOldTimestamp(int operatingTimeMins) {
        //в зависимости от времени меняется startDate
        //в зависимости от юзера и дашборда меняется chartUpdate и dashboardInfo
        long startDate = 1490627550017L;
        String uri = "https://60sglz9l5h.execute-api.us-east-1.amazonaws.com";
        String chartUpdate = uri + "/dev/chart/Thing-000013-i4?channelIdx=1&startDate=" + startDate + "&type=2";
        String dashboardInfo = uri + "/dev/dashboard/a36d7666-2e0c-4f01-9663-6d726264dc04";
        String notificationUnread = uri + "/dev/notification?status=unread";

        canvasVPVChartRefreshTemplate(operatingTimeMins, chartUpdate, dashboardInfo, notificationUnread);
    }

    public void canvasDashboardRefreshCycleProperTimestamp(int operatingTimeMins) {
        //в зависимости от времени меняется startDate
        //в зависимости от юзера и дашборда меняется chartUpdate и dashboardInfo
        long oneSecEarlier = System.currentTimeMillis()-1000;
        String uri = "https://60sglz9l5h.execute-api.us-east-1.amazonaws.com";
        String chartUpdate = uri + "/dev/chart/Thing-000013-i4?channelIdx=1&startDate=" + oneSecEarlier + "&type=2";
        String dashboardInfo = uri + "/dev/dashboard/a36d7666-2e0c-4f01-9663-6d726264dc04";
        String notificationUnread = uri + "/dev/notification?status=unread";

        canvasVPVChartRefreshTemplate(operatingTimeMins, chartUpdate, dashboardInfo, notificationUnread);
    }


    public void canvasGPVDashboardRefreshCycleOldTimestamp(int operatingTimeMins) {
        //в зависимости от времени меняется startDate
        //в зависимости от юзера и дашборда меняется chartUpdate и dashboardInfo
        long startDate = 1490627550017L;
        String uri = "https://60sglz9l5h.execute-api.us-east-1.amazonaws.com";
        String chartUpdate = uri + "/dev/chart/Thing-090035-0?startDate=" + startDate;
        String dashboardInfo = uri + "/dev/dashboard/bff593fe-298e-4726-90de-ad400f868b8c";
        String notificationUnread = uri + "/dev/notification?status=unread";

        canvasGPVChartRefreshTemplate(operatingTimeMins, chartUpdate, dashboardInfo, notificationUnread);
    }

    public void canvasGPVDashboardRefreshCycleProperTimestamp(int operatingTimeMins) {
        //в зависимости от времени меняется startDate
        //в зависимости от юзера и дашборда меняется chartUpdate и dashboardInfo
        long oneSecEarlier = System.currentTimeMillis()-1000;
        String uri = "https://60sglz9l5h.execute-api.us-east-1.amazonaws.com";
        String chartUpdate = uri + "/dev/chart/Thing-090035-0?startDate=" + oneSecEarlier;
        String dashboardInfo = uri + "/dev/dashboard/bff593fe-298e-4726-90de-ad400f868b8c";
        String notificationUnread = uri + "/dev/notification?status=unread";

        canvasGPVChartRefreshTemplate(operatingTimeMins, chartUpdate, dashboardInfo, notificationUnread);
    }

    public void kibanaDashboardRefreshCycle(){ //NOT FINISHED YET!
        String dashboardId = "c020c7c1-2d8c-46f6-933a-abb933788732";
        String preferenceTimeStamp = "1490780679128";
        String chartUpdatePostPayloadJSON = "{\"search_type\":\"count\",\"ignore_unavailable\":true}\n" +
                "{\"query\":{\"filtered\":{\"query\":{\"query_string\":{\"analyze_wildcard\":true,\"query\":\"equipmentId:\\\"Thing-000013-i3\\\" AND channel:1 AND type:2\"}},\"filter\":{\"bool\":{\"must\":[{\"range\":{\"timestamp\":{\"gte\":1488278924314,\"lte\":1490780924314,\"format\":\"epoch_millis\"}}}],\"must_not\":[]}}}},\"size\":0,\"aggs\":{\"2\":{\"date_histogram\":{\"field\":\"timestamp\",\"interval\":\"3h\",\"time_zone\":\"+03:00\",\"min_doc_count\":1,\"extended_bounds\":{\"min\":1488278924313,\"max\":1490780924313}},\"aggs\":{\"1\":{\"avg\":{\"field\":\"value\"}}}}}}";

        String notificationUnreadUrl = "https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev/notification?status=unread";
        String dashboardInfoUrl = "https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev/dashboard/c020c7c1-2d8c-46f6-933a-abb933788732";
        String chartUpdateUrl = "https://elasticsearch.dev.iotsyst.io/vpv-log/_msearch?timeout=0&preference=1490780679128";

        int operatingTimeMins = 2;


        Map<String, String> standardHeaders = standardHeaders();
        Map<String, String> notificationUnreadHeaders = null;
        Map<String, String> dashboardInfoHeaders = null;
        Map<String, String> chartUpdateHeaders = null;


        System.out.println(LocalDateTime.now() + " START");
        dashboardInfoHeaders = authHeaders("GET", dashboardInfoUrl);
        notificationUnreadHeaders = authHeaders("GET", notificationUnreadUrl);

        createEmptyRequestWithHeaders(standardHeaders).options(notificationUnreadUrl);
        createEmptyRequestWithHeaders(standardHeaders).addHeaders(notificationUnreadHeaders).get(notificationUnreadUrl);
        createEmptyRequestWithHeaders(standardHeaders).options(dashboardInfoUrl);
        createEmptyRequestWithHeaders(standardHeaders).addHeaders(dashboardInfoHeaders).get(dashboardInfoUrl);

        System.out.println(LocalDateTime.now()+" _msearch?timeout=0&preference=1490780679128");
        System.out.println(LocalDateTime.now()+" _msearch?timeout=0&preference=1490780679128");
        System.out.println(LocalDateTime.now()+" _msearch?timeout=0&preference=1490780679128");
        for (int i1 = 0; i1 < operatingTimeMins; i1++) {
            for (int i = 0; i < 2; i++) {
                sleep(29200);
                //2 req dash inf here (0.8 sec cut for response)
                dashboardInfoHeaders = authHeaders("GET", dashboardInfoUrl);
                createEmptyRequestWithHeaders(standardHeaders).options(dashboardInfoUrl);
                createEmptyRequestWithHeaders(standardHeaders).addHeaders(dashboardInfoHeaders).get(dashboardInfoUrl);
            }
            notificationUnreadHeaders = authHeaders("GET", notificationUnreadUrl);

            System.out.println(LocalDateTime.now()+" _msearch?timeout=0&preference=1490780679128");
            System.out.println(LocalDateTime.now()+" _msearch?timeout=0&preference=1490780679128");
            System.out.println(LocalDateTime.now()+" _msearch?timeout=0&preference=1490780679128");

            createEmptyRequestWithHeaders(standardHeaders).options(notificationUnreadUrl);
            createEmptyRequestWithHeaders(standardHeaders).addHeaders(notificationUnreadHeaders).get(notificationUnreadUrl);
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


    public void setUpBaseApiGateway(){
        //это вынести по ходу в listener для api/load тестов
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

    public void startLog(String file){
        try {
            fos = new FileOutputStream(file);
            TeeOutputStream myOut = new TeeOutputStream(System.out, fos);
            PrintStream ps = new PrintStream(myOut);
            System.setOut(ps);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void stopLog(){
        try {
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void sleep(int mills){
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
