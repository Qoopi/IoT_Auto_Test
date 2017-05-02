package load;

import load.utils.GatlingReportAdapter;
import load.utils.ListenerLoad;
import load.utils.RequestManagerLoad;
import load.utils.ThreadLaunchDelayer;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by user on 05.04.2017.
 */
@Listeners(ListenerLoad.class)
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
        RequestManagerLoad requestManagerLoad = new RequestManagerLoad();
        requestManagerLoad.notificationRuleCRUD(timeOfTestRunMins, pauseBetweenRequestsMs, pauseBetweenCyclesMs);
    }
}
