
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class RecordedSimulation1 extends Simulation {

  val httpProtocol = http
    .baseURL("https://60sglz9l5h.execute-api.us-east-1.amazonaws.com")
    .inferHtmlResources()
    .acceptHeader("*/*")
    .acceptEncodingHeader("gzip, deflate, sdch")
    .acceptLanguageHeader("en-US,en;q=0.8")
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36")

  val httpProtocolDash = http
    .baseURL("https://dashboard.dev.iotsyst.com")
    .inferHtmlResources()
    .acceptHeader("*/*")
    .acceptEncodingHeader("gzip, deflate, sdch")
    .acceptLanguageHeader("en-US,en;q=0.8")
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36")

  val uri1 = "https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev"

  object Headers{
    val aws: SignAWSv4 = new SignAWSv4
    val list = aws.readCredsFromFile()
    val authHeads = aws.authHeaders("GET", "https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev/chart/Thing-000013-i3?channelIdx=1&startDate=1490189802247&type=2")
    val map = aws.standardHeaders

    def buildStandardHeaders: Map[String, String] = {
      map
    }

    def buildAuth: String = {
      authHeads("Authorization")
    }

    def buildAmzDate: String = {
      authHeads("x-amz-date")
    }

    def buildToken: String = {
      authHeads("x-amz-security-token")
    }

  }

  def buildHeaders: Map[String, String] = {
    val aws: SignAWSv4 = new SignAWSv4
    val list = aws.readCredsFromFile()
    val map = aws.allHeaders("GET", "https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev/chart/Thing-000013-i3?channelIdx=1&startDate=1490189802247&type=2")
    map
  }

  object Build{
    def buildHeaders: Map[String, String] = {
      val aws: SignAWSv4 = new SignAWSv4
      val list = aws.readCredsFromFile()
      val map = aws.allHeaders("GET", "https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev/chart/Thing-000013-i3?channelIdx=1&startDate=1490189802247&type=2")
      map
    }
  }

  def buildStandardHeaders: Map[String, String] = {
    val aws: SignAWSv4 = new SignAWSv4
    val list = aws.readCredsFromFile()
    val map = aws.standardHeaders
    map
  }

  def buildAuth: String = {
    val aws: SignAWSv4 = new SignAWSv4
    val list = aws.readCredsFromFile()
    val authHeads = aws.authHeaders("GET", "https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev/chart/Thing-000013-i3?channelIdx=1&startDate=1490189802247&type=2")
    authHeads("Authorization")
  }

  def buildAmzDate: String = {
    val aws: SignAWSv4 = new SignAWSv4
    val list = aws.readCredsFromFile()
    val authHeads = aws.authHeaders("GET", "https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev/chart/Thing-000013-i3?channelIdx=1&startDate=1490189802247&type=2")
    authHeads("x-amz-date")
  }

  def buildToken: String = {
    val aws: SignAWSv4 = new SignAWSv4
    val list = aws.readCredsFromFile()
    val authHeads = aws.authHeaders("GET", "https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev/chart/Thing-000013-i3?channelIdx=1&startDate=1490189802247&type=2")
    authHeads("x-amz-security-token")
  }


  //  val scn = scenario("RecordedSimulation1")
  //    .exec(http("request_0")
  //      .options("/dev/notification?status=unread")
  //      .headers(map)
  //      .resources(http("request_2")
  //          .get("/dev/notification?status=unread")
  //          .headers(map)))



  val users = scenario("getNotification").exec(Notification.scn)
  val getDash = scenario("getDashboardFiles").exec(Dashboard.scn)
  val getDash2 = scenario("get Dash 2 ").exec(Dash2.scn)
  val getDash3 = scenario("get Dash 2 ").exec(repeat (50){
    exec(
      http("brainfuckwithheaders")
        .get("/dev/chart/Thing-000013-i3?channelIdx=1&startDate=1490189802247&type=2")
        .header("x-amz-security-token", crap => Headers.buildToken)
        .header("x-amz-date", crap => Headers.buildAmzDate)
        .header("Authorization", crap => Headers.buildAuth)
        .headers(Headers.buildStandardHeaders))
    .pause(1)
})

  val getDash4 = scenario("get Dash 4").exec(Dash3.scn)
//
//  var head1 = new SignAWSv4()
//  val getDash4 = scenario("get Dash 2 ").exec(repeat (150){
//    exec(
//      http("brainfuckwithheaders")
//        .get("/dev/chart/Thing-000013-i3?channelIdx=1&startDate=1490189802247&type=2")
//        .headers(buildHeaders("GET", "/dev/chart/Thing-000013-i3?channelIdx=1&startDate=1490189802247&type=2")))
//      .pause(1)
//  })
////
//
//  val endNum = 5
//  val startNum = 1
//  var counter = new java.util.concurrent.atomic.AtomicInteger(startNum-1)
//
//  var head = new SignAWSv4()
//
//  val scn = scenario("+1")
//    .asLongAs(session => counter.getAndIncrement() < endNum)
//    {
//      exec(http("Change_Password")
//        .get(session =>"http://demo.mockable.io/" + s"""${head.allHeaders("","")}""")
//        .check(status.is(404))
//      )
//    }
//
////  val getDash2 = scenario("get Dash 2 ").feed(Iterator.continually(Map("auth" -> buildHeaders)).exec(Dash2.scn)
//
//  val unixTime = scenario("Unix Time")
//    .exec(_.set("unixTime", System.currentTimeMillis / 1000))
//    .exec { session => println(session("unixTime").as[String]); session }
//
////  setUp(unixTime.inject(rampUsers(5) over(5)))
//

  setUp(getDash4.inject(rampUsers(1000) over (1))).protocols(httpProtocol)
//  setUp(getDash3.inject(rampUsers(100) over (1))).protocols(httpProtocol)
}