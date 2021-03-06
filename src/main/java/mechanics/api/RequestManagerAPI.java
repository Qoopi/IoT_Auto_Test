package mechanics.api;

import com.google.gson.JsonObject;
import com.jayway.restassured.response.Response;
import mechanics.system.constant.AssembledEquipments;
import mechanics.system.constant.AssembledUrls;
import mechanics.system.http.JSONHandler;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Pattern;

import static mechanics.system.constant.HTTPMethod.*;

/**
 * Created by user on 20.04.2017.
 */
public class RequestManagerAPI extends JSONManagerAPI {
    public static String idOfCreatedNotificationRule = null;
    private static String idOfCreatedReport = null;
    private static String idOfCreatedDashboard = null;
    private Response responseApi = null;


    private static String dashboard = AssembledUrls.dashboard;

    private static String thingVPVForDashboard = AssembledEquipments.equipmentVpv;
    private static String thingGPVForDashboard = AssembledEquipments.equipmentGpv;

    public RequestManagerAPI() {
        messagesEnableAllDebugResponse = true;
        messagesEnableErrorDebugResponse = false;
        messagesEnableGatlingReport = false;
    }


    public Response getGlobalSettings(){
        Response response = sendAmazonRequest(GET.getValue(), AssembledUrls.globalSettings);
        checkResponse(response);
        return response;
    }

    public void getRoute(String[] routes) {

        for (int i = 0; i < routes.length; i++) {
            Response response = sendAmazonRequest(GET.getValue(), AssembledUrls.apiUrl + routes[i]);
            checkResponseSoft(response);
        }

    }


    public void authenticationRefresh() {
        Response response = sendAmazonRequest(GET.getValue(), AssembledUrls.authenticationRefresh);
        checkResponse(response);
    }

    @Step("Creating report")
    public void skedlerReportCreate() {
        String jsonBody = JSONReportCreate();
        Response response = sendAmazonRequest(PUT.getValue(), AssembledUrls.report, jsonBody);
        //тут сделать парс json и запись id в variable
        idOfCreatedReport = getIdOfCreatedReport(response.asString());
        checkResponse(response);
    }

    @Step("Sending report now.")
    public void skedlerReportSendNow() {
        String jsonBody = JSONReportSendNow(idOfCreatedReport);
        Response response = sendAmazonRequest(POST.getValue(), AssembledUrls.report, jsonBody);
        checkResponse(response);
    }

    public void skedlerReportDelete() {
        String jsonBody = "";
        //get body from test account
        //{"filter_name":"GPV-Smart-Sensor-Report-List-15-minutes","filterTitle":"GPV-Smart-Sensor-Report-List-15-minutes hom.ossystem@gmail.com","equipments":"Thing-090035-0","id":null,"filterId":"7e15db45-45f3-4f41-8979-bd35787be667","emails":"hom.ossystem@gmail.com","userId":"0315f51c-67ab-4390-bdd1-46bd9d3fd038","createdAt":null,"excelIncluded":null}
        Response response = sendAmazonRequest(DELETE.getValue(), AssembledUrls.report, jsonBody);
        checkResponse(response);
    }


    @Step("Deleting all notifications.")
    public void notificationListDeleteAll() {
        ArrayList<String> ids = getIdsOfAllNotifications(notificationListRead().asString());
        String jsonBody = notificationListDeleteAllJSON(ids);
        Response response = sendAmazonRequest(DELETE.getValue(), AssembledUrls.notification, jsonBody);
        checkResponse(response);
    }

    public void notificationListDeleteAllAssertless() {
        ArrayList<String> ids = getIdsOfAllNotifications(notificationListRead().asString());
        String jsonBody = notificationListDeleteAllJSON(ids);
        Response response = sendAmazonRequest(DELETE.getValue(), AssembledUrls.notification, jsonBody);
        checkStatusCode(response);
    }

