package api.enums;


public enum  Url {
     LOGIN("/"),
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
