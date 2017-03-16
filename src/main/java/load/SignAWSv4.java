package load;

import api.utils.RequestSender;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.config.SSLConfig;
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
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


public class SignAWSv4 extends RequestSender {

    static String accessKeyId = "ASIAJWWDCCOVOUI6TFBA";
    static String secretAccessKey = "+gkpt6pXam39g+2ColHNkNs/rGWKZY/N109bYm8G";
    static String sessionToken = "FQoDYXdzEPH//////////wEaDGxbfyyxMAJ6v31EaiLmA6wY2OcV5o5Dc/VaOj834RAdK6nBDPKV2OnRr5qBqqUVRzu791pf1jynfi+SCpfQnd91GmnTZwOzXcKlcZ2YmDtAd7+0Gg8eWtPmZKSiVQtDNXxu/mq5jgEGNKSGB4i4GvEff6F6SFYldvOl4iqQgUEtYNlaogPZvFPHLniP/c1oInp07KNstm7UUeD/JiapHkCQ1gSkmfwCHyUXavSTliU8FccNUvG/uTJ8QMHHwUsOy9J2rRsfQn40jKxBh2E8uxfWHpbGSbnmBY5u54BDVCi5snLo9K2mmNVdsV/fL/AtIxgRh87wAS0/c8CQP0c47cqo8ow/xhDos6Rxg7hxbbfst2petykQR5Dd1bzJuoAjOjntsPJ7qToC/hCEH0R0pT9GdCssYGZtHICnA81/AWPo15zQtlYtpGdRgyOmBahl+2uH1/Fu4jJvtqeuzIaikwPB/F+c7OWOl/v5xoxbdgk01XV2mmyq+wHbarbEEXHLnggKcyDvXTKsBZwTUY5OH2IBLW1XEKDZy/SP4WvG0Qt9oSWKz5NPZK/NDso5zwVzEodbAxpupQ6sDv4BK3bc5T8/lC38K3OF52yXpEHcaTBgSfjbg3uDJZWReAQRNznbvqxu5NbPBr+M4nj9rcuvary4stadICiJ3arGBQ==";

    public static final String API_GATEWAY_HOST_URL = "https://4********r.execute-api.us-east-1.amazonaws.com";
    private static final int API_GATEWAY_HOST_PORT = 443;




