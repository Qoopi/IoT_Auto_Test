
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

  val headers_0 = Map(
    "Access-Control-Request-Headers" -> "authorization, content-type, x-amz-date, x-amz-security-token",
    "Access-Control-Request-Method" -> "GET",
    "Origin" -> "https://dashboard.dev.iotsyst.com")

  val headers_2 = Map(
    "Authorization" -> "AWS4-HMAC-SHA256 Credential=ASIAIGCMSP6UMELOXIGA/20170320/us-east-1/execute-api/aws4_request, SignedHeaders=host;x-amz-date, Signature=cf8c2ec92fd296182b0c25775ee1ba4aa8e6363a0c1d1869d0c2993ff5828a8b",
    "Content-Type" -> "application/json",
    "Origin" -> "https://dashboard.dev.iotsyst.com",
    "x-amz-date" -> "20170320T131226Z",
    "x-amz-security-token" -> "FQoDYXdzEF4aDERLtPP2G7h9HxQNGSLmA3iZVkY1XX+Psg0KNrspMJviRpGGDPKwfygMxzo6G5O+T0yZMLS3nIcntVzBEU2voBCOoHh6vPn9Fb7nWpli2e6Gpihr1mlypDPrx1Tl/B71S9MVowklFZ2LVxve449TWKwx0V8SUJijsJmhgfPQ38wxAD6FlLd3AK7nigzwCt5IfHxbpXuEOjvFFEpMvbeAy78n74Nx8NP55hlH2YfxkJ+dx4kL4itJdwto9LwURhB28fhBrLADVxHB91xl/icihJJTK41IBvi+GYhmKYZetCEXq+DMiEE2dmqr34JNJ0mUbuzXD/Mc1mOVl/cgVZ0ixRtGWUQf6mu5iupyuO8I0XxI4ifY0zDVRU839i4JxetWMZFlpFsiiFGPE/BkOQCHC6Nv9B+94ALp/CGePv7lIiKQWMbov/0pY2WwnccAmjZD0MBdYsLnuf1g6B2uNzQk08jDuNmvuoyHn6zd4fb+d3rQ8pGRCSAsh/RYhLmZfh6XwRKZ89xj41ZfDwGvJ7GCIPQpNrKTLF1gV0dw3KuAlj6oEA4dH7bJjWfOeP/Euw8nBBJNt+zq5ztbwwZ+42Y+8v3xD7npEVIMlIpYcksW9M9WeuGkopF/rpYbJAEgn6pklCpKQJtXzS9p3uCK62Agetyh1+VnjCj5qb/GBQ==")

  val headers_3 = Map(
    "Authorization" -> "AWS4-HMAC-SHA256 Credential=ASIAIGCMSP6UMELOXIGA/20170320/us-east-1/execute-api/aws4_request, SignedHeaders=host;x-amz-date, Signature=48830c372c532494bf9446411ea4c0dbb6815ac9b725d441af939639845d9b37",
    "Content-Type" -> "application/json",
    "Origin" -> "https://dashboard.dev.iotsyst.com",
    "x-amz-date" -> "20170320T131226Z",
    "x-amz-security-token" -> "FQoDYXdzEF4aDERLtPP2G7h9HxQNGSLmA3iZVkY1XX+Psg0KNrspMJviRpGGDPKwfygMxzo6G5O+T0yZMLS3nIcntVzBEU2voBCOoHh6vPn9Fb7nWpli2e6Gpihr1mlypDPrx1Tl/B71S9MVowklFZ2LVxve449TWKwx0V8SUJijsJmhgfPQ38wxAD6FlLd3AK7nigzwCt5IfHxbpXuEOjvFFEpMvbeAy78n74Nx8NP55hlH2YfxkJ+dx4kL4itJdwto9LwURhB28fhBrLADVxHB91xl/icihJJTK41IBvi+GYhmKYZetCEXq+DMiEE2dmqr34JNJ0mUbuzXD/Mc1mOVl/cgVZ0ixRtGWUQf6mu5iupyuO8I0XxI4ifY0zDVRU839i4JxetWMZFlpFsiiFGPE/BkOQCHC6Nv9B+94ALp/CGePv7lIiKQWMbov/0pY2WwnccAmjZD0MBdYsLnuf1g6B2uNzQk08jDuNmvuoyHn6zd4fb+d3rQ8pGRCSAsh/RYhLmZfh6XwRKZ89xj41ZfDwGvJ7GCIPQpNrKTLF1gV0dw3KuAlj6oEA4dH7bJjWfOeP/Euw8nBBJNt+zq5ztbwwZ+42Y+8v3xD7npEVIMlIpYcksW9M9WeuGkopF/rpYbJAEgn6pklCpKQJtXzS9p3uCK62Agetyh1+VnjCj5qb/GBQ==")

  val uri1 = "https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev"

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

  setUp(scn.inject(atOnceUsers(100))).protocols(httpProtocol)
}