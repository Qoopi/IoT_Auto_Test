package ui.pageObjets.dashboard;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;
import ui.utils.WaitsAsserts;
import ui.utils.WebDriverManager;

public class Notifications {

    private WaitsAsserts waits_asserts = new WaitsAsserts();
    private WebDriver driver;

    public Notifications() {this.driver = WebDriverManager.getDriver();}

    @Step
    public void checkNameColumn(){
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"name_tab_col\"]/span/span[1]","Name");
        driver.findElement(By.xpath("//*[@id=\"name_tab_col\"]/span/span[1]")).click();
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"name_tab_col\"]/span/span[1]")).click();
    }
    @Step
    public void checkMessageColumn(){
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"message_tab_col\"]/span/span[1]","Message");
        driver.findElement(By.xpath("//*[@id=\"message_tab_col\"]/span/span[1]")).click();
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"message_tab_col\"]/span/span[1]")).click();
    }
    @Step
    public void checkAcknowledgeColumns(){
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"acknowledged_tab_col\"]/span/span[1]","Acknowledged");
        driver.findElement(By.xpath("//*[@id=\"acknowledged_tab_col\"]/span/span[1]")).click();
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"acknowledged_tab_col\"]/span/span[1]")).click();
    }
    @Step
    public void checkTimeTriggeredColumns(){
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"time_triggered_tab_col\"]/span/span[1]","Time triggered");
        driver.findElement(By.xpath("//*[@id=\"time_triggered_tab_col\"]/span/span[1]")).click();
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"time_triggered_tab_col\"]/span/span[1]")).click();
    }

    @Step
    public void openMenu(){
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[1]/span/div/button");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[1]/span/div/button")).click();
    }

    @Step
    public void checkLeftMenuNameColumns(){
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"name_show_tab_col_btn\"]/div/div/div","Name");
    }
    @Step
    public void checkLeftMenuMessageColumns(){

        waits_asserts.assertTextByXpath(driver,"//*[@id=\"message_show_tab_col_btn\"]/div/div/div","Message");
    }
    @Step
    public void checkLeftMenuAcknowledgeColumns(){

        waits_asserts.assertTextByXpath(driver,"//*[@id=\"acknowledged_show_tab_col_btn\"]/div/div/div","Acknowledge");
    }
    @Step
    public void checkLeftMenuTimeTriggeredColumns(){

        waits_asserts.assertTextByXpath(driver,"//*[@id=\"time_triggered_show_tab_col_btn\"]/div/div/div","Time triggered");
    }
}
