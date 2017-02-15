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

    @Features("Admin role testing of functionality ")
    @Stories("OSF-53 Equipment view")
    @Test(priority = 1)
    public void EquipmentCheck() {
        Dashboard dashboard = new Dashboard();
        dashboard.openEquipment();

        Equipment equipment = new Equipment();
        equipment.sortEquipByName();
        equipment.sortEquipById();
        equipment.sortEquipByType();
        equipment.sortEquipByGroup();
        equipment.sortEquipByUpdatedAt();

        equipment.viewEquip();
        equipment.checkEquipment();

    }
    @Features("Admin role testing of functionality ")
    @Stories("Equipment upper right menu columns check")
    @Test(priority = 2)
    public void checkUpperRightMenuInEquipment(){
        Dashboard dashboard = new Dashboard();
        dashboard.openMenu();
        Equipment equipment = new Equipment();
        equipment.checkEquipmentNameInMenu();
        equipment.checkEquipmentTypeInMenu();
        equipment.checkEquipmentIdInMenu();
        equipment.checkEquipmentGroupInMenu();
        equipment.checkEquipmentUpdatedAtInMenu();
        equipment.checkEquipmentCreatedInMenu();


    }
    @Features("Admin role testing of functionality")
    @Stories("Equipment view add column Created ")
    @Test(priority = 3)
    public void EquipmentAddColumn() {
        Equipment equipment = new Equipment();
        equipment.addCreatedColumn();

        LogInPage log = new LogInPage();
        log.refresh();
        Dashboard dashboard = new Dashboard();
        dashboard.openMenu();
        equipment.dismissCreated();
    }

    @Features("Admin role testing of functionality")
    @Stories("OSF-53 Equipment list view")
    @Test(priority = 4)
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
        equip.sortEquipByUpdatedAt();

        equip.editEquip();
        equip.checkEquipEdition();
    }

    @Features("Admin role testing of functionality ")
    @Stories("Equipment upper right menu columns check")
    @Test(priority = 5)
    public void checkUpperRightMenuInEquipmentList() {
        Dashboard dashboard = new Dashboard();
        dashboard.openMenu();
        Equipment equipment = new Equipment();
        equipment.checkEquipmentNameInMenu();
        equipment.checkEquipmentTypeInMenu();
        equipment.checkEquipmentIdInMenu();
        equipment.checkEquipmentGroupInMenu();
        equipment.checkEquipmentActiveInMenu();
        equipment.checkEquipmentUpdatedAtInMenu();
        equipment.checkEquipmentCreatedInMenu();
    }
    @Features("Admin role testing of functionality")
    @Stories("Equipment view add column Created ")
    @Test(priority = 6)
    public void EquipmentListAddColumn() {
        Dashboard dashboard = new Dashboard();
        Equipment equip = new Equipment();
        equip.addCreatedColumn();

        dashboard.openMenu();
        equip.dismissCreated();
    }
    @Features("Admin role testing of functionality")
    @Stories("Notifications lists view, default columns ")
    @Test(priority = 5)
    public void NotificationsListDefaultColumns() {
        Dashboard dashboard = new Dashboard();
        dashboard.openNotifications();
        dashboard.openNotificationsList();

        Notifications not = new Notifications();
        not.checkNameColumn();
        not.checkMessageColumn();
        not.checkAcknowledgeColumn();
        not.checkTimeTriggeredColumn();

    }

    @Features("Admin role testing of functionality")
    @Stories("Notifications lists view, columns in upper right menu")
    @Test(priority = 6)
    public void NotificationsListRightMenu() {
        Dashboard dash = new Dashboard();
        dash.openMenu();
        Notifications not = new Notifications();
        not.checkLeftMenuNameColumns();
        not.checkLeftMenuMessageColumns();
        not.checkLeftMenuAcknowledgeColumns();
        not.checkLeftMenuTimeTriggeredColumns();
    }



    @Features("Admin role testing of functionality")
    @Stories("OSF-200 User List")
    @Test(priority = 7)
    public void openUserList() {
        Dashboard dashboard = new Dashboard();
        dashboard.openAdministration();
        dashboard.openUserList();

    }

    @Features("Admin role testing of functionality")
    @Stories("OSF-200 User List")
    @Test(priority = 8)
    public void checkDefaultColumnsOfUserList() {
        UserList userList = new UserList();
        userList.defaultColumnsCheck();
        Dashboard dashboard = new Dashboard();
        dashboard.openMenu();
        userList.checkingColumnsInPompUpMenu();
    }

    @Features("Admin role testing of functionality")
    @Stories("OSF-200 User List")
    @Test(priority = 9)
    public void addColumnsToUserList() {
        UserList userList = new UserList();

        userList.addServices();

        Dashboard dashboard = new Dashboard();
        dashboard.openMenu();
        userList.addUpdatedAt();

        dashboard.openMenu();
        userList.addRegTime();

    }
    @Features("Admin role testing of functionality")
    @Stories("OSF-200 User List")
    @Test(priority = 10)
    public void deleteColumnsFromUserList(){

        LogInPage log = new LogInPage();
        log.refresh();

        Dashboard dashboard = new Dashboard();
        dashboard.openMenu();
        UserList userList = new UserList();
        userList.dismissRegTime();


        //log.refresh();
        dashboard.openMenu();
        userList.dismissUpdatedAt();

        //log.refresh();
        dashboard.openMenu();
        userList.dismissService();
    }
    @Features("Admin role testing of functionality")
    @Stories("OSF-200 User List")
    @Test(priority = 11)
    public void markToDeactivateSomeUser() {
        UserList userList = new UserList();
        userList.markSeveralUser();
        userList.deactivateUsersWithHover();
        userList.activateUserWithColumn();
    }

    @Features("Admin role testing of functionality")
    @Stories("OSF-199 Request, accept request")
    @Test(priority = 12)
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
    @Test(priority = 13)
    public void deleteUser(){
        Dashboard dashboard = new Dashboard();
        dashboard.openUserList();
        dashboard.openMenu();

        UserList user = new UserList();
        user.addUpdatedAt();
        user.foundUserToDelete();
        user.deleteChosenUser();
    }
}