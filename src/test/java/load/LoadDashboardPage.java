package load;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(LoadListener.class)
public class LoadDashboardPage {
    private final int threadsDashboardPage = 20;
    private final int testOperationTimeMins = 1;
    private final int newThreadLaunchDelayMs = 500;

    @Test
    public void checkNewCreds(){
        RequestManager requestManager = new RequestManager();
        requestManager.checkExpiredCredentials(testOperationTimeMins);
    }

    @Test(threadPoolSize = threadsDashboardPage, invocationCount = threadsDashboardPage)
    public void loadDashboardPage (){
        ThreadLaunchDelayer.delay(newThreadLaunchDelayMs);
        RequestManager requestManager = new RequestManager();
        requestManager.loadDashboardPage(10,2000);
    }
}
