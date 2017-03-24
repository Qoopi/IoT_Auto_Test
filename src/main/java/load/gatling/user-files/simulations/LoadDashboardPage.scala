
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class LoadDashboardPage extends Simulation {

	val httpProtocol = http
		.baseURL("https://dashboard.dev.iotsyst.com")
		.inferHtmlResources()


	val uri1 = "https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev"
	val uri3 = "https://cdn.fontawesome.com/js/stats.js"
	val uri4 = "https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.2.0"
	val uri5 = "https://iotsystems.zendesk.com/embeddable"
	val uri6 = "https://assets.zendesk.com/embeddable_framework/main.js"
	val uri7 = "https://d30q8hmeeybh67.cloudfront.net/iotLogo_white.png"
	val uri8 = "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	val uri9 = "https://use.fontawesome.com"


	val headers_0 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8",
		"Accept-Encoding" -> "gzip, deflate, sdch, br",
		"Accept-Language" -> "en-US,en;q=0.8",
		"Cache-Control" -> "no-cache",
		"Connection" -> "keep-alive",
		"Pragma" -> "no-cache",
		"Upgrade-Insecure-Requests" -> "1",
		"User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36")

	val headers_1 = Map(
		"Accept" -> "*/*",
		"Accept-Encoding" -> "gzip, deflate, sdch, br",
		"Accept-Language" -> "en-US,en;q=0.8",
		"Cache-Control" -> "no-cache",
		"Connection" -> "keep-alive",
		"Content-Type" -> "application/json",
		"Pragma" -> "no-cache",
		"User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36")

	val headers_2 = Map(
		"Accept" -> "*/*",
		"Accept-Encoding" -> "gzip, deflate, sdch, br",
		"Accept-Language" -> "en-US,en;q=0.8",
		"Cache-Control" -> "no-cache",
		"Connection" -> "keep-alive",
		"Pragma" -> "no-cache",
		"User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36")

	val headers_3 = Map(
		"accept" -> "*/*",
		"accept-encoding" -> "gzip, deflate, sdch, br",
		"accept-language" -> "en-US,en;q=0.8",
		"cache-control" -> "no-cache",
		"pragma" -> "no-cache",
		"referer" -> "https://dashboard.dev.iotsyst.com/",
		"user-agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36")

	val headers_5 = Map(
		"Accept" -> "image/webp,image/*,*/*;q=0.8",
		"Accept-Encoding" -> "gzip, deflate, sdch, br",
		"Accept-Language" -> "en-US,en;q=0.8",
		"Cache-Control" -> "no-cache",
		"Connection" -> "keep-alive",
		"Pragma" -> "no-cache",
		"User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36")

	val headers_6 = Map(
		"Accept" -> "*/*",
		"Accept-Encoding" -> "gzip, deflate, sdch, br",
		"Accept-Language" -> "en-US,en;q=0.8",
		"Access-Control-Request-Headers" -> "authorization, content-type, x-amz-date, x-amz-security-token",
		"Access-Control-Request-Method" -> "GET",
		"Cache-Control" -> "no-cache",
		"Connection" -> "keep-alive",
		"Origin" -> "https://dashboard.dev.iotsyst.com",
		"Pragma" -> "no-cache",
		"User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36")

	val headers_9 = Map(
		"accept" -> "*/*",
		"accept-encoding" -> "gzip, deflate, sdch, br",
		"accept-language" -> "en-US,en;q=0.8",
		"cache-control" -> "no-cache",
		"origin" -> "https://dashboard.dev.iotsyst.com",
		"pragma" -> "no-cache",
		"referer" -> "https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.2.0/css/material-design-iconic-font.min.css",
		"user-agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36")

	val headers_10 = Map(
		"Accept" -> "*/*",
		"Accept-Encoding" -> "gzip, deflate, sdch, br",
		"Accept-Language" -> "en-US,en;q=0.8",
		"Cache-Control" -> "no-cache",
		"Connection" -> "keep-alive",
		"Origin" -> "https://dashboard.dev.iotsyst.com",
		"Pragma" -> "no-cache",
		"User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36")

	val headers_12 = Map(
		"accept" -> "text/css,*/*;q=0.1",
		"accept-encoding" -> "gzip, deflate, sdch, br",
		"accept-language" -> "en-US,en;q=0.8",
		"cache-control" -> "no-cache",
		"pragma" -> "no-cache",
		"referer" -> "https://dashboard.dev.iotsyst.com/",
		"user-agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36")

	val headers_15 = Map(
		"accept" -> "*/*",
		"accept-encoding" -> "gzip, deflate, sdch, br",
		"accept-language" -> "en-US,en;q=0.8",
		"cache-control" -> "no-cache",
		"origin" -> "https://dashboard.dev.iotsyst.com",
		"pragma" -> "no-cache",
		"referer" -> "https://use.fontawesome.com/05f7c8a54f.css",
		"user-agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36")


	val aws: SignAWSv4 = new SignAWSv4
	val headers_16_aws = aws.allHeaders("GET", uri1 + "/notification?status=unread")



	val headers_17_aws = aws.allHeaders("GET", uri1 + "/equipment_models?availables=true")


	val headers_18 = Map(
		"Accept" -> "*/*",
		"Accept-Encoding" -> "gzip, deflate, sdch, br",
		"Accept-Language" -> "en-US,en;q=0.8",
		"Access-Control-Request-Headers" -> "content-type",
		"Access-Control-Request-Method" -> "POST",
		"Cache-Control" -> "no-cache",
		"Connection" -> "keep-alive",
		"Origin" -> "https://dashboard.dev.iotsyst.com",
		"Pragma" -> "no-cache",
		"User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36")


	val headers_20_aws = aws.allHeaders("GET", uri1 + "/dashboard/acadcc02-8979-4a9a-ad06-308c37291792")



	val headers_21 = Map(
		"Accept" -> "*/*",
		"Accept-Encoding" -> "gzip, deflate, br",
		"Accept-Language" -> "en-US,en;q=0.8",
		"Cache-Control" -> "no-cache",
		"Connection" -> "keep-alive",
		"Content-Type" -> "application/json",
		"Origin" -> "https://dashboard.dev.iotsyst.com",
		"Pragma" -> "no-cache",
		"User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36")


	val repeats = 5
	val users = 100


	val scn = scenario("LoadDashboardPage").exec( repeat(repeats){
		exec(http("request_0")
			.get("/")
			.headers(headers_0))
			.pause(3)
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
						.get(uri7 + "?10a8403")
						.headers(headers_5),
					http("request_6")
						.options(uri1 + "/notification?status=unread")
						.headers(headers_6),
					http("request_7")
						.options(uri1 + "/dashboard/acadcc02-8979-4a9a-ad06-308c37291792")
						.headers(headers_6),
					http("request_8")
						.options(uri1 + "/equipment_models?availables=true")
						.headers(headers_6),
					http("request_9")
						.get(uri4 + "/fonts/Material-Design-Iconic-Font.woff2?v=2.2.0")
						.headers(headers_9),
					http("request_10")
						.get("/99fc0816a09395454061301fefa42bf1.ttf?10a8403")
						.headers(headers_10),
					http("request_11")
						.get("/54a91b0619ccf9373d525109268219dc.ttf?10a8403")
						.headers(headers_10),
					http("request_12")
						.get(uri9 + "/05f7c8a54f.css")
						.headers(headers_12),
					http("request_13")
						.get(uri9 + "/releases/v4.6.3/css/font-awesome-css.min.css")
						.headers(headers_12),
					http("request_14")
						.get(uri5 + "/config")
						.headers(headers_10),
					http("request_15")
						.get(uri9 + "/releases/v4.6.3/fonts/fontawesome-webfont.woff2")
						.headers(headers_15),
					http("request_16")
						.get(uri1 + "/notification?status=unread")
						.headers(headers_16_aws),
					http("request_17")
						.get(uri1 + "/equipment_models?availables=true")
						.headers(headers_17_aws),
					http("request_18")
						.options(uri5 + "/blips")
						.headers(headers_18),
					http("request_19")
						.options(uri5 + "/identify")
						.headers(headers_18),
					http("request_20")
						.get(uri1 + "/dashboard/acadcc02-8979-4a9a-ad06-308c37291792")
						.headers(headers_20_aws),
					http("request_21")
						.post(uri5 + "/blips")
						.headers(headers_21)
						.body(RawFileBody("RecordedSimulation_0021_request.txt")),
					http("request_22")
						.post(uri5 + "/identify")
						.headers(headers_21)
						.body(RawFileBody("RecordedSimulation_0022_request.txt"))))
	})

	setUp(scn.inject(atOnceUsers(users))).protocols(httpProtocol)
}