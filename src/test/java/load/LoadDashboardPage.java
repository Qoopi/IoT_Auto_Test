package load;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by Oleg Kutafin on 28.03.2017.
 */
@Listeners(LoadListener.class)
public class LoadDashboardPage {
    final int threadsDashboardPage = 1;

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
