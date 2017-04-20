package system.http;


import com.jayway.restassured.RestAssured;
import com.jayway.restassured.config.SSLConfig;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.apache.http.conn.ssl.SSLSocketFactory;
import system.aws.objects.AWSCredentials;
import load.utils.GatlingReportAdapter;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.net.ssl.SSLContext;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;

public class RequestSender {
    private RequestSpecification requestSpecification = null;
    public Response response = null;
    public static AWSCredentials awsCredentials = new AWSCredentials();

    //these three booleans controls console output messages
    protected boolean messagesEnableGatlingReport = true; //should be used with debug messages off (if you want load.gatling reports to work)
    protected boolean messagesEnableErrorDebugResponse = false;
    protected boolean messagesEnableAllDebugResponse = false;
    private boolean messagesReplaceTimeStampsInUrls = true; //should be on, if you want to generate small and nimble load.gatling reports

    public RequestSender() {
    }

    public RequestSender createEmptyRequestWithHeaders(Map<String, ?> map) {
        requestSpecification = given().when().headers(map);
        return this;
    }

    public RequestSender createRequestWithHeaders(Map<String, ?> map, String body) {
        requestSpecification = given().when().headers(map).body(body);
        return this;
    }

    public RequestSender createRequestSpecification() {
        requestSpecification = given().
                when();
        return this;
    }

    // этот метод сможет добавлять столько угодно хедеров из Map
    public RequestSender addHeaders(Map<String, ?> map) {
        requestSpecification.headers(map);
        return this;
    }

    // этот метод сможет добавлять столько угодно хедеров
    public RequestSender addHeader(String headerName, String headerValue) {
        requestSpecification.header(headerName, headerValue);
        return this;
    }

    private RequestSender addBody(String body) {
        requestSpecification.body(body);
        return this;
    }

    public RequestSender post(String uri) {
        response = requestSpecification.post(uri);
        debugInfoPrint("POST_" + uri);
        GatlingReportAdapter gatling = new GatlingReportAdapter();
        gatling.gatlingInfoPrintRequest("POST_" + uri, response, messagesEnableGatlingReport, messagesReplaceTimeStampsInUrls);
        return this;
    }

    public RequestSender post(String uri, boolean print) {
        response = requestSpecification.post(uri);
        if (print) {
            debugInfoPrint("POST_" + uri);
            GatlingReportAdapter gatling = new GatlingReportAdapter();
            gatling.gatlingInfoPrintRequest("POST_" + uri, response, messagesEnableGatlingReport, messagesReplaceTimeStampsInUrls);
        }
        return this;
    }

    public RequestSender options(String uri) {
        response = requestSpecification.options(uri);
        debugInfoPrint("OPTIONS_" + uri);
        GatlingReportAdapter gatling = new GatlingReportAdapter();
        gatling.gatlingInfoPrintRequest("OPTIONS_" + uri, response, messagesEnableGatlingReport, messagesReplaceTimeStampsInUrls);
        return this;
    }

    public RequestSender options(String uri, boolean print) {
        response = requestSpecification.options(uri);
        if (print) {
            debugInfoPrint("OPTIONS_" + uri);
            GatlingReportAdapter gatling = new GatlingReportAdapter();
            gatling.gatlingInfoPrintRequest("OPTIONS_" + uri, response, messagesEnableGatlingReport, messagesReplaceTimeStampsInUrls);
        }
        return this;
    }

    public RequestSender delete(String uri) {
        response = requestSpecification.delete(uri);
        debugInfoPrint("DELETE_" + uri);
        GatlingReportAdapter gatling = new GatlingReportAdapter();
        gatling.gatlingInfoPrintRequest("DELETE_" + uri, response, messagesEnableGatlingReport, messagesReplaceTimeStampsInUrls);
        return this;
    }

    public RequestSender delete(String uri, boolean print) {
        response = requestSpecification.delete(uri);
        if (print) {
            debugInfoPrint("DELETE_" + uri);
            GatlingReportAdapter gatling = new GatlingReportAdapter();
            gatling.gatlingInfoPrintRequest("DELETE_" + uri, response, messagesEnableGatlingReport, messagesReplaceTimeStampsInUrls);
        }
        return this;
    }

    public RequestSender get(String uri) {
        response = requestSpecification.get(uri);
        debugInfoPrint("GET_" + uri);
        GatlingReportAdapter gatling = new GatlingReportAdapter();
        gatling.gatlingInfoPrintRequest("GET_" + uri, response, messagesEnableGatlingReport, messagesReplaceTimeStampsInUrls);
        checkExpiredCredentials(response, uri);
        return this;
    }

    public RequestSender get(String uri, boolean print) {
        response = requestSpecification.get(uri);
        if (print) {
            debugInfoPrint("GET_" + uri);
            GatlingReportAdapter gatling = new GatlingReportAdapter();
            gatling.gatlingInfoPrintRequest("GET_" + uri, response, messagesEnableGatlingReport, messagesReplaceTimeStampsInUrls);
            checkExpiredCredentials(response, uri);
        }
        return this;
    }

    public RequestSender put(String uri) {
        response = requestSpecification.put(uri);
        debugInfoPrint("PUT_" + uri);
        GatlingReportAdapter gatling = new GatlingReportAdapter();
        gatling.gatlingInfoPrintRequest("PUT_" + uri, response, messagesEnableGatlingReport, messagesReplaceTimeStampsInUrls);
        return this;
    }

    public RequestSender put(String uri, boolean print) {
        response = requestSpecification.put(uri);
        if (print) {
            debugInfoPrint("PUT_" + uri);
            GatlingReportAdapter gatling = new GatlingReportAdapter();
            gatling.gatlingInfoPrintRequest("PUT_" + uri, response, messagesEnableGatlingReport, messagesReplaceTimeStampsInUrls);
        }
        return this;
    }

    public String extractResponseByPath(String path) {
        return response.then().extract().path(path);
    }

    public String extractAllResponseAsString() {
        return response.then().extract().asString();
    }

    public Response getResponse() {
        return response;
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
        if (messagesEnableErrorDebugResponse || messagesEnableAllDebugResponse) {
            if (response.statusCode() != 200 || response.asString().contains("error") || messagesEnableAllDebugResponse) {
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
}