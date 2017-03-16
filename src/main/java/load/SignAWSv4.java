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
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


public class SignAWSv4 extends RequestSender {

    static String accessKeyId = "ASIAJWWDCCOVOUI6TFBA";
    static String secretAccessKey = "+gkpt6pXam39g+2ColHNkNs/rGWKZY/N109bYm8G";
    static String sessionToken = "FQoDYXdzEPH//////////wEaDGxbfyyxMAJ6v31EaiLmA6wY2OcV5o5Dc/VaOj834RAdK6nBDPKV2OnRr5qBqqUVRzu791pf1jynfi+SCpfQnd91GmnTZwOzXcKlcZ2YmDtAd7+0Gg8eWtPmZKSiVQtDNXxu/mq5jgEGNKSGB4i4GvEff6F6SFYldvOl4iqQgUEtYNlaogPZvFPHLniP/c1oInp07KNstm7UUeD/JiapHkCQ1gSkmfwCHyUXavSTliU8FccNUvG/uTJ8QMHHwUsOy9J2rRsfQn40jKxBh2E8uxfWHpbGSbnmBY5u54BDVCi5snLo9K2mmNVdsV/fL/AtIxgRh87wAS0/c8CQP0c47cqo8ow/xhDos6Rxg7hxbbfst2petykQR5Dd1bzJuoAjOjntsPJ7qToC/hCEH0R0pT9GdCssYGZtHICnA81/AWPo15zQtlYtpGdRgyOmBahl+2uH1/Fu4jJvtqeuzIaikwPB/F+c7OWOl/v5xoxbdgk01XV2mmyq+wHbarbEEXHLnggKcyDvXTKsBZwTUY5OH2IBLW1XEKDZy/SP4WvG0Qt9oSWKz5NPZK/NDso5zwVzEodbAxpupQ6sDv4BK3bc5T8/lC38K3OF52yXpEHcaTBgSfjbg3uDJZWReAQRNznbvqxu5NbPBr+M4nj9rcuvary4stadICiJ3arGBQ==";


