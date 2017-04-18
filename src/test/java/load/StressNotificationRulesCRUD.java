package load;

import load.utils.GatlingReportAdapter;
import load.utils.LoadListener;
import load.utils.RequestManager;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(LoadListener.class)
public class StressNotificationRulesCRUD {
    private final int threads = 500;//required 100-200-300-400-500-600-700-800-900-1000
    private final int timeOfTestRunMins = 1;//required 3 for each quantity of users

    @Test(threadPoolSize = threads, invocationCount = threads)
    public void notificationRulesCRUD(){
        GatlingReportAdapter.gatlingInfoPrintUserStart();
        RequestManager requestManager = new RequestManager();
        requestManager.notificationRuleCRUD(timeOfTestRunMins);
    }
}
