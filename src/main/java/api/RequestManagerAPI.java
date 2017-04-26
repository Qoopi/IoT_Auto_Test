package api;

import com.jayway.restassured.response.Response;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;
import system.constant.HTTPMethod;
import system.constant.URLs;
import system.http.JSONHandler;

import java.util.ArrayList;
import java.util.Map;

import static jodd.util.ThreadUtil.sleep;

/**
 * Created by user on 20.04.2017.
 */
public class RequestManagerAPI extends JSONManagerAPI{
    private static String idOfCreatedNotificationRule = null;
    private static String idOfCreatedReport = null;
    private Response responseApi = null;
    private static final String uri = URLs.HTTPS.getValue()+ URLs.ApiGateway.getValue();
    private static final String notificationRule = uri+"/dev/rule";
    private static final String notificationUnread = uri+"/dev/notification?status=unread";
    private static final String notification = uri+"/dev/notification";
    private static final String equipmentAdmin = uri+"/dev/equipment_admin";
    private static final String report = uri+"/dev/report";

    public RequestManagerAPI() {
        messagesEnableAllDebugResponse = true;
        messagesEnableErrorDebugResponse = false;
        messagesEnableGatlingReport = false;
    }

    public void skedlerReportCreate(){
        //TODO вынести JSONы для репортов в JsonManagerAPI
        String jsonBody = JSONReportCreate();

        Map<String, String> authHeaders = allHeaders(HTTPMethod.PUT.getValue(), report, jsonBody);

        Response response = createRequestWithHeaders(authHeaders, jsonBody).put(report).getResponse();
        //тут сделать парс json и запись id в variable
        idOfCreatedReport = getIdOfCreatedReport(response.asString());
        checkStatusCode(response);
        checkErrorInResponseBody(response);
    }

    public void skedlerReportSendNow(){
        String jsonBody = JSONReportSendNow(idOfCreatedReport);
        Map<String, String> authHeaders = allHeaders(HTTPMethod.POST.getValue(), report, jsonBody);

        Response response = createRequestWithHeaders(authHeaders, jsonBody).post(report).getResponse();
        checkStatusCode(response);
        checkErrorInResponseBody(response);
    }

    public void skedlerReportDelete(){
        String jsonBody = "";
        //get body from test account
        //{"filter_name":"GPV-Smart-Sensor-Report-List-15-minutes","filterTitle":"GPV-Smart-Sensor-Report-List-15-minutes hom.ossystem@gmail.com","equipments":"Thing-090035-0","id":null,"filterId":"7e15db45-45f3-4f41-8979-bd35787be667","emails":"hom.ossystem@gmail.com","userId":"0315f51c-67ab-4390-bdd1-46bd9d3fd038","createdAt":null,"excelIncluded":null}

        Map<String, String> authHeaders = allHeaders(HTTPMethod.DELETE.getValue(), report, jsonBody);

        Response response = createRequestWithHeaders(authHeaders, jsonBody).delete(report).getResponse();
        checkStatusCode(response);
        checkErrorInResponseBody(response);
    }


    @Step("Deleting all notifications.")
    public void notificationListDeleteAll(){
        ArrayList ids = getIdsOfAllNotifications(notificationListRead().asString());
        String jsonBody = notificationListDeleteAllJSON(ids);
        Map<String, String> authHeaders = allHeaders(HTTPMethod.DELETE.getValue(), notification, jsonBody);
        Response response = createRequestWithHeaders(authHeaders, jsonBody).delete(notification).getResponse();
        checkStatusCode(response);
        checkErrorInResponseBody(response);
    }
    @Step("Changing state of equipment Connected/Disconnected")
    public Response equipmentChangeState(String jsonBody){
        Map<String, String> authHeaders = allHeaders(HTTPMethod.PUT.getValue(), equipmentAdmin, jsonBody);
        Response response = createRequestWithHeaders(authHeaders, jsonBody).put(equipmentAdmin).getResponse();
        checkStatusCode(response);
        checkErrorInResponseBody(response);
        return response;

    }
    @Step("Creating rule.")
    public Response notificationRuleCreate(String jsonBody){
        Map<String, String> authHeaders = allHeaders(HTTPMethod.POST.getValue(), notificationRule, jsonBody);
        Response response = createRequestWithHeaders(authHeaders, jsonBody).post(notificationRule).getResponse();
        idOfCreatedNotificationRule = getIdOfCreatedNotificationRule(response.asString());
        checkStatusCode(response);
        checkErrorInResponseBody(response);
        return response;
    }
    @Step("Check if rule created.")
    public void checkNotificationRuleIsCreated(){
        Response response = notificationRulesRead();
        checkStatusCode(response);
        checkErrorInResponseBody(response);
        Assert.assertTrue(response.asString().contains(idOfCreatedNotificationRule));
    }
    @Step("Check if Rule not triggered.")
    public void checkNotificationRuleNotTriggered(){
        Assert.assertTrue(!notificationListRead().asString().contains(idOfCreatedNotificationRule));
    }
    @Step("Check if rule triggered.")
    public void checkNotificationRuleTriggered(){
        if(notificationListRead().asString().contains(idOfCreatedNotificationRule)){
            Assert.assertTrue(true);
        }
        else{
            sleep(10000);
            Assert.assertTrue(notificationListRead().asString().contains(idOfCreatedNotificationRule));
        }
    }
    @Step("Check if rule triggered.")
    public void checkNotificationRuleTriggeredLong(){
        if(notificationListRead().asString().contains(idOfCreatedNotificationRule)){
            Assert.assertTrue(true);
        }
        else{
            sleep(10000);
            if (notificationListRead().asString().contains(idOfCreatedNotificationRule)){
                Assert.assertTrue(true);
            }
            else {
                sleep(30000);
                Assert.assertTrue(notificationListRead().asString().contains(idOfCreatedNotificationRule));
            }
        }
    }

