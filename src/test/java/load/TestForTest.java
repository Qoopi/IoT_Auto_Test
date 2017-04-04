package load;

import org.testng.annotations.Test;

public class TestForTest {
    private final int threads = 10;

    @Test(threadPoolSize = threads, invocationCount = threads)
    public void test() {
        ThreadLaunchDelayer.delay(5000);
        System.out.println("hello, i'm your new thread!");
    }
}
