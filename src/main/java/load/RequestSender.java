package load;


import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import load.objects.AWSCredentials;

import java.time.LocalDateTime;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;

public class RequestSender {
        public RequestSpecification requestSpecification = null;
        public Response response = null;
        public static AWSCredentials awsCredentials = new AWSCredentials();

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
            System.out.println(LocalDateTime.now()+" : "+response.statusCode()+" : "+response.time()+" : "+"POST    : "+uri);
            return this;
        }

        RequestSender options(String uri) {
            response = requestSpecification.options(uri);
            debugInfoPrint();
            System.out.println(LocalDateTime.now()+" : "+response.statusCode()+" : "+response.time()+" : "+"OPTIONS : "+uri);
            return this;
        }

        RequestSender delete(String uri){
            response = requestSpecification.delete(uri);
            debugInfoPrint();
            System.out.println(LocalDateTime.now()+" : "+response.statusCode()+" : "+response.time()+" : "+"DELETE  : "+uri);
            return this;
        }

        public RequestSender get(String uri){
            response = requestSpecification.get(uri);
            debugInfoPrint();
            System.out.println(LocalDateTime.now()+" : "+response.statusCode()+" : "+response.time()+" : "+"GET     : "+uri);
            return this;
        }

        RequestSender put(String uri) {
            response = requestSpecification.put(uri);
            debugInfoPrint();
            System.out.println(LocalDateTime.now()+" : "+response.statusCode()+" : "+response.time()+" : "+"PUT     : "+uri);
            return this;
        }

        public String extractResponseByPath(String path){
            return response.then().extract().path(path);
        }

        public String extractAllResponseAsString(){
            return response.then().extract().asString();
        }

        public void debugInfoPrint(){
            if (response.statusCode() != 200) {
                System.out.println("==================================");
                System.out.println(response.statusCode());
                System.out.println("-------------------------------");
                System.out.println(response.headers().toString());
                System.out.println("-------------------------------");
                System.out.println(response.asString());
                System.out.println("==================================");
            }
        }

    }
