package ui.pageObjets;

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
    @Step("Open Equipment List")
    public void openEquipmentList(){
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[1]/div/div/div[1]/div[5]/div/div[3]/span/div/div")).click();
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"naviCrumb\"]","Equipment list");
    }
}