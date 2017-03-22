import io.gatling.core.Predef._
import io.gatling.http.Predef._



object Notification{

  val aws: SignAWSv4 = new SignAWSv4
  val list = aws.readCredsFromFile()
  val map = aws.allHeaders("GET", "https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev/notification?status=unread")

    val scn = scenario("RecordedSimulation1")
      .exec(http("request_0")
        .options("/dev/notification?status=unread")
        .headers(map)
        .resources(http("request_2")
          .get("/dev/notification?status=unread")
          .headers(map)))

}

object Dashboard{
  val aws: SignAWSv4 = new SignAWSv4
  val list = aws.readCredsFromFile()
  val map = aws.allHeaders("GET", "https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev/notification?status=unread")
  val scn = exec(http("req").get("https://dashboard.dev.iotsyst.com").headers(map))
}

object Dash2{

  val aws: SignAWSv4 = new SignAWSv4
  val list = aws.readCredsFromFile()
  val map = aws.allHeaders("GET", "https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev/chart/Thing-000013-i3?channelIdx=1&startDate=1490189802247&type=2")

  val scn = scenario("RecordedSimulation1")
    .exec(http("request_0")
      .options("/dev/chart/Thing-000013-i3?channelIdx=1&startDate=1490189802247&type=2")
      .headers(map)
      .resources(http("request_2")
        .get("/dev/chart/Thing-000013-i3?channelIdx=1&startDate=1490189802247&type=2")
        .headers(map)))

}