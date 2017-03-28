
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class ChartRefreshing extends Simulation {

	val httpProtocol = http
		.baseURL("https://60sglz9l5h.execute-api.us-east-1.amazonaws.com")
		.inferHtmlResources()
		.acceptHeader("*/*")
		.acceptEncodingHeader("gzip, deflate, sdch")
		.acceptLanguageHeader("en-US,en;q=0.8")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.110 Safari/537.36")

	val headers_0 = Map(
		"Access-Control-Request-Headers" -> "authorization,content-type,x-amz-date,x-amz-security-token",
		"Access-Control-Request-Method" -> "GET",
		"Cache-Control" -> "no-cache",
		"Origin" -> "https://dashboard.dev.iotsyst.com",
		"Pragma" -> "no-cache")

	val headers_3 = Map(
		"Authorization" -> "AWS4-HMAC-SHA256 Credential=ASIAJPM2LWBQAN44AWUA/20170327/us-east-1/execute-api/aws4_request, SignedHeaders=host;x-amz-date, Signature=112cfd13fa1901de91c866349f68479d5dcf46ca8d9bec0aa93abdb8e1342268",
		"Cache-Control" -> "no-cache",
		"Content-Type" -> "application/json",
		"Origin" -> "https://dashboard.dev.iotsyst.com",
		"Pragma" -> "no-cache",
		"x-amz-date" -> "20170327T151239Z",
		"x-amz-security-token" -> "FQoDYXdzEBgaDJzWEoueemDLPwUn0SLmA7CMwgRbCgTmdoBQGdjtuyifyetkcoDNdFqBwq6b7AmMLB+R87oA2+bnkCtyY/ZxBwqSah09F57dbYCSFYHXG4We3h7CcjTL9i9SC1GrXuqiS0xlzFxuKNxgTeV8i51EeFqW1hdxI/q63XpTcvYhfgMm2w3Vxh8b7EmxWVPtfr7svgnox0Dd1fb+YJtfAwAgmengc4WfWYkQyOKtvCC0vrfz2efZdWbvrhXdtHV26cpO1UXbcr5j884isiwSF4grEvIQLjGVXhVNxl3yJEIQtldUD7mhS6GFcZy2osTwiPlIXKlDO2NuZzP5oNvvIOWzCqFZ6IcoTZ997nKsvH6P314bZQv8rrpHSdUm8mH24qP7Kr4XiEWfCXcMY+zD/QRxATqgUlF9s+2BQzQ0LqeV98NkQ7CwkdXAJtj7+GJzS0uRuuO1lzxll96RQAxuEE8guZk5Au/aoFfxX4ufONfF8LRTUOp32al59G5DCy0FK17BRjhoqy/irwnmM1pOItZWQO/+g6Fiui3v50tTwiHB/KrnCVef53d6U/WM8W5LXeIjTks6hZlZYh0vWddN8YxnuH2LrMX5dn1S4OK7h/TzPPUueLIKCHHxExw4Vs5Ptw0x2m9qWLnB/I11M6L1BjjnAH5binNKxiit1uTGBQ==")

	val headers_9 = Map(
		"Authorization" -> "AWS4-HMAC-SHA256 Credential=ASIAJPM2LWBQAN44AWUA/20170327/us-east-1/execute-api/aws4_request, SignedHeaders=host;x-amz-date, Signature=43bbf63f00c564024750cce5fb90097eaf1f3e6b59519a024b750c64f1ffd67c",
		"Cache-Control" -> "no-cache",
		"Content-Type" -> "application/json",
		"Origin" -> "https://dashboard.dev.iotsyst.com",
		"Pragma" -> "no-cache",
		"x-amz-date" -> "20170327T151244Z",
		"x-amz-security-token" -> "FQoDYXdzEBgaDJzWEoueemDLPwUn0SLmA7CMwgRbCgTmdoBQGdjtuyifyetkcoDNdFqBwq6b7AmMLB+R87oA2+bnkCtyY/ZxBwqSah09F57dbYCSFYHXG4We3h7CcjTL9i9SC1GrXuqiS0xlzFxuKNxgTeV8i51EeFqW1hdxI/q63XpTcvYhfgMm2w3Vxh8b7EmxWVPtfr7svgnox0Dd1fb+YJtfAwAgmengc4WfWYkQyOKtvCC0vrfz2efZdWbvrhXdtHV26cpO1UXbcr5j884isiwSF4grEvIQLjGVXhVNxl3yJEIQtldUD7mhS6GFcZy2osTwiPlIXKlDO2NuZzP5oNvvIOWzCqFZ6IcoTZ997nKsvH6P314bZQv8rrpHSdUm8mH24qP7Kr4XiEWfCXcMY+zD/QRxATqgUlF9s+2BQzQ0LqeV98NkQ7CwkdXAJtj7+GJzS0uRuuO1lzxll96RQAxuEE8guZk5Au/aoFfxX4ufONfF8LRTUOp32al59G5DCy0FK17BRjhoqy/irwnmM1pOItZWQO/+g6Fiui3v50tTwiHB/KrnCVef53d6U/WM8W5LXeIjTks6hZlZYh0vWddN8YxnuH2LrMX5dn1S4OK7h/TzPPUueLIKCHHxExw4Vs5Ptw0x2m9qWLnB/I11M6L1BjjnAH5binNKxiit1uTGBQ==")

	val headers_13 = Map(
		"Authorization" -> "AWS4-HMAC-SHA256 Credential=ASIAJPM2LWBQAN44AWUA/20170327/us-east-1/execute-api/aws4_request, SignedHeaders=host;x-amz-date, Signature=af761093fd39440e3b449e69726defa6325052be1fa116668bd914a9425dc170",
		"Cache-Control" -> "no-cache",
		"Content-Type" -> "application/json",
		"Origin" -> "https://dashboard.dev.iotsyst.com",
		"Pragma" -> "no-cache",
		"x-amz-date" -> "20170327T151248Z",
		"x-amz-security-token" -> "FQoDYXdzEBgaDJzWEoueemDLPwUn0SLmA7CMwgRbCgTmdoBQGdjtuyifyetkcoDNdFqBwq6b7AmMLB+R87oA2+bnkCtyY/ZxBwqSah09F57dbYCSFYHXG4We3h7CcjTL9i9SC1GrXuqiS0xlzFxuKNxgTeV8i51EeFqW1hdxI/q63XpTcvYhfgMm2w3Vxh8b7EmxWVPtfr7svgnox0Dd1fb+YJtfAwAgmengc4WfWYkQyOKtvCC0vrfz2efZdWbvrhXdtHV26cpO1UXbcr5j884isiwSF4grEvIQLjGVXhVNxl3yJEIQtldUD7mhS6GFcZy2osTwiPlIXKlDO2NuZzP5oNvvIOWzCqFZ6IcoTZ997nKsvH6P314bZQv8rrpHSdUm8mH24qP7Kr4XiEWfCXcMY+zD/QRxATqgUlF9s+2BQzQ0LqeV98NkQ7CwkdXAJtj7+GJzS0uRuuO1lzxll96RQAxuEE8guZk5Au/aoFfxX4ufONfF8LRTUOp32al59G5DCy0FK17BRjhoqy/irwnmM1pOItZWQO/+g6Fiui3v50tTwiHB/KrnCVef53d6U/WM8W5LXeIjTks6hZlZYh0vWddN8YxnuH2LrMX5dn1S4OK7h/TzPPUueLIKCHHxExw4Vs5Ptw0x2m9qWLnB/I11M6L1BjjnAH5binNKxiit1uTGBQ==")

	val headers_17 = Map(
		"Authorization" -> "AWS4-HMAC-SHA256 Credential=ASIAJPM2LWBQAN44AWUA/20170327/us-east-1/execute-api/aws4_request, SignedHeaders=host;x-amz-date, Signature=c852b21997bd0a8b676d6fbb076613c2089de7046f9c054b8953bbbf74e22d82",
		"Cache-Control" -> "no-cache",
		"Content-Type" -> "application/json",
		"Origin" -> "https://dashboard.dev.iotsyst.com",
		"Pragma" -> "no-cache",
		"x-amz-date" -> "20170327T151249Z",
		"x-amz-security-token" -> "FQoDYXdzEBgaDJzWEoueemDLPwUn0SLmA7CMwgRbCgTmdoBQGdjtuyifyetkcoDNdFqBwq6b7AmMLB+R87oA2+bnkCtyY/ZxBwqSah09F57dbYCSFYHXG4We3h7CcjTL9i9SC1GrXuqiS0xlzFxuKNxgTeV8i51EeFqW1hdxI/q63XpTcvYhfgMm2w3Vxh8b7EmxWVPtfr7svgnox0Dd1fb+YJtfAwAgmengc4WfWYkQyOKtvCC0vrfz2efZdWbvrhXdtHV26cpO1UXbcr5j884isiwSF4grEvIQLjGVXhVNxl3yJEIQtldUD7mhS6GFcZy2osTwiPlIXKlDO2NuZzP5oNvvIOWzCqFZ6IcoTZ997nKsvH6P314bZQv8rrpHSdUm8mH24qP7Kr4XiEWfCXcMY+zD/QRxATqgUlF9s+2BQzQ0LqeV98NkQ7CwkdXAJtj7+GJzS0uRuuO1lzxll96RQAxuEE8guZk5Au/aoFfxX4ufONfF8LRTUOp32al59G5DCy0FK17BRjhoqy/irwnmM1pOItZWQO/+g6Fiui3v50tTwiHB/KrnCVef53d6U/WM8W5LXeIjTks6hZlZYh0vWddN8YxnuH2LrMX5dn1S4OK7h/TzPPUueLIKCHHxExw4Vs5Ptw0x2m9qWLnB/I11M6L1BjjnAH5binNKxiit1uTGBQ==")

	val headers_23 = Map(
		"Authorization" -> "AWS4-HMAC-SHA256 Credential=ASIAJPM2LWBQAN44AWUA/20170327/us-east-1/execute-api/aws4_request, SignedHeaders=host;x-amz-date, Signature=0c107269edf584734d04e27230ae8f75c33efc89df2814a271e0733c0c0befbf",
		"Cache-Control" -> "no-cache",
		"Content-Type" -> "application/json",
		"Origin" -> "https://dashboard.dev.iotsyst.com",
		"Pragma" -> "no-cache",
		"x-amz-date" -> "20170327T151254Z",
		"x-amz-security-token" -> "FQoDYXdzEBgaDJzWEoueemDLPwUn0SLmA7CMwgRbCgTmdoBQGdjtuyifyetkcoDNdFqBwq6b7AmMLB+R87oA2+bnkCtyY/ZxBwqSah09F57dbYCSFYHXG4We3h7CcjTL9i9SC1GrXuqiS0xlzFxuKNxgTeV8i51EeFqW1hdxI/q63XpTcvYhfgMm2w3Vxh8b7EmxWVPtfr7svgnox0Dd1fb+YJtfAwAgmengc4WfWYkQyOKtvCC0vrfz2efZdWbvrhXdtHV26cpO1UXbcr5j884isiwSF4grEvIQLjGVXhVNxl3yJEIQtldUD7mhS6GFcZy2osTwiPlIXKlDO2NuZzP5oNvvIOWzCqFZ6IcoTZ997nKsvH6P314bZQv8rrpHSdUm8mH24qP7Kr4XiEWfCXcMY+zD/QRxATqgUlF9s+2BQzQ0LqeV98NkQ7CwkdXAJtj7+GJzS0uRuuO1lzxll96RQAxuEE8guZk5Au/aoFfxX4ufONfF8LRTUOp32al59G5DCy0FK17BRjhoqy/irwnmM1pOItZWQO/+g6Fiui3v50tTwiHB/KrnCVef53d6U/WM8W5LXeIjTks6hZlZYh0vWddN8YxnuH2LrMX5dn1S4OK7h/TzPPUueLIKCHHxExw4Vs5Ptw0x2m9qWLnB/I11M6L1BjjnAH5binNKxiit1uTGBQ==")

	val headers_29 = Map(
		"Authorization" -> "AWS4-HMAC-SHA256 Credential=ASIAJPM2LWBQAN44AWUA/20170327/us-east-1/execute-api/aws4_request, SignedHeaders=host;x-amz-date, Signature=1e6615211d4c1ad331c25e84261724791b090fc86e7a0247a5aa210373081d09",
		"Cache-Control" -> "no-cache",
		"Content-Type" -> "application/json",
		"Origin" -> "https://dashboard.dev.iotsyst.com",
		"Pragma" -> "no-cache",
		"x-amz-date" -> "20170327T151259Z",
		"x-amz-security-token" -> "FQoDYXdzEBgaDJzWEoueemDLPwUn0SLmA7CMwgRbCgTmdoBQGdjtuyifyetkcoDNdFqBwq6b7AmMLB+R87oA2+bnkCtyY/ZxBwqSah09F57dbYCSFYHXG4We3h7CcjTL9i9SC1GrXuqiS0xlzFxuKNxgTeV8i51EeFqW1hdxI/q63XpTcvYhfgMm2w3Vxh8b7EmxWVPtfr7svgnox0Dd1fb+YJtfAwAgmengc4WfWYkQyOKtvCC0vrfz2efZdWbvrhXdtHV26cpO1UXbcr5j884isiwSF4grEvIQLjGVXhVNxl3yJEIQtldUD7mhS6GFcZy2osTwiPlIXKlDO2NuZzP5oNvvIOWzCqFZ6IcoTZ997nKsvH6P314bZQv8rrpHSdUm8mH24qP7Kr4XiEWfCXcMY+zD/QRxATqgUlF9s+2BQzQ0LqeV98NkQ7CwkdXAJtj7+GJzS0uRuuO1lzxll96RQAxuEE8guZk5Au/aoFfxX4ufONfF8LRTUOp32al59G5DCy0FK17BRjhoqy/irwnmM1pOItZWQO/+g6Fiui3v50tTwiHB/KrnCVef53d6U/WM8W5LXeIjTks6hZlZYh0vWddN8YxnuH2LrMX5dn1S4OK7h/TzPPUueLIKCHHxExw4Vs5Ptw0x2m9qWLnB/I11M6L1BjjnAH5binNKxiit1uTGBQ==")

	val headers_35 = Map(
		"Authorization" -> "AWS4-HMAC-SHA256 Credential=ASIAJPM2LWBQAN44AWUA/20170327/us-east-1/execute-api/aws4_request, SignedHeaders=host;x-amz-date, Signature=3fd205951026fbaf3039373324d4c04fdd1b609509af105183a30827343e13bc",
		"Cache-Control" -> "no-cache",
		"Content-Type" -> "application/json",
		"Origin" -> "https://dashboard.dev.iotsyst.com",
		"Pragma" -> "no-cache",
		"x-amz-date" -> "20170327T151304Z",
		"x-amz-security-token" -> "FQoDYXdzEBgaDJzWEoueemDLPwUn0SLmA7CMwgRbCgTmdoBQGdjtuyifyetkcoDNdFqBwq6b7AmMLB+R87oA2+bnkCtyY/ZxBwqSah09F57dbYCSFYHXG4We3h7CcjTL9i9SC1GrXuqiS0xlzFxuKNxgTeV8i51EeFqW1hdxI/q63XpTcvYhfgMm2w3Vxh8b7EmxWVPtfr7svgnox0Dd1fb+YJtfAwAgmengc4WfWYkQyOKtvCC0vrfz2efZdWbvrhXdtHV26cpO1UXbcr5j884isiwSF4grEvIQLjGVXhVNxl3yJEIQtldUD7mhS6GFcZy2osTwiPlIXKlDO2NuZzP5oNvvIOWzCqFZ6IcoTZ997nKsvH6P314bZQv8rrpHSdUm8mH24qP7Kr4XiEWfCXcMY+zD/QRxATqgUlF9s+2BQzQ0LqeV98NkQ7CwkdXAJtj7+GJzS0uRuuO1lzxll96RQAxuEE8guZk5Au/aoFfxX4ufONfF8LRTUOp32al59G5DCy0FK17BRjhoqy/irwnmM1pOItZWQO/+g6Fiui3v50tTwiHB/KrnCVef53d6U/WM8W5LXeIjTks6hZlZYh0vWddN8YxnuH2LrMX5dn1S4OK7h/TzPPUueLIKCHHxExw4Vs5Ptw0x2m9qWLnB/I11M6L1BjjnAH5binNKxiit1uTGBQ==")

	val headers_41 = Map(
		"Authorization" -> "AWS4-HMAC-SHA256 Credential=ASIAJPM2LWBQAN44AWUA/20170327/us-east-1/execute-api/aws4_request, SignedHeaders=host;x-amz-date, Signature=1cb7f5f4d76ba713925213751e0965fa19a7ba19165974850e8891cf4f014585",
		"Cache-Control" -> "no-cache",
		"Content-Type" -> "application/json",
		"Origin" -> "https://dashboard.dev.iotsyst.com",
		"Pragma" -> "no-cache",
		"x-amz-date" -> "20170327T151309Z",
		"x-amz-security-token" -> "FQoDYXdzEBgaDJzWEoueemDLPwUn0SLmA7CMwgRbCgTmdoBQGdjtuyifyetkcoDNdFqBwq6b7AmMLB+R87oA2+bnkCtyY/ZxBwqSah09F57dbYCSFYHXG4We3h7CcjTL9i9SC1GrXuqiS0xlzFxuKNxgTeV8i51EeFqW1hdxI/q63XpTcvYhfgMm2w3Vxh8b7EmxWVPtfr7svgnox0Dd1fb+YJtfAwAgmengc4WfWYkQyOKtvCC0vrfz2efZdWbvrhXdtHV26cpO1UXbcr5j884isiwSF4grEvIQLjGVXhVNxl3yJEIQtldUD7mhS6GFcZy2osTwiPlIXKlDO2NuZzP5oNvvIOWzCqFZ6IcoTZ997nKsvH6P314bZQv8rrpHSdUm8mH24qP7Kr4XiEWfCXcMY+zD/QRxATqgUlF9s+2BQzQ0LqeV98NkQ7CwkdXAJtj7+GJzS0uRuuO1lzxll96RQAxuEE8guZk5Au/aoFfxX4ufONfF8LRTUOp32al59G5DCy0FK17BRjhoqy/irwnmM1pOItZWQO/+g6Fiui3v50tTwiHB/KrnCVef53d6U/WM8W5LXeIjTks6hZlZYh0vWddN8YxnuH2LrMX5dn1S4OK7h/TzPPUueLIKCHHxExw4Vs5Ptw0x2m9qWLnB/I11M6L1BjjnAH5binNKxiit1uTGBQ==")

	val headers_47 = Map(
		"Authorization" -> "AWS4-HMAC-SHA256 Credential=ASIAJPM2LWBQAN44AWUA/20170327/us-east-1/execute-api/aws4_request, SignedHeaders=host;x-amz-date, Signature=49175d8f1efc949ffe7cd7a106863f72389f715cfcce2473861e0477bc25fb75",
		"Cache-Control" -> "no-cache",
		"Content-Type" -> "application/json",
		"Origin" -> "https://dashboard.dev.iotsyst.com",
		"Pragma" -> "no-cache",
		"x-amz-date" -> "20170327T151314Z",
		"x-amz-security-token" -> "FQoDYXdzEBgaDJzWEoueemDLPwUn0SLmA7CMwgRbCgTmdoBQGdjtuyifyetkcoDNdFqBwq6b7AmMLB+R87oA2+bnkCtyY/ZxBwqSah09F57dbYCSFYHXG4We3h7CcjTL9i9SC1GrXuqiS0xlzFxuKNxgTeV8i51EeFqW1hdxI/q63XpTcvYhfgMm2w3Vxh8b7EmxWVPtfr7svgnox0Dd1fb+YJtfAwAgmengc4WfWYkQyOKtvCC0vrfz2efZdWbvrhXdtHV26cpO1UXbcr5j884isiwSF4grEvIQLjGVXhVNxl3yJEIQtldUD7mhS6GFcZy2osTwiPlIXKlDO2NuZzP5oNvvIOWzCqFZ6IcoTZ997nKsvH6P314bZQv8rrpHSdUm8mH24qP7Kr4XiEWfCXcMY+zD/QRxATqgUlF9s+2BQzQ0LqeV98NkQ7CwkdXAJtj7+GJzS0uRuuO1lzxll96RQAxuEE8guZk5Au/aoFfxX4ufONfF8LRTUOp32al59G5DCy0FK17BRjhoqy/irwnmM1pOItZWQO/+g6Fiui3v50tTwiHB/KrnCVef53d6U/WM8W5LXeIjTks6hZlZYh0vWddN8YxnuH2LrMX5dn1S4OK7h/TzPPUueLIKCHHxExw4Vs5Ptw0x2m9qWLnB/I11M6L1BjjnAH5binNKxiit1uTGBQ==")

	val headers_51 = Map(
		"Authorization" -> "AWS4-HMAC-SHA256 Credential=ASIAJPM2LWBQAN44AWUA/20170327/us-east-1/execute-api/aws4_request, SignedHeaders=host;x-amz-date, Signature=cce6beef134399d59347b0b7afd2b9b36e86c638cf441f274627ffaf6a089ce6",
		"Cache-Control" -> "no-cache",
		"Content-Type" -> "application/json",
		"Origin" -> "https://dashboard.dev.iotsyst.com",
		"Pragma" -> "no-cache",
		"x-amz-date" -> "20170327T151318Z",
		"x-amz-security-token" -> "FQoDYXdzEBgaDJzWEoueemDLPwUn0SLmA7CMwgRbCgTmdoBQGdjtuyifyetkcoDNdFqBwq6b7AmMLB+R87oA2+bnkCtyY/ZxBwqSah09F57dbYCSFYHXG4We3h7CcjTL9i9SC1GrXuqiS0xlzFxuKNxgTeV8i51EeFqW1hdxI/q63XpTcvYhfgMm2w3Vxh8b7EmxWVPtfr7svgnox0Dd1fb+YJtfAwAgmengc4WfWYkQyOKtvCC0vrfz2efZdWbvrhXdtHV26cpO1UXbcr5j884isiwSF4grEvIQLjGVXhVNxl3yJEIQtldUD7mhS6GFcZy2osTwiPlIXKlDO2NuZzP5oNvvIOWzCqFZ6IcoTZ997nKsvH6P314bZQv8rrpHSdUm8mH24qP7Kr4XiEWfCXcMY+zD/QRxATqgUlF9s+2BQzQ0LqeV98NkQ7CwkdXAJtj7+GJzS0uRuuO1lzxll96RQAxuEE8guZk5Au/aoFfxX4ufONfF8LRTUOp32al59G5DCy0FK17BRjhoqy/irwnmM1pOItZWQO/+g6Fiui3v50tTwiHB/KrnCVef53d6U/WM8W5LXeIjTks6hZlZYh0vWddN8YxnuH2LrMX5dn1S4OK7h/TzPPUueLIKCHHxExw4Vs5Ptw0x2m9qWLnB/I11M6L1BjjnAH5binNKxiit1uTGBQ==")

	val headers_55 = Map(
		"Authorization" -> "AWS4-HMAC-SHA256 Credential=ASIAJPM2LWBQAN44AWUA/20170327/us-east-1/execute-api/aws4_request, SignedHeaders=host;x-amz-date, Signature=b2ca7d91fa32072c7b174f5ca6e8e83d6bda47939796a5252826e07af356bfca",
		"Cache-Control" -> "no-cache",
		"Content-Type" -> "application/json",
		"Origin" -> "https://dashboard.dev.iotsyst.com",
		"Pragma" -> "no-cache",
		"x-amz-date" -> "20170327T151319Z",
		"x-amz-security-token" -> "FQoDYXdzEBgaDJzWEoueemDLPwUn0SLmA7CMwgRbCgTmdoBQGdjtuyifyetkcoDNdFqBwq6b7AmMLB+R87oA2+bnkCtyY/ZxBwqSah09F57dbYCSFYHXG4We3h7CcjTL9i9SC1GrXuqiS0xlzFxuKNxgTeV8i51EeFqW1hdxI/q63XpTcvYhfgMm2w3Vxh8b7EmxWVPtfr7svgnox0Dd1fb+YJtfAwAgmengc4WfWYkQyOKtvCC0vrfz2efZdWbvrhXdtHV26cpO1UXbcr5j884isiwSF4grEvIQLjGVXhVNxl3yJEIQtldUD7mhS6GFcZy2osTwiPlIXKlDO2NuZzP5oNvvIOWzCqFZ6IcoTZ997nKsvH6P314bZQv8rrpHSdUm8mH24qP7Kr4XiEWfCXcMY+zD/QRxATqgUlF9s+2BQzQ0LqeV98NkQ7CwkdXAJtj7+GJzS0uRuuO1lzxll96RQAxuEE8guZk5Au/aoFfxX4ufONfF8LRTUOp32al59G5DCy0FK17BRjhoqy/irwnmM1pOItZWQO/+g6Fiui3v50tTwiHB/KrnCVef53d6U/WM8W5LXeIjTks6hZlZYh0vWddN8YxnuH2LrMX5dn1S4OK7h/TzPPUueLIKCHHxExw4Vs5Ptw0x2m9qWLnB/I11M6L1BjjnAH5binNKxiit1uTGBQ==")

	val headers_61 = Map(
		"Authorization" -> "AWS4-HMAC-SHA256 Credential=ASIAJPM2LWBQAN44AWUA/20170327/us-east-1/execute-api/aws4_request, SignedHeaders=host;x-amz-date, Signature=34d7514941f634b29b5ab11c0f7ff7b4f948a71fb081f152cc6afe19f63d20ec",
		"Cache-Control" -> "no-cache",
		"Content-Type" -> "application/json",
		"Origin" -> "https://dashboard.dev.iotsyst.com",
		"Pragma" -> "no-cache",
		"x-amz-date" -> "20170327T151324Z",
		"x-amz-security-token" -> "FQoDYXdzEBgaDJzWEoueemDLPwUn0SLmA7CMwgRbCgTmdoBQGdjtuyifyetkcoDNdFqBwq6b7AmMLB+R87oA2+bnkCtyY/ZxBwqSah09F57dbYCSFYHXG4We3h7CcjTL9i9SC1GrXuqiS0xlzFxuKNxgTeV8i51EeFqW1hdxI/q63XpTcvYhfgMm2w3Vxh8b7EmxWVPtfr7svgnox0Dd1fb+YJtfAwAgmengc4WfWYkQyOKtvCC0vrfz2efZdWbvrhXdtHV26cpO1UXbcr5j884isiwSF4grEvIQLjGVXhVNxl3yJEIQtldUD7mhS6GFcZy2osTwiPlIXKlDO2NuZzP5oNvvIOWzCqFZ6IcoTZ997nKsvH6P314bZQv8rrpHSdUm8mH24qP7Kr4XiEWfCXcMY+zD/QRxATqgUlF9s+2BQzQ0LqeV98NkQ7CwkdXAJtj7+GJzS0uRuuO1lzxll96RQAxuEE8guZk5Au/aoFfxX4ufONfF8LRTUOp32al59G5DCy0FK17BRjhoqy/irwnmM1pOItZWQO/+g6Fiui3v50tTwiHB/KrnCVef53d6U/WM8W5LXeIjTks6hZlZYh0vWddN8YxnuH2LrMX5dn1S4OK7h/TzPPUueLIKCHHxExw4Vs5Ptw0x2m9qWLnB/I11M6L1BjjnAH5binNKxiit1uTGBQ==")

	val headers_67 = Map(
		"Authorization" -> "AWS4-HMAC-SHA256 Credential=ASIAJPM2LWBQAN44AWUA/20170327/us-east-1/execute-api/aws4_request, SignedHeaders=host;x-amz-date, Signature=ccefefb8048be07ab97041d0bd168ccc46bdeaf946c491b457b0b67bb84107b3",
		"Cache-Control" -> "no-cache",
		"Content-Type" -> "application/json",
		"Origin" -> "https://dashboard.dev.iotsyst.com",
		"Pragma" -> "no-cache",
		"x-amz-date" -> "20170327T151329Z",
		"x-amz-security-token" -> "FQoDYXdzEBgaDJzWEoueemDLPwUn0SLmA7CMwgRbCgTmdoBQGdjtuyifyetkcoDNdFqBwq6b7AmMLB+R87oA2+bnkCtyY/ZxBwqSah09F57dbYCSFYHXG4We3h7CcjTL9i9SC1GrXuqiS0xlzFxuKNxgTeV8i51EeFqW1hdxI/q63XpTcvYhfgMm2w3Vxh8b7EmxWVPtfr7svgnox0Dd1fb+YJtfAwAgmengc4WfWYkQyOKtvCC0vrfz2efZdWbvrhXdtHV26cpO1UXbcr5j884isiwSF4grEvIQLjGVXhVNxl3yJEIQtldUD7mhS6GFcZy2osTwiPlIXKlDO2NuZzP5oNvvIOWzCqFZ6IcoTZ997nKsvH6P314bZQv8rrpHSdUm8mH24qP7Kr4XiEWfCXcMY+zD/QRxATqgUlF9s+2BQzQ0LqeV98NkQ7CwkdXAJtj7+GJzS0uRuuO1lzxll96RQAxuEE8guZk5Au/aoFfxX4ufONfF8LRTUOp32al59G5DCy0FK17BRjhoqy/irwnmM1pOItZWQO/+g6Fiui3v50tTwiHB/KrnCVef53d6U/WM8W5LXeIjTks6hZlZYh0vWddN8YxnuH2LrMX5dn1S4OK7h/TzPPUueLIKCHHxExw4Vs5Ptw0x2m9qWLnB/I11M6L1BjjnAH5binNKxiit1uTGBQ==")

	val headers_73 = Map(
		"Authorization" -> "AWS4-HMAC-SHA256 Credential=ASIAJPM2LWBQAN44AWUA/20170327/us-east-1/execute-api/aws4_request, SignedHeaders=host;x-amz-date, Signature=f5aaa5bf8aa2b0ad27d28544c58a9245cb8cff856fe9ceca57e09d1050d1ea2d",
		"Cache-Control" -> "no-cache",
		"Content-Type" -> "application/json",
		"Origin" -> "https://dashboard.dev.iotsyst.com",
		"Pragma" -> "no-cache",
		"x-amz-date" -> "20170327T151334Z",
		"x-amz-security-token" -> "FQoDYXdzEBgaDJzWEoueemDLPwUn0SLmA7CMwgRbCgTmdoBQGdjtuyifyetkcoDNdFqBwq6b7AmMLB+R87oA2+bnkCtyY/ZxBwqSah09F57dbYCSFYHXG4We3h7CcjTL9i9SC1GrXuqiS0xlzFxuKNxgTeV8i51EeFqW1hdxI/q63XpTcvYhfgMm2w3Vxh8b7EmxWVPtfr7svgnox0Dd1fb+YJtfAwAgmengc4WfWYkQyOKtvCC0vrfz2efZdWbvrhXdtHV26cpO1UXbcr5j884isiwSF4grEvIQLjGVXhVNxl3yJEIQtldUD7mhS6GFcZy2osTwiPlIXKlDO2NuZzP5oNvvIOWzCqFZ6IcoTZ997nKsvH6P314bZQv8rrpHSdUm8mH24qP7Kr4XiEWfCXcMY+zD/QRxATqgUlF9s+2BQzQ0LqeV98NkQ7CwkdXAJtj7+GJzS0uRuuO1lzxll96RQAxuEE8guZk5Au/aoFfxX4ufONfF8LRTUOp32al59G5DCy0FK17BRjhoqy/irwnmM1pOItZWQO/+g6Fiui3v50tTwiHB/KrnCVef53d6U/WM8W5LXeIjTks6hZlZYh0vWddN8YxnuH2LrMX5dn1S4OK7h/TzPPUueLIKCHHxExw4Vs5Ptw0x2m9qWLnB/I11M6L1BjjnAH5binNKxiit1uTGBQ==")

	val headers_77 = Map(
		"Authorization" -> "AWS4-HMAC-SHA256 Credential=ASIAJPM2LWBQAN44AWUA/20170327/us-east-1/execute-api/aws4_request, SignedHeaders=host;x-amz-date, Signature=21a8fe5e3f851e9bbf9ee7e3b2ca017422a6fd44f3328a8f35b7cff484a4cee0",
		"Cache-Control" -> "no-cache",
		"Content-Type" -> "application/json",
		"Origin" -> "https://dashboard.dev.iotsyst.com",
		"Pragma" -> "no-cache",
		"x-amz-date" -> "20170327T151335Z",
		"x-amz-security-token" -> "FQoDYXdzEBgaDJzWEoueemDLPwUn0SLmA7CMwgRbCgTmdoBQGdjtuyifyetkcoDNdFqBwq6b7AmMLB+R87oA2+bnkCtyY/ZxBwqSah09F57dbYCSFYHXG4We3h7CcjTL9i9SC1GrXuqiS0xlzFxuKNxgTeV8i51EeFqW1hdxI/q63XpTcvYhfgMm2w3Vxh8b7EmxWVPtfr7svgnox0Dd1fb+YJtfAwAgmengc4WfWYkQyOKtvCC0vrfz2efZdWbvrhXdtHV26cpO1UXbcr5j884isiwSF4grEvIQLjGVXhVNxl3yJEIQtldUD7mhS6GFcZy2osTwiPlIXKlDO2NuZzP5oNvvIOWzCqFZ6IcoTZ997nKsvH6P314bZQv8rrpHSdUm8mH24qP7Kr4XiEWfCXcMY+zD/QRxATqgUlF9s+2BQzQ0LqeV98NkQ7CwkdXAJtj7+GJzS0uRuuO1lzxll96RQAxuEE8guZk5Au/aoFfxX4ufONfF8LRTUOp32al59G5DCy0FK17BRjhoqy/irwnmM1pOItZWQO/+g6Fiui3v50tTwiHB/KrnCVef53d6U/WM8W5LXeIjTks6hZlZYh0vWddN8YxnuH2LrMX5dn1S4OK7h/TzPPUueLIKCHHxExw4Vs5Ptw0x2m9qWLnB/I11M6L1BjjnAH5binNKxiit1uTGBQ==")

	val headers_81 = Map(
		"Authorization" -> "AWS4-HMAC-SHA256 Credential=ASIAJPM2LWBQAN44AWUA/20170327/us-east-1/execute-api/aws4_request, SignedHeaders=host;x-amz-date, Signature=705d3814f890e5f78931600d1b70d006760780a9d616c49c84c395c1169a0ae5",
		"Cache-Control" -> "no-cache",
		"Content-Type" -> "application/json",
		"Origin" -> "https://dashboard.dev.iotsyst.com",
		"Pragma" -> "no-cache",
		"x-amz-date" -> "20170327T151339Z",
		"x-amz-security-token" -> "FQoDYXdzEBgaDJzWEoueemDLPwUn0SLmA7CMwgRbCgTmdoBQGdjtuyifyetkcoDNdFqBwq6b7AmMLB+R87oA2+bnkCtyY/ZxBwqSah09F57dbYCSFYHXG4We3h7CcjTL9i9SC1GrXuqiS0xlzFxuKNxgTeV8i51EeFqW1hdxI/q63XpTcvYhfgMm2w3Vxh8b7EmxWVPtfr7svgnox0Dd1fb+YJtfAwAgmengc4WfWYkQyOKtvCC0vrfz2efZdWbvrhXdtHV26cpO1UXbcr5j884isiwSF4grEvIQLjGVXhVNxl3yJEIQtldUD7mhS6GFcZy2osTwiPlIXKlDO2NuZzP5oNvvIOWzCqFZ6IcoTZ997nKsvH6P314bZQv8rrpHSdUm8mH24qP7Kr4XiEWfCXcMY+zD/QRxATqgUlF9s+2BQzQ0LqeV98NkQ7CwkdXAJtj7+GJzS0uRuuO1lzxll96RQAxuEE8guZk5Au/aoFfxX4ufONfF8LRTUOp32al59G5DCy0FK17BRjhoqy/irwnmM1pOItZWQO/+g6Fiui3v50tTwiHB/KrnCVef53d6U/WM8W5LXeIjTks6hZlZYh0vWddN8YxnuH2LrMX5dn1S4OK7h/TzPPUueLIKCHHxExw4Vs5Ptw0x2m9qWLnB/I11M6L1BjjnAH5binNKxiit1uTGBQ==")


    val uri1 = "https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev"

	val scn = scenario("RecordedSimulation")
		.exec(http("request_0")
			.options("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627550017&type=2")
			.headers(headers_0)
			.resources(http("request_1")
			.options("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627550017&type=2")
			.headers(headers_0),
            http("request_2")
			.options("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627550017&type=2")
			.headers(headers_0),
            http("request_3")
			.get("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627550017&type=2")
			.headers(headers_3),
            http("request_4")
			.get("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627550017&type=2")
			.headers(headers_3),
            http("request_5")
			.get("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627550017&type=2")
			.headers(headers_3)))
		.pause(4)
		.exec(http("request_6")
			.options("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627550017&type=2")
			.headers(headers_0)
			.resources(http("request_7")
			.options("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627550017&type=2")
			.headers(headers_0),
            http("request_8")
			.options("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627550017&type=2")
			.headers(headers_0),
            http("request_9")
			.get("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627550017&type=2")
			.headers(headers_9),
            http("request_10")
			.get("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627550017&type=2")
			.headers(headers_9),
            http("request_11")
			.get("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627550017&type=2")
			.headers(headers_9)))
		.pause(3)
		.exec(http("request_12")
			.options("/dev/dashboard/a36d7666-2e0c-4f01-9663-6d726264dc04")
			.headers(headers_0)
			.resources(http("request_13")
			.get("/dev/dashboard/a36d7666-2e0c-4f01-9663-6d726264dc04")
			.headers(headers_13)))
		.pause(1)
		.exec(http("request_14")
			.options("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627550017&type=2")
			.headers(headers_0)
			.resources(http("request_15")
			.options("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627550017&type=2")
			.headers(headers_0),
            http("request_16")
			.options("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627550017&type=2")
			.headers(headers_0),
            http("request_17")
			.get("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627550017&type=2")
			.headers(headers_17),
            http("request_18")
			.get("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627550017&type=2")
			.headers(headers_17),
            http("request_19")
			.get("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627550017&type=2")
			.headers(headers_17)))
		.pause(4)
		.exec(http("request_20")
			.options("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627550017&type=2")
			.headers(headers_0)
			.resources(http("request_21")
			.options("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627550017&type=2")
			.headers(headers_0),
            http("request_22")
			.options("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627550017&type=2")
			.headers(headers_0),
            http("request_23")
			.get("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627550017&type=2")
			.headers(headers_23),
            http("request_24")
			.get("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627550017&type=2")
			.headers(headers_23),
            http("request_25")
			.get("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627550017&type=2")
			.headers(headers_23)))
		.pause(4)
		.exec(http("request_26")
			.options("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627550017&type=2")
			.headers(headers_0)
			.resources(http("request_27")
			.options("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627550017&type=2")
			.headers(headers_0),
            http("request_28")
			.options("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627550017&type=2")
			.headers(headers_0),
            http("request_29")
			.get("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627550017&type=2")
			.headers(headers_29),
            http("request_30")
			.get("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627550017&type=2")
			.headers(headers_29),
            http("request_31")
			.get("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627550017&type=2")
			.headers(headers_29)))
		.pause(4)
		.exec(http("request_32")
			.options("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627550017&type=2")
			.headers(headers_0)
			.resources(http("request_33")
			.options("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627550017&type=2")
			.headers(headers_0),
            http("request_34")
			.options("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627550017&type=2")
			.headers(headers_0),
            http("request_35")
			.get("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627550017&type=2")
			.headers(headers_35),
            http("request_36")
			.get("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627550017&type=2")
			.headers(headers_35),
            http("request_37")
			.get("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627550017&type=2")
			.headers(headers_35)))
		.pause(4)
		.exec(http("request_38")
			.options("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627579764&type=2")
			.headers(headers_0)
			.resources(http("request_39")
			.options("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627579764&type=2")
			.headers(headers_0),
            http("request_40")
			.options("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627579764&type=2")
			.headers(headers_0),
            http("request_41")
			.get("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627579764&type=2")
			.headers(headers_41),
            http("request_42")
			.get("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627579764&type=2")
			.headers(headers_41),
            http("request_43")
			.get("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627579764&type=2")
			.headers(headers_41)))
		.pause(4)
		.exec(http("request_44")
			.options("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627579764&type=2")
			.headers(headers_0)
			.resources(http("request_45")
			.options("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627579764&type=2")
			.headers(headers_0),
            http("request_46")
			.options("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627579764&type=2")
			.headers(headers_0),
            http("request_47")
			.get("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627579764&type=2")
			.headers(headers_47),
            http("request_48")
			.get("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627579764&type=2")
			.headers(headers_47),
            http("request_49")
			.get("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627579764&type=2")
			.headers(headers_47)))
		.pause(3)
		.exec(http("request_50")
			.options("/dev/dashboard/a36d7666-2e0c-4f01-9663-6d726264dc04")
			.headers(headers_0)
			.resources(http("request_51")
			.get("/dev/dashboard/a36d7666-2e0c-4f01-9663-6d726264dc04")
			.headers(headers_51)))
		.pause(1)
		.exec(http("request_52")
			.options("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627579764&type=2")
			.headers(headers_0)
			.resources(http("request_53")
			.options("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627579764&type=2")
			.headers(headers_0),
            http("request_54")
			.options("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627579764&type=2")
			.headers(headers_0),
            http("request_55")
			.get("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627579764&type=2")
			.headers(headers_55),
            http("request_56")
			.get("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627579764&type=2")
			.headers(headers_55),
            http("request_57")
			.get("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627579764&type=2")
			.headers(headers_55)))
		.pause(4)
		.exec(http("request_58")
			.options("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627579764&type=2")
			.headers(headers_0)
			.resources(http("request_59")
			.options("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627579764&type=2")
			.headers(headers_0),
            http("request_60")
			.options("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627579764&type=2")
			.headers(headers_0),
            http("request_61")
			.get("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627579764&type=2")
			.headers(headers_61),
            http("request_62")
			.get("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627579764&type=2")
			.headers(headers_61),
            http("request_63")
			.get("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627579764&type=2")
			.headers(headers_61)))
		.pause(4)
		.exec(http("request_64")
			.options("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627579764&type=2")
			.headers(headers_0)
			.resources(http("request_65")
			.options("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627579764&type=2")
			.headers(headers_0),
            http("request_66")
			.options("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627579764&type=2")
			.headers(headers_0),
            http("request_67")
			.get("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627579764&type=2")
			.headers(headers_67),
            http("request_68")
			.get("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627579764&type=2")
			.headers(headers_67),
            http("request_69")
			.get("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627579764&type=2")
			.headers(headers_67)))
		.pause(4)
		.exec(http("request_70")
			.options("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627579764&type=2")
			.headers(headers_0)
			.resources(http("request_71")
			.options("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627579764&type=2")
			.headers(headers_0),
            http("request_72")
			.options("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627579764&type=2")
			.headers(headers_0),
            http("request_73")
			.get("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627579764&type=2")
			.headers(headers_73),
            http("request_74")
			.get("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627579764&type=2")
			.headers(headers_73),
            http("request_75")
			.get("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627579764&type=2")
			.headers(headers_73),
            http("request_76")
			.options("/dev/notification?status=unread")
			.headers(headers_0),
            http("request_77")
			.get("/dev/notification?status=unread")
			.headers(headers_77)))
		.pause(4)
		.exec(http("request_78")
			.options("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627609826&type=2")
			.headers(headers_0)
			.resources(http("request_79")
			.options("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627609826&type=2")
			.headers(headers_0),
            http("request_80")
			.options("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627609826&type=2")
			.headers(headers_0),
            http("request_81")
			.get("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627609826&type=2")
			.headers(headers_81),
            http("request_82")
			.get("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627609826&type=2")
			.headers(headers_81),
            http("request_83")
			.get("/dev/chart/Thing-000013-i4?channelIdx=1&startDate=1490627609826&type=2")
			.headers(headers_81)))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}