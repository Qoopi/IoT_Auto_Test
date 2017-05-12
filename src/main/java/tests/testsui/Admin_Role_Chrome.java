package tests.testsui;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ui.pageObjets.DDMenus;
import ui.pageObjets.DDMenusChrome;
import ui.pageObjets.LogInPage;
import ui.pageObjets.administration.Requests;
import ui.pageObjets.administration.UserList;
import ui.pageObjets.dashboard.Dasboards.Dashboard;
import ui.pageObjets.dashboard.Equipments.Equipment;
import ui.pageObjets.dashboard.Notifications.Notifications;
import ui.pageObjets.dashboard.Reports;
import ui.utils.ListenerUi;


@Listeners(ListenerUi.class)
public class Admin_Role_Chrome {

    @BeforeTest
    public void LogIn() {
        LogInPage log = new LogInPage();
        log.getToIoTPage();
        log.enterGoogleCred();
    }
    @Features("Regression")
    @Stories("[OSF-53] Equipment, what element is active in DDMenu")
    @Test(priority = 1)
    public void checkWhatIsActiveInDDMenuEquipment(){
        Dashboard dashboard = new Dashboard();
        dashboard.openEquipment();
        dashboard.openMenu();
        DDMenus ddm = new DDMenusChrome();
        ddm.checkMenuEquipment();
        dashboard.closeMenu();
    }
    @Features("Regression")
    @Stories("[OSF-53] Equipment view")
    @Test(priority = 2)
    public void EquipmentCheck() {
        Dashboard dashboard = new Dashboard();
        Equipment equipment = new Equipment();

        dashboard.openEquipment();
        equipment.sortEquipByName();
        equipment.sortEquipById();
        equipment.sortEquipByType();
        equipment.sortEquipByGroup();
        equipment.sortEquipByUpdatedAt();

    }

    @Features("Regression")
    @Stories("[OSF-53] Equipment, columns menu check")
    @Test(priority = 3)
    public void checkUpperRightMenuInEquipment() {
        Dashboard dashboard = new Dashboard();
        Equipment equipment = new Equipment();

        dashboard.openMenu();
        equipment.checkEquipmentNameInMenu();
        equipment.checkEquipmentTypeInMenu();
        equipment.checkEquipmentIdInMenu();
        equipment.checkEquipmentGroupInMenu();
        equipment.checkEquipmentUpdatedAtInMenu();
        equipment.checkEquipmentCreatedInMenu();
        dashboard.closeMenu();

    }

    @Features("Admin role testing of functionality")
    @Stories("[OSF-53] Equipment, add column Created ")
    @Test(priority = 4)
    public void EquipmentAddColumn() {
        Dashboard dashboard = new Dashboard();
        Equipment equipment = new Equipment();
        LogInPage log = new LogInPage();

        dashboard.openMenu();
        equipment.addCreatedColumn();
        log.refresh();
        dashboard.openMenu();
        equipment.dismissCreated();
    }

    @Features("Regression")
    @Stories("[OSF-53] Equipment view detail info")
    @Test(priority = 5)
    public void viewEquipInfo() {
        Equipment equipment = new Equipment();
        equipment.viewEquip();
        equipment.checkEquipment();

    }

    @Features("Regression")
    @Stories("[OSF-53] Notification Lit, what element is active in DDMenu")
    @Test(priority = 6)
    public void checkWhatIsActiveInDDMenuNotificationsList(){
        Dashboard dashboard = new Dashboard();
        dashboard.openNotifications();
        dashboard.openNotificationsList();
        dashboard.openMenu();
        DDMenus ddm = new DDMenusChrome();
        ddm.checkMenuNotificationList();
        dashboard.closeMenu();
    }
    @Features("Regression")
    @Stories("Notifications list default columns check")
    @Test(priority = 7)
    public void notificationsListDefaultColumns() {

        Notifications not = new Notifications();
        not.checkNameColumn();
        not.checkMessageColumn();
        not.checkAcknowledgeColumn();
        not.checkTimeTriggeredColumn();
    }

