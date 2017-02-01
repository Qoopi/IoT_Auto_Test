import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjets.Dashboard;
import pageObjets.LogInPage;
import utils.TestListener;


@Listeners(TestListener.class)

public class UserList {

    @Test
    public void LogInWithGoogle() {
        LogInPage log = new LogInPage();
        log.autoriseWithGoogle();
    }

    @Test(priority = 1)
    public void openUserList() {
        Dashboard dash = new Dashboard();
        dash.openAdministration();
        UserList user = new UserList();
        user.openUserList();
    }

    @Test(priority = 2)
    public void checkDefaultColumns() {

    }
}