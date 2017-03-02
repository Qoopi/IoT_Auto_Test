package ui.pageObjets.dashboard.Dasboards;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;
import ui.utils.WebDriverManager;
import ui.utils.WaitsAsserts;

public class Dashboard {
    private WaitsAsserts waits_asserts = new WaitsAsserts();
    private WebDriver driver;

    public Dashboard() {
        this.driver = WebDriverManager.getDriver();
    }

    /*Меню IoT*/

    @Step("Open Equipment as Regular")
    public void openEquipment() {
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"equipment_main_menu_item\"]");
        driver.findElement(By.xpath("//*[@id=\"equipment_main_menu_item\"]")).click();
        // waits_asserts.assertTextByXpath(driver,"//*[@id=\"naviCrumb\"]/span","Equipment list");
    }

    @Step("Open Notifications")
    public void openNotifications() {
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"notifications_main_menu_item\"]");
        driver.findElement(By.xpath("//*[@id=\"notifications_main_menu_item\"]")).click();
    }

    @Step("Open Notifications")
    public void openNotificationsList() {
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"notifications_list_main_menu_item\"]");
        driver.findElement(By.xpath("//*[@id=\"notifications_list_main_menu_item\"]")).click();
        // waits_asserts.assertTextByXpath(driver,"//*[@id=\"notifications_list_main_menu_item\"]/div/div/span","Notification List");
    }

    @Step("Open Notifications")
    public void openNotificationsRules() {
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"notification_rules_main_menu_item\"]");
        driver.findElement(By.xpath("//*[@id=\"notification_rules_main_menu_item\"]")).click();
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"notification_rules_main_menu_item\"]", "Notification Rules");
    }

    @Step("Open Reports")
    public void openReports() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"reports_main_menu_item\"]", "Reports");
        driver.findElement(By.xpath("//*[@id=\"reports_main_menu_item\"]")).click();
    }

    @Step("Open Administration menu")
    public void openAdministration() {
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"administration_main_menu_item\"]");
        driver.findElement(By.xpath("//*[@id=\"administration_main_menu_item\"]")).click();
    }

    @Step("Open AWS")
    public void openRequests() {
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"requests_main_menu_item\"]");
        driver.findElement(By.xpath("//*[@id=\"requests_main_menu_item\"]")).click();
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"naviCrumb\"]", "Pending");
    }

    @Step("Open Users list")
    public void openUserList() {
        waits_asserts.waitForClickableByXpath(driver, "//*[@id=\"user_list_main_menu_item\"]");
        driver.findElement(By.xpath("//*[@id=\"user_list_main_menu_item\"]")).click();
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"naviCrumb\"]", "Registered and approved users");
    }

    @Step("Open Equipment List as Admin")
    public void openEquipmentListAsAdmin() {
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"equipment_list_main_menu_item\"]");
        driver.findElement(By.xpath("//*[@id=\"equipment_list_main_menu_item\"]")).click();
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"naviCrumb\"]", "Equipment list");
    }

    @Step("Open Access to Skedler")
    public void opernReportAdmin() {
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"reports_main_menu_item\"]");
        driver.findElement(By.xpath("//*[@id=\"reports_main_menu_item\"]")).click();
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"naviCrumb\"]", "Admin reports");
    }

    @Step("Open Global Settings")
    public void openGlobalSettings() {
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"global_settings_main_menu_item\"]");
        driver.findElement(By.xpath("//*[@id=\"global_settings_main_menu_item\"]")).click();
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"naviCrumb\"]", "Global Settings");
    }

    @Step("Open right menu")
    public void openMenu() {
        //open menu
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"table_menu_btn\"]");
        driver.findElement(By.xpath("//*[@id=\"table_menu_btn\"]")).click();
    }

    @Step("Open dashboard table")
    public void openDashboadr() {
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[1]/div[1]/button");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[1]/div[1]/button")).click();
    }
}