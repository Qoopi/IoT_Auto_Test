import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjets.Dashboard;
import pageObjets.LogInPage;
import utils.TestListener;


@Listeners(TestListener.class)
public class UI_User_Test {


    @Test
    public void Login() {
        LogInPage login = new LogInPage();
        login.autoriseWithGoogle();
    }

    @Test(priority = 1)
    public void checkOutUserList() {
        Dashboard dashboard = new Dashboard();
        dashboard.openAdministration();
        dashboard.openUserList();
    }

    @Test(priority = 2)
    public void checkOutService() {
        Dashboard dashboard = new Dashboard();
        dashboard.openMenu();
        dashboard.addServices();
        dashboard.openMenu();
        dashboard.dismissService();
    }
    @Test(priority = 3)
    public void checkOutUpdatedAt(){
         Dashboard dashboard = new Dashboard();
         dashboard.openMenu();
         dashboard.addUpdatedAt();
         dashboard.openMenu();
         dashboard.dismissUpdatedAt();
}
    @Test(priority = 4)
    public void checkOutRegTime(){
        Dashboard dashboard = new Dashboard();
        dashboard.openMenu();
        dashboard.addRegTime();
        dashboard.openMenu();
        dashboard.dismissRegTime();

}
}



