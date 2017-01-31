package pageObjets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;
import utils.WaitsAsserts;
import utils.WebDriverManager;

import java.sql.Driver;

/**
 * Created by User on 31.01.2017.
 */
public class UserList {
        WaitsAsserts waits_asserts = new WaitsAsserts();
    public WebDriver driver;

    public UserList() {this.driver = WebDriverManager.getDriver();}
    @Step
    public void openUserList() {
        waits_asserts.waitForClickableByXpath(driver,"//*[@id=\"root\"]/div/div[4]/div/div/div[1]/div/div/div[1]/div[5]/div");
        driver.findElement(new By.ByXPath("//*[@id=\"root\"]/div/div[4]/div/div/div[1]/div/div/div[1]/div[5]/div/div[2]/span/div/div")).click();
    }

    @Step
    public void openMenu() {
        //open menu
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[1]/span/div/button");
        driver.findElement(new By.ByXPath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[1]/span/div/button")).click();
    }@Step
    public void userNameColumCheck() {
        // Checkout User name column in menu
        waits_asserts.assertTextByXpath(driver, "/html/body/div[5]/div/div/div/div/div/div[1]/span/div/div/div", "User name");
    }@Step
    public void emailColumCheck() {
        //Checkout Email column in menu
        waits_asserts.assertTextByXpath(driver, "/html/body/div[5]/div/div/div/div/div/div[2]/span/div/div/div", "Email");
    }@Step
    public void activeColumCheck() {
        // Checkout Active column in menu
        waits_asserts.assertTextByXpath(driver, "/html/body/div[5]/div/div/div/div/div/div[3]/span/div/div/div", "Active");
    }@Step
    public void adminGroupColumCheck() {
        // Checkout Admin Group column in menu
        waits_asserts.assertTextByXpath(driver, "/html/body/div[5]/div/div/div/div/div/div[4]/span/div/div/div", "Admin group");
    }@Step
    public void serviceColumCheck() {
        // Checkout Service column in menu
        waits_asserts.assertTextByXpath(driver, "/html/body/div[5]/div/div/div/div/div/div[5]/span/div/div/div", "Service");
    }@Step
    public void updatedAtColumCheck() {
        // Checkout Updated At column in menu
        waits_asserts.assertTextByXpath(driver, "/html/body/div[5]/div/div/div/div/div/div[5]/span/div/div/div", "Updated at");
    }@Step
    public void regTimeColumCheck() {
        // Checkout Reg. Time column in menu
        waits_asserts.assertTextByXpath(driver,"/html/body/div[5]/div/div/div/div/div/div[5]/span/div/div/div","Reg. time");
    }

    @Step
    public void addServices() {

        //wait for Service
        waits_asserts.waitForVisibilityByXpath(driver, "/html/body/div[5]/div/div/div/div/div/div[5]/span/div");
        //add new column service
        driver.findElement(new By.ByXPath("/html/body/div[5]/div/div/div/div/div/div[5]/span/div/div")).click();
        waits_asserts.sleep(1000);
        // waits_asserts.waitForVisibilityByXpath(driver,"//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[1]/table/thead/tr/th[6]/span/span[1]");
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[1]/table/thead/tr/th[6]/span/span[1]", "Service");
        waits_asserts.sleep(1000);
    }

    @Step
    public void dismissService() {
        //wait for Service
        waits_asserts.waitForVisibilityByXpath(driver, "/html/body/div[5]/div/div/div/div/div/div[5]/span/div");
        //add new column service
        driver.findElement(new By.ByXPath("/html/body/div[5]/div/div/div/div/div/div[5]/span/div/div")).click();
        waits_asserts.sleep(1000);
    }

    @Step
    public void addUpdatedAt() {
        // wait for
        waits_asserts.waitForVisibilityByXpath(driver, "/html/body/div[5]/div/div/div/div/div/div[6]/span/div/div");
        driver.findElement(new By.ByXPath("/html/body/div[5]/div/div/div/div/div/div[6]/span/div/div/span")).click();
        //wait for
        waits_asserts.sleep(1000);
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[1]/table/thead/tr/th[7]/span/span[1]", "Updated at");
        waits_asserts.sleep(1000);
    }

    @Step
    public void dismissUpdatedAt() {
        // wait for
        waits_asserts.waitForVisibilityByXpath(driver, "/html/body/div[5]/div/div/div/div/div/div[6]/span/div/div");
        driver.findElement(new By.ByXPath("/html/body/div[5]/div/div/div/div/div/div[6]/span/div/div/span")).click();
        //wait for
        waits_asserts.sleep(1000);
    }

    @Step
    public void addRegTime() {
        // wait for
        waits_asserts.waitForVisibilityByXpath(driver,"/html/body/div[5]/div/div/div/div/div/div[7]/span/div/div");
        driver.findElement(new By.ByXPath("/html/body/div[5]/div/div/div/div/div/div[7]/span/div/div/span")).click();
        // wait for
        waits_asserts.sleep(1000);
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[1]/table/thead/tr/th[8]/span/span[1]","Reg. time");
        waits_asserts.sleep(1000);
    }

    @Step
    public void dismissRegTime() {
        // wait for
        waits_asserts.waitForVisibilityByXpath(driver,"/html/body/div[5]/div/div/div/div/div/div[7]/span/div/div");
        driver.findElement(new By.ByXPath("/html/body/div[5]/div/div/div/div/div/div[7]/span/div/div/span")).click();
        // wait for
        waits_asserts.sleep(1000);

    }

}
