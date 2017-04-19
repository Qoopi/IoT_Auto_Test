package load;

/**
 * Created by user on 19.04.2017.
 */
public enum URLs {
    HTTPS("https://"),
    ApiGateway("60sglz9l5h.execute-api.us-east-1.amazonaws.com"),
    Dashboard("dashboard.dev.iotsyst.com");

    private final String value;

    URLs(String s) {
        value = s;
    }

    public String getValue(){
        return value;
    }

    public String getValue(String suffix){
        return value+"/"+suffix;
    }
}
