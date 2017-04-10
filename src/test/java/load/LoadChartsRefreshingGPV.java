package load;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by alex00x6 on 28.03.2017.
 */

@Listeners(LoadListener.class)
public class LoadChartsRefreshingGPV {
    private final int threads = 70;
    private final int newThreadLaunchDelayMs = 5000;
    private final int tenMinutesCyclesCount = 2;

    @BeforeClass
    public void createDashboards(){
        RequestManager requestManager = new RequestManager();
        requestManager.dashboardCreateCanvasGPV();
    }

    @AfterClass
    public void deleteDashboards(){
        RequestManager requestManager = new RequestManager();
        requestManager.dashboardDeleteCanvasGPV();
    }

    @Test(threadPoolSize = threads, invocationCount = threads)
    public void refreshGPVDashboard(){
        ThreadLaunchDelayer.delay(newThreadLaunchDelayMs);
        gatlingInfoPrintUserStart();
        RequestManager requestManager = new RequestManager();
        requestManager.canvasGPVDashboardLoadRefreshCycle(tenMinutesCyclesCount);
    }

    private void gatlingInfoPrintUserStart(){
        String name = "RecordedSimulation1";
        long thread = Thread.currentThread().getId();
        long timeStart = System.currentTimeMillis();
        System.out.println("USER\t"+name+"\t"+thread+"\tSTART\t"+timeStart+"\t"+timeStart);
    }
}
