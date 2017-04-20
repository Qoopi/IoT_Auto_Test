package api;

import system.constant.HTTPMethod;
import system.constant.URLs;
import system.http.JSONHandler;

import java.util.Map;

/**
 * Created by user on 20.04.2017.
 */
public class RequestManagerAPI extends JSONManagerAPI{
    private String idOfCreatedNotificationRule = null;
    private static final String uri = URLs.HTTPS.getValue()+ URLs.ApiGateway.getValue();
    private static final String notificationRule = uri+"/dev/rule";

    public RequestManagerAPI() {
        messagesEnableAllDebugResponse = true;
        messagesEnableErrorDebugResponse = false;
        messagesEnableGatlingReport = false;
    }

    public void notificationRuleCreate(String jsonBody){
//        JSONHandler jsonHandler = new JSONHandler();
//        String jsonBody = jsonHandler.notificationRuleCreateJSONDefault();
        Map<String, String> standardHeaders = standardHeaders();
        Map<String, String> authHeaders = authHeaders(HTTPMethod.POST.getValue(), notificationRule, jsonBody);

        String response = createRequestWithHeaders(standardHeaders, jsonBody).addHeaders(authHeaders).post(notificationRule).extractAllResponseAsString();
        idOfCreatedNotificationRule = getIdOfCreatedNotificationRule(response);
    }

    public void notificationRulesRead(){
        Map<String, String> standardHeaders = standardHeaders();
        Map<String, String> authHeaders = authHeaders(HTTPMethod.GET.getValue(), notificationRule);

        createEmptyRequestWithHeaders(standardHeaders).addHeaders(authHeaders).get(notificationRule);
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
