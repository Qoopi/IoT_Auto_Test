
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class LoadDashboardPage extends Simulation {

	val httpProtocol = http
		.baseURL("https://dashboard.dev.iotsyst.com")
		.inferHtmlResources().disableCaching

	val headers_0 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8",
		"Accept-Encoding" -> "gzip, deflate, sdch, br",
		"Accept-Language" -> "en-US,en;q=0.8",
		"Cache-Control" -> "no-cache",
		"Connection" -> "keep-alive",
		"Pragma" -> "no-cache",
		"Upgrade-Insecure-Requests" -> "1",
		"User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 Safari/537.36")

	val headers_1 = Map(
		"Accept" -> "*/*",
		"Accept-Encoding" -> "gzip, deflate, sdch, br",
		"Accept-Language" -> "en-US,en;q=0.8",
		"Cache-Control" -> "no-cache",
		"Connection" -> "keep-alive",
		"Content-Type" -> "application/json",
		"Pragma" -> "no-cache",
		"User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 Safari/537.36")

	val headers_2 = Map(
		"Accept" -> "*/*",
		"Accept-Encoding" -> "gzip, deflate, sdch, br",
		"Accept-Language" -> "en-US,en;q=0.8",
		"Cache-Control" -> "no-cache",
		"Connection" -> "keep-alive",
		"Pragma" -> "no-cache",
		"User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 Safari/537.36")

	val headers_3 = Map(
		"accept" -> "*/*",
		"accept-encoding" -> "gzip, deflate, sdch, br",
		"accept-language" -> "en-US,en;q=0.8",
		"cache-control" -> "no-cache",
		"pragma" -> "no-cache",
		"referer" -> "https://dashboard.dev.iotsyst.com/",
		"user-agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 Safari/537.36")

	val headers_5 = Map(
		"accept" -> "text/css,*/*;q=0.1",
		"accept-encoding" -> "gzip, deflate, sdch, br",
		"accept-language" -> "en-US,en;q=0.8",
		"cache-control" -> "no-cache",
		"pragma" -> "no-cache",
		"referer" -> "https://dashboard.dev.iotsyst.com/",
		"user-agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 Safari/537.36")

	val headers_7 = Map(
		"Accept" -> "*/*",
		"Accept-Encoding" -> "gzip, deflate, sdch, br",
		"Accept-Language" -> "en-US,en;q=0.8",
		"Cache-Control" -> "no-cache",
		"Connection" -> "keep-alive",
		"Origin" -> "https://dashboard.dev.iotsyst.com",
		"Pragma" -> "no-cache",
		"User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 Safari/537.36")

	val headers_8 = Map(
		"accept" -> "*/*",
		"accept-encoding" -> "gzip, deflate, sdch, br",
		"accept-language" -> "en-US,en;q=0.8",
		"cache-control" -> "no-cache",
		"origin" -> "https://dashboard.dev.iotsyst.com",
		"pragma" -> "no-cache",
		"referer" -> "https://use.fontawesome.com/05f7c8a54f.css",
		"user-agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 Safari/537.36")

	val headers_9 = Map(
		"Accept" -> "image/webp,image/*,*/*;q=0.8",
		"Accept-Encoding" -> "gzip, deflate, sdch, br",
		"Accept-Language" -> "en-US,en;q=0.8",
		"Cache-Control" -> "no-cache",
		"Connection" -> "keep-alive",
		"Pragma" -> "no-cache",
		"User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 Safari/537.36")

	val headers_10 = Map(
		"Accept" -> "*/*",
		"Accept-Encoding" -> "gzip, deflate, sdch, br",
		"Accept-Language" -> "en-US,en;q=0.8",
		"Access-Control-Request-Headers" -> "authorization,content-type,x-amz-date,x-amz-security-token",
		"Access-Control-Request-Method" -> "GET",
		"Cache-Control" -> "no-cache",
		"Connection" -> "keep-alive",
		"Origin" -> "https://dashboard.dev.iotsyst.com",
		"Pragma" -> "no-cache",
		"User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 Safari/537.36")

	val headers_13 = Map(
		"accept" -> "*/*",
		"accept-encoding" -> "gzip, deflate, sdch, br",
		"accept-language" -> "en-US,en;q=0.8",
		"cache-control" -> "no-cache",
		"origin" -> "https://dashboard.dev.iotsyst.com",
		"pragma" -> "no-cache",
		"referer" -> "https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.2.0/css/material-design-iconic-font.min.css",
		"user-agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 Safari/537.36")

    val uri1 = "https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev"
    val uri3 = "https://cdn.fontawesome.com/js/stats.js"
    val uri4 = "https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.2.0"
    val uri5 = "https://iotsystems.zendesk.com"
    val uri6 = "https://assets.zendesk.com/embeddable_framework/main.js"
    val uri7 = "https://d30q8hmeeybh67.cloudfront.net/iotLogo_white.png"
    val uri8 = "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
    val uri9 = "https://use.fontawesome.com"

	val scn = scenario("LoadDashboardPage2")exec( during(30 minutes){
		exec(http("request_0")
			.get("/")
			.headers(headers_0))
		.exec(http("request_1")
			.get("/paths.json")
			.headers(headers_1)
			.resources(http("request_2")
			.get(uri3 + "")
			.headers(headers_2),
            http("request_3")
			.get(uri9 + "/webfontloader/1.6.24/webfontloader.js")
			.headers(headers_3),
            http("request_4")
			.get(uri6 + "")
			.headers(headers_3),
            http("request_5")
			.get(uri9 + "/05f7c8a54f.css")
			.headers(headers_5),
            http("request_6")
			.get(uri9 + "/releases/v4.6.3/css/font-awesome-css.min.css")
			.headers(headers_5),
            http("request_7")
			.get(uri5 + "/embeddable/config")
			.headers(headers_7),
            http("request_8")
			.get(uri9 + "/releases/v4.6.3/fonts/fontawesome-webfont.woff2")
			.headers(headers_8),
            http("request_9")
			.get(uri7 + "?05cc9dd")
			.headers(headers_9),
            http("request_10")
			.options(uri1 + "/notification?status=unread")
			.headers(headers_10),
            http("request_11")
			.options(uri1 + "/equipment_models?availables=true")
			.headers(headers_10),
            http("request_12")
			.options(uri1 + "/dashboard/68478b27-7690-455e-8e15-4b901441b121")
			.headers(headers_10),
            http("request_13")
			.get(uri4 + "/fonts/Material-Design-Iconic-Font.woff2?v=2.2.0")
			.headers(headers_13),
            http("request_14")
			.get("/99fc0816a09395454061301fefa42bf1.ttf?5cc9dd")
			.headers(headers_7),
            http("request_15")
			.get("/54a91b0619ccf9373d525109268219dc.ttf?5cc9dd")
			.headers(headers_7),
            http("request_16")
			.get(uri5 + "/embeddable_blip?data=eyJ1cmwiOiJodHRwczovL2Rhc2hib2FyZC5kZXYuaW90c3lzdC5jb20vIy9kYXNoYm9hcmQ%2FX2s9OTl0eHJjIiwiYnVpZCI6ImRmYTllMzhhMzUyM2M3NzkwMDU2YWVkODA4MDFiNDNjIiwic3VpZCI6IjFkYzE5OThmNmMwZWQwODk5M2EyMTUzZmE1Y2JlNTkyIiwidmVyc2lvbiI6IjI3MjE2ZTkiLCJ0aW1lc3RhbXAiOiIyMDE3LTA0LTEyVDA3OjI0OjE2LjgwOVoiLCJwYWdlVmlldyI6eyJyZWZlcnJlciI6Imh0dHBzOi8vYWNjb3VudHMuZ29vZ2xlLmNvbS9BY2NvdW50Q2hvb3Nlcj9jb250aW51ZT1odHRwczovL2FjY291bnRzLmdvb2dsZS5jb20vby9vYXV0aDIvdjIvYXV0aD9jbGllbnRfaWQlM0Q0MzAwMjAxMjIxNzgtcXJmdTU5M25yOGk4anMya3RmcHVpMTNjMzA2NGQ2bm0uYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20lMjZyZWRpcmVjdF91cmklM0RodHRwczovLzYwc2dsejlsNWguZXhlY3V0ZS1hcGkudXMtZWFzdC0xLmFtYXpvbmF3cy5jb20vZGV2L2F1dGhlbnRpY2F0aW9uL2NhbGxiYWNrL2N1c3RvbS1nb29nbGUlMjZyZXNwb25zZV90eXBlJTNEY29kZSUyNnNjb3BlJTNEcHJvZmlsZSUyQmVtYWlsJTI2c3RhdGUlM0Q0Y2NiNjVhNjIyNmY5MTE5ZDQ4M2Y5NmVlZDM4M2MyZDZjYmM5OGJjZmI5ZDc2NWZlZjk4NjJmOTcwOTRiMDY4ZmE1NTU1MjdhY2Q0MGZhY2UyZDU2M2NlY2IyOGU5ZGQlMjZmcm9tX2xvZ2luJTNEMSUyNmFzJTNEMTE2MTBkYzk2NDkzMDY1NCZidG1wbD1hdXRoc3ViJnNjYz0xJm9hdXRoPTEiLCJ0aW1lIjowLCJsb2FkVGltZSI6MTI4LjkzNTAwMDAwMDAwMDAzLCJuYXZpZ2F0b3JMYW5ndWFnZSI6ImVuLVVTIiwicGFnZVRpdGxlIjoiSW9UIFN5c3RlbXMgQXBwIiwidXNlckFnZW50IjoiTW96aWxsYS81LjAgKFdpbmRvd3MgTlQgMTAuMDsgV2luNjQ7IHg2NCkgQXBwbGVXZWJLaXQvNTM3LjM2IChLSFRNTCwgbGlrZSBHZWNrbykgQ2hyb21lLzU3LjAuMjk4Ny4xMzMgU2FmYXJpLzUzNy4zNiIsImhlbHBDZW50ZXJEZWR1cCI6ZmFsc2V9fQ%3D%3D")
			.headers(headers_7),
            http("request_17")
			.get(uri5 + "/embeddable_blip?data=eyJ1cmwiOiJodHRwczovL2Rhc2hib2FyZC5kZXYuaW90c3lzdC5jb20vIy9kYXNoYm9hcmQ%2FX2s9OTl0eHJjIiwiYnVpZCI6ImRmYTllMzhhMzUyM2M3NzkwMDU2YWVkODA4MDFiNDNjIiwic3VpZCI6IjFkYzE5OThmNmMwZWQwODk5M2EyMTUzZmE1Y2JlNTkyIiwidmVyc2lvbiI6IjI3MjE2ZTkiLCJ0aW1lc3RhbXAiOiIyMDE3LTA0LTEyVDA3OjI0OjE2LjgxN1oiLCJzZXR0aW5ncyI6eyJ3ZWJXaWRnZXQiOnsiY29sb3IiOnsidGhlbWUiOiIjMjE5NkYzIn0sImxhdW5jaGVyIjp7ImxhYmVsIjp7IioiOiJSZXBvcnQgYW4gaXNzdWUifX0sInBvc2l0aW9uIjp7InZlcnRpY2FsIjoiYm90dG9tIiwiaG9yaXpvbnRhbCI6ImxlZnQifX19fQ%3D%3D")
			.headers(headers_7),
            http("request_21")
			.options(uri1 + "/chart/Thing-090035-0?startDate=1491980957542")
			.headers(headers_10)))
	})

	setUp(scn.inject(splitUsers(100) into(atOnceUsers(1)) separatedBy(5 seconds))).protocols(httpProtocol)
}