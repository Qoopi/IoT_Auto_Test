package load.utils;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import system.constant.HTTPMethod;
import system.constant.Things;
import system.http.JSONHandler;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;

import static system.constant.URLs.*;
import static ui.utils.WaitsAsserts.sleep;

public class RequestManager extends RequestTemplates{
    private static ThreadLocal<String> idOfCreatedNotificationRule = new ThreadLocal<>();
    private static ThreadLocal<String> idOfCreatedReport = new ThreadLocal<>();
    private static String idOfCreatedVPVDashboard = null;
    private static String idOfCreatedGPVDashboard = null;


    private static final String thingGPV = Things.ThingGPV.getValue();
    private static final String thingVPV = Things.ThingVPV13.getValue();
    private static final String channelVPV = Things.ChannelVPV.getValue();


    public void getChart(int repeats, int timeBetweenRequests){
        long startDate = 1490189802247L;
        String url = Chart.getValue()+"/"+thingVPV+"?"+channelVPV+"&startDate="+startDate+"&type=2";
        Map<String,?> standardHeaders = standardHeaders();

        for (int i = 0; i<repeats; i++) {
            Map<String, ?> authHeaders = authHeaders(HTTPMethod.GET.getValue(), url);

            createEmptyRequestWithHeaders(authHeaders).addHeaders(standardHeaders).get(url);
            sleep(timeBetweenRequests);
        }
    }

    //CRUD here
    private void notificationRuleCreate(){
        JSONHandler jsonHandler = new JSONHandler();
        String jsonBody = jsonHandler.notificationRuleCreateJSONDefault();
        Map<String, String> standardHeaders = standardHeaders();
        Map<String, String> authHeaders = authHeaders(HTTPMethod.POST.getValue(), NotificationRule.getValue(), jsonBody);

        String response = createRequestWithHeaders(standardHeaders, jsonBody).addHeaders(authHeaders).post(NotificationRule.getValue()).extractAllResponseAsString();
        idOfCreatedNotificationRule.set(getIdOfCreatedNotificationRule(response));
    }

    private void notificationRulesRead(){
        Map<String, String> standardHeaders = standardHeaders();
        Map<String, String> authHeaders = authHeaders(HTTPMethod.GET.getValue(), NotificationRule.getValue());

        createEmptyRequestWithHeaders(standardHeaders).addHeaders(authHeaders).get(NotificationRule.getValue());
    }

    private void notificationRuleUpdate(){
        JSONHandler jsonHandler = new JSONHandler();
        String jsonBody = jsonHandler.notificationRuleUpdateJSON(idOfCreatedNotificationRule.get());
        Map<String, String> standardHeaders = standardHeaders();
        Map<String, String> authHeaders = authHeaders(HTTPMethod.PUT.getValue(), NotificationRule.getValue(), jsonBody);

        createRequestWithHeaders(standardHeaders, jsonBody).addHeaders(authHeaders).put(NotificationRule.getValue());
    }