    @Step("Changing state of equipment Connected/Disconnected")
    public Response equipmentChangeState(String jsonBody) {
        Response response = sendAmazonRequest(PUT.getValue(), AssembledUrls.equipmentAdmin, jsonBody);
        checkResponse(response);
        return response;

    }

    @Step("Creating rule.")
    public Response notificationRuleCreate(String jsonBody) {
        Response response = sendAmazonRequest(POST.getValue(), AssembledUrls.notificationRule, jsonBody);
        idOfCreatedNotificationRule = getIdOfCreatedNotificationRule(response.asString());
        checkResponse(response);
        return response;
    }

    @Step("Check if rule created.")
    public Response checkNotificationRuleIsCreated() {
        Response response = notificationRulesRead();
        checkResponse(response);
        Assert.assertTrue(response.asString().contains(idOfCreatedNotificationRule));
        return response;
    }

    @Step("Check if Rule not triggered.")
    public void checkNotificationRuleNotTriggered() {
        Assert.assertTrue(!notificationListRead().asString().contains(idOfCreatedNotificationRule));
    }

    @Step("Check if rule triggered.")
    public void checkNotificationRuleTriggered() {
        if (notificationListRead().asString().contains(idOfCreatedNotificationRule)) {
            Assert.assertTrue(true);
        } else {
            sleep(10000);
            Assert.assertTrue(notificationListRead().asString().contains(idOfCreatedNotificationRule));
        }
    }

    @Step("Check if rule triggered.")
    public void checkNotificationRuleTriggeredLong() {
        if (notificationListRead().asString().contains(idOfCreatedNotificationRule)) {
            Assert.assertTrue(true);
        } else {
            sleep(5000);
            if (notificationListRead().asString().contains(idOfCreatedNotificationRule)) {
                Assert.assertTrue(true);
            } else {
                sleep(30000);
                Assert.assertTrue(notificationListRead().asString().contains(idOfCreatedNotificationRule));
            }
        }
    }

    public Response notificationGetUnread() {
        Map<String, String> headers = allHeaders(GET.getValue(), AssembledUrls.notificationUnread);
        Response response = createEmptyRequestWithHeaders(headers).get(AssembledUrls.notificationUnread).getResponse();
        checkResponse(response);
        return response;
    }

    public Response notificationRulesRead() {
        Response response = sendAmazonRequest(GET.getValue(), AssembledUrls.notificationRule);
        checkResponse(response);
        return response;
    }

    public Response notificationRulesRead(boolean checkResponse) {
        Response response = sendAmazonRequest(GET.getValue(), AssembledUrls.notificationRule);
        if (checkResponse) {
            checkResponse(response);
        }
        return response;
    }

    public Response notificationListRead() {
        Response response = sendAmazonRequest(GET.getValue(), AssembledUrls.notification);
        checkResponse(response);
        return response;
    }

    public void setEquipmentThresholdVPV(String equipmentId, int newMaxDistanceAlarmLevelMain, int newMaxDistanceAlarmLevelBlower, int newMaxDistanceAbortLevelMain, int newMaxDistanceAbortLevelBlower) {
        Response response = sendAmazonRequest(GET.getValue(), AssembledUrls.equipmentAdmin);
        checkResponse(response);
        String newBody = changeThresholdVPV(response.asString(), equipmentId, newMaxDistanceAlarmLevelMain, newMaxDistanceAlarmLevelBlower, newMaxDistanceAbortLevelMain, newMaxDistanceAbortLevelBlower);
        if (newBody != null) {
            Response response1 = sendAmazonRequest(PUT.getValue(), AssembledUrls.equipmentAdmin, newBody);
            checkResponse(response1);
        } else {
            System.out.println("ERR: Can't create request for change equipment threshold. Does the equipment have all the required parameters?");
            System.out.println("Check if equipment have any thresholds at all.");
        }
    }

