import java.io.UnsupportedEncodingException
import java.math.BigInteger
import java.net.{MalformedURLException, URL}
import java.security.{MessageDigest, NoSuchAlgorithmException}
import java.text.SimpleDateFormat
import java.util.{Date, TimeZone}
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

import scala.io.Source

class SignAWSv4 extends AWSCredentials {

//  setAccessKeyId("ASIAIYSX3BWOL2OVWPWA")
//  setSecretAccessKey("43fSPzYhdqyEP3Pr4h19A7+pJjQwNHMRd2mNsgpE")
//  setSessionToken("FQoDYXdzEHcaDJRe9HJRRcGQ8cVJzSLmAz4xs91/hApVt1aMt/GH2ozOrNGcG/mLlonKlWgM3l+gtyCb5sSXApO+ypy+LbwtXKGkfWC/TrDYHg86NeUALT9x3oMC7MCDJD4KrSyM6BdYfCKjwylLIL1Dafp10tiosa3XP+sNJ1cK72EGgEhYFt4iAobTz6qvCafHcpBz8pi49VADy9R6MlxCQ/Gsuzk/yjx2krVjnX1SiFeH7mktO7v1VS1CBO6qnww1gqK5YHeJ4HB7nrZliudOEFcWbY/M5P5bedNhPMhdvevbrDs/OkLP5pZYgh/uybepQnkqyqRjdfuwm1LHVDfDqswm8TPEgtheDUubhdyh5qTp5OAwalTAKghyaZVHcOSLKsSUHDtbPTIWXth1u1UPSXmebLDdhe3SihZv0shww0AeqrKnPdoGTjODPR80d9hyP5uBKL+aDEsbDQcEt6dm3b5J1ZIS5b0nKOoFt52iag8yXk2n0UWDXUnF2AjF1N+EPC0eCiq8rbAyVD8/rP4dFfg9pUrdlxTXfBBWVMU8MHsDEnu0I6zzjOOsATMaU2sMA6zhsB2dFglBk5Vc8WpBm2i8texklV7IwI5F6nsWzwCv0iEjysoej58OqYvqxHr7c7ZNjIexoO3d0Nw7NkxGBfx+B3OvVt2ZCtquMSjl3MTGBQ==")


  //проверить этот метод и реализовать что-то на его основе, если он работает
  def readCredsFromFile(){ //берет файл из корня проекта, разбирает его в map (файл генерится jav'ой), сетит ключи и юзает их
    val filename = "../../../../../../creds.txt"
    val keyValuePairs = Source.fromFile(filename, "UTF8")
      .getLines.map(_.stripLineEnd.split(",", -1))
      .map(fields => fields(0) -> fields(1)).toList

    val map = Map(keyValuePairs : _*)

    val accessKey = map("AccessKeyId")
    val secretAccessKey = map("SecretAccessKey")
    val sessionToken = map("SessionToken")
    setAccessKeyId(accessKey)
    setSecretAccessKey(secretAccessKey)
    setSessionToken(sessionToken)
  }

  def allHeaders(method: String, url: String): Map[String, String] = {
    readCredsFromFile()
    val map3 = standardHeaders++authHeaders(method, url)
    map3
  }

  def authHeaders(method: String, url: String): Map[String, String] = {
    val date: Date = new Date
    val awsuri: AWSURI = parseForCanonicalRequest(method, url)
    val sign: String = generateSign(date, awsuri)
    val amzDate = getAmzDate(date)
    val map = Map("x-amz-date" -> amzDate, "Authorization" -> sign, "x-amz-security-token"-> getSessionToken)
    map
  }

  def standardHeaders: Map[String, String] = {
    val map = Map("Connection" -> "keep-alive",
      "Referer" -> "https://dashboard.dev.iotsyst.com/",
      "Accept"-> "*/*",
      "Content-Type"-> "application/json",
      "User-Agent"-> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36",
      "Accept-Language"-> "en-US,en;q=0.8",
      "Accept-Encoding"-> "gzip, deflate, sdch, br",
      "Origin"-> "https://dashboard.dev.iotsyst.com")
    map
  }

  def parseForCanonicalRequest(method: String, url: String): AWSURI = {
    val awsuri: AWSURI = new AWSURI
    var uri: URL = null
    try {
      uri = new URL(url)
    }
    catch {
      case e: MalformedURLException => {
        e.printStackTrace()
      }
    }
    val host: String = uri.getHost
    val path: String = uri.getPath
    var queryString: String = ""
      if(uri.getQuery!=null){
        queryString=uri.getQuery}
    if (!url.contains("60sglz9l5h.execute-api.us-east-1.amazonaws.com")) {
      System.out.println("Looks like you using unknown URL, check it!")
    }
    val serviceName: String = "execute-api"
    val regionName: String = "us-east-1"
    awsuri.setMethod(method)
    awsuri.setCanonicalUri(path)
    awsuri.setCanonicalQueryString(queryString)
    awsuri.setHost(host)
    awsuri.setServiceName(serviceName)
    awsuri.setRegionName(regionName)
    awsuri.setFullURL(url)
    return awsuri
  }

