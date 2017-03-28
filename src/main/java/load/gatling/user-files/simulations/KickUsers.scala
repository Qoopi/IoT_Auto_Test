import io.gatling.core.Predef._
import io.gatling.http.Predef._

/**
  * Created by alex00x6 on 27.03.2017.
  */
class KickUsers extends Simulation{

  val httpProtocol = http
  .baseURL("https://dashboard.dev.iotsyst.com")
  .inferHtmlResources.disableCaching

  val uri1 = "https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev"

  val aws: SignAWSv4 = new SignAWSv4
  val headers_16_aws = aws.allHeaders("GET", uri1 + "/notification?status=unread")
  val headers_17_aws = aws.allHeaders("GET", uri1 + "/equipment_models?availables=true")

  val repeats = 25 //should not be zero
  val users = 200
  val rampUsersDelay = 5


  val scn = scenario("LoadDashboardPage").exec(repeat(repeats){
            exec(http("request_16")
            .get(uri1 + "/notification?status=unread") //AWS notifications + check expired creds
            .headers(headers_16_aws))
//            exec(http("request_17")
//            .get(uri1 + "/equipment_models?availables=true") //AWS
//            .headers(headers_17_aws)).pause(2)
  })


  	setUp(scn.inject(atOnceUsers(users))).protocols(httpProtocol)
//  	setUp(scn.inject(rampUsersPerSec(10) to 50 during(600))).protocols(httpProtocol)
 // setUp(scn.inject(rampUsers(users) over (rampUsersDelay seconds))).protocols(httpProtocol)
}
