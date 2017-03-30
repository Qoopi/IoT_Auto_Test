package load;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by alex00x6 on 28.03.2017.
 */

@Listeners(LoadListener.class)
public class EmulateChartsRefreshing {
    private final int threadsDistantRequest = 20;
    private final int threadsActualRequest = 80;
    private final int testOperationTimeMins = 1;

    @Test
    public void checkNewCreds(){
        RequestManager requestManager = new RequestManager();
        requestManager.checkExpiredCredentials(10000, 1);
    }

    @Test(threadPoolSize = threadsDistantRequest, invocationCount = threadsDistantRequest)
    public void refreshVPVDashboardLong(){
        RequestManager requestManager = new RequestManager();
        requestManager.startLog("refreshDashboard"+".txt");
        requestManager.canvasDashboardRefreshCycleOldTimestamp(testOperationTimeMins);
        requestManager.stopLog();
    }

    @Test(threadPoolSize = threadsActualRequest, invocationCount = threadsActualRequest)
    public void refreshVPVDashboardShort(){
        RequestManager requestManager = new RequestManager();
        requestManager.canvasDashboardRefreshCycleProperTimestamp(testOperationTimeMins);
    }

    @Test(threadPoolSize = threadsDistantRequest, invocationCount = threadsDistantRequest)
    public void refreshGPVDashboardLong(){
        RequestManager requestManager = new RequestManager();
        requestManager.canvasGPVDashboardRefreshCycleOldTimestamp(testOperationTimeMins);
    }

    @Test(threadPoolSize = threadsActualRequest, invocationCount = threadsActualRequest)
    public void refreshGPVDashboardShort(){
        RequestManager requestManager = new RequestManager();
        requestManager.canvasGPVDashboardRefreshCycleProperTimestamp(testOperationTimeMins);
    }

}
