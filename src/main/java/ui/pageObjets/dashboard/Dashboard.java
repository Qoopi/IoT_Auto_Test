package ui.pageObjets.dashboard;

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

    @Step("Open Equipment as Regular")
    public void openEquipment(){
        waits_asserts.waitForVisibilityByXpath(driver,"//*[@id=\"root\"]/div/div[4]/div/div/div[1]/div/div/div[1]/div[2]/span/div/div");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[1]/div/div/div[1]/div[2]/span/div/div")).click();
        // waits_asserts.assertTextByXpath(driver,"//*[@id=\"naviCrumb\"]/span","Equipment list");
    }
    @Step("Open Notifications")
    public void openNotifications(){
        waits_asserts.waitForVisibilityByXpath(driver,"//*[@id=\"root\"]/div/div[4]/div/div/div[1]/div/div/div[1]/div[3]/span");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[1]/div/div/div[1]/div[3]/span")).click();
    }
            @Step("Open Notifications")
            public void openNotificationsList(){
                waits_asserts.waitForVisibilityByXpath(driver,"//*[@id=\"root\"]/div/div[4]/div/div/div[1]/div/div/div[1]/div[3]/div/div[1]/span");
                waits_asserts.assertTextByXpath(driver,"//*[@id=\"root\"]/div/div[4]/div/div/div[1]/div/div/div[1]/div[3]/div/div[1]/span","Notification List");
                driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[1]/div/div/div[1]/div[3]/div/div[1]/span")).click();
            }
            @Step("Open Notifications")
            public void openNotificationsRules(){
                waits_asserts.waitForVisibilityByXpath(driver,"//*[@id=\"root\"]/div/div[4]/div/div/div[1]/div/div/div[1]/div[3]/div/div[2]/span");
                waits_asserts.assertTextByXpath(driver,"//*[@id=\"root\"]/div/div[4]/div/div/div[1]/div/div/div[1]/div[3]/div/div[2]/span","Notification Rules");
                driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[1]/div/div/div[1]/div[3]/div/div[2]/span")).click();
            }
    @Step("Open Reports")
    public void openReports(){
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"root\"]/div/div[4]/div/div/div[1]/div/div/div[1]/div[4]/span","Reports");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[1]/div/div/div[1]/div[4]/span")).click();
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"naviCrumb\"]","My scheduled reports ");
    }
    @Step("Open Administration menu")
    public void openAdministration() {
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[1]/div/div/div[1]/div[5]/span/div/div");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[1]/div/div/div[1]/div[5]/span/div/div")).click();
    }
            @Step("Open Requests")
            public void openRequests(){
                waits_asserts.waitForVisibilityByXpath(driver,"//*[@id=\"root\"]/div/div[4]/div/div/div[1]/div/div/div[1]/div[5]/div/div[1]/span/div/div");
                driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[1]/div/div/div[1]/div[5]/div/div[1]/span/div/div")).click();
                waits_asserts.assertTextByXpath(driver,"//*[@id=\"naviCrumb\"]","Pending");
            }
            @Step("Open Users list")
            public void openUserList() {
                waits_asserts.waitForClickableByXpath(driver,"//*[@id=\"root\"]/div/div[4]/div/div/div[1]/div/div/div[1]/div[5]/div");
                driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[1]/div/div/div[1]/div[5]/div/div[2]/span/div/div")).click();
                waits_asserts.assertTextByXpath(driver,"//*[@id=\"naviCrumb\"]","Registered and approved users");
            }
            @Step("Open Equipment List as Admin")
            public void openEquipmentListAsAdmin(){
            driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[1]/div/div/div[1]/div[5]/div/div[3]/span/div/div")).click();
            waits_asserts.assertTextByXpath(driver,"//*[@id=\"naviCrumb\"]","Equipment list");
            }
            @Step("Open Access to Skedler")
            public void opernReportAdmin(){
                driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[1]/div/div/div[1]/div[5]/div/div[4]/span/div/div")).click();
                waits_asserts.assertTextByXpath(driver,"//*[@id=\"naviCrumb\"]","Admin reports");
            }
            @Step("Open Global Settings")
            public void openGlobalSettings(){
                driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[1]/div/div/div[1]/div[5]/div/div[5]/span/div/span")).click();
                waits_asserts.assertTextByXpath(driver,"//*[@id=\"naviCrumb\"]","Global Settings");
            }
    }