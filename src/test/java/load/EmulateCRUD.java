package load;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by alex00x on 30.03.2017.
 */

@Listeners(LoadListener.class)
public class EmulateCRUD {
    private final int threads = 10;

    @Test(threadPoolSize = threads, invocationCount = threads)
    public void notificationRulesCRUD(){
        RequestManager requestManager = new RequestManager();
        requestManager.notificationRuleCRUD(1, 2500, 5000);
    }


}
