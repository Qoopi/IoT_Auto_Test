package load;

import org.testng.annotations.Test;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class SignAWSv4 {



    String key = "ASIAI24CD54MW4VZCQTQ";
    String regionName = "us-east-1";
    String serviceName = "execute-api";
    String host = "60sglz9l5h."+serviceName+"."+regionName+".amazonaws.com";
    String endpoint = "https://"+host;
    String algoritm = "AWS4-HMAC-SHA256";
    String method = "GET";
    String cannonicalUri = "/dev/authentication/callback/custom-google";
    String cannonicalQueryString = "";
    String signedHeaders = "host;x-amz-date";

    //credential_scope = datestamp + '/' + region + '/' + service + '/' + 'aws4_request'

    //RAW static headers down here
    String UserAgent = "User-Agent:Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36";
    String ContentType = "Content-Type:application/json";
    String Connection = "Connection:keep-alive";
    String Accept = "Accept:*/*";
    String AcceptEncoding = "Accept-Encoding: gzip, deflate, sdch, br";;
    String AcceptLanguage = "Accept-Language: en-US,en;q=0.8";

    @Test
    public void start() throws Exception {
//        Date date = new Date();
//        String amzDate = getAmzDate(date);
//        String dateStamp = getDateStamp(date);
        String amzDate = "20170315T135826Z";
        String dateStamp = "20170315";
        String credentialScope = dateStamp+"/"+regionName+"/"+serviceName+"/"+"aws4_request";
        String canonicalHeaders = "host:"+host+"\n"+"x-amz-date:"+amzDate+"\n";
        String payloadHash = SHA256("");
        String cannonicalRequest = method+"\n"+cannonicalUri+"\n"+cannonicalQueryString+"\n"+canonicalHeaders+"\n"+signedHeaders+"\n"+payloadHash;

        byte[] signingKey = getSignatureKey("vLTv8UbD3ruENGd7dmsNdnbxCWYDLtnlMgrfc1Qx", dateStamp, regionName, serviceName);

        String stringToSign = algoritm+"\n"+amzDate+"\n"+credentialScope+"\n"+SHA256(cannonicalRequest);

        byte[] si = HmacSHA256(stringToSign, signingKey);
        String signature = String.format("%064x", new java.math.BigInteger(1, si));

        String authorizationHeader = algoritm+" "+"Credential="+key+"/"+credentialScope+", "+"SignedHeaders="+signedHeaders+", "+"Signature="+signature;


//        System.out.println(credentialScope);
//        System.out.println(canonicalHeaders);
//        System.out.println(payloadHash);
//        System.out.println(cannonicalRequest);
//        System.out.println(signingKey);
//        System.out.println(stringToSign);
//        System.out.println(signature);
        System.out.println(authorizationHeader);
    }

    @Test
    public void testSHA(){
        SHA256("");
    }


    public void buildPythonRequest(){

    }

    public void buildJSRequest(){

    }

    /*
    Request URL:https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev/chart/Thing-000013-i3?channelIdx=1&startDate=1489581139389&type=2
    Request Method:GET

    GET /dev/chart/Thing-000013-i3?channelIdx=1&startDate=1489581139389&type=2 HTTP/1.1
    Host: 60sglz9l5h.execute-api.us-east-1.amazonaws.com
    Authorization: AWS4-HMAC-SHA256 Credential=ASIAJIVXZMWHSLQDVI6Q/20170315/us-east-1/execute-api/aws4_request, SignedHeaders=host;x-amz-date, Signature=70ce2af3b850d6d6dd9f91f88e0a374088af96d2cb57672b5a09d755954031c5
    Origin: https://dashboard.dev.iotsyst.com
    x-amz-security-token: FQoDYXdzENb//////////wEaDDGaPC0o+WuwWbb0bCLmA01Th9Vowshtcaxsrxwr2KRRunRaPXN8F90iVheADAmRa0C7ePuK3TUywNWaz5ncoBrDpQt4XmAQI3eO8LMc8WKKdBZ5fIL8uNhuadetK3Wy+u5FuZLmanSrMUUNf3WOVSsG1IuY9Yf8tPSWXYvTFV9qLhDP+aAe2d6H3l62Bg1jvCgu00690gja+0Qx8Rp5Pm/mE/hWkPB2ZJ+8lI8ZL4GBKWRA7yL8M2HgQzc6YTwRyeH/Bjn0QZfMWV0RzY1WINQgygqOVkJOWhopEGK0lP5I1+20QcvywFyxozqqc70arbL/n9VejcGd+0aHBvsMkwbfFcxZFwrbC1w55tEFGkdG0JIMVnMI6SxUUkqHKummFLDEKQlBsJDsJalwyTcL3w0Bz0AmxvLr/UFHMy5KMO/wXyw9oq0YP2hTX56gDh330KpKV6BhZGoaJ0JhtGAedF2yL/cVq7lWU22YHoEJDTzeA6o985+HTgP5Mumn7n5kCnrXQY/3V5/kUrQF1Zirf5j9chsw8auCngdNFsjujzjf00Qs8ksVqvTLfBPIA3fo40C167UEvmmfm+f9xWnMROLKTw1eDRl+z+yuwpNMTFYH6LYj75/wTzWa7dnuAgeIDEn9Jk7sh8Xk8uqinorHewNosZ93ZijE6KTGBQ==
    x-amz-date: 20170315T123250Z
    Referer: https://dashboard.dev.iotsyst.com/
     */



    public void testTest() {
        /*
        CanonicalRequest =
        HTTPRequestMethod + '\n' +
        CanonicalURI + '\n' +
        CanonicalQueryString + '\n' +
        CanonicalHeaders + '\n' +
        SignedHeaders + '\n' +
        HexEncode(Hash(RequestPayload))
     */


        String HTTPRequestMethod = "GET";
        String CanonicalURI = "";
        String CanonicalQueryString = "";
        String CanonicalHeaders = "";
        String SignedHeaders = "";
        String HexEndoce = "";




    }


    public String getAmzDate(Date date) {
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");
        String xAmzDate = f.format(date);
        //System.out.println(xAmzDate);
        return xAmzDate;
    }

    public String getDateStamp(Date date) {
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
        String dateStamp = f.format(date);
        //System.out.println(dateStamp);
        return dateStamp;
    }

    static byte[] HmacSHA256(String data, byte[] key) throws Exception {
        String algorithm = "HmacSHA256";
        Mac mac = Mac.getInstance(algorithm);
        mac.init(new SecretKeySpec(key, algorithm));
        return mac.doFinal(data.getBytes("UTF8"));
    }

    public String SHA256(String text){
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
        //System.out.println(result);
        return result;
    }

    static byte[] getSignatureKey(String key, String dateStamp, String regionName, String serviceName) throws Exception {
        byte[] kSecret = ("AWS4" + key).getBytes("UTF8");
        byte[] kDate = HmacSHA256(dateStamp, kSecret);
        byte[] kRegion = HmacSHA256(regionName, kDate);
        byte[] kService = HmacSHA256(serviceName, kRegion);
        byte[] kSigning = HmacSHA256("aws4_request", kService);
        return kSigning;
    }
}
