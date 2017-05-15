package mechanics.ui.pageObjets.dashboard.Dasboards;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import ru.yandex.qatools.allure.annotations.Step;
import mechanics.ui.utils.UiUtils;
import mechanics.ui.utils.WebDriverManager;
import mechanics.ui.utils.WaitsAsserts;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Dashboard{
    private WaitsAsserts waits_asserts = new WaitsAsserts();
    private WebDriver driver;

    public Dashboard() {
        this.driver = WebDriverManager.getDriver();
    }

    /*Меню IoT*/

    @Step("Open Equipment as Regular")
    public void openEquipment() {
        String equipMainMenu = "//*[@id=\"equipment_main_menu_item\"]";
        waits_asserts.waitForVisibilityByXpath(driver, equipMainMenu);

        driver.findElement(By.xpath(equipMainMenu)).click();
        // waits_asserts.assertTextByXpath(driver,"//*[@id=\"naviCrumb\"]/span","Equipment list");

    }

    @Step("Open Notifications")
    public void openNotifications() {
        String notificationMainMenu = "//*[@id=\"notifications_main_menu_item\"]";
        waits_asserts.waitForVisibilityByXpath(driver, notificationMainMenu);
        driver.findElement(By.xpath(notificationMainMenu)).click();
    }

    @Step("Open Notifications")
    public void openNotificationsList() {
        String notificationsListMainMenu = "//*[@id=\"notifications_list_main_menu_item\"]";
        waits_asserts.waitForVisibilityByXpath(driver, notificationsListMainMenu);
        driver.findElement(By.xpath(notificationsListMainMenu)).click();
        // waits_asserts.assertTextByXpath(driver,"//*[@id=\"notifications_list_main_menu_item\"]/div/div/span","Notification List");
    }

    @Step("Open Notifications")
    public void openNotificationsRules() {
        String notificationRulesMainMenu = "//*[@id=\"notification_rules_main_menu_item\"]";
        waits_asserts.waitForVisibilityByXpath(driver, notificationRulesMainMenu);
        driver.findElement(By.xpath(notificationRulesMainMenu)).click();
        waits_asserts.assertTextByXpath(driver, notificationRulesMainMenu, "Notification Rules");
    }

    @Step("Open Reports")
    public void openReports() {
        String reportsMainMenu = "//*[@id=\"reports_main_menu_item\"]";
        waits_asserts.assertTextByXpath(driver, reportsMainMenu, "Reports");
        driver.findElement(By.xpath(reportsMainMenu)).click();
    }

    @Step("Open Administration menu")
    public void openAdministration() {
        String administrationMainMenu = "//*[@id=\"administration_main_menu_item\"]";
        waits_asserts.waitForVisibilityByXpath(driver, administrationMainMenu);
        driver.findElement(By.xpath(administrationMainMenu)).click();
    }

    @Step("Open AWS")
    public void openRequests() {
        String requestsMainMenu = "//*[@id=\"requests_main_menu_item\"]";
        waits_asserts.waitForVisibilityByXpath(driver, requestsMainMenu);
        driver.findElement(By.xpath(requestsMainMenu)).click();
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"naviCrumb\"]", "Pending");
    }

    @Step("Open Users list")
    public void openUserList() {
        String userListMainMenu = "//*[@id=\"user_list_main_menu_item\"]";
        waits_asserts.waitForClickableByXpath(driver, userListMainMenu);
        driver.findElement(By.xpath(userListMainMenu)).click();
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"naviCrumb\"]", "Registered and approved users");
    }

    @Step("Open Equipment List as Admin")
    public void openEquipmentListAsAdmin() {
        String equipmentListMainMenu = "//*[@id=\"equipment_list_main_menu_item\"]";
        waits_asserts.waitForVisibilityByXpath(driver, equipmentListMainMenu);
        driver.findElement(By.xpath(equipmentListMainMenu)).click();
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"naviCrumb\"]", "Equipment list");
    }

    @Step("Open Access to Skedler")
    public void opernReportAdmin() {
        String reportsMainMenu = "//*[@id=\"reports_main_menu_item\"]";
        waits_asserts.waitForVisibilityByXpath(driver, reportsMainMenu);
        driver.findElement(By.xpath(reportsMainMenu)).click();
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"naviCrumb\"]", "Admin reports");
    }

    @Step("Open Global Settings")
    public void openGlobalSettings() {
        String globalSettingsMainMenu = "//*[@id=\"global_settings_main_menu_item\"]";
        waits_asserts.waitForVisibilityByXpath(driver, globalSettingsMainMenu);
        driver.findElement(By.xpath(globalSettingsMainMenu)).click();
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"naviCrumb\"]", "Global Settings");
    }

    @Step("Open right menu")
    public void openMenu() {
        //open menu
        String openMenuButton = "//*[@id=\"table_menu_btn\"]";
        //String openMenuButton = "//*[@id=\"table_menu_btn\"]/div/span";
        waits_asserts.waitForVisibilityByXpath(driver, openMenuButton);
        driver.findElement(By.xpath(openMenuButton)).click();
        waits_asserts.sleep(500);

    }


    @Step("Close menu")
    public void closeMenu(){
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ESCAPE).build().perform();
        waits_asserts.sleep(500);
    }

    @Step("Close menu")
    public void closeMenuFF(){
        UiUtils uiUtils = new UiUtils();
        if (uiUtils.isDDMenuOpenFF(driver)) {
            Robot r = null;
            try {
                r = new Robot();
            } catch (AWTException e) {
                e.printStackTrace();
            }
            if(r!=null) {
                r.keyPress(KeyEvent.VK_ESCAPE);
                r.keyRelease(KeyEvent.VK_ESCAPE);
                waits_asserts.sleep(500);
            }
        }
        else{
            System.out.println("Sorry, looks like menu is already closed");
        }
    }

    @Step("Open dashboard table")
    public void openDashboard() {
        String openDashboardButton = "//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[1]/div[1]/button";
        waits_asserts.waitForVisibilityByXpath(driver, openDashboardButton);
        driver.findElement(By.xpath(openDashboardButton)).click();
    }
}