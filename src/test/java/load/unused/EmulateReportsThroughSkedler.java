package load.unused;

import load.LoadListener;
import load.RequestManager;
import load.ThreadLaunchDelayer;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by user on 03.04.2017.
 */

@Listeners(LoadListener.class)
public class EmulateReportsThroughSkedler {
    private final int threadsDashboardPage = 20;
    private final int newThreadLaunchDelayMs = 500;

    @Test(threadPoolSize = threadsDashboardPage, invocationCount = threadsDashboardPage)
    public void createReport(){
        ThreadLaunchDelayer.delay(newThreadLaunchDelayMs);
        RequestManager requestManager = new RequestManager();
        requestManager.skedlerReportCreate();
    }
}
