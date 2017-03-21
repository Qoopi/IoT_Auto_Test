package load;

import api.utils.RequestManager;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ui.pageObjets.LogInPage;
import ui.utils.TestListener;

@Listeners(TestListener.class)
public class PageBootSpeed {

    @BeforeTest
    public void getCreds(){
        LogInPage log = new LogInPage();
        log.getToIoTPage();
        log.enterGoogleCred();
        log.getRequestSigns();
        RequestManager requestManager = new RequestManager();
        requestManager.writeCredsTofile();

    }

    @Test
    public void checkNewCreds(){
        SignAWSv4 signAWSv4 = new SignAWSv4();
        RequestManager requestManager = new RequestManager();
        requestManager.setUpBaseApiGateway();
        requestManager.checkExpiredCredentials();
    }
}
