package load;

import org.apache.commons.io.output.TeeOutputStream;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by alex00x6 on 28.03.2017.
 */

@Listeners(LoadListener.class)
public class EmulateChartsRefreshing {
    private final int threadsDistantRequest = 2;
    private final int threadsActualRequest = 8;
    private final int testOperationTimeMins = 1;

    FileOutputStream fos = null;
    @BeforeClass
    public void before(){
        try {
            fos = new FileOutputStream("loadReports/simulation.log");
            TeeOutputStream myOut = new TeeOutputStream(System.out, fos);
            PrintStream ps = new PrintStream(myOut);
            System.setOut(ps);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String name = "RecordedSimulation1";
        String nameof = "recordedsimulation1";
        System.out.println("RUN\t"+name+"\ts\t"+nameof+"\t"+System.currentTimeMillis()+"\ts\t2.0");
    }

    @AfterClass
    public void after(){
        try {
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkNewCreds(){
        RequestManager requestManager = new RequestManager();
        requestManager.checkExpiredCredentials(50, 1000);
    }

    @Test(threadPoolSize = threadsDistantRequest, invocationCount = threadsDistantRequest)
    public void refreshVPVDashboardLong(){
        RequestManager requestManager = new RequestManager();
        requestManager.canvasDashboardRefreshCycleOldTimestamp(testOperationTimeMins);
    }

    @Test(threadPoolSize = threadsActualRequest, invocationCount = threadsActualRequest)
    public void refreshVPVDashboardShort(){
        RequestManager requestManager = new RequestManager();
        requestManager.canvasDashboardRefreshCycleProperTimestamp(testOperationTimeMins);
    }

    @Test(threadPoolSize = threadsDistantRequest, invocationCount = threadsDistantRequest)
    public void refreshGPVDashboardLong(){
        RequestManager requestManager = new RequestManager();
        requestManager.canvasGPVDashboardRefreshCycleOldTimestamp(testOperationTimeMins);
    }

    @Test(threadPoolSize = threadsActualRequest, invocationCount = threadsActualRequest)
    public void refreshGPVDashboardShort(){
        RequestManager requestManager = new RequestManager();
        requestManager.canvasGPVDashboardRefreshCycleProperTimestamp(testOperationTimeMins);
    }

}
