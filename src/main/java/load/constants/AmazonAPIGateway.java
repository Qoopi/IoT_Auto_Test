package load.constants;

/**
 * Created by user on 04.04.2017.
 */
public enum AmazonAPIGateway {
    Dashboard("https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev/dashboard"),
    Rule("https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev/rule"),
    Report("https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev/report"),

    ;
    private String uri;
    AmazonAPIGateway(String url) {
        this.uri = url;
    }

    public String getUri() {
        return this.uri;
    }

    public String getUri(String suffix) {
        return this.uri + "/" + suffix;
    }

}