package load;

import api.utils.RequestSender;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.config.SSLConfig;
import load.objects.AWSURI;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.SSLContext;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


public class SignAWSv4 extends RequestSender {
    public static final String API_GATEWAY_HOST_URL = "https://4********r.execute-api.us-east-1.amazonaws.com";
    private static final int API_GATEWAY_HOST_PORT = 443;


    @BeforeClass
    public void setUpBaseApiGateway(){
        // Set the host, port, and base path
        //RestAssured.baseURI = API_GATEWAY_HOST_URL;
        //RestAssured.port = API_GATEWAY_HOST_PORT;
        //RestAssured.basePath = "dev";

        // Use our custom socket factory
        SSLSocketFactory customSslFactory = null;
        try {
            customSslFactory = new GatewaySslSocketFactory(
                    SSLContext.getDefault(), SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        RestAssured.config = RestAssured.config().sslConfig(
                SSLConfig.sslConfig().sslSocketFactory(customSslFactory));
        RestAssured.config.getHttpClientConfig().reuseHttpClientInstance();
    }

    @Test
    public void test(){
       AWSURI uriaws =  parseForCanonicalRequest("GET", "https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev/notification?status=unread");
        System.out.println(uriaws.toString());
    }


    private AWSURI parseForCanonicalRequest(String method, String url){
        AWSURI awsuri = new AWSURI();

        URL uri = null;
        try {
            uri = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        String host = uri.getHost();
        String path = uri.getPath();
        String queryString = uri.getQuery();

        if (!url.contains("60sglz9l5h.execute-api.us-east-1.amazonaws.com")){
            System.out.println("Looks like you using unknown URL, check it!");
        }

        String serviceName = "execute-api";
        String regionName = "us-east-1";

        awsuri.setMethod(method);
        awsuri.setCanonicalUri(path);
        awsuri.setCanonicalQueryString(queryString);
        awsuri.setHost(host);
        awsuri.setServiceName(serviceName);
        awsuri.setRegionName(regionName);
        awsuri.setFullURL(url);

        return awsuri;
    }

    @Test
    public void checkResponse(){
        for (int i = 0; i<100; i++) {
            Date date = new Date();
            String auth = generateSign(date, parseForCanonicalRequest("GET", "https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev/notification?status=unread"));
            String amzDate = getAmzDate(date);

            createRequestSpecification()
                    .addHeader("Connection", "keep-alive")
                    .addHeader("Referer", "https://dashboard.dev.iotsyst.com/")
                    .addHeader("Accept", "*/*")
                    .addHeader("Content-Type", "application/json")
                    .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36")
                    .addHeader("Accept-Language", "en-US,en;q=0.8")
                    .addHeader("Accept-Encoding", "gzip, deflate, sdch, br")
                    .addHeader("Origin", "https://dashboard.dev.iotsyst.com")
                    .addHeader("x-amz-date", amzDate)
                    .addHeader("x-amz-security-token", awsCredentials.getSessionToken())
                    .addHeader("Authorization", auth)
                    .get("https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev/notification?status=unread");

            System.out.println("==================================");
            System.out.println(response.statusCode());
            System.out.println(response.asString());
            System.out.println("==================================");

            String jsonString = response.asString();

            if (jsonString.contains("\"expired\":true")) {
                parseNewCreds(jsonString);
            }

            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }


    private void parseNewCreds(String jsonString){
        //parse new credentials from jsonstring and write to awsCredentials
        if (jsonString.contains("\"expired\":true")) {
            JSONParser parser = new JSONParser();
            JSONObject json = null;
            try {
                json = (JSONObject) parser.parse(jsonString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            JSONObject creds = (JSONObject) json.get("creds");
            awsCredentials.setAccessKeyId(creds.get("accessKeyId").toString());
            awsCredentials.setSecretAccessKey(creds.get("secretAccessKey").toString());
            awsCredentials.setSessionToken(creds.get("sessionToken").toString());
        }

    }

    private String generateSign(Date date, AWSURI awsuri) {
        String method = awsuri.getMethod();
        String serviceName = awsuri.getServiceName();
        String regionName = awsuri.getRegionName();
        String host = awsuri.getHost();
        String canonicalUri = awsuri.getCanonicalUri();
        String canonicalQueryString = awsuri.getCanonicalQueryString();

        String signedHeaders = "host;x-amz-date";
        String algoritm = "AWS4-HMAC-SHA256";
        String access_key_id = awsCredentials.getAccessKeyId();
        String secret_access_key = awsCredentials.getSecretAccessKey();

        String amzDate = getAmzDate(date);
        String dateStamp = getDateStamp(date);


        String credentialScope = dateStamp+"/"+regionName+"/"+serviceName+"/"+"aws4_request";
        String canonicalHeaders = "host:"+host+"\n"+"x-amz-date:"+amzDate+"\n";
        String payloadHash = SHA256("");
        String canonicalRequest = method+"\n"+canonicalUri+"\n"+canonicalQueryString+"\n"+canonicalHeaders+"\n"+signedHeaders+"\n"+payloadHash;

        byte[] signingKey = new byte[0];
        try {
            signingKey = getSignatureKey(secret_access_key, dateStamp, regionName, serviceName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String stringToSign = algoritm+"\n"+amzDate+"\n"+credentialScope+"\n"+SHA256(canonicalRequest);

        byte[] si = new byte[0];
        try {
            si = HmacSHA256(stringToSign, signingKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String signature = String.format("%064x", new java.math.BigInteger(1, si));

        String authorizationHeader = algoritm+" "+"Credential="+access_key_id+"/"+credentialScope+", "+"SignedHeaders="+signedHeaders+", "+"Signature="+signature;

        System.out.println(amzDate);
        System.out.println(authorizationHeader);

        return authorizationHeader;
    }

    private String getAmzDate(Date date) {
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");
        f.setTimeZone(TimeZone.getTimeZone("GMT"));
        String xAmzDate = f.format(date);
        return xAmzDate;
    }

    private String getDateStamp(Date date) {
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
        f.setTimeZone(TimeZone.getTimeZone("GMT"));
        String dateStamp = f.format(date);
        return dateStamp;
    }

    private byte[] HmacSHA256(String data, byte[] key) throws Exception {
        String algorithm = "HmacSHA256";
        Mac mac = Mac.getInstance(algorithm);
        mac.init(new SecretKeySpec(key, algorithm));
        return mac.doFinal(data.getBytes("UTF8"));
    }

    private String SHA256(String text){
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            md.update(text.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte[] digest = md.digest();
        String result = String.format("%064x", new java.math.BigInteger(1, digest));
        return result;
    }

    private byte[] getSignatureKey(String key, String dateStamp, String regionName, String serviceName) throws Exception {
        byte[] kSecret = ("AWS4" + key).getBytes("UTF8");
        byte[] kDate = HmacSHA256(dateStamp, kSecret);
        byte[] kRegion = HmacSHA256(regionName, kDate);
        byte[] kService = HmacSHA256(serviceName, kRegion);
        byte[] kSigning = HmacSHA256("aws4_request", kService);
        return kSigning;
    }
}