    @Features("Regression")
    @Stories("Notifications lists, dropdown menu check")
    @Test(priority = 8)
    public void NotificationsListRightMenu() {
        Dashboard dash = new Dashboard();
        Notifications not = new Notifications();

        dash.openMenu();
        not.checkLeftMenuNameColumns();
        not.checkLeftMenuMessageColumns();
        not.checkLeftMenuAcknowledgeColumns();
        not.checkLeftMenuTimeTriggeredColumns();
    }

    @Features("Regression")
    @Stories("[OSF-53] Reports, what element is active in DDMenu")
    @Test(priority = 9)
    public void checkWhatIsActiveInDDMenuReport(){
        Dashboard dashboard = new Dashboard();
        dashboard.openReports();
        dashboard.openMenu();
        DDMenus ddm = new DDMenusChrome();
        ddm.checkMenuReports();
        dashboard.closeMenu();
    }
    @Features("Regression")
    @Stories("Report list default columns testing")
    @Test(priority = 10)
    public void CheckOutReportsDefaultColumns() {
        Dashboard dash = new Dashboard();
        Reports reports = new Reports();

        dash.openReports();
        reports.checkReportTitleColumn();
        reports.checkReportScheduleColumn();
    }

    @Features("Regression")
    @Stories("Report list additions columns in dropdown menu check")
    @Test(priority = 11)
    public void CheckAdditionalColumns() {
        Dashboard dash = new Dashboard();
        Reports reports = new Reports();

        dash.openMenu();
        reports.checkReportTitleColumnInDropDownMenu();
        reports.checkReportScheduleColumnInDropDownMenu();
        reports.checkRecipientsColumnInDropDownMenu();
        reports.checkExcelIncludedColumnInDropDownMenu();
        reports.checkEquipmentItemsColumnInDropDownMenu();
        dash.closeMenu();
    }

    @Features("Regression")
    @Stories("Report list add additional columns testing")
    @Test(priority = 12)
    public void AddColumnsInReports() {
        Reports reports = new Reports();
        Dashboard dashboard = new Dashboard();

        dashboard.openMenu();
        reports.addEquipmentItemColumn();
        reports.checkAddedEquipItem();
        dashboard.openMenu();
        reports.addRecipients();
        reports.checkAddedRecipients();
        dashboard.openMenu();
        reports.addExcelIncluded();
        reports.checkAddedExcelIncluded();
    }

    @Features("Regression")
    @Stories("Report list dismiss additional columns ")
    @Test(priority = 13)
    public void DismissColumnsInReports() {
        Reports reports = new Reports();
        Dashboard dashboard = new Dashboard();

        dashboard.openMenu();
        reports.dismissEquipmentItem();
        dashboard.openMenu();
        reports.dismissRecipients();
        dashboard.openMenu();
        reports.dismissExcelIncluded();
    }

    @Features("Regression")
    @Stories("OSF-200 User List, what element is active in DDMenu")
    @Test(priority = 14)
    public void openUserListActiveColumns() {
        Dashboard dashboard = new Dashboard();
        dashboard.openAdministration();
        dashboard.openUserList();
        dashboard.openMenu();
        DDMenus ddm = new DDMenusChrome();
        ddm.checkMenuAdministrationUserList();
        dashboard.closeMenu();
    }

    @Features("Regression")
    @Stories("OSF-200 User List")
    @Test(priority = 15)
    public void checkDefaultColumnsOfUserList() {
        UserList userList = new UserList();
        Dashboard dashboard = new Dashboard();

        dashboard.openMenu();
        userList.checkingColumnsInPompUpMenu();
        userList.defaultColumnsCheck();
        dashboard.closeMenu();
    }

    @Features("Regression")
    @Stories("OSF-200 User List")
    @Test(priority = 16)
    public void addColumnsToUserList() {
        UserList userList = new UserList();
        Dashboard dashboard = new Dashboard();

        dashboard.openMenu();
        userList.clickMenuService();
        userList.checkServiceColumn();

        dashboard.openMenu();
        userList.clickMenuUpdated();
        userList.checkUpdatedColumn();

        dashboard.openMenu();
        userList.clickMenuRegTime();
        userList.checkColumnRegTime();

    }

