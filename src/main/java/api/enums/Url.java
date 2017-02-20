package api.enums;


public enum  Url {
     Equipment("https://qpo57tscm2.execute-api.us-east-1.amazonaws.com/wstaging/equipment"),
     SEARCH("/"), ;
    private String uri;

    Url(String url) {
        this.uri = url;
    }

    public String getUri() {
        return this.uri;
    }

    public String getUri(String suffix) {
        return this.uri + "/" + suffix;
    }

}