    public Response setEquipmentThresholdGPV(String equipmentId, int newMaxDistanceAlarmLevel) {
        Response response = sendAmazonRequest(GET.getValue(), AssembledUrls.equipmentAdmin);
        checkResponse(response);
        String newBody = changeThresholdGPV(response.asString(), equipmentId, newMaxDistanceAlarmLevel);
        Response response1 = sendAmazonRequest(PUT.getValue(), AssembledUrls.equipmentAdmin, newBody);
        checkResponse(response1);
        return response1;
    }


    public Response notificationRuleUpdate(String jsonBody) {
        Response response = sendAmazonRequest(PUT.getValue(), AssembledUrls.notificationRule, jsonBody);
        checkResponse(response);
        return response;
    }

    @Step("Deleting rule")
    public void notificationRuleDelete(String idOfNotificationRule) {
        JSONHandler jsonHandler = new JSONHandler();
        String jsonBody = jsonHandler.notificationRuleDeleteJSON(idOfNotificationRule);
        Response response = sendAmazonRequest(DELETE.getValue(), AssembledUrls.notificationRule, jsonBody);
        checkResponse(response);
    }

    @Step("Deleting notifications")
    public void notificationRuleDelete() {
        JSONHandler jsonHandler = new JSONHandler();
        String jsonBody = jsonHandler.notificationRuleDeleteJSON(idOfCreatedNotificationRule);
        Response response = sendAmazonRequest(DELETE.getValue(), AssembledUrls.notificationRule, jsonBody);
        checkResponse(response);
    }

    private void checkStatusCode(Response response) {
        Assert.assertTrue(response.statusCode() == 200 || response.statusCode() == 304 || response.statusCode() == 201 || response.statusCode() == 202
                || response.statusCode() == 203 || response.statusCode() == 204 || response.statusCode() == 205 || response.statusCode() == 206
                || response.statusCode() == 207 || response.statusCode() == 208 || response.statusCode() == 209);
    }

