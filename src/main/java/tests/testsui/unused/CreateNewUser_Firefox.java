package tests.testsui.unused;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ui.pageObjets.LogInPage;
import ui.utils.ListenerUi;

@Listeners(ListenerUi.class)

public class CreateNewUser_Firefox {
    @Features("Create New User")
    @Stories("User")
    @Test
    public void createNewUser() {
        LogInPage log = new LogInPage();
        log.getToIoTPage();
        log.enterGoogleCred2();
    }
}
