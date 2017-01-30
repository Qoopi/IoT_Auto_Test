import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjets.Dashboard;
import pageObjets.LogInPage;
import utils.TestListener;


@Listeners(TestListener.class)
public class UI_User_Test {


@Test
public void Login(){
    LogInPage  login = new LogInPage();
    login.autoriseWithGoogle();
    }
@Test
    public void getToUserList(){
    Dashboard dashboard = new Dashboard();
    dashboard.openAdministration();
    dashboard.openUserList();
    //dashboard.checkOutFilters();
    dashboard.addOrDIsmissUpdatedAt();
    dashboard.addOrDissmissServices();
}
}


