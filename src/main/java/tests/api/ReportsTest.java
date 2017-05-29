package tests.api;

import mechanics.api.ListenerAPI;
import mechanics.api.RequestManagerAPI;
import mechanics.system.email.CheckingMails;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

import static mechanics.system.constant.EmailInbox.SubjectReportListVPVWeekly;

/**
 * Created by user on 26.04.2017.
 */
@Listeners(ListenerAPI.class)
@Title("Reports test suite.")
public class ReportsTest {

    @Features("Vacuum Pump Vibration Report - Optimized for Printing - Weekly.")
    @Stories("")
    @Description("Send now check")
    @Test
    public void reportSendNowCheck(){
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.skedlerReportCreate();
        requestManagerAPI.sleep(30000);
        requestManagerAPI.skedlerReportSendNow();
        CheckingMails checkingMails = new CheckingMails();
        checkingMails.checkLong(SubjectReportListVPVWeekly.getMessage());
//        requestManagerAPI.skedlerReportDelete();
    }
}
