
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class LoadPageToBrowser extends Simulation {

	val httpProtocol = http
		.baseURL("https://oshk5hrphl.execute-api.eu-west-1.amazonaws.com")
		.inferHtmlResources()

	val headers_0 = Map(
		"accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8",
		"accept-encoding" -> "gzip, deflate, sdch, br",
		"accept-language" -> "ru-RU,ru;q=0.8,en-US;q=0.6,en;q=0.4",
		"cache-control" -> "no-cache",
		"pragma" -> "no-cache",
		"referer" -> "https://accounts.google.com/signin/oauth/oauthchooseaccount?client_id=430020122178-qrfu593nr8i8js2ktfpui13c3064d6nm.apps.googleusercontent.com&as=-2f00611eb95eb507&destination=https%3A%2F%2Foshk5hrphl.execute-api.eu-west-1.amazonaws.com&approval_state=!ChR4RC1yT0FmSk9qRmFqbzBLYUpsWBIfQTljaEt1dDFDWDBXd0Q4c01wTnQ0WVlIRlhSaXZ4VQ%E2%88%99AE5-E40AAAAAWRVTW8posASaoJeuv9EnMpN9MT5j2Of4&xsrfsig=AHgIfE85Fl4x0FyfGZGm4W4pQixVCejqwA&flowName=GeneralOAuthFlow",
		"upgrade-insecure-requests" -> "1",
		"user-agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.96 Safari/537.36")

	val headers_1 = Map(
		"Accept" -> "*/*",
		"Accept-Encoding" -> "gzip, deflate, sdch",
		"Accept-Language" -> "ru-RU,ru;q=0.8,en-US;q=0.6,en;q=0.4",
		"Cache-Control" -> "no-cache",
		"Connection" -> "keep-alive",
		"Content-Type" -> "application/json",
		"Pragma" -> "no-cache",
		"User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.96 Safari/537.36")

	val headers_2 = Map(
		"accept" -> "*/*",
		"accept-encoding" -> "gzip, deflate, sdch, br",
		"accept-language" -> "ru-RU,ru;q=0.8,en-US;q=0.6,en;q=0.4",
		"cache-control" -> "no-cache",
		"pragma" -> "no-cache",
		"referer" -> "http://d12pl6fd8zs84c.cloudfront.net/",
		"user-agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.96 Safari/537.36")

	val headers_3 = Map(
		"accept" -> "*/*",
		"accept-encoding" -> "gzip, deflate, sdch, br",
		"accept-language" -> "ru-RU,ru;q=0.8,en-US;q=0.6,en;q=0.4",
		"cache-control" -> "no-cache",
		"cookie" -> "_ga=GA1.2.1463184154.1493801667; _gid=GA1.2.1034051987.1494418625",
		"pragma" -> "no-cache",
		"referer" -> "http://d12pl6fd8zs84c.cloudfront.net/",
		"user-agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.96 Safari/537.36")

	val headers_4 = Map(
		"accept" -> "*/*",
		"accept-encoding" -> "gzip, deflate, sdch, br",
		"accept-language" -> "ru-RU,ru;q=0.8,en-US;q=0.6,en;q=0.4",
		"access-control-request-headers" -> "authorization,content-type,x-amz-date,x-amz-security-token",
		"access-control-request-method" -> "GET",
		"cache-control" -> "no-cache",
		"origin" -> "http://d12pl6fd8zs84c.cloudfront.net",
		"pragma" -> "no-cache",
		"referer" -> "http://d12pl6fd8zs84c.cloudfront.net/",
		"user-agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.96 Safari/537.36")

	val headers_5 = Map(
		"Accept" -> "image/webp,image/*,*/*;q=0.8",
		"Accept-Encoding" -> "gzip, deflate, sdch, br",
		"Accept-Language" -> "ru-RU,ru;q=0.8,en-US;q=0.6,en;q=0.4",
		"Cache-Control" -> "no-cache",
		"Connection" -> "keep-alive",
		"Pragma" -> "no-cache",
		"User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.96 Safari/537.36")

	val headers_7 = Map(
		"accept" -> "*/*",
		"accept-encoding" -> "gzip, deflate, sdch, br",
		"accept-language" -> "ru-RU,ru;q=0.8,en-US;q=0.6,en;q=0.4",
		"cache-control" -> "no-cache",
		"origin" -> "http://d12pl6fd8zs84c.cloudfront.net",
		"pragma" -> "no-cache",
		"referer" -> "https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.2.0/css/material-design-iconic-font.min.css",
		"user-agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.96 Safari/537.36")

	val headers_8 = Map(
		"Accept" -> "*/*",
		"Accept-Encoding" -> "gzip, deflate, sdch",
		"Accept-Language" -> "ru-RU,ru;q=0.8,en-US;q=0.6,en;q=0.4",
		"Cache-Control" -> "no-cache",
		"Connection" -> "keep-alive",
		"Origin" -> "http://d12pl6fd8zs84c.cloudfront.net",
		"Pragma" -> "no-cache",
		"User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.96 Safari/537.36")

	val headers_10 = Map(
		"accept" -> "text/css,*/*;q=0.1",
		"accept-encoding" -> "gzip, deflate, sdch, br",
		"accept-language" -> "ru-RU,ru;q=0.8,en-US;q=0.6,en;q=0.4",
		"cache-control" -> "no-cache",
		"pragma" -> "no-cache",
		"referer" -> "http://d12pl6fd8zs84c.cloudfront.net/",
		"user-agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.96 Safari/537.36")



	val headers_14 = Map(
		"Accept" -> "*/*",
		"Accept-Encoding" -> "gzip, deflate, sdch, br",
		"Accept-Language" -> "ru-RU,ru;q=0.8,en-US;q=0.6,en;q=0.4",
		"Cache-Control" -> "no-cache",
		"Connection" -> "keep-alive",
		"Origin" -> "http://d12pl6fd8zs84c.cloudfront.net",
		"Pragma" -> "no-cache",
		"User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.96 Safari/537.36")

	val headers_16 = Map(
		"accept" -> "*/*",
		"accept-encoding" -> "gzip, deflate, sdch, br",
		"accept-language" -> "ru-RU,ru;q=0.8,en-US;q=0.6,en;q=0.4",
		"cache-control" -> "no-cache",
		"origin" -> "http://d12pl6fd8zs84c.cloudfront.net",
		"pragma" -> "no-cache",
		"referer" -> "https://use.fontawesome.com/05f7c8a54f.css",
		"user-agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.96 Safari/537.36")


	val headers_20 = Map(
		"Accept" -> "*/*",
		"Accept-Encoding" -> "gzip, deflate, sdch, br",
		"Accept-Language" -> "ru-RU,ru;q=0.8,en-US;q=0.6,en;q=0.4",
		"Access-Control-Request-Headers" -> "content-type",
		"Access-Control-Request-Method" -> "POST",
		"Cache-Control" -> "no-cache",
		"Connection" -> "keep-alive",
		"Origin" -> "http://d12pl6fd8zs84c.cloudfront.net",
		"Pragma" -> "no-cache",
		"User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.96 Safari/537.36")

	val headers_21 = Map(
		"accept" -> "image/webp,image/*,*/*;q=0.8",
		"accept-encoding" -> "gzip, deflate, sdch, br",
		"accept-language" -> "ru-RU,ru;q=0.8,en-US;q=0.6,en;q=0.4",
		"cache-control" -> "no-cache",
		"cookie" -> "NID=102=rbTmr9gjqTLSpRfh6S7fxbMvPx0ls5NlKyA_zNJ9HwaCxAAb7W0NA6rw7Nb-X_XJdQ8cVi-s-oPxizEn2ue3CA8sw60gynepiaG4deLANft9DQNVvwCJvydwaKH8x1jB",
		"pragma" -> "no-cache",
		"referer" -> "http://d12pl6fd8zs84c.cloudfront.net/",
		"user-agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.96 Safari/537.36",
		"x-chrome-uma-enabled" -> "1",
		"x-client-data" -> "CIi2yQEIprbJAQjEtskBCPqcygEIqZ3KAQ==")


	val headers_28 = Map(
		"Accept" -> "*/*",
		"Accept-Encoding" -> "gzip, deflate, br",
		"Accept-Language" -> "ru-RU,ru;q=0.8,en-US;q=0.6,en;q=0.4",
		"Cache-Control" -> "no-cache",
		"Connection" -> "keep-alive",
		"Content-Type" -> "application/json",
		"Origin" -> "http://d12pl6fd8zs84c.cloudfront.net",
		"Pragma" -> "no-cache",
		"User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.96 Safari/537.36")

    val uri1 = "https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.2.0"
    val uri2 = "d12pl6fd8zs84c.cloudfront.net"
    val uri3 = "https://iotsystems.zendesk.com"
    val uri4 = "https://lh5.googleusercontent.com/-fGUN1_DjnN8/AAAAAAAAAAI/AAAAAAAAAb4/JNAyZ1-sBv4/photo.jpg"
    val uri5 = "https://assets.zendesk.com/embeddable_framework/main.js"
    val uri6 = "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
    val uri7 = "https://oshk5hrphl.execute-api.eu-west-1.amazonaws.com/loadtest"
    val uri8 = "https://use.fontawesome.com"

	val scn = scenario("LoadPageToBrowser")
		.exec(http("request_0")
			.get("/loadtest/authentication/callback/custom-google?state=2b1af532731c1c2314c92a1abb1f5658c1c6515f9576df193828266c5b8e0f5e6adb4bd792f31466dae9ba35bf60b896&code=4/sCePjMR4e7wY6hdp_R1mbFcpSQWyDNjce8Pshd60Yfg")
			.headers(headers_0))
		.pause(1)
		.exec(http("request_1")
			.get("http://" + uri2 + "/paths.json")
			.headers(headers_1)
			.resources(http("request_2")
			.get(uri8 + "/webfontloader/1.6.24/webfontloader.js")
			.headers(headers_2)
			.check(bodyBytes.is(RawFileBody("LoadPageToBrowser_0002_response.txt"))),
            http("request_3")
			.get(uri5 + "")
			.headers(headers_3)
			.check(bodyBytes.is(RawFileBody("LoadPageToBrowser_0003_response.txt"))),
            http("request_4")
			.options("/loadtest/menu")
			.headers(headers_4),
            http("request_5")
			.get("https://" + uri2 + "/iotLogo_white.png?a0274f9")
			.headers(headers_5)
			.check(bodyBytes.is(RawFileBody("LoadPageToBrowser_0005_response.txt"))),
            http("request_6")
			.options("/loadtest/global_settings")
			.headers(headers_4),
            http("request_7")
			.get(uri1 + "/fonts/Material-Design-Iconic-Font.woff2?v=2.2.0")
			.headers(headers_7)
			.check(bodyBytes.is(RawFileBody("LoadPageToBrowser_0007_response.txt"))),
            http("request_8")
			.get("http://" + uri2 + "/99fc0816a09395454061301fefa42bf1.ttf?a0274f9")
			.headers(headers_8)
			.check(bodyBytes.is(RawFileBody("LoadPageToBrowser_0008_response.txt"))),
            http("request_9")
			.get("http://" + uri2 + "/54a91b0619ccf9373d525109268219dc.ttf?a0274f9")
			.headers(headers_8)
			.check(bodyBytes.is(RawFileBody("LoadPageToBrowser_0009_response.txt"))),
            http("request_10")
			.get(uri8 + "/05f7c8a54f.css")
			.headers(headers_10)
			.check(bodyBytes.is(RawFileBody("LoadPageToBrowser_0010_response.txt"))),

            http("request_13")
			.get(uri8 + "/releases/v4.6.3/css/font-awesome-css.min.css")
			.headers(headers_10)
			.check(bodyBytes.is(RawFileBody("LoadPageToBrowser_0013_response.txt"))),
            http("request_14")
			.get(uri3 + "/embeddable/config")
			.headers(headers_14)
			.check(bodyBytes.is(RawFileBody("LoadPageToBrowser_0014_response.txt"))),
            http("request_15")
			.options("/loadtest/profile")
			.headers(headers_4),
            http("request_16")
			.get(uri8 + "/releases/v4.6.3/fonts/fontawesome-webfont.woff2")
			.headers(headers_16)
			.check(bodyBytes.is(RawFileBody("LoadPageToBrowser_0016_response.txt"))),
            http("request_18")
			.get(uri3 + "/embeddable_blip?data=eyJwYWdlVmlldyI6eyJyZWZlcnJlciI6Imh0dHA6Ly9kMTJwbDZmZDh6czg0Yy5jbG91ZGZyb250Lm5ldC8iLCJ0aW1lIjo1ODIsImxvYWRUaW1lIjo4MDMuMjM1MDAwMDAwMDAwMSwibmF2aWdhdG9yTGFuZ3VhZ2UiOiJydSIsInBhZ2VUaXRsZSI6IklvVCBTeXN0ZW1zIEFwcCIsInVzZXJBZ2VudCI6Ik1vemlsbGEvNS4wIChXaW5kb3dzIE5UIDEwLjA7IFdpbjY0OyB4NjQpIEFwcGxlV2ViS2l0LzUzNy4zNiAoS0hUTUwsIGxpa2UgR2Vja28pIENocm9tZS81OC4wLjMwMjkuOTYgU2FmYXJpLzUzNy4zNiIsImhlbHBDZW50ZXJEZWR1cCI6ZmFsc2V9LCJidWlkIjoiZTFlNjMzMzgzMDJmNzQxNTI5ODRjZmU1YjJhZDkyMTAiLCJzdWlkIjoiNjMwZGI2ZDllODY3YjRhMmQ2MDQ2ZDMzYTMwZTU1N2YiLCJ2ZXJzaW9uIjoiZGMwOTdmMyIsInRpbWVzdGFtcCI6IjIwMTctMDUtMTFUMDY6MTc6MjAuNzI5WiIsInVybCI6Imh0dHA6Ly9kMTJwbDZmZDh6czg0Yy5jbG91ZGZyb250Lm5ldC8jL2Rhc2hib2FyZD9faz12eXNiMXEifQ%3D%3D")
			.headers(headers_14),
            http("request_19")
			.get(uri3 + "/embeddable_blip?data=eyJzZXR0aW5ncyI6eyJ3ZWJXaWRnZXQiOnsiY29sb3IiOnsidGhlbWUiOiIjMjE5NkYzIn0sImxhdW5jaGVyIjp7ImxhYmVsIjp7IioiOiJSZXBvcnQgYW4gaXNzdWUifX0sInBvc2l0aW9uIjp7Imhvcml6b250YWwiOiJsZWZ0IiwidmVydGljYWwiOiJib3R0b20ifX19LCJidWlkIjoiZTFlNjMzMzgzMDJmNzQxNTI5ODRjZmU1YjJhZDkyMTAiLCJzdWlkIjoiNjMwZGI2ZDllODY3YjRhMmQ2MDQ2ZDMzYTMwZTU1N2YiLCJ2ZXJzaW9uIjoiZGMwOTdmMyIsInRpbWVzdGFtcCI6IjIwMTctMDUtMTFUMDY6MTc6MjAuNzQzWiIsInVybCI6Imh0dHA6Ly9kMTJwbDZmZDh6czg0Yy5jbG91ZGZyb250Lm5ldC8jL2Rhc2hib2FyZD9faz12eXNiMXEifQ%3D%3D")
			.headers(headers_14),
            http("request_20")
			.options(uri3 + "/embeddable/identify")
			.headers(headers_20),
            http("request_21")
			.get(uri4 + "?sz=50")
			.headers(headers_21)
			.check(bodyBytes.is(RawFileBody("LoadPageToBrowser_0021_response.txt"))),
            http("request_22")
			.options("/loadtest/notification?status=unread")
			.headers(headers_4),
            http("request_23")
			.options("/loadtest/dashboard/e5673aa1-5db8-472e-9305-332feb7b34d9")
			.headers(headers_4),
            http("request_24")
			.options("/loadtest/equipment_models?availables=true")
			.headers(headers_4),
            http("request_28")
			.post(uri3 + "/embeddable/identify")
			.headers(headers_28)
			.body(RawFileBody("LoadPageToBrowser_0028_request.txt"))
			.check(bodyBytes.is(RawFileBody("LoadPageToBrowser_0028_response.txt"))))
			.check(bodyBytes.is(RawFileBody("LoadPageToBrowser_0001_response.txt"))))

	setUp(scn.inject(splitUsers(100) into(atOnceUsers(1)) separatedBy(5 seconds))).protocols(httpProtocol)
}