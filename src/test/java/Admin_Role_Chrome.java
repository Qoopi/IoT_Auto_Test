import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ui.pageObjets.LogInPage;
import ui.pageObjets.administration.Requests;
import ui.pageObjets.administration.UserList;
import ui.pageObjets.dashboard.Dashboard;
import ui.pageObjets.dashboard.Equipment;
import ui.pageObjets.dashboard.Notifications;
import ui.utils.TestListener;


@Listeners(TestListener.class)
public class Admin_Role_Chrome {
    @BeforeTest
    public void LogIn() {
        LogInPage log = new LogInPage();
        log.getToIoTPage();
        log.enterGoogleCred();
    }

    @Features("Admin role testing of functionality")
    @Stories("OSF-53 Equipment view")
    @Test
    public void EquipmentCheck() {
        Dashboard dashboard = new Dashboard();
        dashboard.openEquipment();

        Equipment equipment = new Equipment();
        equipment.sortEquipByName();
        equipment.sortEquipById();
        equipment.sortEquipByType();
        equipment.sortEquipByGroup();
        equipment.sortEquipByUpdatedAt();
    }

    @Features("Admin role testing of functionality")
    @Stories("OSF-53 Equipment list view")
    @Test
    public void checkEquipmentList() {

        Dashboard dashboard = new Dashboard();
        dashboard.openAdministration();
        dashboard.openEquipmentListAsAdmin();

        Equipment equip = new Equipment();
        equip.sortEquipByName();
        equip.sortEquipById();
        equip.sortEquipByType();
        equip.sortEquipByGroup();
        equip.sortEquipByActive();

    }

    @Features("Admin role testing of functionality")
    @Stories("Notifications lists view, default columns ")
    @Test
    public void NotificationsListDefaultColumns() {
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

    @Features("Admin role testing of functionality")
    @Stories("OSF-200 User List")
    @Test(priority = 1)
    public void openUserList() {
        Dashboard dashboard = new Dashboard();
        dashboard.openAdministration();
        dashboard.openUserList();

    }

    @Features("Admin role testing of functionality")
    @Stories("OSF-200 User List")
    @Test
    public void checkDefaultColumns() {
        UserList userList = new UserList();
        userList.defaultColumnsCheck();
        userList.openMenu();
        userList.checkingColumnsInPompUpMenu();
    }

    @Features("Admin role testing of functionality")
    @Stories("OSF-200 User List")
    @Test
    public void addColumnsFromMenu() {
        UserList userList = new UserList();

        userList.addServices();

        userList.openMenu();
        userList.addUpdatedAt();

        userList.openMenu();
        userList.addRegTime();

    }

    @Features("Admin role testing of functionality")
    @Stories("OSF-200 User List")
    @Test
    public void markDeactivateSomeUser() {
        UserList userList = new UserList();
        userList.markSeveralUser();
        userList.deactivateUsersWithHover();
        userList.activateUserWithColumn();

    }

    @Features("Admin role testing of functionality")
    @Stories("OSF-199 Request, accept request")
    @Test
    public void openRequests() {

        Dashboard dashboards = new Dashboard();
        dashboards.openAdministration();
        dashboards.openRequests();

        Requests requests = new Requests();
        requests.checkRequest();
        requests.acceptUser();
    }
    @Features("Admin role testing of functionality")
    @Stories("OSF-403 Delete User")
    @Test
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