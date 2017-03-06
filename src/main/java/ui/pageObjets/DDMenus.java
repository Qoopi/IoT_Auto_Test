package ui.pageObjets;

import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;
import ui.utils.UiUtils;
import ui.utils.WaitsAsserts;
import ui.utils.WebDriverManager;

/**
 * Created by User on 06.03.2017.
 */
public class DDMenus {
    private WaitsAsserts waits_asserts = new WaitsAsserts();
    private WebDriver driver;

    public DDMenus() {
        this.driver = WebDriverManager.getDriver();
    }
    @Step("Checkout active columns statement in Reports")
    public void checkMenuReports(){
        String reportsTitle = "#report_title_show_tab_col_btn > div > div > svg";
        String reportsSchedule = "#report_schedule_show_tab_col_btn > div > div > svg";
        String equipmentItems = "#equipment_items_show_tab_col_btn > div > div > svg";
        String recipients = "#recipients_show_tab_col_btn > div > div > svg";
        String excelIncluded = "#excel_included_show_tab_col_btn > div > div > svg";

        UiUtils uiUtils = new UiUtils();
        uiUtils.checkActiveCSS(driver, reportsTitle);
        uiUtils.checkActiveCSS(driver, reportsSchedule);
        uiUtils.checkActiveCSS(driver, equipmentItems);
        uiUtils.checkActiveCSS(driver, recipients);
        uiUtils.checkActiveCSS(driver, excelIncluded);
    }
    @Step("Checkout active columns statement in Equipment")
    public void checkMenuEquipment(){
        String equipmentName = "#equipment_name_show_tab_col_btn > div > div > svg";
        String equipmentId = "#equipment_id_show_tab_col_btn > div > div > svg";
        String equipmentType = "#equipment_type_show_tab_col_btn > div > div > svg";
        String group = "#group_show_tab_col_btn > div > div > svg";
        String updatedAt = "#updated_at_show_tab_col_btn > div > div > svg";
        String created = "#created_show_tab_col_btn > div > div > svg";

        UiUtils uiUtils = new UiUtils();
        uiUtils.checkActiveCSS(driver, equipmentName);
        uiUtils.checkActiveCSS(driver, equipmentId);
        uiUtils.checkActiveCSS(driver, equipmentType);
        uiUtils.checkActiveCSS(driver, group);
        uiUtils.checkActiveCSS(driver, updatedAt);
        uiUtils.checkActiveCSS(driver, created);
    }
    @Step("Checkout active columns statement in Notification List")
    public void checkMenuNotificationList(){
        String name = "#name_show_tab_col_btn > div > div > svg";
        String message = "#message_show_tab_col_btn > div > div > svg";
        String acknowledged = "#acknowledged_show_tab_col_btn > div > div > svg";
        String timeTriggered = "#time_triggered_show_tab_col_btn > div > div > svg";

        UiUtils uiUtils = new UiUtils();
        uiUtils.checkActiveCSS(driver, name);
        uiUtils.checkActiveCSS(driver, message);
        uiUtils.checkActiveCSS(driver, acknowledged);
        uiUtils.checkActiveCSS(driver, timeTriggered);

    }
    @Step("Checkout active columns statement in Notification Rules")
    public void checkMenuNotificationRules(){
        String notificationSubject = "#notification_subject_show_tab_col_btn > div > div > svg";
        String message = "#message_show_tab_col_btn > div > div > svg";
        String active = "#active_show_tab_col_btn > div > div > svg";
        String ruleType = "#rule_type_show_tab_col_btn > div > div > svg";
        String id = "#id_show_tab_col_btn > div > div > svg";
        String triggerAgainAfter = "#trigger_again\\20 after_show_tab_col_btn > div > div > svg";
        String acknowledgementLasts = "#acknowledgement_lasts_show_tab_col_btn > div > div > svg";

        UiUtils uiUtils = new UiUtils();
        uiUtils.checkActiveCSS(driver, notificationSubject);
        uiUtils.checkActiveCSS(driver, message);
        uiUtils.checkActiveCSS(driver, active);
        uiUtils.checkActiveCSS(driver, ruleType);
        uiUtils.checkActiveCSS(driver, id);
        uiUtils.checkActiveCSS(driver, triggerAgainAfter);
        uiUtils.checkActiveCSS(driver, acknowledgementLasts);
    }
    @Step("Checkout active columns statement in Administration menu - Requests")
    public void checkMenuAdministrationRequests(){
        String userName = "#user_name_show_tab_col_btn > div > div > svg";
        String email = "#email_show_tab_col_btn > div > div > svg";
        String adminGroup = "#admin_group_show_tab_col_btn > div > div > svg";
        String service = "#service_show_tab_col_btn > div > div > svg";
        String updatedAt = "#updated_at_show_tab_col_btn > div > div > svg";
        String regTime = "#reg\\2e _time_show_tab_col_btn > div > div > svg";

        UiUtils uiUtils = new UiUtils();
        uiUtils.checkActiveCSS(driver, userName);
        uiUtils.checkActiveCSS(driver, email);
        uiUtils.checkActiveCSS(driver, adminGroup);
        uiUtils.checkActiveCSS(driver, service);
        uiUtils.checkActiveCSS(driver, updatedAt);
        uiUtils.checkActiveCSS(driver, regTime);
    }
    @Step("Checkout active columns statement in Administration menu - User List")
    public void checkMenuAdministrationUserList(){
        String userName = "#user_name_show_tab_col_btn > div > div > svg";
        String email = "#email_show_tab_col_btn > div > div > svg";
        String adminGroup = "#admin_group_show_tab_col_btn > div > div > svg";
        String service = "#service_show_tab_col_btn > div > div > svg";
        String updatedAt = "#updated_at_show_tab_col_btn > div > div > svg";
        String regTime = "#reg\\2e _time_show_tab_col_btn > div > div > svg";

        UiUtils uiUtils = new UiUtils();
        uiUtils.checkActiveCSS(driver, userName);
        uiUtils.checkActiveCSS(driver, email);
        uiUtils.checkActiveCSS(driver, adminGroup);
        uiUtils.checkActiveCSS(driver, service);
        uiUtils.checkActiveCSS(driver, updatedAt);
        uiUtils.checkActiveCSS(driver, regTime);
    }
    @Step("Checkout active columns statement in Administration menu - Equipment List")
    public void checkMenuAdministrationEquipmentList(){
        String equipmentName = "#equipment_name_show_tab_col_btn > div > div > svg";
        String equipmentId = "#equipment_id_show_tab_col_btn > div > div > svg";
        String equipmentType = "#equipment_type_show_tab_col_btn > div > div > svg";
        String group = "#group_show_tab_col_btn > div > div > svg";
        String active = "#active_show_tab_col_btn > div > div > svg";
        String updatedAt = "#updated_at_show_tab_col_btn > div > div > svg";
        String created = "#created_show_tab_col_btn > div > div > svg";

        UiUtils uiUtils = new UiUtils();
        uiUtils.checkActiveCSS(driver, equipmentName);
        uiUtils.checkActiveCSS(driver, equipmentId);
        uiUtils.checkActiveCSS(driver, equipmentType);
        uiUtils.checkActiveCSS(driver, group);
        uiUtils.checkActiveCSS(driver, active);
        uiUtils.checkActiveCSS(driver, updatedAt);
        uiUtils.checkActiveCSS(driver, created);
    }
}
