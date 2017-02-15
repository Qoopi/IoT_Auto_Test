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
    /*Проверка стандартных колонок таблицы Notification List*/
    @Step("Check out Name column")
    public void checkNameColumn(){
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"name_tab_col\"]/span/span[1]","Name");
        driver.findElement(By.xpath("//*[@id=\"name_tab_col\"]/span/span[1]")).click();
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"name_tab_col\"]/span/span[1]")).click();
    }
    @Step("Check out Message column")
    public void checkMessageColumn(){
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"message_tab_col\"]/span/span[1]","Message");
        driver.findElement(By.xpath("//*[@id=\"message_tab_col\"]/span/span[1]")).click();
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"message_tab_col\"]/span/span[1]")).click();
    }
    @Step("Check out Acknowledge column")
    public void checkAcknowledgeColumn(){
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"acknowledged_tab_col\"]/span/span[1]","Acknowledged");
        driver.findElement(By.xpath("//*[@id=\"acknowledged_tab_col\"]/span/span[1]")).click();
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"acknowledged_tab_col\"]/span/span[1]")).click();
    }
    @Step("Check out Time Triggered column")
    public void checkTimeTriggeredColumn(){
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"time_triggered_tab_col\"]/span/span[1]","Time triggered");
        driver.findElement(By.xpath("//*[@id=\"time_triggered_tab_col\"]/span/span[1]")).click();
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"time_triggered_tab_col\"]/span/span[1]")).click();
    }

    /*Провека дополнительных колонок в таблицу Notification List*/

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
