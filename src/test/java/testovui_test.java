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
import ui.pageObjets.dashboard.Reports;
import ui.utils.TestListener;


@Listeners(TestListener.class)
public class testovui_test {
    @BeforeTest
    public void LogIn() {
        LogInPage log = new LogInPage();
        log.getToIoTPage();
        log.enterGoogleCred();
    }

    @Features("Admin role testing of functionality")
    @Stories("Report list testing")
    @Test(priority = 8)
    public void CheckOutReportsDefaultColumns() {
        Dashboard dash = new Dashboard();
        dash.openReports();

        Reports reports = new Reports();
        reports.checkReportTitleColumn();
        reports.checkReportScheduleColumn();
    }
    @Features("Admin role testing of functionality")
    @Stories("Report list testing")
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


}



