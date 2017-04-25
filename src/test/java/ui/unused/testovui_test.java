package ui.unused;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ui.pageObjets.DDMenus;
import ui.pageObjets.DDMenusChrome;
import ui.pageObjets.dashboard.Dasboards.Dashboard;
import ui.pageObjets.LogInPage;
import ui.pageObjets.dashboard.Notifications.Notifications;
import ui.utils.TestListener;


@Listeners(TestListener.class)
public class testovui_test {
    @Test
    public void LogIn() {
        LogInPage log = new LogInPage();
        log.getToIoTPage();
        log.enterGoogleCred();
    }
    @Features("Regression")
    @Stories("[OSF-53] Equipment view")
    @Test
    public void checkWhatIsActiveInDDMenu(){
        Dashboard dashboard = new Dashboard();
        dashboard.openEquipment();
        dashboard.openMenu();
        DDMenus ddm = new DDMenusChrome();
        ddm.checkMenuEquipment();
        dashboard.closeMenu();
    }
    @Features("Regression")
    @Stories("Notifications Rule, default columns checkEmail")
    @Test(priority = 1)
    public void NotificationsRuleDefault() {
        Dashboard dash = new Dashboard();
        dash.openNotifications();
        dash.openNotificationsRules();
        Notifications not = new Notifications();
        not.checkNotificationSubject();
        not.checkMessage();
        not.checkActive();
    }

    @Features("Regression")
    @Stories("Notifications Rule, drop down menu with additional columns checkEmail")
    @Test(priority = 2)
    public void NotificationsRuleDDMCheck() {
        Dashboard dash = new Dashboard();
        dash.openMenu();
        Notifications not = new Notifications();
        not.checkDDMNotificationSubject();
        not.checkDDMMessage();
        not.checkDDMActive();
        not.checkDDMRuleType();
        not.checkDDMId();
        not.checkDDMTriggerAgainAfter();
        not.checkDAMAcknowledgementLast();

    }

    @Features("Regression")
    @Stories("Create new Rule Abnormal vibration,Chanel main ")
    @Test(priority = 3)
    public void CreateNewRule() {
        Notifications not = new Notifications();
        not.floatingButton();
        not.createNewRule();
        not.createRuleAbnormalVibration();
        not.insertName();
        not.insertDescription();
        not.clickContinue();
        not.clickOnFloatingButton();
        not.chooseEquip();
        not.clickAdd();
        not.checkAddedEquip();
        not.selectChannelCheck();
        not.clickContinue2Chrome();
        not.checkGlobalNotification();
    }

}



