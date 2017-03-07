package ui.pageObjets;

import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;
import ui.utils.UiUtils;
import ui.utils.WaitsAsserts;
import ui.utils.WebDriverManager;

/**
 * Created by User on 06.03.2017.
 */
public class DDMenusFirefox extends UiUtils implements DDMenus {
    private WaitsAsserts waits_asserts = new WaitsAsserts();
    private WebDriver driver;

    public DDMenusFirefox() {
        this.driver = WebDriverManager.getDriver();
    }

    @Override
    @Step("Checkout active columns statement in Reports")
    public void checkMenuReports(){
        //below is on by default
        String reportsTitle = "#report_title_show_tab_col_btn > div > div > svg";
        String reportsTitleBtn = "#report_title_show_tab_col_btn > div > div > div";
        String reportsSchedule = "#report_schedule_show_tab_col_btn > div > div > svg";
        String reportsScheduleBtn = "#report_schedule_show_tab_col_btn > div > div > div";
        //below is off by default
        String equipmentItems = "#equipment_items_show_tab_col_btn > div > div > svg";
        String equipmentItemsBtn = "#equipment_items_show_tab_col_btn > div > div > div";
        String recipients = "#recipients_show_tab_col_btn > div > div > svg";
        String recipientsBtn = "#recipients_show_tab_col_btn > div > div > div";
        String excelIncluded = "#excel_included_show_tab_col_btn > div > div > svg";
        String excelIncludedBtn = "#excel_included_show_tab_col_btn > div > div > div";

        checkDefaultItemFF(driver, reportsTitle, reportsTitleBtn, true);
        checkDefaultItemFF(driver, reportsSchedule, reportsScheduleBtn, true);
        checkDefaultItemFF(driver, equipmentItems, equipmentItemsBtn, false);
        checkDefaultItemFF(driver, recipients, recipientsBtn, false);
        checkDefaultItemFF(driver, excelIncluded, excelIncludedBtn, false);
    }
    @Override
    @Step("Checkout active columns statement in Equipment")
    public void checkMenuEquipment(){
        //below is on by default
        String equipmentName = "#equipment_name_show_tab_col_btn > div > div > svg";
        String equipmentNameBtn = "#equipment_name_show_tab_col_btn > div > div > div";
        String equipmentId = "#equipment_id_show_tab_col_btn > div > div > svg";
        String equipmentIdBtn = "#equipment_id_show_tab_col_btn > div > div > div";
        String equipmentType = "#equipment_type_show_tab_col_btn > div > div > svg";
        String equipmentTypeBtn = "#equipment_type_show_tab_col_btn > div > div > div";
        String group = "#group_show_tab_col_btn > div > div > svg";
        String groupBtn = "#group_show_tab_col_btn > div > div > div";
        String updatedAt = "#updated_at_show_tab_col_btn > div > div > svg";
        String updatedAtBtn = "#updated_at_show_tab_col_btn > div > div > div";
        //below is off by default
        String created = "#created_show_tab_col_btn > div > div > svg";
        String createdBtn = "#created_show_tab_col_btn > div > div > div";

        checkDefaultItemFF(driver, equipmentName, equipmentNameBtn, true);
        checkDefaultItemFF(driver, equipmentId, equipmentIdBtn, true);
        checkDefaultItemFF(driver, equipmentType, equipmentTypeBtn, true);
        checkDefaultItemFF(driver, group, groupBtn, true);
        checkDefaultItemFF(driver, updatedAt, updatedAtBtn, true);
        checkDefaultItemFF(driver, created, createdBtn, false);
    }
    @Override
    @Step("Checkout active columns statement in Notification List")
    public void checkMenuNotificationList(){
        //below is on by default
        String name = "#name_show_tab_col_btn > div > div > svg";
        String nameBtn = "#name_show_tab_col_btn > div > div > div";
        String message = "#message_show_tab_col_btn > div > div > svg";
        String messageBtn = "#message_show_tab_col_btn > div > div > div";
        String acknowledged = "#acknowledged_show_tab_col_btn > div > div > svg";
        String acknowledgedBtn = "#acknowledged_show_tab_col_btn > div > div > div";
        String timeTriggered = "#time_triggered_show_tab_col_btn > div > div > svg";
        String timeTriggeredBtn = "#time_triggered_show_tab_col_btn > div > div > div";

        checkDefaultItemFF(driver, name, nameBtn, true);
        checkDefaultItemFF(driver, message, messageBtn, true);
        checkDefaultItemFF(driver, acknowledged, acknowledgedBtn, true);
        checkDefaultItemFF(driver, timeTriggered, timeTriggeredBtn, true);

    }
    @Override
    @Step("Checkout active columns statement in Notification Rules")
    public void checkMenuNotificationRules(){
        //below is on by default
        String notificationSubject = "#notification_subject_show_tab_col_btn > div > div > svg";
        String notificationSubjectBtn = "#notification_subject_show_tab_col_btn > div > div > div";
        String message = "#message_show_tab_col_btn > div > div > svg";
        String messageBtn = "#message_show_tab_col_btn > div > div > div";
        String active = "#active_show_tab_col_btn > div > div > svg";
        String activeBtn = "#active_show_tab_col_btn > div > div > div";
        //below is off by default
        String ruleType = "#rule_type_show_tab_col_btn > div > div > svg";
        String ruleTypeBtn = "#rule_type_show_tab_col_btn > div > div > div";
        String id = "#id_show_tab_col_btn > div > div > svg";
        String idBtn = "#id_show_tab_col_btn > div > div > div";
        String triggerAgainAfter = "#trigger_again\\20 after_show_tab_col_btn > div > div > svg";
        String triggerAgainAfterBtn = "#trigger_again\\20 after_show_tab_col_btn > div > div > div";
        String acknowledgementLasts = "#acknowledgement_lasts_show_tab_col_btn > div > div > svg";
        String acknowledgementLastsBtn = "#acknowledgement_lasts_show_tab_col_btn > div > div > div";

        checkDefaultItemFF(driver, notificationSubject, notificationSubjectBtn, true);
        checkDefaultItemFF(driver, message, messageBtn, true);
        checkDefaultItemFF(driver, active, activeBtn, true);
        checkDefaultItemFF(driver, ruleType, ruleTypeBtn, false);
        checkDefaultItemFF(driver, id, idBtn, false);
        checkDefaultItemFF(driver, triggerAgainAfter, triggerAgainAfterBtn, false);
        checkDefaultItemFF(driver, acknowledgementLasts, acknowledgementLastsBtn, false);
    }
    @Override
    @Step("Checkout active columns statement in Administration menu - Requests")
    public void checkMenuAdministrationRequests(){
        //below is on by default
        String userName = "#user_name_show_tab_col_btn > div > div > svg";
        String userNameBtn = "#user_name_show_tab_col_btn > div > div > div";
        String email = "#email_show_tab_col_btn > div > div > svg";
        String emailBtn = "#email_show_tab_col_btn > div > div > div";
        String adminGroup = "#admin_group_show_tab_col_btn > div > div > svg";
        String adminGroupBtn = "#admin_group_show_tab_col_btn > div > div > div";
        //below is off by default
        String service = "#service_show_tab_col_btn > div > div > svg";
        String serviceBtn = "#service_show_tab_col_btn > div > div > div";
        String updatedAt = "#updated_at_show_tab_col_btn > div > div > svg";
        String updatedAtBtn = "#updated_at_show_tab_col_btn > div > div > div";
        String regTime = "#reg\\2e _time_show_tab_col_btn > div > div > svg";
        String regTimeBtn = "#reg\\2e _time_show_tab_col_btn > div > div > div";

        checkDefaultItemFF(driver, userName, userNameBtn, true);
        checkDefaultItemFF(driver, email, emailBtn, true);
        checkDefaultItemFF(driver, adminGroup, adminGroupBtn, true);
        checkDefaultItemFF(driver, service, serviceBtn, false);
        checkDefaultItemFF(driver, updatedAt, updatedAtBtn, false);
        checkDefaultItemFF(driver, regTime, regTimeBtn, false);
    }
    @Override
    @Step("Checkout active columns statement in Administration menu - User List")
    public void checkMenuAdministrationUserList(){
        //below is on by default
        String userName = "#user_name_show_tab_col_btn > div > div > svg";
        String userNameBtn = "#user_name_show_tab_col_btn > div > div > div";
        String email = "#email_show_tab_col_btn > div > div > svg";
        String emailBtn = "#email_show_tab_col_btn > div > div > div";
        String adminGroup = "#admin_group_show_tab_col_btn > div > div > svg";
        String adminGroupBtn = "#admin_group_show_tab_col_btn > div > div > div";
        String active = "#active_show_tab_col_btn > div > div > svg";
        String activeBtn = "#active_show_tab_col_btn > div > div > div";
        //below is off by default
        String service = "#service_show_tab_col_btn > div > div > svg";
        String serviceBtn = "#service_show_tab_col_btn > div > div > div";
        String updatedAt = "#updated_at_show_tab_col_btn > div > div > svg";
        String updatedAtBtn = "#updated_at_show_tab_col_btn > div > div > div";
        String regTime = "#reg\\2e _time_show_tab_col_btn > div > div > svg";
        String regTimeBtn = "#reg\\2e _time_show_tab_col_btn > div > div > div";

        checkDefaultItemFF(driver, userName, userNameBtn, true);
        checkDefaultItemFF(driver, email, emailBtn, true);
        checkDefaultItemFF(driver, adminGroup, adminGroupBtn, true);
        checkDefaultItemFF(driver, active, activeBtn, true);
        checkDefaultItemFF(driver, service, serviceBtn, false);
        checkDefaultItemFF(driver, updatedAt, updatedAtBtn, false);
        checkDefaultItemFF(driver, regTime, regTimeBtn, false);
    }
    @Override
    @Step("Checkout active columns statement in Administration menu - Equipment List")
    public void checkMenuAdministrationEquipmentList(){
        //below is on by default
        String equipmentName = "#equipment_name_show_tab_col_btn > div > div > svg";
        String equipmentNameBtn = "#equipment_name_show_tab_col_btn > div > div > div";
        String equipmentId = "#equipment_id_show_tab_col_btn > div > div > svg";
        String equipmentIdBtn = "#equipment_id_show_tab_col_btn > div > div > div";
        String equipmentType = "#equipment_type_show_tab_col_btn > div > div > svg";
        String equipmentTypeBtn = "#equipment_type_show_tab_col_btn > div > div > div";
        String group = "#group_show_tab_col_btn > div > div > svg";
        String groupBtn = "#group_show_tab_col_btn > div > div > div";
        String active = "#active_show_tab_col_btn > div > div > svg";
        String activeBtn = "#active_show_tab_col_btn > div > div > div";
        String updatedAt = "#updated_at_show_tab_col_btn > div > div > svg";
        String updatedAtBtn = "#updated_at_show_tab_col_btn > div > div > div";
        //below is off by default
        String created = "#created_show_tab_col_btn > div > div > svg";
        String createdBtn = "#created_show_tab_col_btn > div > div > div";

        checkDefaultItemFF(driver, equipmentName, equipmentNameBtn, true);
        checkDefaultItemFF(driver, equipmentId, equipmentIdBtn, true);
        checkDefaultItemFF(driver, equipmentType, equipmentTypeBtn, true);
        checkDefaultItemFF(driver, group, groupBtn, true);
        checkDefaultItemFF(driver, active, activeBtn, true);
        checkDefaultItemFF(driver, updatedAt, updatedAtBtn, true);
        checkDefaultItemFF(driver, created, createdBtn, false);
    }
}
