package api.utils;


import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import load.utils.GatlingReportAdapter;
import load.utils.RequestSender;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.Map;

import static com.jayway.restassured.RestAssured.given;
import static load.utils.RequestSender.awsCredentials;

public class RequestSenderApi {
        private RequestSpecification requestSpecification = null;
        private Response response = null;
        private final boolean enableErrorDebugResponseMessages = false;
        private final boolean enableAllDebugResponseMessages = false;

        public RequestSenderApi(){
        }


    public RequestSenderApi createEmptyRequestWithHeaders(Map<String, ?> map) {
        requestSpecification = given().when().headers(map);
        return this;
    }

    public RequestSenderApi createRequestWithHeaders(Map<String, ?> map, String body) {
        requestSpecification = given().when().headers(map).body(body);
        return this;
    }

    public RequestSenderApi createRequestSpecification() {
        requestSpecification = given().
                when();
        return this;
    }

    // этот метод сможет добавлять столько угодно хедеров из Map
    public RequestSenderApi addHeaders(Map<String, ?> map) {
        requestSpecification.headers(map);
        return this;
    }

    // этот метод сможет добавлять столько угодно хедеров
    public RequestSenderApi addHeader(String headerName, String headerValue) {
        requestSpecification.header(headerName, headerValue);
        return this;
    }

    private RequestSenderApi addBody(String body) {
        requestSpecification.body(body);
        return this;
    }

    RequestSenderApi post(String uri) {
        response = requestSpecification.post(uri);
        debugInfoPrint("POST_" + uri);

        return this;
    }

    RequestSenderApi options(String uri) {
        response = requestSpecification.options(uri);
        debugInfoPrint("OPTIONS_" + uri);
        return this;
    }

    RequestSenderApi delete(String uri) {
        response = requestSpecification.delete(uri);
        debugInfoPrint("DELETE_" + uri);
        return this;
    }

    RequestSenderApi get(String uri) {
        response = requestSpecification.get(uri);
        debugInfoPrint("GET_" + uri);
        checkExpiredCredentials(response, uri);
        return this;
    }

    RequestSenderApi put(String uri) {
        response = requestSpecification.put(uri);
        debugInfoPrint("PUT_" + uri);
        return this;
    }



    public String extractResponseByPath(String path) {
        return response.then().extract().path(path);
    }

    public String extractAllResponseAsString() {
        return response.then().extract().asString();
    }


    private void checkExpiredCredentials(Response response, String url) {
        if (url.contains("notification?status=unread")) {
            if (response.asString().contains("\"expired\":true")) {
                JSONParser parser = new JSONParser();
                JSONObject json = null;
                try {
                    json = (JSONObject) parser.parse(response.asString());
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
    }


    private void debugInfoPrint(String url) {
        if (enableErrorDebugResponseMessages || enableAllDebugResponseMessages) {
            if (response.statusCode() != 200 || response.asString().contains("error") || enableAllDebugResponseMessages) {
                System.out.println("==================================");
                System.out.println("Request: ");
                System.out.println(url);
                System.out.println("-------------------------------");
                System.out.println("Response time: " + response.time());
                System.out.println("Status code: " + response.statusCode());
                System.out.println("-------------------------------");
                System.out.println(response.headers().toString());
                System.out.println("-------------------------------");
                System.out.println(response.asString());
                System.out.println("==================================");
            }
        }
    }
}
