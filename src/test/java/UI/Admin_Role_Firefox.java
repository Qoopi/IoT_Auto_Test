package UI;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ui.pageObjets.LogInPage;
import ui.pageObjets.administration.Requests;
import ui.pageObjets.administration.UserList;
import ui.pageObjets.dashboard.Dasboards.Dashboard;
import ui.pageObjets.dashboard.Equipments.Equipment;
import ui.pageObjets.dashboard.Notifications.Notifications;
import ui.pageObjets.dashboard.Reports;
import ui.utils.TestListener;


@Listeners(TestListener.class)
public class Admin_Role_Firefox {

    @BeforeTest
    public void LogIn() {
        LogInPage log = new LogInPage();
        log.getToIoTPage();
        log.enterGoogleCred2();
    }

    @Features("Regression")
    @Stories("[OSF-53] Equipment view")
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

    }

    @Features("Regression")
    @Stories("[OSF-53] Equipment, columns menu check")
    @Test(priority = 2)
    public void checkUpperRightMenuInEquipment() {
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
    @Stories("[OSF-53] Equipment, add column Created ")
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

    @Features("Regression")
    @Stories("[OSF-53] Equipment view detail info")
    @Test(priority = 4)
    public void viewEquipInfo() {
        Equipment equipment = new Equipment();
        equipment.viewEquip();
        equipment.checkEquipment();

    }

    @Features("Regression")
    @Stories("Notifications list default columns check")
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

    @Features("Regression")
    @Stories("Notifications lists, dropdown menu check")
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
       /*Notification Rules tests should be*/

    @Features("Regression")
    @Stories("Report list default columns testing")
    @Test(priority = 7)
    public void CheckOutReportsDefaultColumns() {
        Dashboard dash = new Dashboard();
        dash.openReports();

        Reports reports = new Reports();
        reports.checkReportTitleColumn();
        reports.checkReportScheduleColumn();
    }

    @Features("Regression")
    @Stories("Report list additions columns in dropdown menu check")
    @Test(priority = 8)
    public void CheckAdditionalColumns() {
        Dashboard dash = new Dashboard();
        dash.openMenu();

        Reports reports = new Reports();
        reports.checkReportTitleColumnInDropDownMenu();
        reports.checkReportScheduleColumnInDropDownMenu();
        reports.checkRecipientsColumnInDropDownMenu();
        reports.checkExcelIncludedColumnInDropDownMenu();
        reports.checkEquipmentItemsColumnInDropDownMenu();
    }

    @Features("Regression")
    @Stories("Report list add additional columns testing")
    @Test(priority = 9)
    public void AddColumnsInReports() {
        Reports reports = new Reports();
        Dashboard dashboard = new Dashboard();

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
    @Test(priority = 10)
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
    @Stories("OSF-200 User List")
    @Test(priority = 11)
    public void openUserList() {
        Dashboard dashboard = new Dashboard();
        dashboard.openAdministration();
        dashboard.openUserList();

    }

    @Features("Regression")
    @Stories("OSF-200 User List")
    @Test(priority = 12)
    public void checkDefaultColumnsOfUserList() {
        UserList userList = new UserList();
        userList.defaultColumnsCheck();
        Dashboard dashboard = new Dashboard();
        dashboard.openMenu();
        userList.checkingColumnsInPompUpMenu();
    }

    @Features("Regression")
    @Stories("OSF-200 User List")
    @Test(priority = 13)
    public void addColumnsToUserList() {
        UserList userList = new UserList();

        userList.addServices();

        Dashboard dashboard = new Dashboard();
        dashboard.openMenu();
        userList.addUpdatedAt();

        dashboard.openMenu();
        userList.addRegTime();

    }

    @Features("Regression")
    @Stories("OSF-200 User List")
    @Test(priority = 14)
    public void deleteColumnsFromUserList() {

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
        userList.clickMenuService();
        //userList.dismissService();
    }

    @Features("Regression")
    @Stories("OSF-200 User List")
    @Test(priority = 15)
    public void markToDeactivateSomeUser() {
        UserList userList = new UserList();
        userList.markSeveralUser();
        userList.deactivateUsersWithHover();
        userList.activateUserWithColumn();
    }

    @Features("Regression")
    @Stories("OSF-199 Request, accept request")
    @Test(priority = 16)
    public void checkRequests() {
        Dashboard dashboards = new Dashboard();
        dashboards.openAdministration();
        dashboards.openRequests();

        Requests requests = new Requests();
        requests.checkRequest();
        requests.acceptUser();
    }

    @Features("Regression")
    @Stories("OSF-403 Delete User")
    @Test(priority = 17)
    public void deleteUser() {
        Dashboard dashboard = new Dashboard();
        dashboard.openUserList();
        dashboard.openMenu();

        UserList user = new UserList();
        user.addUpdatedAt();
        user.foundUserToDelete();
        user.deleteChosenUser();
    }

    @Features("Regression")
    @Stories("[OSF-53] Equipment list, default columns check")
    @Test(priority = 18)
    public void checkEquipmentList() {
        Dashboard dashboard = new Dashboard();
        Equipment equip = new Equipment();
        LogInPage log = new LogInPage();

        log.refresh();

        dashboard.openAdministration();
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
    @Test(priority = 19)
    public void checkEditEquip() {
        Equipment equip = new Equipment();
        equip.editEquip();
        equip.checkEquipEdition();
    }

    @Features("Regression")
    @Stories("[OSF-53] Equipment List, dropdown menu check")
    @Test(priority = 20)
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
        dashboard.closeMenu();
    }

    @Features("Regression")
    @Stories("[OSF-53] Equipment List add column Created ")
    @Test(priority = 21)
    public void EquipmentListAddColumn() {
        Dashboard dashboard = new Dashboard();
        Equipment equip = new Equipment();
        dashboard.openMenu();
        equip.addCreatedColumn();

        dashboard.openMenu();
        equip.dismissCreated();
    }
}