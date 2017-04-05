package load;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by user on 05.04.2017.
 */
@Listeners(LoadListener.class)
public class StressNotificationRulesCRUD {
    private final int threads = 100;//required 100-200-300-400-500-600-700-800-900-1000
    private final int timeOfTestRunMins = 1;//required 3 for each quantity of users

    @Test(threadPoolSize = threads, invocationCount = threads)
    public void notificationRulesCRUD(){
        gatlingInfoPrintUserStart();
        RequestManager requestManager = new RequestManager();
        requestManager.notificationRuleCRUDStress(timeOfTestRunMins);
    }

    private void gatlingInfoPrintUserStart(){
        String name = "RecordedSimulation1";
        long thread = Thread.currentThread().getId();
        long timeStart = System.currentTimeMillis();
        System.out.println("USER\t"+name+"\t"+thread+"\tSTART\t"+timeStart+"\t"+timeStart);
    }
}
