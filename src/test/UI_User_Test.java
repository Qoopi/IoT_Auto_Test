import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjets.Dashboard;
import pageObjets.LogInPage;
import pageObjets.UserList;
import utils.TestListener;


@Listeners(TestListener.class)
public class UI_User_Test {


    @Test
    public void Login() {
        LogInPage login = new LogInPage();
        login.autoriseWithGoogle();
    }

    @Test(priority = 1)
    public void openUserList() {
        Dashboard dashboard = new Dashboard();
        dashboard.openAdministration();
        UserList userList = new UserList();
        userList.openUserList();
    }
    @Test(priority =2 )
    public  void checkOutColumns(){
        UserList userList = new UserList();
        userList.openMenu();
        userList.userNameColumCheck();
        userList.emailColumCheck();
        userList.activeColumCheck();
        userList.adminGroupColumCheck();
        userList.serviceColumCheck();
        userList.updatedAtColumCheck();
        userList.regTimeColumCheck();
        userList.openUserList();
    }

    @Test(priority = 2)
    public void addColumnService() {
        UserList userList = new UserList();
        userList.openMenu();
        userList.addServices();
    }
    @Test(priority = 3)
    public void addColumnUpdatedAt(){
        UserList userList = new UserList();
        userList.openMenu();
        userList.addUpdatedAt();;
    }
    @Test(priority = 4)
    public void addColumnRegTime(){
        UserList userList = new UserList();
        userList.openMenu();
        userList.addRegTime();
    }
    @Test(dependsOnMethods = "addColumnRegTime")
    public void dismissAddedColumns (){
        UserList userList = new UserList();
        userList.openMenu();
        userList.dismissService();

        userList.openMenu();
        userList.dismissUpdatedAt();

        userList.openMenu();
        userList.dismissRegTime();
    }
}