    private void checkStatusCodeSoft(Response response) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(response.statusCode() == 200 || response.statusCode() == 304 || response.statusCode() == 201 || response.statusCode() == 202
                || response.statusCode() == 203 || response.statusCode() == 204 || response.statusCode() == 205 || response.statusCode() == 206
                || response.statusCode() == 207 || response.statusCode() == 208 || response.statusCode() == 209);
    }

    private void checkErrorInResponseBody(Response response) {
        if (!response.asString().contains("error") && !response.asString().contains("exception") && !response.asString().contains("expired") && !response.asString().contains("timed out")) {
            Assert.assertTrue(true);
        } else {
            if (response.asString().contains("\"expired\":false") || response.asString().contains("\"expired\":true,\"accessKeyId\"") || response.asString().contains("Dashboards list is empty")) {
                Assert.assertTrue(true);
            } else {
                Assert.assertTrue(false);
                System.out.println("ERR: error message found in response body");
            }
        }
    }

    private void checkErrorInResponseBodySoft(Response response) {
        SoftAssert softAssert = new SoftAssert();
        if (!response.asString().contains("error") && !response.asString().contains("exception") && !response.asString().contains("expired") && !response.asString().contains("timed out")) {
            softAssert.assertTrue(true);
        } else {
            if (response.asString().contains("\"expired\":false") || response.asString().contains("\"expired\":true,\"accessKeyId\"") || response.asString().contains("Dashboards list is empty")) {
                softAssert.assertTrue(true);
            } else {
                softAssert.assertTrue(false);
                System.out.println("ERR: error message found in response body");
            }
        }
    }

    @Step("Check if response contains error message in body or 4** 5** http status code")
    private void checkResponse(Response response) {
        checkStatusCode(response);
        checkErrorInResponseBody(response);
    }

    private void checkResponseSoft(Response response) {
        checkStatusCodeSoft(response);
        checkErrorInResponseBodySoft(response);
    }

    public void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private void dashboardDeleteById(String id) {
        JSONHandler jsonHandler = new JSONHandler();
        String jsonBody = jsonHandler.dashboardDeleteJSON(id);

        Response response = sendAmazonRequest(DELETE.getValue(), dashboard, jsonBody);
        checkResponse(response);
    }

    private Response dashboardsGet() {
        return sendAmazonRequest(GET.getValue(), dashboard);
    }

    @Step("Creating dashboard.")
    public void dashboardCreate(String body) {
        Response response = sendAmazonRequest(POST.getValue(), dashboard, body);
        checkResponse(response);
        idOfCreatedDashboard = getIdOfCreatedDashboard(response.asString());
    }

    @Step("Checking if dashboard is created")
    public void checkDashboardCreated() {
        Response response = dashboardsGet();
        checkResponse(response);
        Assert.assertTrue(response.asString().contains(idOfCreatedDashboard));
        Assert.assertTrue(response.asString().contains(thingVPVForDashboard) || response.asString().contains(thingGPVForDashboard));
    }

    public void dashboardUpdate(String body) {

    }

    public void checkDashboardUpdated(String updatedBody) {

    }

    @Step("Deleting created dashboard.")
    public void dashboardDelete() {
        dashboardDeleteById(idOfCreatedDashboard);
    }

    @Step("Cheking if Dashboard is deleted.")
    public void checkDashboardDeleted() {
        Response response = dashboardsGet();
        checkResponse(response);
        Assert.assertFalse(response.asString().contains(idOfCreatedDashboard));
    }


    public void checkEquipmentDataGPV() {
        String url = AssembledUrls.chart + "/" + AssembledEquipments.equipmentGpv + "?startDate=" + (System.currentTimeMillis() - 60000000);
        Response response = sendAmazonRequest(GET.getValue(), url, false);
        checkResponse(response);
        checkChartData(response);
    }

    public void checkEquipmentDataVPV(String channel, String type) {
        String url = AssembledUrls.chart + "/" + AssembledEquipments.equipmentVpv + "?channelIdx="+ channel + "&startDate=" + (System.currentTimeMillis() - 60000000) + "&type="+type;
        Response response = sendAmazonRequest(GET.getValue(), url, false);
        checkResponse(response);
        checkChartData(response);
    }

    public void checkEquipmentNewDataVPV(String channel, String type) {
        String url = AssembledUrls.chart + "/" + AssembledEquipments.equipmentVpv + "?channelIdx="+ channel + "&startDate=" + (System.currentTimeMillis() - 600000) + "&type="+type;
        Response response = sendAmazonRequest(GET.getValue(), url, false);
        checkResponse(response);
        checkChartData(response);
    }

    public void checkEquipmentNewDataGPV() {
        String url = AssembledUrls.chart + "/" + AssembledEquipments.equipmentGpv + "?startDate=" + (System.currentTimeMillis() - 600000);
        Response response = sendAmazonRequest(GET.getValue(), url, false);
        checkResponse(response);
        checkChartData(response);
    }

    private void checkChartData(Response response) {
        Assert.assertTrue(
                response.asString().contains("{\"x\":") &&
                        response.asString().contains("result") &&
                        response.asString().contains("\"y\":")
        );
    }

    public void checkEquipmentNotDeletedGPV(){
        String url = AssembledUrls.equipment+"/"+AssembledEquipments.equipmentGpv;
        Response response = sendAmazonRequest(GET.getValue(), url);
        checkResponse(response);
        Assert.assertTrue(response.asString().contains("\"isDeleted\":0"));
    }

    public void checkEquipmentNotDeletedVPV(){
        String url = AssembledUrls.equipment+"/"+AssembledEquipments.equipmentVpv;
        Response response = sendAmazonRequest(GET.getValue(), url);
        checkResponse(response);
        Assert.assertTrue(response.asString().contains("\"isDeleted\":0"));
    }

}