    @BeforeClass
    public void setUpBaseApiGateway() throws NoSuchAlgorithmException {
        // Set the host, port, and base path
        //RestAssured.baseURI = API_GATEWAY_HOST_URL;
        //RestAssured.port = API_GATEWAY_HOST_PORT;
        //RestAssured.basePath = "dev";

        // Use our custom socket factory
        SSLSocketFactory customSslFactory = new GatewaySslSocketFactory(
                SSLContext.getDefault(), SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        RestAssured.config = RestAssured.config().sslConfig(
                SSLConfig.sslConfig().sslSocketFactory(customSslFactory));
        RestAssured.config.getHttpClientConfig().reuseHttpClientInstance();
    }

    @Test
    public void parseForCanonicalRequest() throws MalformedURLException, URISyntaxException {
        //GET https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev/notification?status=unread
//        String method1 = method;
//        String url1 = url;

        String sUrl = "https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev/notification?status=unread";

        URL url = new URL(sUrl);
        String host = url.getHost();
        String path = url.getPath();
        String queryString = url.getQuery();

        if (!sUrl.contains("60sglz9l5h.execute-api.us-east-1.amazonaws.com")){
            System.out.println("Looks like you using unknown URL, check it!");
        }

        System.out.println(host);
        System.out.println(path);
        System.out.println(queryString);


        String serviceName = "execute-api";
        String regionName = "us-east-1";
        //String host = "60sglz9l5h."+serviceName+"."+regionName+".amazonaws.com";
        //String cannonicalUri = "/dev/notification";
        //String cannonicalQueryString = "status=unread";

    }

    @Test
    private void checkResponse(){
        for (int i = 0; i<100; i++) {
            Date date = new Date();
            String auth = generateSign(date, accessKeyId, secretAccessKey);
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
                    .addHeader("x-amz-security-token", sessionToken)
                    .addHeader("Authorization", auth)
                    .get("https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev/notification?status=unread");

            System.out.println("==================================");
            System.out.println(response.statusCode());
            System.out.println(response.asString());
            System.out.println("==================================");

            //{"count":0,"creds":{"expired":true,"accessKeyId":"ASIAJCDWWYVW5EFRSO5A","secretAccessKey":"vBrImXNINrlEFwxD1fcUzPu/J2KEj0ECTOkmt4wJ","sessionToken":"FQoDYXdzEO///////////wEaDHx0AkBey4fnCcE1DyLmA/ypMj1aITry4qeHvW30PVXLQAKzZV3K4KOmZr0+6wiNkOh3wkjY9WTKEW0zaC4z0IfXrxf3idzOVrlDYWME3m8pq2uZ3k58AU4EdWpNfxRsKpjt3NeS1sD+Jsy9OZyN8yCWsSSCjv0LGLj8Spcg1lJhKns1L+G0zI4FrFNe02iSaT9s+Ly0whrFySp0vXrthBW4b5C0VGqPoYL7OmMM8uLPvlRr0Ep/B++WW5lFr6d40biC0J8c7mqytsWM+ION0C3Fr7nJT6kTkZYlbGE11YyaODxHxjHzd2EjGYkvbO6cuCOnfkjfdeLPQ2akmXYy86fcJBXokaNdZzg82lQMne6CUp0bOiXMIFPuBiQFFR66qLqMZXpM1wgX39QyPxJDo8S/T6UTasutLxOvQxYAbdELJqAysSIBEndl3K/7JOdMVq5rquIN8rD3o+QAnxU0mL+BqR2cg1YS8PwEqHWYU/KVyiW+v92u3NNGRV6+3FD4BNzqqNShzyN5wstbokY8X7cQwtOM4Su1jUfJ7Fx2p0QZckyg4azh1jriF8nUfcGAGJGOGYsLYuF8qb9CKaufqlLCSVeDYOt20/b69rYl/zHbH8GRXhIqMNxak5V7KELy0Lmh9PfUa+dkLiqyBjDIl7EmrNF6bSiPsqrGBQ=="}}

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


    public void parseNewCreds(String jsonString){
        //{"count":0,"creds":{"expired":true,"accessKeyId":"ASIAJCDWWYVW5EFRSO5A","secretAccessKey":"vBrImXNINrlEFwxD1fcUzPu/J2KEj0ECTOkmt4wJ","sessionToken":"FQoDYXdzEO///////////wEaDHx0AkBey4fnCcE1DyLmA/ypMj1aITry4qeHvW30PVXLQAKzZV3K4KOmZr0+6wiNkOh3wkjY9WTKEW0zaC4z0IfXrxf3idzOVrlDYWME3m8pq2uZ3k58AU4EdWpNfxRsKpjt3NeS1sD+Jsy9OZyN8yCWsSSCjv0LGLj8Spcg1lJhKns1L+G0zI4FrFNe02iSaT9s+Ly0whrFySp0vXrthBW4b5C0VGqPoYL7OmMM8uLPvlRr0Ep/B++WW5lFr6d40biC0J8c7mqytsWM+ION0C3Fr7nJT6kTkZYlbGE11YyaODxHxjHzd2EjGYkvbO6cuCOnfkjfdeLPQ2akmXYy86fcJBXokaNdZzg82lQMne6CUp0bOiXMIFPuBiQFFR66qLqMZXpM1wgX39QyPxJDo8S/T6UTasutLxOvQxYAbdELJqAysSIBEndl3K/7JOdMVq5rquIN8rD3o+QAnxU0mL+BqR2cg1YS8PwEqHWYU/KVyiW+v92u3NNGRV6+3FD4BNzqqNShzyN5wstbokY8X7cQwtOM4Su1jUfJ7Fx2p0QZckyg4azh1jriF8nUfcGAGJGOGYsLYuF8qb9CKaufqlLCSVeDYOt20/b69rYl/zHbH8GRXhIqMNxak5V7KELy0Lmh9PfUa+dkLiqyBjDIl7EmrNF6bSiPsqrGBQ=="}}

//        String jsonString = "{\"count\":0,\"creds\":{\"expired\":true,\"accessKeyId\":\"ASIAJCDWWYVW5EFRSO5A\",\"secretAccessKey\":\"vBrImXNINrlEFwxD1fcUzPu/J2KEj0ECTOkmt4wJ\",\"sessionToken\":\"FQoDYXdzEO///////////wEaDHx0AkBey4fnCcE1DyLmA/ypMj1aITry4qeHvW30PVXLQAKzZV3K4KOmZr0+6wiNkOh3wkjY9WTKEW0zaC4z0IfXrxf3idzOVrlDYWME3m8pq2uZ3k58AU4EdWpNfxRsKpjt3NeS1sD+Jsy9OZyN8yCWsSSCjv0LGLj8Spcg1lJhKns1L+G0zI4FrFNe02iSaT9s+Ly0whrFySp0vXrthBW4b5C0VGqPoYL7OmMM8uLPvlRr0Ep/B++WW5lFr6d40biC0J8c7mqytsWM+ION0C3Fr7nJT6kTkZYlbGE11YyaODxHxjHzd2EjGYkvbO6cuCOnfkjfdeLPQ2akmXYy86fcJBXokaNdZzg82lQMne6CUp0bOiXMIFPuBiQFFR66qLqMZXpM1wgX39QyPxJDo8S/T6UTasutLxOvQxYAbdELJqAysSIBEndl3K/7JOdMVq5rquIN8rD3o+QAnxU0mL+BqR2cg1YS8PwEqHWYU/KVyiW+v92u3NNGRV6+3FD4BNzqqNShzyN5wstbokY8X7cQwtOM4Su1jUfJ7Fx2p0QZckyg4azh1jriF8nUfcGAGJGOGYsLYuF8qb9CKaufqlLCSVeDYOt20/b69rYl/zHbH8GRXhIqMNxak5V7KELy0Lmh9PfUa+dkLiqyBjDIl7EmrNF6bSiPsqrGBQ==\"}}\n";


        if (jsonString.contains("\"expired\":true")) {
            JSONParser parser = new JSONParser();
            JSONObject json = null;
            try {
                json = (JSONObject) parser.parse(jsonString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            JSONObject creds = (JSONObject) json.get("creds");
            accessKeyId = creds.get("accessKeyId").toString();
            secretAccessKey = creds.get("secretAccessKey").toString();
            sessionToken = creds.get("sessionToken").toString();

            System.out.println(accessKeyId);
            System.out.println(secretAccessKey);
            System.out.println(sessionToken);
        }

    }

    private String generateSign(Date date, String key, String secretKey) {
        //GET https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev/notification?status=unread
        String method = "GET";
        String serviceName = "execute-api";
        String regionName = "us-east-1";
        String host = "60sglz9l5h."+serviceName+"."+regionName+".amazonaws.com";
        String canonicalUri = "/dev/notification";
        String canonicalQueryString = "status=unread";

        String signedHeaders = "host;x-amz-date";
        String algoritm = "AWS4-HMAC-SHA256";
        String access_key_id = key;
        String secret_access_key = secretKey;

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
