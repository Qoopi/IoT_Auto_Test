package tests.load.unused;

import mechanics.load.utils.ListenerLoad;
import mechanics.load.utils.RequestManagerLoad;
import mechanics.load.utils.ThreadLaunchDelayer;
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
