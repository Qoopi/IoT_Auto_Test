package load;

import load.utils.GatlingReportAdapter;
import load.utils.LoadListener;
import load.utils.RequestManager;
import load.utils.ThreadLaunchDelayer;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(LoadListener.class)
public class LoadChartsRefreshingVPV {
    private final int threads = 70;
    private final int newThreadLaunchDelayMs = 5000;
    private final int tenMinutesCyclesCount = 2;

    @BeforeClass
    public void createDashboardVPV(){
        RequestManager requestManager = new RequestManager();
        requestManager.dashboardCreateCanvasVPV();
    }

    @AfterClass
    public void deleteDashboardVPV(){
        RequestManager requestManager = new RequestManager();
        requestManager.dashboardDeleteCanvasVPV();
    }

    @Test(threadPoolSize = threads, invocationCount = threads)
    public void refreshDashboardVPV(){
        ThreadLaunchDelayer.delay(newThreadLaunchDelayMs);
        GatlingReportAdapter.gatlingInfoPrintUserStart();
        RequestManager requestManager = new RequestManager();
        requestManager.canvasVPVDashboardLoadRefreshCycle(tenMinutesCyclesCount);
    }
}
