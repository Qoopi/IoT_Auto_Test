import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ui.pageObjets.dashboard.Dashboard;
import ui.pageObjets.LogInPage;
import ui.pageObjets.dashboard.Notifications;
import ui.utils.TestListener;


@Listeners(TestListener.class)
public class OSF_200 {

    @Features("User List TestingUser")
    @Stories("User")
    @Test
    public void Login() {
        LogInPage login = new LogInPage();
        login.getToIoTPage();
        login.enterGoogleCred();
    }
    @Features("Admin role testing of functionality")
    @Stories("Notifications lists view, default columns ")
    @Test
    public void NotificationsListDefaultColumns(){
        Dashboard dashboard = new Dashboard();
        dashboard.openNotifications();
        dashboard.openNotificationsList();

        Notifications not = new Notifications();
        not.checkNameColumn();
        not.checkMessageColumn();
        not.checkAcknowledgeColumns();
        not.checkTimeTriggeredColumns();

    }
    @Features("Admin role testing of functionality")
    @Stories("Notifications lists view, columns in upper right menu")
    @Test
    public void NotificationsListRightMenu() {
        Notifications not = new Notifications();
        not.openMenu();
        not.checkLeftMenuNameColumns();
        not.checkLeftMenuMessageColumns();
        not.checkLeftMenuAcknowledgeColumns();
        not.checkLeftMenuTimeTriggeredColumns();
    }
}



