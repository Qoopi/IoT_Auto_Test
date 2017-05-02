package load;

import load.utils.GatlingReportAdapter;
import load.utils.ListenerLoad;
import load.utils.RequestManagerLoad;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenerLoad.class)
public class StressNotificationRulesCRUD {
    private final int threads = 500;//required 100-200-300-400-500-600-700-800-900-1000
    private final int timeOfTestRunMins = 1;//required 3 for each quantity of users

    @Test(threadPoolSize = threads, invocationCount = threads)
    public void notificationRulesCRUD(){
        GatlingReportAdapter gatling = new GatlingReportAdapter();
        gatling.gatlingInfoPrintUserStart();
        RequestManagerLoad requestManagerLoad = new RequestManagerLoad();
        requestManagerLoad.notificationRuleCRUD(timeOfTestRunMins);
    }
}
