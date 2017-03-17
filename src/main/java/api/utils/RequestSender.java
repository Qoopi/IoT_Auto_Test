package api.utils;


import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import load.objects.AWSCredentials;

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
            return this;
        }

        RequestSender options(String uri) {
            response = requestSpecification.options(uri);
            return this;
        }

        RequestSender delete(String uri){
            response = requestSpecification.delete(uri);
            return this;
        }

        public RequestSender get(String uri){
            response = requestSpecification.get(uri);
            return this;
        }

        RequestSender put(String uri) {
            response = requestSpecification.put(uri);
            return this;
        }

        public String extractResponseByPath(String path){
            return response.then().extract().path(path);
        }

        public String extractAllResponseAsString(){
            return response.then().extract().asString();
        }

    }
