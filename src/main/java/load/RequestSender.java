package load;


import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import load.objects.AWSCredentials;

import java.util.Map;

import static com.jayway.restassured.RestAssured.given;

public class RequestSender {
        public RequestSpecification requestSpecification = null;
        public Response response = null;
        public static AWSCredentials awsCredentials = new AWSCredentials();

        //these three booleans controls console output messages
        private boolean enableGatlingReportMessages = false; //should be used with debug messages off (if you want gatling reports to work)
        private boolean enableErrorDebugResponseMessages = false;
        private boolean enableAllDebugResponseMessages = true;

        public RequestSender(){
        }

        public RequestSender createEmptyRequestWithHeaders(Map<String, ?> map){
            requestSpecification = given().when().headers(map);
            return this;
        }

        public RequestSender createRequestWithHeaders(Map<String, ?> map, String body){
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

        RequestSender post(String uri) {
            response = requestSpecification.post(uri);
            debugInfoPrint();
            gatlingInfoPrintRequest("POST_"+uri);
            return this;
        }

        RequestSender options(String uri) {
            response = requestSpecification.options(uri);
            debugInfoPrint();
            gatlingInfoPrintRequest("OPTIONS_"+uri);
            return this;
        }

        RequestSender delete(String uri){
            response = requestSpecification.delete(uri);
            debugInfoPrint();
            gatlingInfoPrintRequest("DELETE_"+uri);
            return this;
        }

        public RequestSender get(String uri){
            response = requestSpecification.get(uri);
            debugInfoPrint();
            gatlingInfoPrintRequest("GET_"+uri);
            return this;
        }

        RequestSender put(String uri) {
            response = requestSpecification.put(uri);
            debugInfoPrint();
            gatlingInfoPrintRequest("PUT_"+uri);
            return this;
        }

        public String extractResponseByPath(String path){
            return response.then().extract().path(path);
        }

        public String extractAllResponseAsString(){
            return response.then().extract().asString();
        }



        private void gatlingInfoPrintRequest(String methodAndUri){
            if (enableGatlingReportMessages) {
                String name = "somename";
                long thread = Thread.currentThread().getId();
                String requestName = methodAndUri;

                if (response.statusCode() == 200 || response.statusCode() == 304 || response.statusCode() == 201 || response.statusCode() == 202
                        || response.statusCode() == 203 || response.statusCode() == 204 || response.statusCode() == 205 || response.statusCode() == 206
                        || response.statusCode() == 207 || response.statusCode() == 208 || response.statusCode() == 209) {
                    System.out.println("REQUEST\t" + name + "\t" + thread + "\t\t" + requestName + "\t" + (System.currentTimeMillis() - response.time()) + "\t" + System.currentTimeMillis() + "\t" + "OK\t ");
                } else {
                    System.out.println("REQUEST\t" + name + "\t" + thread + "\t\t" + requestName + "\t" + (System.currentTimeMillis() - response.time()) + "\t" + System.currentTimeMillis() + "\t" + "KO\tstatus.find.in(200,304,201,202,203,204,205,206,207,208,209), but actually found " + response.statusCode());
                }
            }
        }

        private void debugInfoPrint(){
            if(enableErrorDebugResponseMessages) {
                if (response.statusCode() != 200) {
                    System.out.println("==================================");
                    System.out.println("Response time: "+response.time());
                    System.out.println("Status code: "+response.statusCode());
                    System.out.println("-------------------------------");
                    System.out.println(response.headers().toString());
                    System.out.println("-------------------------------");
                    System.out.println(response.asString());
                    System.out.println("==================================");
                }
            }
            if (enableAllDebugResponseMessages){
                System.out.println("==================================");
                System.out.println("Response time: "+response.time());
                System.out.println("Status code: "+response.statusCode());
                System.out.println("-------------------------------");
                System.out.println(response.headers().toString());
                System.out.println("-------------------------------");
                System.out.println(response.asString());
                System.out.println("==================================");
            }
        }

    }