    @BeforeClass
    public void setUpBaseApiGateway() throws NoSuchAlgorithmException {
        String API_GATEWAY_HOST_URL = "https://60sglz9l5h.execute-api.us-east-1.amazonaws.com";
        int API_GATEWAY_HOST_PORT = 443;
        // Set the host, port, and base path
        RestAssured.baseURI = API_GATEWAY_HOST_URL;
        RestAssured.port = API_GATEWAY_HOST_PORT;
        RestAssured.basePath = "dev";

        // Use our custom socket factory
        SSLSocketFactory customSslFactory = new GatewaySslSocketFactory(
                SSLContext.getDefault(), SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        RestAssured.config = RestAssured.config().sslConfig(
                SSLConfig.sslConfig().sslSocketFactory(customSslFactory));
        RestAssured.config.getHttpClientConfig().reuseHttpClientInstance();
    }

    public void start(){
        //https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev/notification?status=unread

        String serviceName1 = "execute-api";
        String regionName1 = "us-east-1";
        String host1 = "60sglz9l5h."+serviceName1+"."+regionName1+".amazonaws.com";
        String method1 = "GET";
        String cannonicalUri1 = "/dev/notification?status=unread";
        String cannonicalQueryString1 = "";
        String signedHeaders1 = "host;x-amz-date";
        String algoritm1 = "AWS4-HMAC-SHA256";
        String access_key_id1 = "ASIAJLKZL5IDT2F22H5A";
        String secret_access_key = "1DpQqJfd9Wo8liYeRVEhfUZnfKFPFyy8coJJS7JD";
        String session_token = "FQoDYXdzEOr//////////wEaDM5li2qK2gXNuDGaSCLmA4P8OeHnLSUDbV7cE5/tQqnZ+WLO6vkJR/AMpN5nmLb9QZ44cynqPoQDhmggyn32Z98+o7UVCOaxJLH7mNIdkI0BCQG1VFMDmeRk6aVC/JL86I25kVdvA9dOf+uIeZTJIX5oEfjNCcPVpUGnOiZJDgpuisSa6pGVwyKy/gSJBo8ZS9YfEHhbfgGvwREBhBj9LRi+6sRYUW+dtdBDaDIBPUln4702MgpSmZFklS1mAoUjAYiM1BVkvb1Sidq49JsyTHjrj6d0lW5EofxfLJbKtP7wOBULeM+4me6lX8Rc+7gHokZdmdWZOftG6+c/2ST5brUw9GxxQ1QUxyA06pXDhypsQ+bZfJnmJal3ZYm82XZ9qctWq9OvxJPynWRCgHJ4bQrMkQKiTVt6pX8yFD2jDGSnnyJuswX/opKmS4HKYgTrV3zYdsRdXEv3uibFouTQaikYxrULJdlIKaO+5eB5Tu9G1MDpdeXHlsh6Q9NMoMymTfFtpVVTX90PCHYbalmM+xl9E7mZK82ZaB7NO6pnTPHufgTA7wUzWG6vh2G/Zd4QY0a0oMTda47C6WDVeWkwpiLYbvF9+iA4w6Md0eOqIExCYuNLmzogno+z7ouG7zUfNM4vtDEk3DesXO9mRTD9UQKwGr6AqCibrKnGBQ==";
        Date date1 = new Date();

        //generateSign(date1, secret_access_key);

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

    @Test
    private void javaGeneratorTest() throws Exception {
        /*
        Test data:
        key = 'wJalrXUtnFEMI/K7MDENG+bPxRfiCYEXAMPLEKEY'
        dateStamp = '20120215'
        regionName = 'us-east-1'
        serviceName = 'iam'
        Output should be:
        kSecret  = '41575334774a616c725855746e46454d492f4b374d44454e472b62507852666943594558414d504c454b4559'
        kDate    = '969fbb94feb542b71ede6f87fe4d5fa29c789342b0f407474670f0c2489e0a0d'
        kRegion  = '69daa0209cd9c5ff5c8ced464a696fd4252e981430b10e3d3fd8e2f197d7a70c'
        kService = 'f72cfd46f26bc4643f06a11eabb6c0ba18780c19a8da0c31ace671265e3c87fa'
        kSigning = 'f4780e2d9f65fa895f9c67b32ce1baf0b0d8a43505a000a1a9e090d414db404d'
         */

        byte[] kSigning = getSignatureKey("wJalrXUtnFEMI/K7MDENG+bPxRfiCYEXAMPLEKEY", "20120215", "us-east-1", "iam");
        String kS = String.format("%064x", new java.math.BigInteger(1, kSigning));
        System.out.println(kS);
        /*
        Output is: f4780e2d9f65fa895f9c67b32ce1baf0b0d8a43505a000a1a9e090d414db404d
        Expected : f4780e2d9f65fa895f9c67b32ce1baf0b0d8a43505a000a1a9e090d414db404d
        Method getSignatureKey works as expected
        */
    }


    private String generateSign(Date date, String key, String secretKey) {
        //GET https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev/notification?status=unread
        String method = "GET";
        String serviceName = "execute-api";
        String regionName = "us-east-1";
        String host = "60sglz9l5h."+serviceName+"."+regionName+".amazonaws.com";
        String cannonicalUri = "/dev/notification";
        String cannonicalQueryString = "status=unread";

        String signedHeaders = "host;x-amz-date";
        String algoritm = "AWS4-HMAC-SHA256";
        String access_key_id = key;
        String secret_access_key = secretKey;

        String amzDate = getAmzDate(date);
        String dateStamp = getDateStamp(date);


        String credentialScope = dateStamp+"/"+regionName+"/"+serviceName+"/"+"aws4_request";
        String canonicalHeaders = "host:"+host+"\n"+"x-amz-date:"+amzDate+"\n";
        String payloadHash = SHA256("");
        String cannonicalRequest = method+"\n"+cannonicalUri+"\n"+cannonicalQueryString+"\n"+canonicalHeaders+"\n"+signedHeaders+"\n"+payloadHash;

        byte[] signingKey = new byte[0];
        try {
            signingKey = getSignatureKey(secret_access_key, dateStamp, regionName, serviceName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String stringToSign = algoritm+"\n"+amzDate+"\n"+credentialScope+"\n"+SHA256(cannonicalRequest);

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
        //System.out.println(xAmzDate);
        return xAmzDate;
    }

    private String getDateStamp(Date date) {
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
        f.setTimeZone(TimeZone.getTimeZone("GMT"));
        String dateStamp = f.format(date);
        //System.out.println(dateStamp);
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
            md.update(text.getBytes("UTF-8")); // Change this to "UTF-16" if needed
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
