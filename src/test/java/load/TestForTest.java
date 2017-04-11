package load;

import load.constants.AmazonAPIGateway;
import org.testng.annotations.Test;

public class TestForTest {
    private final int threads = 10;

//    @Test(threadPoolSize = threads, invocationCount = threads)
    public void test() {
        ThreadLaunchDelayer.delay(1000);
        System.out.println(System.currentTimeMillis()+": hello, i'm your new thread!");
    }

//    @Test(threadPoolSize = threads, invocationCount = threads)
    public void test1() {
        ThreadLaunchDelayer.delay(1000);
        System.out.println(System.currentTimeMillis()+": hello, i'm your new thread!");
    }

//    @Test
    public void sometest(){
        System.out.println(AmazonAPIGateway.Dashboard.getUri());
    }

    @Test
    public void testagain(){
        String text = "GET_https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev/chart/Thing-090035-0?startDate=1491567426185";

        String removedTimestamp = text.replaceAll("[0-9]{13}", "*************");
        System.out.println(removedTimestamp);
    }
}
