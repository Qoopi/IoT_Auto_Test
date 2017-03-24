
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class LoadLoginPage extends Simulation {

	val httpProtocol = http
		.baseURL("https://dashboard.dev.iotsyst.com")
		.inferHtmlResources()

	val headers_0 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8",
		"Accept-Encoding" -> "gzip, deflate, sdch, br",
		"Accept-Language" -> "en-US,en;q=0.8",
		"Connection" -> "keep-alive",
		"Upgrade-Insecure-Requests" -> "1",
		"User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36")

	val headers_1 = Map(
		"accept" -> "text/css,*/*;q=0.1",
		"accept-encoding" -> "gzip, deflate, sdch, br",
		"accept-language" -> "en-US,en;q=0.8",
		"origin" -> "https://dashboard.dev.iotsyst.com",
		"referer" -> "https://dashboard.dev.iotsyst.com/",
		"user-agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36")

	val headers_2 = Map(
		"accept" -> "text/css,*/*;q=0.1",
		"accept-encoding" -> "gzip, deflate, sdch, br",
		"accept-language" -> "en-US,en;q=0.8",
		"referer" -> "https://dashboard.dev.iotsyst.com/",
		"user-agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36")

	val headers_3 = Map(
		"Accept" -> "*/*",
		"Accept-Encoding" -> "gzip, deflate, sdch, br",
		"Accept-Language" -> "en-US,en;q=0.8",
		"Connection" -> "keep-alive",
		"User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36")

	val headers_4 = Map(
		"accept" -> "*/*",
		"accept-encoding" -> "gzip, deflate, sdch, br",
		"accept-language" -> "en-US,en;q=0.8",
		"referer" -> "https://dashboard.dev.iotsyst.com/",
		"user-agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36")

	val headers_6 = Map(
		"Origin" -> "https://dashboard.dev.iotsyst.com",
		"User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36")

	val headers_7 = Map(
		"Accept" -> "*/*",
		"Accept-Encoding" -> "gzip, deflate, sdch, br",
		"Accept-Language" -> "en-US,en;q=0.8",
		"Connection" -> "keep-alive",
		"Content-Type" -> "application/json",
		"User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36")

	val headers_13 = Map(
		"accept" -> "*/*",
		"accept-encoding" -> "gzip, deflate, sdch, br",
		"accept-language" -> "en-US,en;q=0.8",
		"origin" -> "https://dashboard.dev.iotsyst.com",
		"referer" -> "https://use.fontawesome.com/05f7c8a54f.css",
		"user-agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36")

	val headers_14 = Map(
		"Accept" -> "image/webp,image/*,*/*;q=0.8",
		"Accept-Encoding" -> "gzip, deflate, sdch, br",
		"Accept-Language" -> "en-US,en;q=0.8",
		"Connection" -> "keep-alive",
		"User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36")

	val headers_16 = Map(
		"Accept" -> "*/*",
		"Accept-Encoding" -> "gzip, deflate, sdch, br",
		"Accept-Language" -> "en-US,en;q=0.8",
		"Connection" -> "keep-alive",
		"Origin" -> "https://dashboard.dev.iotsyst.com",
		"User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36")

	val headers_18 = Map(
		"Accept" -> "*/*",
		"Accept-Encoding" -> "gzip, deflate, sdch, br",
		"Accept-Language" -> "en-US,en;q=0.8",
		"Access-Control-Request-Headers" -> "content-type",
		"Access-Control-Request-Method" -> "POST",
		"Connection" -> "keep-alive",
		"Origin" -> "https://dashboard.dev.iotsyst.com",
		"User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36")

	val headers_20 = Map(
		"Accept" -> "*/*",
		"Accept-Encoding" -> "gzip, deflate, br",
		"Accept-Language" -> "en-US,en;q=0.8",
		"Connection" -> "keep-alive",
		"Content-Type" -> "application/json",
		"Origin" -> "https://dashboard.dev.iotsyst.com",
		"User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36")

    val uri2 = "https://cdn.fontawesome.com/js/stats.js"
    val uri3 = "https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.2.0/css/material-design-iconic-font.min.css"
    val uri4 = "https://iotsystems.zendesk.com/embeddable"
    val uri5 = "https://assets.zendesk.com/embeddable_framework/main.js"
    val uri6 = "https://d30q8hmeeybh67.cloudfront.net"
    val uri7 = "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
    val uri8 = "https://use.fontawesome.com"

	val scn = scenario("logiPageDownload")
		.exec(http("request_0")
			.get("/")
			.headers(headers_0))
		.pause(11)
		.exec(http("request_1")
			.get(uri7 + "")
			.headers(headers_1)
			.resources(http("request_2")
			.get(uri3 + "")
			.headers(headers_2),
            http("request_3")
			.get("/bundle.js")
			.headers(headers_3),
            http("request_4")
			.get(uri8 + "/05f7c8a54f.js")
			.headers(headers_4),
            http("request_5")
			.get("/ZenDeskWidgetScript.js")
			.headers(headers_3),
            http("request_6")
			.get(uri7 + "")
			.headers(headers_6)))
		.pause(1)
		.exec(http("request_7")
			.get("/paths.json")
			.headers(headers_7)
			.resources(http("request_8")
			.get(uri2 + "")
			.headers(headers_3),
            http("request_9")
			.get(uri8 + "/webfontloader/1.6.24/webfontloader.js")
			.headers(headers_4),
            http("request_10")
			.get(uri5 + "")
			.headers(headers_4),
            http("request_11")
			.get(uri8 + "/05f7c8a54f.css")
			.headers(headers_2),
            http("request_12")
			.get(uri8 + "/releases/v4.6.3/css/font-awesome-css.min.css")
			.headers(headers_2),
            http("request_13")
			.get(uri8 + "/releases/v4.6.3/fonts/fontawesome-webfont.woff2")
			.headers(headers_13),
            http("request_14")
			.get(uri6 + "/c0f68f659e74333fd659f0ed158e7bed.svg?10a8403")
			.headers(headers_14),
            http("request_15")
			.get(uri6 + "/IoT-LoginPage-Background.png?10a8403")
			.headers(headers_14),
            http("request_16")
			.get("/54a91b0619ccf9373d525109268219dc.ttf?10a8403")
			.headers(headers_16),
            http("request_17")
			.get(uri4 + "/config")
			.headers(headers_16)))
		.pause(1)
		.exec(http("request_18")
			.options(uri4 + "/blips")
			.headers(headers_18)
			.resources(http("request_19")
			.options(uri4 + "/blips")
			.headers(headers_18),
            http("request_20")
			.post(uri4 + "/blips")
			.headers(headers_20)
			.body(RawFileBody("RecordedSimulation_0020_request.txt")),
            http("request_21")
			.post(uri4 + "/blips")
			.headers(headers_20)
			.body(RawFileBody("RecordedSimulation_0021_request.txt"))))

	setUp(scn.inject(atOnceUsers(10))).protocols(httpProtocol)
}