    @Features("Regression")
    @Stories("OSF-200 User List")
    @Test(priority = 17)
    public void deleteColumnsFromUserList() {
        LogInPage log = new LogInPage();
        Dashboard dashboard = new Dashboard();
        UserList userList = new UserList();

        log.refresh();//is it necessary?

        dashboard.openMenu();
        userList.clickMenuRegTime();
        dashboard.openMenu();
        userList.clickMenuUpdated();
        dashboard.openMenu();
        userList.clickMenuService();
    }

    @Features("Regression")
    @Stories("OSF-200 User List")
    @Test(priority = 18)
    public void markToDeactivateSomeUser() {
        UserList userList = new UserList();
        userList.markSeveralUser();
        userList.deactivateUsersWithHover();
        userList.activateUserWithColumn();
    }

    @Features("Regression")
    @Stories("OSF-199 Request, accept request")
    //@Test(priority = 19)
    public void openRequests() {
        Dashboard dashboards = new Dashboard();
        Requests requests = new Requests();

        dashboards.openAdministration();
        dashboards.openRequests();
        requests.checkRequest(); //как, если нет реквеста
        requests.acceptUser(); //падает на этом шаге хотя и чекнуть не должно было
    }

    @Features("Regression")
    @Stories("OSF-403 Delete User")
    //@Test(priority = 20)
    public void deleteUser() {
        Dashboard dashboard = new Dashboard();
        UserList user = new UserList();
        dashboard.openUserList();
        dashboard.openMenu();

        user.addUpdatedAt();
        user.foundUserToDelete();
        user.deleteChosenUser();
        dashboard.openMenu();
        user.clickMenuUpdated();
    }

    @Features("Regression")
    @Stories("OSF-200 User List, what element is active in DDMenu")
    @Test(priority = 21)
    public void checkWhatIsActiveInDDMenuEquipmentList() {
        Dashboard dashboard = new Dashboard();
        dashboard.openAdministration();
        dashboard.openEquipmentListAsAdmin();
        dashboard.openMenu();
        DDMenus ddm = new DDMenusChrome();
        ddm.checkMenuAdministrationEquipmentList();
        dashboard.closeMenu();
    }

    @Features("Regression")
    @Stories("[OSF-53] Equipment list, default columns check")
    @Test(priority = 22)
    public void checkEquipmentList() {

        Dashboard dashboard = new Dashboard();
        Equipment equip = new Equipment();
        //dashboard.openAdministration();
        dashboard.openEquipmentListAsAdmin();

        equip.sortEquipByName();
        equip.sortEquipById();
        equip.sortEquipByType();
        equip.sortEquipByGroup();
        equip.sortEquipByActive();
        equip.sortEquipByUpdatedAt();
    }

    @Features("Regression")
    @Stories("[OSF-53] Equipment list, edit equip")
    @Test(priority = 23)
    public void checkEditEquip() {
        Equipment equip = new Equipment();
        equip.editEquip();
        equip.checkEquipEdition();
    }

    @Features("Regression")
    @Stories("[OSF-53] Equipment List, dropdown menu check")
    @Test(priority = 24)
    public void checkUpperRightMenuInEquipmentList() {
        Dashboard dashboard = new Dashboard();
        Equipment equipment = new Equipment();

        dashboard.openMenu();
        equipment.checkEquipmentNameInMenu();
        equipment.checkEquipmentTypeInMenu();
        equipment.checkEquipmentIdInMenu();
        equipment.checkEquipmentGroupInMenu();
        equipment.checkEquipmentActiveInMenu();
        equipment.checkEquipmentUpdatedAtInMenu();
        equipment.checkEquipmentCreatedInMenu();
        dashboard.closeMenu();
    }

    @Features("Regression")
    @Stories("[OSF-53] Equipment List add column Created ")
    @Test(priority = 25)
    public void EquipmentListAddColumn() {
        Dashboard dashboard = new Dashboard();
        Equipment equip = new Equipment();

        dashboard.openMenu();
        equip.addCreatedColumn();
        dashboard.openMenu();
        equip.dismissCreated();
    }
}