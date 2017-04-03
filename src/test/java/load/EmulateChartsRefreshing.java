package load;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by alex00x6 on 28.03.2017.
 */

@Listeners(LoadListener.class)
public class EmulateChartsRefreshing {
    private final int threadsDistantRequest = 1;
    private final int threadsActualRequest = 1;
    private final int testOperationTimeMins = 1;

    @BeforeClass
    public void createDashboards(){
        RequestManager requestManager = new RequestManager();
        requestManager.dashboardCreateCanvasGPV();
        requestManager.dashboardCreateCanvasVPV();
    }

    @AfterClass
    public void deleteDashboards(){
        RequestManager requestManager = new RequestManager();
        requestManager.dashboardDeleteCanvasGPV();
        requestManager.dashboardDeleteCanvasVPV();
    }

    @Test
    public void checkNewCreds(){
        RequestManager requestManager = new RequestManager();
        requestManager.checkExpiredCredentials(testOperationTimeMins);
    }

    @Test(threadPoolSize = threadsDistantRequest, invocationCount = threadsDistantRequest)
    public void refreshVPVDashboardLong(){
        RequestManager requestManager = new RequestManager();
        requestManager.canvasVPVDashboardRefreshCycleOldTimestamp(testOperationTimeMins);
    }

    @Test(threadPoolSize = threadsActualRequest, invocationCount = threadsActualRequest)
    public void refreshVPVDashboardShort(){
        RequestManager requestManager = new RequestManager();
        requestManager.canvasVPVDashboardRefreshCycleProperTimestamp(testOperationTimeMins);
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
