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

    @Step("Checking dropdown menu column Name")
    public void checkLeftMenuNameColumns(){
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"name_show_tab_col_btn\"]/div/div/div","Name");
    }
    @Step("Checking dropdown menu column Message")
    public void checkLeftMenuMessageColumns(){
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"message_show_tab_col_btn\"]/div/div/div","Message");
    }
    @Step("Checking dropdown menu column Acknowledged")
    public void checkLeftMenuAcknowledgeColumns(){
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"acknowledged_show_tab_col_btn\"]/div/div/div","Acknowledge");
    }
    @Step("Checking dropdown menu column Time TriggeredColumns")
    public void checkLeftMenuTimeTriggeredColumns(){
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"time_triggered_show_tab_col_btn\"]/div/div/div","Time triggered");
    }

    /*Проверка стандартных колонок таблицы Notification Rule*/

    @Step("Check out Notification Subject column")
    public void checkNotificationSubject(){
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"notification_subject_tab_col\"]/span/span[1]","Notification subject");
        waits_asserts.waitForClickableByXpath(driver,"//*[@id=\"notification_subject_tab_col\"]/span/span[1]");
        driver.findElement(By.xpath("//*[@id=\"notification_subject_tab_col\"]/span/span[1]")).click();
        waits_asserts.waitForClickableByXpath(driver,"//*[@id=\"notification_subject_tab_col\"]/span/span[1]");
        driver.findElement(By.xpath("//*[@id=\"notification_subject_tab_col\"]/span/span[1]")).click();
    }
    @Step("Check out Mesage column")
    public void checkMessage(){
        waits_asserts.waitForVisibilityByXpath(driver,"//*[@id=\"message_tab_col\"]/span/span[1]");
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"message_tab_col\"]/span/span[1]","Message");

        waits_asserts.waitForClickableByXpath(driver,"//*[@id=\"message_tab_col\"]/span/span[1]");
        driver.findElement(By.xpath("//*[@id=\"message_tab_col\"]/span/span[1]")).click();
        waits_asserts.waitForClickableByXpath(driver,"//*[@id=\"message_tab_col\"]/span/span[1]");
        driver.findElement(By.xpath("//*[@id=\"message_tab_col\"]/span/span[1]")).click();
    }
    @Step("Check out Active column")
    public void checkActive(){
        waits_asserts.waitForVisibilityByXpath(driver,"//*[@id=\"active_tab_col\"]/span/span[1]");
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"active_tab_col\"]/span/span[1]","Active");

        waits_asserts.waitForClickableByXpath(driver,"//*[@id=\"active_tab_col\"]/span/span[1]");
        driver.findElement(By.xpath("//*[@id=\"active_tab_col\"]/span/span[1]")).click();
        waits_asserts.waitForClickableByXpath(driver,"//*[@id=\"active_tab_col\"]/span/span[1]");
        driver.findElement(By.xpath("//*[@id=\"active_tab_col\"]/span/span[1]")).click();
    }

    /*Провека дополнительных колонок в таблицу Notification Rule*/

    @Step("Checking dropdown menu column Notification Subject")
    public void checkDDMNotificationSubject(){
        waits_asserts.waitForVisibilityByXpath(driver,"//*[@id=\"notification_subject_show_tab_col_btn\"]/div/div/div");
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"notification_subject_show_tab_col_btn\"]/div/div/div","Notification subject");
    }
    @Step("Checking dropdown menu column Message")
    public void checkDDMMessage(){
        waits_asserts.waitForVisibilityByXpath(driver,"//*[@id=\"message_show_tab_col_btn\"]/div/div/div");
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"message_show_tab_col_btn\"]/div/div/div","Message");
    }
    @Step("Checking dropdown menu column Active")
    public void checkDDMActive(){
        waits_asserts.waitForVisibilityByXpath(driver,"//*[@id=\"message_show_tab_col_btn\"]/div/div/div");
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"message_show_tab_col_btn\"]/div/div/div","Message");
    }
    @Step("Checking dropdown menu column Rule type")
    public void checkDDMRuleType(){
        waits_asserts.waitForVisibilityByXpath(driver,"//*[@id=\"rule_type_show_tab_col_btn\"]/div/div/div");
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"rule_type_show_tab_col_btn\"]/div/div/div","Rule type");
    }
    @Step("Checking dropdown menu column Id")
    public void checkDDMId(){
        waits_asserts.waitForVisibilityByXpath(driver,"//*[@id=\"id_show_tab_col_btn\"]/div/div/div");
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"id_show_tab_col_btn\"]/div/div/div","Id");
    }
    @Step("Checking dropdown menu column Trigger again after")
    public void checkDDMTriggerAgainAfter(){
        waits_asserts.waitForVisibilityByXpath(driver,"//*[@id=\"trigger_again after_show_tab_col_btn\"]/div/div/div");
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"trigger_again after_show_tab_col_btn\"]/div/div/div","Trigger again after");
    }
    @Step("Checking dropdown menu column Acknowledgement last")
    public void checkDAMAcknowledgementLast(){
        waits_asserts.waitForVisibilityByXpath(driver,"//*[@id=\"acknowledgement_lasts_show_tab_col_btn\"]/div/div/div");
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"acknowledgement_lasts_show_tab_col_btn\"]/div/div/div","Acknowledgement last");
    }

    /*=================Поверка правил===================*/

    @Step("Click on the floating button")
    public void floatingButton(){
        waits_asserts.waitForVisibilityByXpath(driver,"//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[2]/span/div/div/div/button");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[2]/span/div/div/div/button/div/div")).click();
    }
    @Step("Click on the New rule button")
    public void createNewRule(){
        //waits_asserts.waitForVisibilityByCSS(driver,"#new_rule_float_btn");
        driver.findElement(By.cssSelector("#new_rule_float_btn")).click();
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[2]/div/div/div/div[1]/div[1]/h3/span",
                "Please, select the desired rule type");
    }
    @Step("Check Rules that presented")
    public void ruleCheck (){
        waits_asserts.waitForVisibilityByXpath(driver,"//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[2]/div/div/div/div[1]/div[1]/div[1]/div");
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[2]/div/div/div/div[1]/div[1]/div[1]/div/p/text()",
                "The rule monitors whether the equipment has abnormal vibrations above the Alarm or Abort thresholds");
    }
            @Step("Create Abnormal vibrations rule")
            public void createRuleAbnormalVibration(){
                 waits_asserts.waitForVisibilityByXpath(driver,"//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[2]/div/div/div/div[1]/div[1]/div[1]/div/div/div/button");
                 driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[2]/div/div/div/div[1]/div[1]/div[1]/div/div/div/button")).click();
                 //waits_asserts.waitForVisibilityByXpath(driver,"//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[1]/div[3]/span/text()");
                 //waits_asserts.assertTextByXpath(driver,"//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[1]/div[3]/span/text()","Main settings");
            }
            @Step("Insert name of rule")
            public void insertName(){
                 driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[2]/div/div/div/div[1]/div[1]/div[1]/div")).click();
                 waits_asserts.waitForVisibilityByXpath(driver,"//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[2]/div/div/div/div[1]/div[1]/div[1]/div");
                 driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[2]/div/div/div/div[1]/div[1]/div[1]/div")).sendKeys("Abnormal vibration");
            }
            @Step("Insert description of rule")
            public void insertDescription(){
                 //waits_asserts.waitForVisibilityByXpath(driver,"//*[@id="root"]/div/div[4]/div/div/div[2]/div/div[2]/div/div/div/div[1]/div[1]/div[2]/div");
                 driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[2]/div/div/div/div[1]/div[1]/div[2]/div")).click();
                 driver.findElement(By.xpath("//*[@id=\"undefined-undefined-Description-14899\"]")).sendKeys("Big BOOOM");
            }
}
