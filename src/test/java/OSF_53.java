import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ui.pageObjets.dashboard.Dashboard;
import ui.pageObjets.dashboard.Equipment;
import ui.pageObjets.LogInPage;
import ui.utils.TestListener;

@Listeners(TestListener.class)
public class OSF_53 {

    @BeforeTest
    public void logInAsRegularUser(){

        LogInPage log = new LogInPage();
        log.getToIoTPage();
        log.enterGoogleCred2();
    }

    @Features("Equipment list testing like regular")
    @Stories("User")
    @Test
    public void checkEquipment(){

        Dashboard dashboard = new Dashboard();
        dashboard.openEquipment();

        Equipment equip = new Equipment();
        equip.sortEquipByName();
        equip.sortEquipById();
        equip.sortEquipByType();
        equip.sortEquipByGroup();
        equip.sortEquipByUpdatedAt();
    }
    @Features("Equipment list testing like admin")
    @Stories("User")
    @Test(priority = 1)
    public void openWithNewUser(){

        LogInPage log = new LogInPage();
        log.openNewDriver();
        log.getToIoTPage();
        log.enterGoogleCred();
    }
    @Features("Equipment list testing like admin")
    @Stories("User")
    @Test(priority = 2)
    public void checkEquipmentList(){

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
}