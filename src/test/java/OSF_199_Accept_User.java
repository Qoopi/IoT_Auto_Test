import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ui.pageObjets.dashboard.Dashboard;
import ui.pageObjets.LogInPage;
import ui.pageObjets.administration.Requests;
import ui.utils.TestListener;

@Listeners(TestListener.class)
public class OSF_199_Accept_User {

    @Features("Accept user request")
    @Stories("User")
    @Test(priority = 1)
    public void LogInWithAdminAcc() {

        LogInPage log = new LogInPage();
        log.getToIoTPage();
        log.enterGoogleCred();
    }

    @Features("Accept user request")
    @Stories("User")
    @Test(priority = 2)
    public void openRequests() {

        Dashboard dashboards = new Dashboard();
        dashboards.openAdministration();
        dashboards.openRequests();

        Requests requests = new Requests();
        requests.checkRequest();
        requests.acceptUser();
    }
}