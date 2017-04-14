package load.unused;

import load.utils.LoadListener;
import load.utils.RequestManager;
import load.utils.ThreadLaunchDelayer;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



@Listeners(LoadListener.class)
public class EmulateCRUD {
    private final int threads = 10;
    private final int newThreadLaunchDelayMs = 500;

    @Test(threadPoolSize = threads, invocationCount = threads)
    public void notificationRulesCRUD(){
        ThreadLaunchDelayer.delay(newThreadLaunchDelayMs);
        RequestManager requestManager = new RequestManager();
        requestManager.notificationRuleCRUD(1, 10000, 10000);
    }


}