    public Response notificationGetUnread(){
        Map<String, String> headers = allHeaders(HTTPMethod.GET.getValue(), notificationUnread);
        Response response = createEmptyRequestWithHeaders(headers).get(notificationUnread).getResponse();
        checkStatusCode(response);
        checkErrorInResponseBody(response);
        return response;
    }

    public Response notificationRulesRead(){
        Map<String, String> authHeaders = allHeaders(HTTPMethod.GET.getValue(), notificationRule);
        Response response = createEmptyRequestWithHeaders(authHeaders).get(notificationRule).getResponse();
        checkStatusCode(response);
        checkErrorInResponseBody(response);
        return response;
    }

    public Response notificationListRead(){
        Map<String, String> authHeaders = allHeaders(HTTPMethod.GET.getValue(), notification);
        Response response = createEmptyRequestWithHeaders(authHeaders).get(notification).getResponse();
        checkStatusCode(response);
        checkErrorInResponseBody(response);
        return response;
    }


    public Response notificationRuleUpdate(String jsonBody){
        Map<String, String> authHeaders = allHeaders(HTTPMethod.PUT.getValue(), notificationRule, jsonBody);

        Response response = createRequestWithHeaders(authHeaders, jsonBody).put(notificationRule).getResponse();
        checkStatusCode(response);
        checkErrorInResponseBody(response);
        return response;
    }

    public void notificationRuleDelete(String idOfNotificationRule){
        JSONHandler jsonHandler = new JSONHandler();
        String jsonBody = jsonHandler.notificationRuleDeleteJSON(idOfNotificationRule);
        Map<String, String> authHeaders = allHeaders(HTTPMethod.DELETE.getValue(), notificationRule, jsonBody);
        Response response = createRequestWithHeaders(authHeaders, jsonBody).delete(notificationRule).getResponse();
        checkStatusCode(response);
        checkErrorInResponseBody(response);
    }
    @Step("Deleting notifications")
    public void notificationRuleDelete(){
        JSONHandler jsonHandler = new JSONHandler();
        String jsonBody = jsonHandler.notificationRuleDeleteJSON(idOfCreatedNotificationRule);
        Map<String, String> authHeaders = allHeaders(HTTPMethod.DELETE.getValue(), notificationRule, jsonBody);
        Response response = createRequestWithHeaders(authHeaders, jsonBody).delete(notificationRule).getResponse();
        checkStatusCode(response);
        checkErrorInResponseBody(response);
    }

    private void checkStatusCode(Response response){
        Assert.assertTrue(response.statusCode() == 200 || response.statusCode() == 304 || response.statusCode() == 201 || response.statusCode() == 202
                || response.statusCode() == 203 || response.statusCode() == 204 || response.statusCode() == 205 || response.statusCode() == 206
                || response.statusCode() == 207 || response.statusCode() == 208 || response.statusCode() == 209);
    }

    private void checkErrorInResponseBody(Response response) {
        if (!response.asString().contains("error") && !response.asString().contains("exception") && !response.asString().contains("expired") && !response.asString().contains("timed out")) {
            Assert.assertTrue(true);
        } else {
            if (response.asString().contains("\"expired\":false")) {
                Assert.assertTrue(true);
            } else {
                Assert.assertTrue(false);
                System.out.println("ERR: error message found in response body");
            }
        }
    }
}
