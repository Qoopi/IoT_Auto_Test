package api;

import com.jayway.restassured.response.Response;
import org.apache.http.protocol.HTTP;
import org.testng.Assert;
import system.constant.HTTPMethod;
import system.constant.URLs;
import system.http.JSONHandler;

import java.util.Map;

/**
 * Created by user on 20.04.2017.
 */
public class RequestManagerAPI extends JSONManagerAPI{
    private String idOfCreatedNotificationRule = null;
    private Response responseApi = null;
    private static final String uri = URLs.HTTPS.getValue()+ URLs.ApiGateway.getValue();
    private static final String notificationRule = uri+"/dev/rule";
    private static final String notificationUnread = uri+"/dev/notification?status=unread";

    public RequestManagerAPI() {
        messagesEnableAllDebugResponse = true;
        messagesEnableErrorDebugResponse = false;
        messagesEnableGatlingReport = false;
    }

    public Response notificationRuleCreate(String jsonBody){
//        JSONHandler jsonHandler = new JSONHandler();
//        String jsonBody = jsonHandler.notificationRuleCreateJSONDefault();
        Map<String, String> standardHeaders = standardHeaders();
        Map<String, String> authHeaders = authHeaders(HTTPMethod.POST.getValue(), notificationRule, jsonBody);

        Response response = createRequestWithHeaders(standardHeaders, jsonBody).addHeaders(authHeaders).post(notificationRule).getResponse();
        idOfCreatedNotificationRule = getIdOfCreatedNotificationRule(response.asString());
        checkStatusCode(response);
        return response;
    }

    private void checkStatusCode(Response response){
        Assert.assertTrue(response.statusCode() == 200 || response.statusCode() == 304 || response.statusCode() == 201 || response.statusCode() == 202
                || response.statusCode() == 203 || response.statusCode() == 204 || response.statusCode() == 205 || response.statusCode() == 206
                || response.statusCode() == 207 || response.statusCode() == 208 || response.statusCode() == 209);
    }

    public void checkNotificationRuleIsCreated(){
        String responseToCheck = notificationRulesRead().asString();
        Assert.assertTrue(responseToCheck.contains(idOfCreatedNotificationRule));
    }

    public void checkNotificationRuleTriggered(){

    }

    public Response notificationGetUnread(){
        Map<String, String> headers = allHeaders(HTTPMethod.GET.getValue(), notificationUnread);

        Response response = createEmptyRequestWithHeaders(headers).get(notificationUnread).getResponse();
        return response;
    }

    public Response notificationRulesRead(){
        Map<String, String> standardHeaders = standardHeaders();
        Map<String, String> authHeaders = authHeaders(HTTPMethod.GET.getValue(), notificationRule);

        Response response = createEmptyRequestWithHeaders(standardHeaders).addHeaders(authHeaders).get(notificationRule).getResponse();
        return response;
    }

    public void notificationRuleUpdate(String jsonBody){
//        JSONHandler jsonHandler = new JSONHandler();
//        String jsonBody = jsonHandler.notificationRuleUpdateJSON(idOfCreatedNotificationRule);
        Map<String, String> standardHeaders = standardHeaders();
        Map<String, String> authHeaders = authHeaders(HTTPMethod.PUT.getValue(), notificationRule, jsonBody);

        createRequestWithHeaders(standardHeaders, jsonBody).addHeaders(authHeaders).put(notificationRule);
    }

    public void notificationRuleDelete(String idOfNotificationRule){
        JSONHandler jsonHandler = new JSONHandler();
        String jsonBody = jsonHandler.notificationRuleDeleteJSON(idOfNotificationRule);

        Map<String, String> standardHeaders = standardHeaders();
        Map<String, String> authHeaders = authHeaders(HTTPMethod.DELETE.getValue(), notificationRule, jsonBody);

        createRequestWithHeaders(standardHeaders, jsonBody).addHeaders(authHeaders).delete(notificationRule);
    }
}
