package load.unused;

import load.utils.ListenerLoad;
import load.utils.RequestManager;
import load.utils.ThreadLaunchDelayer;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenerLoad.class)
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
