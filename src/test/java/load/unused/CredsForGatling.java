package load.unused;

import load.LoadListener;
import load.RequestManager;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by user on 04.04.2017.
 */
@Listeners(LoadListener.class)
public class CredsForGatling {
    private final int testOperationTimeMins = 20;

    @Test
    public void checkNewCreds(){
        RequestManager requestManager = new RequestManager();
        requestManager.checkExpiredCredentials(testOperationTimeMins);
    }
}
