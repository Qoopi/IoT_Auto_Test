package load;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ui.pageObjets.LogInPage;
import ui.utils.TestListener;

@Listeners(TestListener.class)
public class PageBootSpeed {

    @Test
    public void loadingDashboard(){
        LogInPage log = new LogInPage();
        log.getToIoTPage();
        log.enterGoogleCred();

    }
}
