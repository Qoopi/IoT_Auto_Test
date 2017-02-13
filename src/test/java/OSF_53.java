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

        Equipment equipment = new Equipment();
        equipment.sortEquipByName();
        equipment.sortEquipById();
        equipment.sortEquipByType();
        equipment.sortEquipByGroup();
        equipment.sortEquipByUpdatedAt();
    }

}