  def generateSign(date: Date, awsuri: AWSURI): String = {
    val method: String = awsuri.getMethod
    val serviceName: String = awsuri.getServiceName
    val regionName: String = awsuri.getRegionName
    val host: String = awsuri.getHost
    val canonicalUri: String = awsuri.getCanonicalUri
    val canonicalQueryString: String = awsuri.getCanonicalQueryString
    val signedHeaders: String = "host;x-amz-date"
    val algoritm: String = "AWS4-HMAC-SHA256"
    val access_key_id: String = getAccessKeyId
    val secret_access_key: String = getSecretAccessKey
    val amzDate: String = getAmzDate(date)
    val dateStamp: String = getDateStamp(date)
    val credentialScope: String = dateStamp + "/" + regionName + "/" + serviceName + "/" + "aws4_request"
    val canonicalHeaders: String = "host:" + host + "\n" + "x-amz-date:" + amzDate + "\n"
    val payloadHash: String = SHA256("")
    val canonicalRequest: String = method + "\n" + canonicalUri + "\n" + canonicalQueryString + "\n" + canonicalHeaders + "\n" + signedHeaders + "\n" + payloadHash
    var signingKey: Array[Byte] = new Array[Byte](0)
    try {
      signingKey = getSignatureKey(secret_access_key, dateStamp, regionName, serviceName)
    }
    catch {
      case e: Exception => {
        e.printStackTrace()
      }
    }
    val stringToSign: String = algoritm + "\n" + amzDate + "\n" + credentialScope + "\n" + SHA256(canonicalRequest)
    var si: Array[Byte] = new Array[Byte](0)
    try {
      si = HmacSHA256(stringToSign, signingKey)
    }
    catch {
      case e: Exception => {
        e.printStackTrace()
      }
    }
    val signature: String = String.format("%064x", new BigInteger(1, si))
    val authorizationHeader: String = algoritm + " " + "Credential=" + access_key_id + "/" + credentialScope + ", " + "SignedHeaders=" + signedHeaders + ", " + "Signature=" + signature
    System.out.println(amzDate)
    System.out.println(authorizationHeader)
    return authorizationHeader
  }

  def getAmzDate(date: Date): String = {
    val f: SimpleDateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'")
    f.setTimeZone(TimeZone.getTimeZone("GMT"))
    val xAmzDate: String = f.format(date)
    return xAmzDate
  }

  private def getDateStamp(date: Date): String = {
    val f: SimpleDateFormat = new SimpleDateFormat("yyyyMMdd")
    f.setTimeZone(TimeZone.getTimeZone("GMT"))
    val dateStamp: String = f.format(date)
    return dateStamp
  }

  @throws[Exception]
  private def HmacSHA256(data: String, key: Array[Byte]): Array[Byte] = {
    val algorithm: String = "HmacSHA256"
    val mac: Mac = Mac.getInstance(algorithm)
    mac.init(new SecretKeySpec(key, algorithm))
    return mac.doFinal(data.getBytes("UTF8"))
  }

  private def SHA256(text: String): String = {
    var md: MessageDigest = null
    try {
      md = MessageDigest.getInstance("SHA-256")
    }
    catch {
      case e: NoSuchAlgorithmException => {
        e.printStackTrace()
      }
    }
    try {
      md.update(text.getBytes("UTF-8"))
    }
    catch {
      case e: UnsupportedEncodingException => {
        e.printStackTrace()
      }
    }
    val digest: Array[Byte] = md.digest
    val result: String = String.format("%064x", new BigInteger(1, digest))
    return result
  }

  @throws[Exception]
  private def getSignatureKey(key: String, dateStamp: String, regionName: String, serviceName: String): Array[Byte] = {
    val kSecret: Array[Byte] = ("AWS4" + key).getBytes("UTF8")
    val kDate: Array[Byte] = HmacSHA256(dateStamp, kSecret)
    val kRegion: Array[Byte] = HmacSHA256(regionName, kDate)
    val kService: Array[Byte] = HmacSHA256(serviceName, kRegion)
    val kSigning: Array[Byte] = HmacSHA256("aws4_request", kService)
    return kSigning
  }
}