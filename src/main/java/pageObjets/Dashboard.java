package pageObjets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import ru.yandex.qatools.allure.annotations.Step;
import utils.WebDriverManager;
import utils.WaitsAsserts;

/**
 * Created by User on 27.01.2017.
 */
public class Dashboard {
    WaitsAsserts waits_asserts = new WaitsAsserts();

    public WebDriver driver;

    public Dashboard() {
        this.driver = WebDriverManager.getDriver();
    }

    @Step
    public void openAdministration() {
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[1]/div/div/div[1]/div[5]/span/div/div");
        driver.findElement(new By.ByXPath("//*[@id=\"root\"]/div/div[4]/div/div/div[1]/div/div/div[1]/div[5]/span/div/div")).click();

    }

    @Step
    public void openUserList() {
        driver.findElement(new By.ByXPath("//*[@id=\"root\"]/div/div[4]/div/div/div[1]/div/div/div[1]/div[5]/div/div[2]/span/div/div")).click();
    }

    @Step
    public void openMenu() {
        //open menu
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[1]/span/div/button");
        driver.findElement(new By.ByXPath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[1]/span/div/button")).click();
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
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[1]/table/thead/tr/th[6]/span/span[1]","Reg. time");
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