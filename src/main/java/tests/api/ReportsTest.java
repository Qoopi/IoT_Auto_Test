package tests.api;

import mechanics.api.ListenerAPI;
import mechanics.api.RequestManagerAPI;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import mechanics.system.email.CheckingMails;

import static mechanics.system.constant.EmailINBOX.SubjectReportListVPVWeekly;

/**
 * Created by user on 26.04.2017.
 */
@Listeners(ListenerAPI.class)
public class ReportsTest {

    @Features("Report Send Now function.")
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
