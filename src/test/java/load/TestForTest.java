package load;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(LoadListener.class)
public class TestForTest {

    @Test
    public void checkNewCreds0(){
        RequestManager requestManager = new RequestManager();
        requestManager.checkExpiredCredentials(2);
    }

    @Test
    public void checkNewCreds(){
        RequestManager requestManager = new RequestManager();
//        requestManager.checkExpiredCredentials(10000, 20000);
        requestManager.canvasVPVDashboardRefreshCycleOldTimestamp(2);
    }

    @Test
    public void checkNewCreds1(){
        RequestManager requestManager = new RequestManager();
        requestManager.getChart(10000,1);
    }

    @Test
    public void checkNewCreds2(){
        RequestManager requestManager = new RequestManager();
        requestManager.getChart(10000,1);
    }

    @Test
    public void checkNewCreds3(){
        RequestManager requestManager = new RequestManager();
        requestManager.getChart(10000,1);
    }

    @Test
    public void checkNewCreds4(){
        RequestManager requestManager = new RequestManager();
        requestManager.getChart(10000,1);
    }

    @Test
    public void checkNewCreds5(){
        RequestManager requestManager = new RequestManager();
        requestManager.getChart(10000,1);
    }

    @Test
    public void checkNewCreds6(){
        RequestManager requestManager = new RequestManager();
        requestManager.getChart(10000,1);
    }

    @Test
    public void checkNewCreds7(){
        RequestManager requestManager = new RequestManager();
        requestManager.getChart(10000,1);
    }

    @Test
    public void checkNewCreds8(){
        RequestManager requestManager = new RequestManager();
        requestManager.getChart(10000,1);
    }

    @Test
    public void checkNewCreds9(){
        RequestManager requestManager = new RequestManager();
        requestManager.getChart(10000,1);
    }

    @Test
    public void checkNewCreds10(){
        RequestManager requestManager = new RequestManager();
        requestManager.getChart(10000,1);
    }

}
