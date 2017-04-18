package load.utils;


import com.jayway.restassured.RestAssured;
import com.jayway.restassured.config.SSLConfig;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.net.ssl.SSLContext;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class RequestManager extends RequestTemplates{
    private String idOfCreatedNotificationRule = null;
    private static String idOfCreatedVPVDashboard = null;
    private static String idOfCreatedGPVDashboard = null;
    private String idOfCreatedReport = null;


    private static final String uri = "https://60sglz9l5h.execute-api.us-east-1.amazonaws.com";
    private static final String notificationUnread = uri+"/dev/notification?status=unread";
    private static final String notificationRule = uri+"/dev/rule";
    private static final String dashboard = uri+"/dev/dashboard";
    private static final String report = uri+"/report";
    private static final String chart = uri+"/dev/chart";

    private static final String thingGPV = "Thing-090035-0";
    private static final String thingVPV = "Thing-000013-i4";
    private static final String channelVPV = "channelIdx=1";

    private static final String httpGET = "GET";
    private static final String httpPOST = "POST";
    private static final String httpPUT = "PUT";
    private static final String httpDELETE = "DELETE";




    public void getChart(int repeats, int timeBetweenRequests){
        String url = chart+"/"+thingVPV+"?"+channelVPV+"&startDate=1490189802247&type=2";
        Map<String,?> standardHeaders = standardHeaders();

        for (int i = 0; i<repeats; i++) {
            Map<String, ?> authHeaders = authHeaders(httpGET, url);

            createEmptyRequestWithHeaders(authHeaders).addHeaders(standardHeaders).get(url);
            sleep(timeBetweenRequests);
        }
    }

    //CRUD here

    private void notificationRuleCreate(){
        String jsonBody = "{\"active\":true,\"name\":\"Abnormal auto-test rule\",\"description\":\"some description\",\"notificationType\":0,\"type\":0,\"phones\":[{\"value\":\"+380634953177\",\"name\":\"My Lifecell\"}],\"emails\":[{\"value\":\"TestUser.Israil@mail.ru\",\"name\":\"hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh\"}],\"notifications\":{\"alwaysSend\":false,\"triggered\":10,\"acknowledged\":15,\"sms\":false,\"emails\":false},\"equipmentIds\":[\"Thing-090011-0\"],\"channel\":0,\"frq\":0,\"threshold\":0,\"trigger\":\"\",\"operation\":\">=\",\"value\":0,\"period\":0,\"sensor\":1}";
        Map<String, String> standardHeaders = standardHeaders();
        Map<String, String> authHeaders = authHeaders(httpPOST, notificationRule, jsonBody);

        String response = createRequestWithHeaders(standardHeaders, jsonBody).addHeaders(authHeaders).post(notificationRule).extractAllResponseAsString();
        idOfCreatedNotificationRule = getIdOfCreatedNotificationRule(response);
    }

    private void notificationRulesRead(){
        Map<String, String> standardHeaders = standardHeaders();
        Map<String, String> authHeaders = authHeaders(httpGET, notificationRule);

        createEmptyRequestWithHeaders(standardHeaders).addHeaders(authHeaders).get(notificationRule);
    }

    private void notificationRuleUpdate(){
        String jsonBody = "{\"items\":[{\"id\":\""+idOfCreatedNotificationRule+"\",\"active\":1,\"name\":\"Abnormal edited auto-test rule\",\"description\":\"edited description\",\"notificationType\":0,\"type\":0,\"phones\":[{\"value\":\"+380634953177\",\"name\":\"My Lifecell\"}],\"emails\":[{\"value\":\"TestUser.Israil@mail.ru\",\"name\":\"hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh\"}],\"notifications\":{\"alwaysSend\":false,\"triggered\":10,\"acknowledged\":15,\"globalSettings\":0,\"sms\":false,\"emails\":false},\"equipmentIds\":[\"Thing-090011-0\"],\"channel\":0,\"frq\":0,\"threshold\":0,\"trigger\":\"\",\"operation\":\">=\",\"value\":30,\"period\":0,\"sensor\":1}]}";

        Map<String, String> standardHeaders = standardHeaders();
        Map<String, String> authHeaders = authHeaders(httpPUT, notificationRule, jsonBody);

        createRequestWithHeaders(standardHeaders, jsonBody).addHeaders(authHeaders).put(notificationRule);
    }

    private void notificationRuleDelete(){
        String jsonBody = "{\"items\":[{\"id\":\""+ idOfCreatedNotificationRule +"\"}]}";

        Map<String, String> standardHeaders = standardHeaders();
        Map<String, String> authHeaders = authHeaders(httpDELETE, notificationRule, jsonBody);

        createRequestWithHeaders(standardHeaders, jsonBody).addHeaders(authHeaders).delete(notificationRule);
    }


    public void notificationRuleCRUD(int timeToRunMins, int timeBetweenRequestsMills, int timeBetweenCyclesMills){
        long start = System.currentTimeMillis();

        while(System.currentTimeMillis()<(start+(timeToRunMins*60000))){
            notificationRuleCreate();
            sleep(timeBetweenRequestsMills);
            notificationRulesRead();
            sleep(timeBetweenRequestsMills);
            notificationRuleUpdate();
            sleep(timeBetweenRequestsMills);
            notificationRuleDelete();
            sleep(timeBetweenCyclesMills);
        }
    }

    public void notificationRuleCRUD(int timeToRunMins){
        long start = System.currentTimeMillis();

        while(System.currentTimeMillis()<(start+(timeToRunMins*60000))){
            notificationRuleCreate();
            notificationRulesRead();
            notificationRuleUpdate();
            notificationRuleDelete();
        }
    }

    //SKEDLER IN PROGRESS AND NOT FINISHED YET

    public void skedlerReportCreate(){
        String jsonBody = "{\"templateId\":\"Vacuum-Pump-Vibration-Report---Optimized-for-Printing---Daily\",\"emaillist\":\"vasya.ossystem@gmasill.com\",\"filter\":\"equipmentId:"+thingGPV+"\",\"filter_name\":\"Vacuum-Pump-Vibration-Report-List---Optimized-for-Printing---Daily\",\"excelEnabled\":false}";

        Map<String, String> standardHeaders = standardHeaders();
        Map<String, String> authHeaders = authHeaders(httpPUT, report, jsonBody);

        String jsonResponse = createRequestWithHeaders(authHeaders, jsonBody).addHeaders(standardHeaders).put(report).extractAllResponseAsString();
        System.out.println(jsonResponse);
        //тут сделать парс json и запись id в variable
        idOfCreatedReport = getIdOfCreatedReport(jsonResponse);
    }

    public void skedlerReportSendNow(){
        String jsonBody = "{\"filterId\":\""+idOfCreatedReport+"\",\"templateId\":\"GPV-Smart-Sensor-Report-15-minutes-activity-1\",\"emaillist\":\"geloksmmm@gmail.com,kov.ossystem@gmail.com\",\"filter\":\"equipmentId:"+thingGPV+"\",\"filter_name\":\"GPV-Smart-Sensor-Report-List-15-minutes\",\"excelEnabled\":false}";

        Map<String, String> standardHeaders = standardHeaders();
        Map<String, String> authHeaders = authHeaders(httpPOST, report, jsonBody);

        createRequestWithHeaders(authHeaders, jsonBody).addHeaders(standardHeaders).post(report);
    }

    public void skedlerReportDelete(){
        String jsonBody = "";
        //get body from test account
        //{"filter_name":"GPV-Smart-Sensor-Report-List-15-minutes","filterTitle":"GPV-Smart-Sensor-Report-List-15-minutes hom.ossystem@gmail.com","equipments":"Thing-090035-0","id":null,"filterId":"7e15db45-45f3-4f41-8979-bd35787be667","emails":"hom.ossystem@gmail.com","userId":"0315f51c-67ab-4390-bdd1-46bd9d3fd038","createdAt":null,"excelIncluded":null}

        Map<String, String> standardHeaders = standardHeaders();
        Map<String, String> authHeaders = authHeaders(httpDELETE, report, jsonBody);

        createRequestWithHeaders(authHeaders, jsonBody).addHeaders(standardHeaders).delete(report);
    }

    //


    public void loadDashboardPage(int repeats, int timeBetweenCycles) {
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
            authHeaders1 = authHeaders(httpGET, urlNotificationsUnread);
            authHeaders2 = authHeaders(httpGET, urlEquipmentMode);
            authHeaders3 = authHeaders(httpGET, urlDashboard);
            authHeaders4 = authHeaders(httpGET, urlGlobal_settings);
            authHeaders5 = authHeaders(httpGET, urlMenu);
            authHeaders6 = authHeaders(httpGET, urlProfile);
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
            sleep(timeBetweenCycles);
        }
    }


    public void checkExpiredCredentials(int operatingTimeMins){
        Map<String,?> standardHeaders = standardHeaders();

        for (int i = 0; i<operatingTimeMins; i++) {
            Map<String,?> authHeaders = authHeaders(httpGET, notificationUnread);

            createEmptyRequestWithHeaders(authHeaders).addHeaders(standardHeaders).get(notificationUnread);
            String jsonString = response.asString();

            if (jsonString.contains("\"expired\":true")) {
                parseNewCreds(jsonString);
            }

            sleep(59000);
        }

    }

    public void dashboardCreateCanvasVPV(){
        String body = "{\"type\":7,\"equipmentIds\":[\"Thing-000013-i3\",\"Thing-000011-i1\",\"Thing-000012-i2\"],\"name\":\"someAutoTestNameVPV\",\"description\":\"someAutoTestDescriptionVPV\"}";
        Map<String, String> standardHeaders = standardHeaders();
        Map<String, String> authHeaders = authHeaders(httpPOST, dashboard, body);

        String response = createRequestWithHeaders(authHeaders, body).addHeaders(standardHeaders).post(dashboard, false).extractAllResponseAsString();
        idOfCreatedVPVDashboard = getIdOfCreatedDashboard(response);
    }

    public void dashboardCreateCanvasGPV(){
        String body = "{\"type\":9,\"equipmentIds\":[\""+thingGPV+"\"],\"name\":\"someAutoTestNameGPV\",\"description\":\"someAutoTestDescriptionGPV\"}";
        Map<String, String> standardHeaders = standardHeaders();
        Map<String, String> authHeaders = authHeaders(httpPOST, dashboard, body);

        String response = createRequestWithHeaders(authHeaders, body).addHeaders(standardHeaders).post(dashboard, false).extractAllResponseAsString();
        idOfCreatedGPVDashboard = getIdOfCreatedDashboard(response);
    }

    public void dashboardDeleteCanvasVPV(){
        deleteCanvasDashboardById(idOfCreatedVPVDashboard);
    }

    public void dashboardDeleteCanvasGPV(){
        deleteCanvasDashboardById(idOfCreatedGPVDashboard);
    }

    private void deleteCanvasDashboardById(String id){
        String jsonBody = "{\"items\":[{\"id\":\""+id+"\"}]}";

        Map<String, String> standardHeaders = standardHeaders();
        Map<String, String> authHeaders = authHeaders(httpDELETE, dashboard, jsonBody);

        createRequestWithHeaders(standardHeaders, jsonBody).addHeaders(authHeaders).delete(dashboard, false);

    }

    public void canvasVPVDashboardLoadRefreshCycle(int tenMinuteCyclesCount){
        int repeatsHighLoad = 11;
        int operatingTimeMinsLowLoad = 9;

        Map<String, String> standardHeaders = standardHeaders();
        long oldDate = 1490627550017L;
        String chartUpdate = chart+"/"+thingVPV+"?"+channelVPV+"&startDate=" + oldDate + "&type=2";
        String chartUpdate1 = chart+"/"+thingVPV+"?"+channelVPV+"&startDate=";
        String chartUpdate2 = "&type=2";
        String dashboardInfo = dashboard+"/"+idOfCreatedVPVDashboard;
        Map<String, String> chartUpdateHeaders = null;

        for(int i1 = 0; i1<tenMinuteCyclesCount; i1++) {
            for (int i = 0; i < repeatsHighLoad; i++) {
                chartUpdateHeaders = authHeaders(httpGET, chartUpdate);
                createEmptyRequestWithHeaders(standardHeaders).options(chartUpdate);
                createEmptyRequestWithHeaders(standardHeaders).addHeaders(chartUpdateHeaders).get(chartUpdate);
            }
            canvasVPVChartRefreshTemplateActualTime(operatingTimeMinsLowLoad, chartUpdate1, chartUpdate2, dashboardInfo, notificationUnread);
        }
    }

    public void canvasGPVDashboardLoadRefreshCycle(int tenMinuteCyclesCount){
        int repeatsHighLoad = 1;
        int operatingTimeMinsLowLoad = 9;//should be 9

        Map<String, String> standardHeaders = standardHeaders();
        long oldDate = System.currentTimeMillis()-898581;//almost 15 min nazad
        String chartUpdate = chart+"/"+thingGPV+"?startDate="+oldDate;
        String chartUpdate1 = chart+"/"+thingGPV+"?startDate=";
        String dashboardInfo = dashboard+"/"+idOfCreatedGPVDashboard;
        Map<String, String> chartUpdateHeaders = null;

        for(int i1 = 0; i1<tenMinuteCyclesCount; i1++) {
            for (int i = 0; i < repeatsHighLoad; i++) {
                chartUpdateHeaders = authHeaders(httpGET, chartUpdate);
                createEmptyRequestWithHeaders(standardHeaders).options(chartUpdate);
                createEmptyRequestWithHeaders(standardHeaders).addHeaders(chartUpdateHeaders).get(chartUpdate);
            }
            canvasGPVChartRefreshTemplateActualTime(operatingTimeMinsLowLoad, chartUpdate1, dashboardInfo, notificationUnread);
        }
    }

    public void canvasGPVDashboardRefreshCycleBurst(int tenMinuteCyclesCount){
        int repeatsHighLoad = 1;
        int operatingTimeMinsLowLoad = 9;

        Map<String, String> standardHeaders = standardHeaders();
        long oldDate = System.currentTimeMillis()-898581;//almost 15 min nazad
        String chartUpdate = chart+"/"+thingGPV+"?startDate="+oldDate;
        String chartUpdate1 = chart+"/"+thingGPV+"?startDate=";
        String dashboardInfo = dashboard+"/"+idOfCreatedGPVDashboard;
        Map<String, String> chartUpdateHeaders = null;

        for(int i1 = 0; i1<tenMinuteCyclesCount; i1++) {
            for (int i = 0; i < repeatsHighLoad; i++) {
                chartUpdateHeaders = authHeaders(httpGET, chartUpdate);
                createEmptyRequestWithHeaders(standardHeaders).options(chartUpdate);
                createEmptyRequestWithHeaders(standardHeaders).addHeaders(chartUpdateHeaders).get(chartUpdate);
            }
            canvasGPVChartRefreshTemplateBurst(operatingTimeMinsLowLoad, chartUpdate1, dashboardInfo, notificationUnread);
        }
    }

    public void canvasVPVDashboardRefreshCycleOldTimestamp(int operatingTimeMins) {
        //в зависимости от времени меняется startDate
        //в зависимости от юзера и дашборда меняется chartUpdate и dashboardInfo
        long startDate = 1490627550017L;
        String chartUpdate = chart+"/"+thingVPV+"?"+channelVPV+"&startDate=" + startDate + "&type=2";
        String dashboardInfo = dashboard+"/"+idOfCreatedVPVDashboard;

        canvasVPVChartRefreshTemplate(operatingTimeMins, chartUpdate, dashboardInfo, notificationUnread);
    }

    public void canvasVPVDashboardRefreshCycleProperTimestamp(int operatingTimeMins) {
        //в зависимости от времени меняется startDate
        //в зависимости от юзера и дашборда меняется chartUpdate и dashboardInfo
        long oneSecEarlier = System.currentTimeMillis()-1000;
        String chartUpdate = chart+"/"+thingVPV+"?"+channelVPV+"&startDate=" + oneSecEarlier + "&type=2";
        String dashboardInfo = dashboard+"/"+idOfCreatedVPVDashboard;

        canvasVPVChartRefreshTemplate(operatingTimeMins, chartUpdate, dashboardInfo, notificationUnread);
    }


    public void canvasGPVDashboardRefreshCycleOldTimestamp(int operatingTimeMins) {
        //в зависимости от времени меняется startDate
        //в зависимости от юзера и дашборда меняется chartUpdate и dashboardInfo
        long startDate = 1490627550017L;
        String chartUpdate = chart+"/"+thingGPV+"?startDate=" + startDate;
        String dashboardInfo = dashboard+"/"+idOfCreatedGPVDashboard;

        canvasGPVChartRefreshTemplate(operatingTimeMins, chartUpdate, dashboardInfo, notificationUnread);
    }

    public void canvasGPVDashboardRefreshCycleProperTimestamp(int operatingTimeMins) {
        //в зависимости от времени меняется startDate
        //в зависимости от юзера и дашборда меняется chartUpdate и dashboardInfo
        long oneSecEarlier = System.currentTimeMillis()-1000;
        String chartUpdate = chart+"/"+thingGPV+"?startDate=" + oneSecEarlier;
        String dashboardInfo = dashboard+"/"+idOfCreatedGPVDashboard;

        canvasGPVChartRefreshTemplate(operatingTimeMins, chartUpdate, dashboardInfo, notificationUnread);
    }

    public void kibanaDashboardRefreshCycle(){ //NOT FINISHED YET!
        String dashboardId = "c020c7c1-2d8c-46f6-933a-abb933788732";
        String preferenceTimeStamp = "1490780679128";
        String chartUpdatePostPayloadJSON = "{\"search_type\":\"count\",\"ignore_unavailable\":true}\n" +
                "{\"query\":{\"filtered\":{\"query\":{\"query_string\":{\"analyze_wildcard\":true,\"query\":\"equipmentId:\\\"Thing-000013-i3\\\" AND channel:1 AND type:2\"}},\"filter\":{\"bool\":{\"must\":[{\"range\":{\"timestamp\":{\"gte\":1488278924314,\"lte\":1490780924314,\"format\":\"epoch_millis\"}}}],\"must_not\":[]}}}},\"size\":0,\"aggs\":{\"2\":{\"date_histogram\":{\"field\":\"timestamp\",\"interval\":\"3h\",\"time_zone\":\"+03:00\",\"min_doc_count\":1,\"extended_bounds\":{\"min\":1488278924313,\"max\":1490780924313}},\"aggs\":{\"1\":{\"avg\":{\"field\":\"value\"}}}}}}";

        String dashboardInfoUrl = "https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev/dashboard/c020c7c1-2d8c-46f6-933a-abb933788732";
        String chartUpdateUrl = "https://elasticsearch.dev.iotsyst.io/vpv-log/_msearch?timeout=0&preference=1490780679128";

        int operatingTimeMins = 2;

        Map<String, String> standardHeaders = standardHeaders();
        Map<String, String> notificationUnreadHeaders = null;
        Map<String, String> dashboardInfoHeaders = null;
        Map<String, String> chartUpdateHeaders = null;

        dashboardInfoHeaders = authHeaders(httpGET, dashboardInfoUrl);
        notificationUnreadHeaders = authHeaders(httpGET, notificationUnread);

        createEmptyRequestWithHeaders(standardHeaders).options(notificationUnread);
        createEmptyRequestWithHeaders(standardHeaders).addHeaders(notificationUnreadHeaders).get(notificationUnread);
        createEmptyRequestWithHeaders(standardHeaders).options(dashboardInfoUrl);
        createEmptyRequestWithHeaders(standardHeaders).addHeaders(dashboardInfoHeaders).get(dashboardInfoUrl);

        for (int i1 = 0; i1 < operatingTimeMins; i1++) {
            for (int i = 0; i < 2; i++) {
                sleep(29200);
                //2 req dash inf here (0.8 sec cut for response)
                dashboardInfoHeaders = authHeaders(httpGET, dashboardInfoUrl);
                createEmptyRequestWithHeaders(standardHeaders).options(dashboardInfoUrl);
                createEmptyRequestWithHeaders(standardHeaders).addHeaders(dashboardInfoHeaders).get(dashboardInfoUrl);
            }
            notificationUnreadHeaders = authHeaders(httpGET, notificationUnread);
            createEmptyRequestWithHeaders(standardHeaders).options(notificationUnread);
            createEmptyRequestWithHeaders(standardHeaders).addHeaders(notificationUnreadHeaders).get(notificationUnread);
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


    private void sleep(int mills){
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
