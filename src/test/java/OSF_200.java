import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ui.pageObjets.Dashboard;
import ui.pageObjets.LogInPage;
import ui.pageObjets.UserList;
import ui.utils.TestListener;


@Listeners(TestListener.class)
public class OSF_200 {
    @Features("User List Testing")
    @Stories("User")
    @Test
    public void Login() {
        LogInPage login = new LogInPage();
        login.getToIoTPage();
        login.enterGoogleCred();
    }
    @Features("User List Testing")
    @Stories("User")
    @Test(priority = 1)
    public void openUserList() {
        Dashboard dashboard = new Dashboard();
        dashboard.openAdministration();
        dashboard.openUserList();

    }
    @Features("User List Testing")
    @Stories("User")
    @Test(priority = 2)
    public void checkDefaultColumns() {
        UserList userList = new UserList();
        userList.defaultColumnsCheck();
        userList.openMenu();
        userList.checkingColumnsInPompUpMenu();
    }

    @Features("User List Testing")
    @Stories("User")
    @Test(priority = 3)
    public void addServiceUpdateAtREgTIme() {
        UserList userList = new UserList();

        userList.addServices();

        userList.openMenu();
        userList.addUpdatedAt();

        userList.openMenu();
        userList.addRegTime();
    }
    @Features("User List Testing")
    @Stories("User")
    @Test(priority = 4)
    public void markDeactivateSomeUser() {
        UserList userList = new UserList();
        userList.markSeveralUser();
        userList.deactivateUsersWithHover();
        userList.activateUserWithColumn();

    }
}



