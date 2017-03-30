package load;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ui.pageObjets.LogInPage;

/**
 * Created by alex00x6 on 28.03.2017.
 */

@Listeners(LoadListener.class)
public class EmulateChartsRefreshing {
    final int testThreads = 20;



    @BeforeTest
    public void getCreds(){
        LogInPage log = new LogInPage();
        log.getToIoTPage();
        log.enterGoogleCred();
        log.getRequestSigns();
        RequestManager requestManager = new RequestManager();
        requestManager.writeCredsTofile();
        requestManager.setUpBaseApiGateway();
    }

    @Test
    public void checkNewCreds(){
        RequestManager requestManager = new RequestManager();
        requestManager.checkExpiredCredentials(10000, 1);
    }

    @Test(threadPoolSize = testThreads, invocationCount = testThreads)
    public void refreshDashboard(){
        RequestManager requestManager = new RequestManager();
        requestManager.startLog("refreshDashboard"+".txt");
        requestManager.canvasDashboardRefreshCycle(1);
        requestManager.stopLog();
    }

//    @Test(threadPoolSize = 80, invocationCount = 80)
    public void refreshDashboard2(){
        RequestManager requestManager = new RequestManager();
        requestManager.canvasDashboardRefreshCycleProperTimestamp(1);
    }

//    @Test
    public void refreshDashboard3(){
        RequestManager requestManager = new RequestManager();
        requestManager.canvasDashboardRefreshCycle(2);
    }

//    @Test
    public void refreshDashboard4(){
        RequestManager requestManager = new RequestManager();
        requestManager.canvasDashboardRefreshCycle(2);
    }

}
