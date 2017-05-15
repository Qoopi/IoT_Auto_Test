package tests.load;

import mechanics.load.utils.GatlingReportAdapter;
import mechanics.load.utils.ListenerLoad;
import mechanics.load.utils.RequestManagerLoad;
import mechanics.load.utils.ThreadLaunchDelayer;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(ListenerLoad.class)
public class LoadChartsRefreshingGPV100 {
    private final int threads = 100;
    private final int newThreadLaunchDelayMs = 5000;
    private final int tenMinutesCyclesCount = 1;


    @Test(threadPoolSize = threads, invocationCount = threads)
    public void refreshDashboardGPV(){
        ThreadLaunchDelayer.delay(newThreadLaunchDelayMs);
        GatlingReportAdapter gatling = new GatlingReportAdapter();
        RequestManagerLoad requestManagerLoad = new RequestManagerLoad();
        requestManagerLoad.dashboardCreateCanvasGPV100();
        gatling.gatlingInfoPrintUserStart();
        requestManagerLoad.canvasGPVDashboardLoadRefreshCycle100(tenMinutesCyclesCount);
        requestManagerLoad.dashboardDeleteCanvasGPV100();
    }
}
