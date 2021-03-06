package tests.load.unused;

import mechanics.load.utils.ListenerLoad;
import mechanics.load.utils.RequestManagerLoad;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by user on 04.04.2017.
 */
@Listeners(ListenerLoad.class)
public class CredsForGatling {
    private final int testOperationTimeMins = 20;

    @Test
    public void checkNewCreds(){
        RequestManagerLoad requestManagerLoad = new RequestManagerLoad();
        requestManagerLoad.checkExpiredCredentials(testOperationTimeMins);
    }
}
