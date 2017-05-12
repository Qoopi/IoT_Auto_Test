package tests.testsload.unused;

import load.utils.ListenerLoad;
import load.utils.RequestManagerLoad;
import load.utils.ThreadLaunchDelayer;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by alex00x6 on 28.03.2017.
 */

@Listeners(ListenerLoad.class)
public class EmulateChartsRefreshing {
    //The quantity of both requests is summed and multiplied by 2 (for this test configuration)
    //For instance 100 threads of Distant and 400 Actual will give 1000 threads total
    private final int threadsDistantRequest = 100;
    private final int threadsActualRequest = 400;
    private final int testOperationTimeMins = 1;
    private final int newThreadLaunchDelayMs = 500;

    @BeforeClass
    public void createDashboards(){
        RequestManagerLoad requestManagerLoad = new RequestManagerLoad();
        requestManagerLoad.dashboardCreateCanvasGPV();
        requestManagerLoad.dashboardCreateCanvasVPV();
    }

    @AfterClass
    public void deleteDashboards(){
        RequestManagerLoad requestManagerLoad = new RequestManagerLoad();
        requestManagerLoad.dashboardDeleteCanvasGPV();
        requestManagerLoad.dashboardDeleteCanvasVPV();
    }

    @Test
    public void checkNewCreds(){
        RequestManagerLoad requestManagerLoad = new RequestManagerLoad();
        requestManagerLoad.checkExpiredCredentials(testOperationTimeMins);
    }

    @Test(threadPoolSize = threadsDistantRequest, invocationCount = threadsDistantRequest)
    public void refreshVPVDashboardLong(){
        ThreadLaunchDelayer.delay(newThreadLaunchDelayMs);
        RequestManagerLoad requestManagerLoad = new RequestManagerLoad();
        requestManagerLoad.canvasVPVDashboardRefreshCycleOldTimestamp(testOperationTimeMins);
    }

    @Test(threadPoolSize = threadsActualRequest, invocationCount = threadsActualRequest)
    public void refreshVPVDashboardShort(){
        ThreadLaunchDelayer.delay(newThreadLaunchDelayMs);
        RequestManagerLoad requestManagerLoad = new RequestManagerLoad();
        requestManagerLoad.canvasVPVDashboardRefreshCycleProperTimestamp(testOperationTimeMins);
    }

    @Test(threadPoolSize = threadsDistantRequest, invocationCount = threadsDistantRequest)
    public void refreshGPVDashboardLong(){
        ThreadLaunchDelayer.delay(newThreadLaunchDelayMs);
        RequestManagerLoad requestManagerLoad = new RequestManagerLoad();
        requestManagerLoad.canvasGPVDashboardRefreshCycleOldTimestamp(testOperationTimeMins);
    }

    @Test(threadPoolSize = threadsActualRequest, invocationCount = threadsActualRequest)
    public void refreshGPVDashboardShort(){
        ThreadLaunchDelayer.delay(newThreadLaunchDelayMs);
        RequestManagerLoad requestManagerLoad = new RequestManagerLoad();
        requestManagerLoad.canvasGPVDashboardRefreshCycleProperTimestamp(testOperationTimeMins);
    }

}
