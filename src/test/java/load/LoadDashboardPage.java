package load;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ui.pageObjets.LogInPage;
import ui.utils.TestListener;

/**
 * Created by Oleg Kutafin on 28.03.2017.
 */
@Listeners(TestListener.class)
public class LoadDashboardPage {
    final int threadsDashboardPage = 10;



    @BeforeTest
    public void getCred(){
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

    @Test(threadPoolSize = threadsDashboardPage, invocationCount = threadsDashboardPage)
    public void loadDashboardPage (){
        RequestManager requestManager = new RequestManager();
        requestManager.startLog("loadDashboardPage.txt");
        requestManager.loadDashboardPage(20,2000);
        requestManager.stopLog();
    }
}
