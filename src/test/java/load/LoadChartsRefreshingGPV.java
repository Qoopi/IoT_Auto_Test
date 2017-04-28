package load;

import load.utils.GatlingReportAdapter;
import load.utils.ListenerLoad;
import load.utils.RequestManager;
import load.utils.ThreadLaunchDelayer;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(ListenerLoad.class)
public class LoadChartsRefreshingGPV {
    private final int threads = 100;
    private final int newThreadLaunchDelayMs = 5000;
    private final int tenMinutesCyclesCount = 2;

    @BeforeClass
    public void createDashboardGPV(){
        RequestManager requestManager = new RequestManager();
        requestManager.dashboardCreateCanvasGPV();
    }

    @AfterClass
    public void deleteDashboardGPV(){
        RequestManager requestManager = new RequestManager();
        requestManager.dashboardDeleteCanvasGPV();
    }

    @Test(threadPoolSize = threads, invocationCount = threads)
    public void refreshDashboardGPV(){
        ThreadLaunchDelayer.delay(newThreadLaunchDelayMs);
        GatlingReportAdapter gatling = new GatlingReportAdapter();
        gatling.gatlingInfoPrintUserStart();
        RequestManager requestManager = new RequestManager();
        requestManager.canvasGPVDashboardLoadRefreshCycle(tenMinutesCyclesCount);
    }
}
