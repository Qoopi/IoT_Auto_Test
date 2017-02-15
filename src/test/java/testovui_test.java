import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ui.pageObjets.dashboard.Dashboard;
import ui.pageObjets.LogInPage;
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
    @Test(priority = 9)
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
    @Features("Admin role testing of functionality")
    @Stories("Report list testing")
    @Test(priority = 10)
    public void AddColumnsInReports() {
        Reports reports = new Reports();
        Dashboard dashboard = new Dashboard();

        reports.addEquipmentItemColumn();
        reports.checkAddedEquipItem();
        dashboard.openMenu();
        reports.addRecipients();
        reports.checkAddedRecipients();
        dashboard.openMenu();
        reports.addExcelIncluded();
        reports.checkAddedExcelIncluded();
    }
    @Features("Admin role testing of functionality")
    @Stories("Report list testing")
    @Test(priority = 11)
    public void DismissColumnsInReports() {
        Reports reports = new Reports();
        Dashboard dashboard = new Dashboard();
        dashboard.openMenu();
        reports.dismissEquipmentItem();
        dashboard.openMenu();
        reports.dismissRecipients();
        dashboard.openMenu();
        reports.dismissExcelIncluded();
    }


}



