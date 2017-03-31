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
    private String idOfCreatedRule = null;


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

    //CRUD here

    public void notificationRuleCreate(){
        String method = "POST";
        String url = "https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev/rule";
        String jsonBody = "{\"active\":true,\"name\":\"twitter-hitler\",\"description\":\"\",\"notificationType\":0,\"type\":0,\"phones\":[{\"value\":\"+380632517418\",\"name\":\"me\"}],\"emails\":[{\"value\":\"hom.ossystem@gmail.com\",\"name\":\"My email\"}],\"notifications\":{\"alwaysSend\":false,\"triggered\":5,\"acknowledged\":30},\"equipmentIds\":[\"Thing-000013-i3\"],\"channel\":0,\"frq\":0,\"threshold\":0,\"trigger\":\"\",\"operation\":\">=\",\"value\":0,\"period\":0,\"sensor\":1}";
        Map<String, String> standardHeaders = standardHeaders();
        Map<String, String> authHeaders = authHeaders(method, url, jsonBody);

        String response = createRequestWithHeaders(standardHeaders, jsonBody).addHeaders(authHeaders).post(url).extractAllResponseAsString();
        idOfCreatedRule = getIdOfCreatedNotificationRule(response);
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
        String jsonBody = "{\"items\":[{\"id\":\""+idOfCreatedRule+"\",\"active\":1,\"name\":\"New auto-test name\",\"description\":\"\",\"notificationType\":0,\"type\":8,\"phones\":[{\"value\":\"+380632517418\",\"name\":\"me\"}],\"emails\":[{\"value\":\"hom.ossystem@gmail.com\",\"name\":\"My email\"}],\"notifications\":{\"alwaysSend\":false,\"triggered\":5,\"acknowledged\":30,\"globalSettings\":0,\"sms\":0,\"emails\":0},\"equipmentIds\":[\"Thing-090018-0\"],\"channel\":0,\"frq\":0,\"threshold\":0,\"trigger\":\"\",\"operation\":\">=\",\"value\":30,\"period\":0,\"sensor\":\"\"}]}";

        Map<String, String> standardHeaders = standardHeaders();
        Map<String, String> authHeaders = authHeaders(method, url, jsonBody);

        createRequestWithHeaders(standardHeaders, jsonBody).addHeaders(authHeaders).put(url);
    }

    public void notificationRuleDelete(){
        String method = "DELETE";
        String url = "https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev/rule";
        String jsonBody = "{\"items\":[{\"id\":\""+idOfCreatedRule+"\"}]}";

        Map<String, String> standardHeaders = standardHeaders();
        Map<String, String> authHeaders = authHeaders(method, url, jsonBody);

        createRequestWithHeaders(standardHeaders, jsonBody).addHeaders(authHeaders).delete(url);
    }


    public void notificationRuleCRUD(int repeats, int timeBetweenRequests, int timeBetweenCycles){
        for (int i = 0; i < repeats; i++){
            sleep(timeBetweenRequests);
            notificationRuleCreate();
            sleep(timeBetweenRequests);
            notificationRulesRead();
            sleep(timeBetweenRequests);
            notificationRuleUpdate();
            sleep(timeBetweenRequests);
            notificationRuleDelete();
            sleep(timeBetweenCycles);
        }
    }


    public void loadDashboardPage(int repeats, int timeBetweenRequests) {
        String urlBootStrap = "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css";
        String urlCloudFlare = "https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.2.0/css/material-design-iconic-font.min.css";
        String urlFontawesome = "https://cdn.fontawesome.com/js/stats.js";
        String urlZenDeskMain = "https://assets.zendesk.com/embeddable_framework/main.js";
        String urCloudFrontLogo = "https://d30q8hmeeybh67.cloudfront.net/iotLogo_white.png";
        String urlCloudFrontc0f68 = "https://d30q8hmeeybh67.cloudfront.net/c0f68f659e74333fd659f0ed158e7bed.svg?457b5ac";

        String url = "https://dashboard.dev.iotsyst.com";
        String urlBundleJS = url + "/bundle.js";
        String urlZenDeskScript = url + "/ZenDeskWidgetScript.js";
        String urlPathsJSON = url + "/paths.json";
        String urlWTF = url + "/99fc0816a09395454061301fefa42bf1.ttf?457b5ac";
        String urlWTF2 = url + "/54a91b0619ccf9373d525109268219dc.ttf?457b5ac";

        String urlUseFont = "https://use.fontawesome.com";
        String urlJS = urlUseFont + "/05f7c8a54f.js";
        String urlCSS = urlUseFont + "/05f7c8a54f.css";
        String urlFontsCSS = urlUseFont + "/releases/v4.6.3/css/font-awesome-css.min.css";
        String urlFonts = urlUseFont + "/releases/v4.6.3/fonts/fontawesome-webfont.woff2";

        String urlAPIGateWay = "https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev";
        String urlMenu = urlAPIGateWay + "/menu";
        String urlGlobal_settings = urlAPIGateWay + "/global_settings";
        String urlProfile = urlAPIGateWay + "/profile";
        String urlNotificationsUnread = urlAPIGateWay + "/notification?status=unread";
        String urlDashboard = urlAPIGateWay + "/dashboard/48bd96f7-de8a-478b-993e-b6f5af3178a1";
        String urlEquipmentMode = urlAPIGateWay + "/equipment_models?availables=true";

        String urlCloudFront = "https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.2.0";
        String urlIconsMaterial = urlCloudFront + "/fonts/Material-Design-Iconic-Font.woff2?v=2.2.0";

        Map<String, ?> standardHeaders = standardHeaders();
        Map<String, ?> authHeaders1 = null;
        Map<String, ?> authHeaders2 = null;
        Map<String, ?> authHeaders3 = null;
        Map<String, ?> authHeaders4 = null;
        Map<String, ?> authHeaders5 = null;
        Map<String, ?> authHeaders6 = null;


        for (int i = 0; i < repeats; i++) {
            authHeaders1 = authHeaders("GET", urlNotificationsUnread);
            authHeaders2 = authHeaders("GET", urlEquipmentMode);
            authHeaders3 = authHeaders("GET", urlDashboard);
            authHeaders4 = authHeaders("GET", urlGlobal_settings);
            authHeaders5 = authHeaders("GET", urlMenu);
            authHeaders6 = authHeaders("GET", urlProfile);
            createEmptyRequestWithHeaders(standardHeaders).get(url);
            createEmptyRequestWithHeaders(standardHeaders).get(urlBootStrap);
            createEmptyRequestWithHeaders(standardHeaders).get(urlCloudFlare);
            createEmptyRequestWithHeaders(standardHeaders).get(urlBundleJS);
            createEmptyRequestWithHeaders(standardHeaders).get(urlJS);
            createEmptyRequestWithHeaders(standardHeaders).get(urlZenDeskScript);
            createEmptyRequestWithHeaders(standardHeaders).get(urlPathsJSON);
            createEmptyRequestWithHeaders(standardHeaders).get(urlFontawesome);
            createEmptyRequestWithHeaders(standardHeaders).get(urlZenDeskMain);
            createEmptyRequestWithHeaders(standardHeaders).get(urlCSS);
            createEmptyRequestWithHeaders(standardHeaders).get(urlFontsCSS);
            createEmptyRequestWithHeaders(standardHeaders).get(urlFonts);
            createEmptyRequestWithHeaders(standardHeaders).options(urlMenu);
            createEmptyRequestWithHeaders(standardHeaders).options(urlGlobal_settings);
            createEmptyRequestWithHeaders(standardHeaders).get(urlCloudFrontc0f68);
            createEmptyRequestWithHeaders(standardHeaders).get(urCloudFrontLogo);
            createEmptyRequestWithHeaders(standardHeaders).get(urlIconsMaterial);
            createEmptyRequestWithHeaders(standardHeaders).get(urlWTF);
            createEmptyRequestWithHeaders(standardHeaders).get(urlWTF2);
            createEmptyRequestWithHeaders(standardHeaders).addHeaders(authHeaders4).get(urlGlobal_settings);
            createEmptyRequestWithHeaders(standardHeaders).addHeaders(authHeaders5).get(urlMenu);
            createEmptyRequestWithHeaders(standardHeaders).options(urlProfile);
            createEmptyRequestWithHeaders(standardHeaders).addHeaders(authHeaders6).get(urlProfile);
            createEmptyRequestWithHeaders(standardHeaders).options(urlNotificationsUnread);
            createEmptyRequestWithHeaders(standardHeaders).options(urlDashboard);
            createEmptyRequestWithHeaders(standardHeaders).options(urlEquipmentMode);
            createEmptyRequestWithHeaders(standardHeaders).addHeaders(authHeaders1).get(urlNotificationsUnread);
            createEmptyRequestWithHeaders(standardHeaders).addHeaders(authHeaders2).get(urlEquipmentMode);
            createEmptyRequestWithHeaders(standardHeaders).addHeaders(authHeaders3).get(urlDashboard);
            sleep(timeBetweenRequests);
        }
    }




    public void checkExpiredCredentials(int repeats, int timeBetweenRequestsMills){
        String method = "GET";
        String url = "https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev/notification?status=unread";
        Map<String,?> standardHeaders = standardHeaders();

        for (int i = 0; i<repeats; i++) {
            Map<String,?> authHeaders = authHeaders(method, url);

//            createEmptyRequestWithHeaders(authHeaders).addHeaders(standardHeaders).get(url, "off");
            createEmptyRequestWithHeaders(authHeaders).addHeaders(standardHeaders).get(url);
            String jsonString = response.asString();

            if (jsonString.contains("\"expired\":true")) {
                parseNewCreds(jsonString);
            }

            sleep(timeBetweenRequestsMills);
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
            fos = new FileOutputStream("loadReports/"+file);
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