    private void notificationRuleDelete(){
        JSONHandler jsonHandler = new JSONHandler();
        String jsonBody = jsonHandler.notificationRuleDeleteJSON(idOfCreatedNotificationRule.get());

        Map<String, String> standardHeaders = standardHeaders();
        Map<String, String> authHeaders = authHeaders(HTTPMethod.DELETE.getValue(), NotificationRule.getValue(), jsonBody);

        createRequestWithHeaders(standardHeaders, jsonBody).addHeaders(authHeaders).delete(NotificationRule.getValue());
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


    public void checkExpiredCredentials(int operatingTimeMins){
        Map<String,?> standardHeaders = standardHeaders();

        for (int i = 0; i<operatingTimeMins; i++) {
            Map<String,?> authHeaders = authHeaders(HTTPMethod.GET.getValue(), NotificationUnread.getValue());

            createEmptyRequestWithHeaders(authHeaders).addHeaders(standardHeaders).get(NotificationUnread.getValue());
            String jsonString = response.asString();

            if (jsonString.contains("\"expired\":true")) {
                parseNewCreds(jsonString);
            }

            sleep(59000);
        }

    }

    public void dashboardCreateCanvasVPV(){
        JSONHandler jsonHandler = new JSONHandler();
        String body = jsonHandler.dashboardCreateCanvasVPVJSONDefault();
        Map<String, String> standardHeaders = standardHeaders();
        Map<String, String> authHeaders = authHeaders(HTTPMethod.POST.getValue(), Dashboard.getValue(), body);

        String response = createRequestWithHeaders(authHeaders, body).addHeaders(standardHeaders).post(Dashboard.getValue(), false).extractAllResponseAsString();
        idOfCreatedVPVDashboard = getIdOfCreatedDashboard(response);
    }

    public void dashboardCreateCanvasGPV(){
        JSONHandler jsonHandler = new JSONHandler();
        String body = jsonHandler.dashboardCreateCanvasGPVJSONDefault();
        Map<String, String> standardHeaders = standardHeaders();
        Map<String, String> authHeaders = authHeaders(HTTPMethod.POST.getValue(), Dashboard.getValue(), body);

        String response = createRequestWithHeaders(authHeaders, body).addHeaders(standardHeaders).post(Dashboard.getValue(), false).extractAllResponseAsString();
        idOfCreatedGPVDashboard = getIdOfCreatedDashboard(response);
    }

    public void dashboardDeleteCanvasVPV(){
        deleteCanvasDashboardById(idOfCreatedVPVDashboard);
    }

    public void dashboardDeleteCanvasGPV(){
        deleteCanvasDashboardById(idOfCreatedGPVDashboard);
    }

    private void deleteCanvasDashboardById(String id){
        JSONHandler jsonHandler = new JSONHandler();
        String jsonBody = jsonHandler.dashboardDeleteJSON(id);

        Map<String, String> standardHeaders = standardHeaders();
        Map<String, String> authHeaders = authHeaders(HTTPMethod.DELETE.getValue(), Dashboard.getValue(), jsonBody);

        createRequestWithHeaders(standardHeaders, jsonBody).addHeaders(authHeaders).delete(Dashboard.getValue(), false);

    }

    public void canvasVPVDashboardLoadRefreshCycle(int tenMinuteCyclesCount){
        int repeatsHighLoad = 11;
        int operatingTimeMinsLowLoad = 9;

        Map<String, String> standardHeaders = standardHeaders();
        long oldDate = 1490627550017L;
        String chartUpdate = Chart.getValue()+"/"+thingVPV+"?"+channelVPV+"&startDate=" + oldDate + "&type=2";
        String chartUpdate1 = Chart.getValue()+"/"+thingVPV+"?"+channelVPV+"&startDate=";
        String chartUpdate2 = "&type=2";
        String dashboardInfo = Dashboard.getValue()+"/"+idOfCreatedVPVDashboard;
        Map<String, String> chartUpdateHeaders = null;

        for(int i1 = 0; i1<tenMinuteCyclesCount; i1++) {
            for (int i = 0; i < repeatsHighLoad; i++) {
                chartUpdateHeaders = authHeaders(HTTPMethod.GET.getValue(), chartUpdate);
                createEmptyRequestWithHeaders(standardHeaders).options(chartUpdate);
                createEmptyRequestWithHeaders(standardHeaders).addHeaders(chartUpdateHeaders).get(chartUpdate);
            }
            canvasVPVChartRefreshTemplateActualTime(operatingTimeMinsLowLoad, chartUpdate1, chartUpdate2, dashboardInfo, NotificationUnread.getValue());
        }
    }

    public void canvasGPVDashboardLoadRefreshCycle(int tenMinuteCyclesCount){
        int repeatsHighLoad = 1;
        int operatingTimeMinsLowLoad = 9;//should be 9

        Map<String, String> standardHeaders = standardHeaders();
        long oldDate = System.currentTimeMillis()-898581;//almost 15 min nazad
        String chartUpdate = Chart.getValue()+"/"+thingGPV+"?startDate="+oldDate;
        String chartUpdate1 = Chart.getValue()+"/"+thingGPV+"?startDate=";
        String dashboardInfo = Dashboard.getValue()+"/"+idOfCreatedGPVDashboard;
        Map<String, String> chartUpdateHeaders = null;

        for(int i1 = 0; i1<tenMinuteCyclesCount; i1++) {
            for (int i = 0; i < repeatsHighLoad; i++) {
                chartUpdateHeaders = authHeaders(HTTPMethod.GET.getValue(), chartUpdate);
                createEmptyRequestWithHeaders(standardHeaders).options(chartUpdate);
                createEmptyRequestWithHeaders(standardHeaders).addHeaders(chartUpdateHeaders).get(chartUpdate);
            }
            canvasGPVChartRefreshTemplateActualTime(operatingTimeMinsLowLoad, chartUpdate1, dashboardInfo, NotificationUnread.getValue());
        }
    }

    public void canvasGPVDashboardRefreshCycleBurst(int tenMinuteCyclesCount){
        int repeatsHighLoad = 1;
        int operatingTimeMinsLowLoad = 9;

        Map<String, String> standardHeaders = standardHeaders();
        long oldDate = System.currentTimeMillis()-898581;//almost 15 min nazad
        String chartUpdate = Chart.getValue()+"/"+thingGPV+"?startDate="+oldDate;
        String chartUpdate1 = Chart.getValue()+"/"+thingGPV+"?startDate=";
        String dashboardInfo = Dashboard.getValue()+"/"+idOfCreatedGPVDashboard;
        Map<String, String> chartUpdateHeaders = null;

        for(int i1 = 0; i1<tenMinuteCyclesCount; i1++) {
            for (int i = 0; i < repeatsHighLoad; i++) {
                chartUpdateHeaders = authHeaders(HTTPMethod.GET.getValue(), chartUpdate);
                createEmptyRequestWithHeaders(standardHeaders).options(chartUpdate);
                createEmptyRequestWithHeaders(standardHeaders).addHeaders(chartUpdateHeaders).get(chartUpdate);
            }
            canvasGPVChartRefreshTemplateBurst(operatingTimeMinsLowLoad, chartUpdate1, dashboardInfo, NotificationUnread.getValue());
        }
    }

    public void canvasVPVDashboardRefreshCycleOldTimestamp(int operatingTimeMins) {
        //в зависимости от времени меняется startDate
        //в зависимости от юзера и дашборда меняется chartUpdate и dashboardInfo
        long startDate = 1490627550017L;
        String chartUpdate = Chart.getValue()+"/"+thingVPV+"?"+channelVPV+"&startDate=" + startDate + "&type=2";
        String dashboardInfo = Dashboard.getValue()+"/"+idOfCreatedVPVDashboard;

        canvasVPVChartRefreshTemplate(operatingTimeMins, chartUpdate, dashboardInfo, NotificationUnread.getValue());
    }

    public void canvasVPVDashboardRefreshCycleProperTimestamp(int operatingTimeMins) {
        //в зависимости от времени меняется startDate
        //в зависимости от юзера и дашборда меняется chartUpdate и dashboardInfo
        long oneSecEarlier = System.currentTimeMillis()-1000;
        String chartUpdate = Chart.getValue()+"/"+thingVPV+"?"+channelVPV+"&startDate=" + oneSecEarlier + "&type=2";
        String dashboardInfo = Dashboard.getValue()+"/"+idOfCreatedVPVDashboard;

        canvasVPVChartRefreshTemplate(operatingTimeMins, chartUpdate, dashboardInfo, NotificationUnread.getValue());
    }


    public void canvasGPVDashboardRefreshCycleOldTimestamp(int operatingTimeMins) {
        //в зависимости от времени меняется startDate
        //в зависимости от юзера и дашборда меняется chartUpdate и dashboardInfo
        long startDate = 1490627550017L;
        String chartUpdate = Chart.getValue()+"/"+thingGPV+"?startDate=" + startDate;
        String dashboardInfo = Dashboard.getValue()+"/"+idOfCreatedGPVDashboard;

        canvasGPVChartRefreshTemplate(operatingTimeMins, chartUpdate, dashboardInfo, NotificationUnread.getValue());
    }

    public void canvasGPVDashboardRefreshCycleProperTimestamp(int operatingTimeMins) {
        //в зависимости от времени меняется startDate
        //в зависимости от юзера и дашборда меняется chartUpdate и dashboardInfo
        long oneSecEarlier = System.currentTimeMillis()-1000;
        String chartUpdate = Chart.getValue()+"/"+thingGPV+"?startDate=" + oneSecEarlier;
        String dashboardInfo = Dashboard.getValue()+"/"+idOfCreatedGPVDashboard;

        canvasGPVChartRefreshTemplate(operatingTimeMins, chartUpdate, dashboardInfo, NotificationUnread.getValue());
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

        dashboardInfoHeaders = authHeaders(HTTPMethod.GET.getValue(), dashboardInfoUrl);
        notificationUnreadHeaders = authHeaders(HTTPMethod.GET.getValue(), NotificationUnread.getValue());

        createEmptyRequestWithHeaders(standardHeaders).options(NotificationUnread.getValue());
        createEmptyRequestWithHeaders(standardHeaders).addHeaders(notificationUnreadHeaders).get(NotificationUnread.getValue());
        createEmptyRequestWithHeaders(standardHeaders).options(dashboardInfoUrl);
        createEmptyRequestWithHeaders(standardHeaders).addHeaders(dashboardInfoHeaders).get(dashboardInfoUrl);

        for (int i1 = 0; i1 < operatingTimeMins; i1++) {
            for (int i = 0; i < 2; i++) {
                sleep(29200);
                //2 req dash inf here (0.8 sec cut for response)
                dashboardInfoHeaders = authHeaders(HTTPMethod.GET.getValue(), dashboardInfoUrl);
                createEmptyRequestWithHeaders(standardHeaders).options(dashboardInfoUrl);
                createEmptyRequestWithHeaders(standardHeaders).addHeaders(dashboardInfoHeaders).get(dashboardInfoUrl);
            }
            notificationUnreadHeaders = authHeaders(HTTPMethod.GET.getValue(), NotificationUnread.getValue());
            createEmptyRequestWithHeaders(standardHeaders).options(NotificationUnread.getValue());
            createEmptyRequestWithHeaders(standardHeaders).addHeaders(notificationUnreadHeaders).get(NotificationUnread.getValue());
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

    //i've turn this method off, because we don't use signed requests in gatling anymore
    public void writeCredsTofile(){
        PrintWriter out = null;
        try {
            out = new PrintWriter("src/main/resources/credentials/creds.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        out.write("AccessKeyId,"+awsCredentials.getAccessKeyId()+"\r\n");
        out.write("SecretAccessKey,"+awsCredentials.getSecretAccessKey()+"\r\n");
        out.write("SessionToken,"+awsCredentials.getSessionToken()+"\r\n");
        out.close();
    }

}
