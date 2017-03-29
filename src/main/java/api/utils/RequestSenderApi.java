package api.utils;


import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import java.util.Map;

import static com.jayway.restassured.RestAssured.given;

public class RequestSenderApi {
        public RequestSpecification requestSpecification = null;
        public Response response = null;

        public RequestSenderApi(){
        }

        public RequestSenderApi createEmptyRequestWithHeaders(Map<String, ?> map){
            requestSpecification = given().when().headers(map);
            return this;
        }

        public RequestSenderApi createRequestWithHeaders(Map<String, ?> map, String body){
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
            return this;
        }

        RequestSenderApi options(String uri) {
            response = requestSpecification.options(uri);
            return this;
        }

        RequestSenderApi delete(String uri){
            response = requestSpecification.delete(uri);
            return this;
        }

        public RequestSenderApi get(String uri){
            response = requestSpecification.get(uri);
            return this;
        }

        RequestSenderApi put(String uri) {
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
