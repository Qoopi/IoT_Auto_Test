package load;

import api.utils.RequestManager;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ui.pageObjets.LogInPage;
import ui.utils.TestListener;

@Listeners(TestListener.class)
public class PageBootSpeed {

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
    public void checkNewCreds1(){
        RequestManager requestManager = new RequestManager();
        requestManager.getChart(10000,0);
    }

    @Test
    public void checkNewCreds2(){
        RequestManager requestManager = new RequestManager();
        requestManager.getChart(10000,0);
    }

    @Test
    public void checkNewCreds3(){
        RequestManager requestManager = new RequestManager();
        requestManager.getChart(10000,0);
    }

    @Test
    public void checkNewCreds4(){
        RequestManager requestManager = new RequestManager();
        requestManager.getChart(10000,0);
    }

    @Test
    public void checkNewCreds5(){
        RequestManager requestManager = new RequestManager();
        requestManager.getChart(10000,0);
    }

    @Test
    public void checkNewCreds6(){
        RequestManager requestManager = new RequestManager();
        requestManager.getChart(10000,0);
    }

    @Test
    public void checkNewCreds7(){
        RequestManager requestManager = new RequestManager();
        requestManager.getChart(10000,0);
    }

    @Test
    public void checkNewCreds8(){
        RequestManager requestManager = new RequestManager();
        requestManager.getChart(10000,0);
    }

    @Test
    public void checkNewCreds9(){
        RequestManager requestManager = new RequestManager();
        requestManager.getChart(10000,0);
    }

    @Test
    public void checkNewCreds10(){
        RequestManager requestManager = new RequestManager();
        requestManager.getChart(10000,0);
    }

}
