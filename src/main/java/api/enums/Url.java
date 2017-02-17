package api.enums;


public enum  Url {
     MqTT("https://console.aws.amazon.com/iotv2/home?region=us-east-1#/test"),
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
