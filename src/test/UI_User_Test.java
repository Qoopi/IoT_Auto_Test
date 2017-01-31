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
    public  void checkDefaultColumns(){
         UserList userList = new UserList();
         userList.defaultColumnsCheck();
    }

    @Test(priority = 3)
    public void addColumnService() {
        UserList userList = new UserList();
        userList.openMenu();
//        userList.userNameColumnCheck();
//        userList.emailColumnCheck();
//        userList.activeColumnCheck();
//        userList.adminGroupColumnCheck();
//        userList.serviceColumnCheck();
//        userList.updatedAtColumnCheck();
//        userList.regTimeColumnCheck();
        userList.addServices();
    }
    @Test(priority = 4)
    public void addColumnUpdatedAt(){
        UserList userList = new UserList();
        userList.openMenu();
        userList.addUpdatedAt();;
    }
    @Test(priority = 5)
    public void addColumnRegTime(){
        UserList userList = new UserList();
        userList.openMenu();
        userList.addRegTime();
    }
    @Test(priority = 6)
    public void markUser(){
        UserList userList = new UserList();
        userList.markUser();
        userList.deactivateSeveralUsers();
    }
    @Test(dependsOnMethods = "addColumnRegTime")
    public void dismissAddedColumns (){
        UserList userList = new UserList();
        userList.openMenu();
        userList.dismissRegTime();

        userList.openMenu();
        userList.dismissUpdatedAt();

        userList.openMenu();
        userList.dismissService();
    }
}



