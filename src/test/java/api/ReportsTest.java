package api;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import system.email.CheckingMails;

import static system.constant.EmailINBOX.SubjectReportListVPVWeekly;

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
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        requestManagerAPI.skedlerReportSendNow();
        CheckingMails checkingMails = new CheckingMails();
        checkingMails.checkLong(SubjectReportListVPVWeekly.getMessage());
    }
}
