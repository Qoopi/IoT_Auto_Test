package load;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(LoadListener.class)
public class LoadDashboardPage {
    final int threadsDashboardPage = 20;

    @Test
    public void checkNewCreds(){
        RequestManager requestManager = new RequestManager();
        requestManager.checkExpiredCredentials(1);
    }

    @Test(threadPoolSize = threadsDashboardPage, invocationCount = threadsDashboardPage)
    public void loadDashboardPage (){
        RequestManager requestManager = new RequestManager();
        requestManager.startLog("loadDashboardPage.txt");
        requestManager.loadDashboardPage(200,2000);
        requestManager.stopLog();
    }
}
