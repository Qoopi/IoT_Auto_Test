package ui.pageObjets.administration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;
import ui.utils.WaitsAsserts;
import ui.utils.WebDriverManager;
import ui.utils.uiUtils;


public class UserList {
    private WaitsAsserts waits_asserts = new WaitsAsserts();
    private WebDriver driver;

    public UserList() {this.driver = WebDriverManager.getDriver();}

    @Step("Checking default columns")
    public void defaultColumnsCheck(){
        waits_asserts.waitForVisibilityByXpath(driver,"//*[@id=\"root\"]/div/div[4]/div/div/div[2]");
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[1]/table/thead/tr/th[2]/span/span[1]","User name");

        waits_asserts.assertTextByXpath(driver,"//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[1]/table/thead/tr/th[3]/span/span[1]","Email");

        waits_asserts.assertTextByXpath(driver,"//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[1]/table/thead/tr/th[4]/span/span[1]","Active");

        waits_asserts.assertTextByXpath(driver,"//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[1]/table/thead/tr/th[5]/span/span[1]","Admin group");


    }

    @Step("Open right menu")
    public void openMenu() {
        //open menu
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[1]/span/div/button");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[1]/span/div/button")).click();

    }
    @Step("Adding Service column")
    public void addServices() {

        //wait for Service
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"Service\"]");
        //add new column service
        driver.findElement(By.xpath("//*[@id=\"Service\"]")).click();
        waits_asserts.sleep(1000);
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[1]/table/thead/tr/th[6]/span/span[1]", "Service");
        waits_asserts.sleep(1000);
    }

    @Step("Dismiss Service columns")
    public void dismissService() {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div[2]/div/div[2]/div/div[1]/span/div/button")).click();
        waits_asserts.waitForVisibilityByXpath(driver,"//*[@id=\"Service\"]");
        driver.findElement(By.xpath("//*[@id=\"Service\"]")).click();
        waits_asserts.sleep(1000);
    }

    @Step("Add Update At column")
    public void addUpdatedAt() {
        // wait for
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"Updated_at\"]");
        driver.findElement(By.xpath("//*[@id=\"Updated_at\"]")).click();
        //wait for
        waits_asserts.sleep(1000);
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[1]/table/thead/tr/th[7]/span/span[1]", "Updated at");
        waits_asserts.sleep(1000);
    }

    @Step("Dismiss Update At column")
    public void dismissUpdatedAt() {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div[2]/div/div[2]/div/div[1]/span/div/button")).click();
        // wait for
        waits_asserts.waitForVisibilityByXpath(driver,"//*[@id=\"Updated_at\"]");
        driver.findElement(By.xpath("//*[@id=\"Updated_at\"]")).click();
        //wait for
        waits_asserts.sleep(1000);
    }

    @Step("Add Reg. Time column")
    public void addRegTime() {
        // wait for
        waits_asserts.waitForVisibilityByXpath(driver,"//*[@id=\"Reg._time\"]");
        driver.findElement(By.xpath("//*[@id=\"Reg._time\"]")).click();
        // wait for
        waits_asserts.sleep(1000);
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[1]/table/thead/tr/th[8]/span/span[1]","Reg. time");
        waits_asserts.sleep(1000);
    }

    @Step("Dismiss  Reg. Time column")
    public void dismissRegTime() {

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div[2]/div/div[2]/div/div[1]/span/div/button")).click();

        driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div/div/div[7]/span/div/div/span")).click();

    }
    // in PoPUp Menu
    @Step
    public void checkingColumnsInPompUpMenu() {
        // Checkout User name column in menu
        waits_asserts.assertTextByXpath(driver, "/html/body/div[5]/div", "User name");
        //Checkout Email column in menu
        waits_asserts.assertTextByXpath(driver, "/html/body/div[5]/div", "Email");
        // Checkout Active column in menu
        waits_asserts.assertTextByXpath(driver, "/html/body/div[5]/div", "Active");
        // Checkout Admin Group column in menu
        waits_asserts.assertTextByXpath(driver, "/html/body/div[5]/div", "Admin group");
        // Checkout Service column in menu
        waits_asserts.assertTextByXpath(driver, "/html/body/div[5]/div", "Service");
        // Checkout Updated At column in menu
        waits_asserts.assertTextByXpath(driver, "/html/body/div[5]/div", "Updated at");
        // Checkout Reg. Time column in menu
        waits_asserts.assertTextByXpath(driver,"/html/body/div[5]/div","Reg. time");
    }

    @Step("Mark several users")
    public void markSeveralUser(){
        waits_asserts.waitForVisibilityByXpath(driver,"//*[@id=\"root\"]/div/div[4]/div/div/div[2]");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[2]/table/tbody/tr[4]/td[1]/div/input")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[2]/table/tbody/tr[10]/td[1]/div/input")).click();
        uiUtils utils = new uiUtils();
        utils.makeScreenshot(driver,"Marked user string terned grey");
    }
    @Step("Deactivate marked users")
    public void deactivateUsersWithHover () {
        // Choosing two more users
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[2]");
        // deactivating users
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[2]/span/div/div/div/button/div/div")).click();
        waits_asserts.waitForClickableByCSS(driver, "div.floatChild:nth-child(2) > span:nth-child(2) > div:nth-child(1) > button:nth-child(1)");
        driver.findElement(By.cssSelector("div.floatChild:nth-child(2) > span:nth-child(2) > div:nth-child(1) > button:nth-child(1)")).click();

    }
    @Step("Activate marked user with Active Column")
    public void activateUserWithColumn(){
        waits_asserts.waitForClickableByXpath(driver,"//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[2]/table/tbody/tr[4]/td[4]");
        driver.findElement(By.cssSelector("#root > div > div.content > div > div > div.table-paper > div > div:nth-child(3) > div:nth-child(2) > table > tbody > tr:nth-child(4) > td:nth-child(4) > span > svg")).click();
        waits_asserts.waitForClickableByXpath(driver,"//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[2]/table/tbody/tr[10]/td[4]");
        driver.findElement(By.cssSelector("#root > div > div.content > div > div > div.table-paper > div > div:nth-child(3) > div:nth-child(2) > table > tbody > tr:nth-child(10) > td:nth-child(4) > span > svg")).click();
    }
    @Step("Found user to delete")
    public void foundUserToDelete(){
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[1]/table/thead/tr/th[6]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[1]/table/thead/tr/th[6]/span")).click();
        waits_asserts.waitForVisibilityByXpath(driver,"//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[2]/table/tbody/tr[1]/td[3]");
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[2]/table/tbody/tr[1]/td[3]","geloksmmm@gmail.com");
    }
    @Step("Delete chosen user")
    public void deleteChosenUser(){
        waits_asserts.sleep(10000);
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[2]/table/tbody/tr[2]/td[3]","geloksmmm@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[2]/table/tbody/tr[2]/td[7]/div/button")).click();
        waits_asserts.assertTextByXpath(driver,"/html/body/div[5]/div/div/div/div/div/div[2]/span/div/div","Delete");
        driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div/div/div[2]/span/div/div")).click();

    }


}
