package load.unused;

import load.utils.ListenerLoad;
import load.utils.RequestManagerLoad;
import load.utils.ThreadLaunchDelayer;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



@Listeners(ListenerLoad.class)
public class EmulateCRUD {
    private final int threads = 10;
    private final int newThreadLaunchDelayMs = 500;

    @Test(threadPoolSize = threads, invocationCount = threads)
    public void notificationRulesCRUD(){
        ThreadLaunchDelayer.delay(newThreadLaunchDelayMs);
        RequestManagerLoad requestManagerLoad = new RequestManagerLoad();
        requestManagerLoad.notificationRuleCRUD(1, 10000, 10000);
    }


}
