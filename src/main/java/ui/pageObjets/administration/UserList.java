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

    public UserList() {
        this.driver = WebDriverManager.getDriver();
    }

    @Step("Checking default columns")
    public void defaultColumnsCheck() {
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[2]");
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"user_name_tab_col\"]/span/span[1]", "User name");

        waits_asserts.assertTextByXpath(driver, "//*[@id=\"email_tab_col\"]/span/span[1]", "Email");

        waits_asserts.assertTextByXpath(driver, "//*[@id=\"active_tab_col\"]/span/span[1]", "Active");

        waits_asserts.assertTextByXpath(driver, "//*[@id=\"admin_group_tab_col\"]/span/span[1]", "Admin group");


    }

    @Step("Adding Service column")
    public void addServices() {

        //wait for Service
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"service_show_tab_col_btn\"]");
        //add new column service
        driver.findElement(By.xpath("//*[@id=\"service_show_tab_col_btn\"]")).click();
        waits_asserts.sleep(1000);
    }

    @Step("Adding Service columns")
    public void clickMenuService() {
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"service_show_tab_col_btn\"]");
        driver.findElement(By.xpath("//*[@id=\"service_show_tab_col_btn\"]")).click();
        waits_asserts.sleep(1000);
    }

    @Step("Checking Service column")
    public void checkServiceColumn(){
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"service_tab_col\"]/span/span[1]", "Service");
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"service_tab_col\"]/span/span[1]")).click();
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"service_tab_col\"]/span/span[1]")).click();
        waits_asserts.sleep(1000);
    }


    public void clickMenuUpdated(){
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"updated_at_show_tab_col_btn\"]");
        driver.findElement(By.xpath("//*[@id=\"updated_at_show_tab_col_btn\"]")).click();
        waits_asserts.sleep(1000);
    }

    public void checkUpdatedColumn(){
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"updated_at_tab_col\"]/span/span[1]", "Updated at");
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"updated_at_tab_col\"]/span/span[1]")).click();
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"updated_at_tab_col\"]/span/span[1]")).click();
        waits_asserts.sleep(1000);
    }


    @Step("Add Update At column")
    public void addUpdatedAt() {
        // wait for
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"updated_at_show_tab_col_btn\"]");
        driver.findElement(By.xpath("//*[@id=\"updated_at_show_tab_col_btn\"]")).click();
        //wait for
        waits_asserts.sleep(1000);
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"updated_at_tab_col\"]/span/span[1]", "Updated at");
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"updated_at_tab_col\"]/span/span[1]")).click();
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"updated_at_tab_col\"]/span/span[1]")).click();
    }

    @Step("Dismiss Update At column")
    public void dismissUpdatedAt() {
        String updatedAtButton2 = "//*[@id=\"updated_at_show_tab_col_btn\"]/div/div/div";
        String updatedAtButton = "//*[@id=\"updated_at_show_tab_col_btn\"]";
        waits_asserts.waitForVisibilityByXpath(driver, updatedAtButton);
        driver.findElement(By.xpath(updatedAtButton)).click();
        //wait for
        waits_asserts.sleep(1000);
    }

    public void clickMenuRegTime(){
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"reg._time_show_tab_col_btn\"]");
        driver.findElement(By.xpath("//*[@id=\"reg._time_show_tab_col_btn\"]")).click();
        waits_asserts.sleep(1000);
    }

    public void checkColumnRegTime(){
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"reg._time_tab_col\"]/span/span[1]", "Reg. time");
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"reg._time_tab_col\"]/span/span[1]")).click();
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"reg._time_tab_col\"]/span/span[1]")).click();
        waits_asserts.sleep(1000);
    }

    @Step("Add Reg. Time column")
    public void addRegTime() {
        // wait for
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"reg._time_show_tab_col_btn\"]");
        driver.findElement(By.xpath("//*[@id=\"reg._time_show_tab_col_btn\"]")).click();
        // wait for
        waits_asserts.sleep(1000);
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"reg._time_tab_col\"]/span/span[1]", "Reg. time");
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"reg._time_tab_col\"]/span/span[1]")).click();
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"reg._time_tab_col\"]/span/span[1]")).click();
    }

    @Step("Dismiss  Reg. Time column")
    public void dismissRegTime() {
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"reg._time_show_tab_col_btn\"]");
        driver.findElement(By.xpath("//*[@id=\"reg._time_show_tab_col_btn\"]")).click();
        waits_asserts.sleep(500);

    }

    // in PoPUp Menu
    @Step
    public void checkingColumnsInPompUpMenu() {
        // Checkout User name column in menu
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"user_name_show_tab_col_btn\"]/div/div/div", "User name");
        //Checkout Email column in menu
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"email_show_tab_col_btn\"]/div/div/div", "Email");
        // Checkout Active column in menu
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"active_show_tab_col_btn\"]/div/div/div", "Active");
        // Checkout Admin Group column in menu
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"admin_group_show_tab_col_btn\"]/div/div/div", "Admin group");
        // Checkout Service column in menu
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"service_show_tab_col_btn\"]/div/div/div", "Service");
        // Checkout Updated At column in menu
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"updated_at_show_tab_col_btn\"]/div/div/div", "Updated at");
        // Checkout Reg. Time column in menu
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"reg._time_show_tab_col_btn\"]/div/div/div", "Reg. time");
    }

    @Step("Mark several users")
    public void markSeveralUser() {
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[2]");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[2]/table/tbody/tr[4]/td[1]/div/input")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[2]/table/tbody/tr[10]/td[1]/div/input")).click();
        uiUtils utils = new uiUtils();
        utils.makeScreenshot(driver, "Marked user string terned grey");
    }

    @Step("Deactivate marked users")
    public void deactivateUsersWithHover() {
        // Choosing two more users
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[2]");
        // deactivating users
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[2]/span/div/div/div/button/div/div")).click();
        waits_asserts.waitForClickableByCSS(driver, "div.floatChild:nth-child(2) > span:nth-child(2) > div:nth-child(1) > button:nth-child(1)");
        driver.findElement(By.cssSelector("div.floatChild:nth-child(2) > span:nth-child(2) > div:nth-child(1) > button:nth-child(1)")).click();

    }

    @Step("Activate marked user with Active Column")
    public void activateUserWithColumn() {
        waits_asserts.waitForClickableByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[2]/table/tbody/tr[4]/td[4]");
        driver.findElement(By.cssSelector("#root > div > div.content > div > div > div.table-paper > div > div:nth-child(3) > div:nth-child(2) > table > tbody > tr:nth-child(4) > td:nth-child(4) > span > svg")).click();
        waits_asserts.waitForClickableByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[2]/table/tbody/tr[10]/td[4]");
        driver.findElement(By.cssSelector("#root > div > div.content > div > div > div.table-paper > div > div:nth-child(3) > div:nth-child(2) > table > tbody > tr:nth-child(10) > td:nth-child(4) > span > svg")).click();
    }

    @Step("Found user to delete")
    public void foundUserToDelete() {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[1]/table/thead/tr/th[6]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[1]/table/thead/tr/th[6]/span")).click();
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[2]/table/tbody/tr[1]/td[3]");
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[2]/table/tbody/tr[1]/td[3]", "geloksmmm@gmail.com");
    }

    @Step("Delete chosen user")
    public void deleteChosenUser() {
        waits_asserts.sleep(1000);
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[2]/table/tbody/tr[1]/td[3]", "geloksmmm@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[2]/table/tbody/tr[1]/td[7]/div/button")).click();
        waits_asserts.assertTextByXpath(driver, "/html/body/div[5]/div/div/div/div/div/div[2]/span/div/div", "Delete");
        driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div/div/div[2]/span/div/div")).click();

    }


}
