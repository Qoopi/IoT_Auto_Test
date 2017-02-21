package UI;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ui.pageObjets.dashboard.Dashboard;
import ui.pageObjets.LogInPage;
import ui.pageObjets.dashboard.Notifications;
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
    @Stories("Notifications Rule, default columns check")
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
    @Stories("Notifications Rule, drop down menu with additional columns check")
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
    @Stories("Create new Rule Abnormal vibration ")
    @Test(priority = 3)
    public void CreateNewRule() {
        Notifications not = new Notifications();
        not.floatingButton();
        not.createNewRule();
        //not.ruleCheck();
        not.createRuleAbnormalVibration();
        not.insertName();
        not.insertDescription();
    }

}



