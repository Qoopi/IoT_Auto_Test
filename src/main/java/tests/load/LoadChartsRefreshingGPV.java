package tests.load;

import mechanics.load.utils.GatlingReportAdapter;
import mechanics.load.utils.ListenerLoad;
import mechanics.load.utils.RequestManagerLoad;
import mechanics.load.utils.ThreadLaunchDelayer;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(ListenerLoad.class)
public class LoadChartsRefreshingGPV {
    private final int threads = 1;
    private final int newThreadLaunchDelayMs = 5000;
    private final int tenMinutesCyclesCount = 1;

    @BeforeClass
    public void createDashboardGPV(){
        RequestManagerLoad requestManagerLoad = new RequestManagerLoad();
        requestManagerLoad.dashboardCreateCanvasGPV();
    }

    @AfterClass
    public void deleteDashboardGPV(){
        RequestManagerLoad requestManagerLoad = new RequestManagerLoad();
        requestManagerLoad.dashboardDeleteCanvasGPV();
    }

    @Test(threadPoolSize = threads, invocationCount = threads)
    public void refreshDashboardGPV(){
        ThreadLaunchDelayer.delay(newThreadLaunchDelayMs);
        GatlingReportAdapter gatling = new GatlingReportAdapter();
        gatling.gatlingInfoPrintUserStart();
        RequestManagerLoad requestManagerLoad = new RequestManagerLoad();
        requestManagerLoad.canvasGPVDashboardLoadRefreshCycle(tenMinutesCyclesCount);
    }
}