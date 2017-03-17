package api.utils;


import load.SignAWSv4;

import java.util.Map;

public class RequestManager extends SignAWSv4{

    //method
    //request url
    //headers
    public void someRequest(){
        String method = "GET";
        String url = "https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev/notification?status=unread";
        Map<String,?> authHeaders = launch(method, url);
        Map<String,?> standardHeaders = standardHeaders();


        createEmptyRequestWithHeaders(authHeaders).addHeaders(standardHeaders).get(url);
        System.out.println(response.asString());
    }


}
