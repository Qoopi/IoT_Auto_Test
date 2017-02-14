import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ui.pageObjets.administration.UserList;
import ui.pageObjets.dashboard.Dashboard;
import ui.pageObjets.LogInPage;
import ui.pageObjets.dashboard.Equipment;
import ui.pageObjets.dashboard.Notifications;
import ui.utils.TestListener;


@Listeners(TestListener.class)
public class testovui_test {
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

        dashboard.openMenu();
        equip.addCreatedColumn();

        dashboard.openMenu();
        equip.dismissCreated();
    }

}



