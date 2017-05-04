package load;

import load.utils.GatlingReportAdapter;
import load.utils.ListenerLoad;
import load.utils.RequestManagerLoad;
import load.utils.ThreadLaunchDelayer;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(ListenerLoad.class)
public class LoadChartsRefreshingVPV {
    private final int threads = 1;
    private final int newThreadLaunchDelayMs = 5000;
    private final int tenMinutesCyclesCount = 1;

    @BeforeClass
    public void createDashboardVPV(){
        RequestManagerLoad requestManagerLoad = new RequestManagerLoad();
        requestManagerLoad.dashboardCreateCanvasVPV();
    }

    @AfterClass
    public void deleteDashboardVPV(){
        RequestManagerLoad requestManagerLoad = new RequestManagerLoad();
        requestManagerLoad.dashboardDeleteCanvasVPV();
    }

    @Test(threadPoolSize = threads, invocationCount = threads)
    public void refreshDashboardVPV(){
        ThreadLaunchDelayer.delay(newThreadLaunchDelayMs);
        GatlingReportAdapter gatling = new GatlingReportAdapter();
        gatling.gatlingInfoPrintUserStart();
        RequestManagerLoad requestManagerLoad = new RequestManagerLoad();
        requestManagerLoad.canvasVPVDashboardLoadRefreshCycle(tenMinutesCyclesCount);
    }
}
