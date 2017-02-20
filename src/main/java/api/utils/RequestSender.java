package api.utils;


import api.enums.Url;
import api.json.PayloadJSON;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;


import static com.jayway.restassured.RestAssured.given;
    public class RequestSender {
        private static String TOKEN = "FQoDYXdzEI///////////wEaDCshIuwocUlgPPP9ByLmA7AF8qtGOslpgBETF4kJ9XTEfhPZ0+DQ2/ENG4bJTDkeVQqeeBKo0ezrNZ8or61GGy/GLmkNqyuxoeOQJH8wB0FhEU/s7XeAuTs4PKwBHAKRgVwFFOxLuBJUH0KY+ZxpVB5pO6aLFTtF3LXTRapPG1pak2DWjjkdpNHJpRzsN7/3UtrDv/j2q8EYCBRFLYUN9FB3X132EbY7qBq1eHPhwkq2LhbXqDFmeqyD5epVOzkSsXDJI+5U/jbNkE+bpQvM3bkqJAkQtYdty79gZ+tlLcXIBx985i/VsIrMMd8sHkB6hanrgzl67dfh9Uxskm1E5Af1EmBK8yhlfGI0xD5jb9NmX5Jus6z+Zpn+HDMJ67SSD3iSq1l6XsHqTnw5PSgUtT6xDo4iCfW1h+6mwujYLQmDBavItJBA3ZqJlqEt5+3hWeZvlX2sXA1NyDowsejWMVBw9G2Ax9194Jwq8pKLw4zwomxpCiT8I/+c1yZz5kvLbOgKOj5uGPOhINOET/wqy7GfKb2r2R9SvFPdRTvPYNu7klrkfAJzJnY8jR0gPjKGDbBLQNhs1jQ9PoQXkgxTBS406OnSd1EdihGiw6QS+fDximBWraeSd3+enRFLRZ0714/gRPCdqwiprEAbHHFxBqRGd7dnmSjg56vFBQ==";
        private static String KEY = "AWS4-HMAC-SHA256 Credential=ASIAI3M4R2BZCBNJVKOA/20170220/us-east-1/execute-api/aws4_request, SignedHeaders=host;x-amz-date, Signature=d9324ac5a8118569ebb2fe00de5dcc42309c70d830ca685b8f50ccc59a4dff1a";
        private final static ContentType CONTENT_TYPE = ContentType.JSON;
        private RequestSpecification requestSpecification = null;
        public Response response = null;

        public RequestSender(){
        }

/*
        public void authenticate(){

            PayloadJSON JSON = new PayloadJSON();
            String credentials = JSON.toString();
            createRequest(credentials)
                    .post(Url.Equipment.getUri());


            if (RestAssured.baseURI.contains("https://")){
                System.out.println("Connected via HTTPS");
                JSESSIONID = response.then().extract().path("session.value");
                STUDIO_TOKEN = response.then().extract().cookie("studio.crowd.tokenkey");
                System.out.println(JSESSIONID);
                System.out.println(STUDIO_TOKEN);
            }
            else{
                System.out.println("Connected via HTTP");
                JSESSIONID = response.then().extract().path("session.value");
                System.out.println(JSESSIONID);
            }

        }
*/

        public RequestSender createRequest(String body){
            if (RestAssured.baseURI.contains("https://")){
                this.createRequestSpecification()
                        .addHeader("Content-Type", CONTENT_TYPE.toString())
                        .addHeader("x-amz-security-token",TOKEN)
                        .addHeader("Authorization",KEY)
                        .addBody(body);
                return this;
            }
            else{
                this.createRequestSpecification()
                        .addHeader("Content-Type", CONTENT_TYPE.toString())
                        .addHeader("x-amz-security-token",TOKEN)
                        .addHeader("Authorization",KEY)
                        .addBody(body);
                return this;
            }
        }
        private RequestSender createRequestSpecification() {
            requestSpecification = given().
                    when();
            return this;
        }

        public RequestSender createEmptyRequest(){
            if(RestAssured.baseURI.contains("https://")){
                this.createRequestSpecification()
                        .addHeader("Content-Type", CONTENT_TYPE.toString())
                        .addHeader("x-amz-security-token",TOKEN)
                        .addHeader("Authorization",KEY);
                return this;
            }
            else{
                this.createRequestSpecification()
                        .addHeader("Content-Type", CONTENT_TYPE.toString())
                        .addHeader("x-amz-security-token",TOKEN)
                        .addHeader("Authorization",KEY);
                return this;
            }
        }


        // этот метод сможет добавлять столько угодно хедеров
        private RequestSender addHeader(String headerName, String headerValue) {
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

        RequestSender delete(String uri){
            response = requestSpecification.delete(uri);
            return this;
        }

        RequestSender get(String uri){
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
