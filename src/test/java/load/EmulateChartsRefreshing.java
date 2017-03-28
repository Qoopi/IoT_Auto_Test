package load;

import api.utils.RequestManager;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ui.pageObjets.LogInPage;

/**
 * Created by alex00x6 on 28.03.2017.
 */

@Listeners(LoadListener.class)
public class EmulateChartsRefreshing {
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
        requestManager.checkExpiredCredentials(10000, 20000);
    }

    @Test
    public void refreshDashboard1(){
        RequestManager requestManager = new RequestManager();
        requestManager.canvasDashboardRefreshCycle(2);
    }

    @Test
    public void refreshDashboard2(){
        RequestManager requestManager = new RequestManager();
        requestManager.canvasDashboardRefreshCycle(2);
    }

    @Test
    public void refreshDashboard3(){
        RequestManager requestManager = new RequestManager();
        requestManager.canvasDashboardRefreshCycle(2);
    }

    @Test
    public void refreshDashboard4(){
        RequestManager requestManager = new RequestManager();
        requestManager.canvasDashboardRefreshCycle(2);
    }

}
