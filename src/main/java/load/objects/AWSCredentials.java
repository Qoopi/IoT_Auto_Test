package load.objects;

/**
 * Created by user on 17.03.2017.
 */
public class AWSCredentials {
    String accessKeyId; //required for request and for sign
    String secretAccessKey; //required for sign
    String sessionToken; //required for request

    @Override
    public String toString() {
        return "AWSCredentials{" +
                "accessKeyId='" + accessKeyId + '\'' +
                ", secretAccessKey='" + secretAccessKey + '\'' +
                ", sessionToken='" + sessionToken + '\'' +
                '}';
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getSecretAccessKey() {
        return secretAccessKey;
    }

    public void setSecretAccessKey(String secretAccessKey) {
        this.secretAccessKey = secretAccessKey;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }
}
