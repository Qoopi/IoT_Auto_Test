package load;

import load.utils.GatlingReportAdapter;
import load.utils.LoadListener;
import load.utils.RequestManager;
import load.utils.ThreadLaunchDelayer;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by user on 05.04.2017.
 */
@Listeners(LoadListener.class)
public class LoadNotificationRulesCRUD {
    private final int threads = 5;//required 100
    private final int newThreadLaunchDelayMs = 5000;//required 5000
    private final int pauseBetweenRequestsMs = 10000;//required 10000
    private final int pauseBetweenCyclesMs = 10000;//required 10000
    private final int timeOfTestRunMins = 1;//required 30

    @Test(threadPoolSize = threads, invocationCount = threads)
    public void notificationRulesCRUD(){
        ThreadLaunchDelayer.delay(newThreadLaunchDelayMs);
        GatlingReportAdapter gatling = new GatlingReportAdapter();
        gatling.gatlingInfoPrintUserStart();
        RequestManager requestManager = new RequestManager();
        requestManager.notificationRuleCRUD(timeOfTestRunMins, pauseBetweenRequestsMs, pauseBetweenCyclesMs);
    }
}
