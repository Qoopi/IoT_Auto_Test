import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ui.pageObjets.dashboard.Dashboard;
import ui.pageObjets.LogInPage;
import ui.pageObjets.administration.UserList;
import ui.utils.TestListener;


@Listeners(TestListener.class)

public class OSF_403 {

    @BeforeTest
    public void LogInWithAdminAcc() {
        LogInPage log = new LogInPage();
        log.getToIoTPage();
        log.enterGoogleCred();
    }

    @Features("User Requests testing")
    @Stories("User")
    @Test
    public void openRequests() {
        Dashboard dashboards = new Dashboard();
        dashboards.openAdministration();
        dashboards.openRequests();
    }

    @Features("User Requests testing")
    @Stories("User")
        @Test(priority = 1)
    public void deleteUser(){
        Dashboard dashboard = new Dashboard();
        dashboard.openUserList();

        UserList user = new UserList();
        user.openMenu();
        user.addUpdatedAt();
        user.foundUserToDelete();
        user.deleteChosenUser();
    }

}