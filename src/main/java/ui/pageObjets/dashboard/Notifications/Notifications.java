package ui.pageObjets.dashboard.Notifications;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;
import ui.utils.WaitsAsserts;
import ui.utils.WebDriverManager;

public class Notifications {

    private WaitsAsserts waits_asserts = new WaitsAsserts();
    private WebDriver driver;

    public Notifications() {
        this.driver = WebDriverManager.getDriver();
    }

    /*Проверка стандартных колонок таблицы Notification List*/
    @Step("Check out Name column")
    public void checkNameColumn() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"name_tab_col\"]/span/span[1]", "Name");
        driver.findElement(By.xpath("//*[@id=\"name_tab_col\"]/span/span[1]")).click();
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"name_tab_col\"]/span/span[1]")).click();
    }

    @Step("Check out Message column")
    public void checkMessageColumn() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"message_tab_col\"]/span/span[1]", "Message");
        driver.findElement(By.xpath("//*[@id=\"message_tab_col\"]/span/span[1]")).click();
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"message_tab_col\"]/span/span[1]")).click();
    }

    @Step("Check out Acknowledge column")
    public void checkAcknowledgeColumn() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"acknowledged_tab_col\"]/span/span[1]", "Acknowledged");
        driver.findElement(By.xpath("//*[@id=\"acknowledged_tab_col\"]/span/span[1]")).click();
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"acknowledged_tab_col\"]/span/span[1]")).click();
    }

    @Step("Check out Time Triggered column")
    public void checkTimeTriggeredColumn() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"time_triggered_tab_col\"]/span/span[1]", "Time triggered");
        driver.findElement(By.xpath("//*[@id=\"time_triggered_tab_col\"]/span/span[1]")).click();
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"time_triggered_tab_col\"]/span/span[1]")).click();
    }

    /*Провека дополнительных колонок в таблицу Notification List*/

    @Step("Checking dropdown menu column Name")
    public void checkLeftMenuNameColumns() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"name_show_tab_col_btn\"]/div/div/div", "Name");
    }

    @Step("Checking dropdown menu column Message")
    public void checkLeftMenuMessageColumns() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"message_show_tab_col_btn\"]/div/div/div", "Message");
    }

    @Step("Checking dropdown menu column Acknowledged")
    public void checkLeftMenuAcknowledgeColumns() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"acknowledged_show_tab_col_btn\"]/div/div/div", "Acknowledge");
    }

    @Step("Checking dropdown menu column Time TriggeredColumns")
    public void checkLeftMenuTimeTriggeredColumns() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"time_triggered_show_tab_col_btn\"]/div/div/div", "Time triggered");
    }

    /*Проверка стандартных колонок таблицы Notification Rule*/

    @Step("Check out Notification Subject column")
    public void checkNotificationSubject() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"notification_subject_tab_col\"]/span/span[1]", "Notification subject");
        waits_asserts.waitForClickableByXpath(driver, "//*[@id=\"notification_subject_tab_col\"]/span/span[1]");
        driver.findElement(By.xpath("//*[@id=\"notification_subject_tab_col\"]/span/span[1]")).click();
        waits_asserts.waitForClickableByXpath(driver, "//*[@id=\"notification_subject_tab_col\"]/span/span[1]");
        driver.findElement(By.xpath("//*[@id=\"notification_subject_tab_col\"]/span/span[1]")).click();
    }

    @Step("Check out Mesage column")
    public void checkMessage() {
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"message_tab_col\"]/span/span[1]");
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"message_tab_col\"]/span/span[1]", "Message");

        waits_asserts.waitForClickableByXpath(driver, "//*[@id=\"message_tab_col\"]/span/span[1]");
        driver.findElement(By.xpath("//*[@id=\"message_tab_col\"]/span/span[1]")).click();
        waits_asserts.waitForClickableByXpath(driver, "//*[@id=\"message_tab_col\"]/span/span[1]");
        driver.findElement(By.xpath("//*[@id=\"message_tab_col\"]/span/span[1]")).click();
    }

    @Step("Check out Active column")
    public void checkActive() {
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"active_tab_col\"]/span/span[1]");
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"active_tab_col\"]/span/span[1]", "Active");

        waits_asserts.waitForClickableByXpath(driver, "//*[@id=\"active_tab_col\"]/span/span[1]");
        driver.findElement(By.xpath("//*[@id=\"active_tab_col\"]/span/span[1]")).click();
        waits_asserts.waitForClickableByXpath(driver, "//*[@id=\"active_tab_col\"]/span/span[1]");
        driver.findElement(By.xpath("//*[@id=\"active_tab_col\"]/span/span[1]")).click();
    }

    /*Провека дополнительных колонок в таблицу Notification Rule*/

    @Step("Checking dropdown menu column Notification Subject")
    public void checkDDMNotificationSubject() {
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"notification_subject_show_tab_col_btn\"]/div/div/div");
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"notification_subject_show_tab_col_btn\"]/div/div/div", "Notification subject");
    }

    @Step("Checking dropdown menu column Message")
    public void checkDDMMessage() {
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"message_show_tab_col_btn\"]/div/div/div");
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"message_show_tab_col_btn\"]/div/div/div", "Message");
    }

    @Step("Checking dropdown menu column Active")
    public void checkDDMActive() {
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"message_show_tab_col_btn\"]/div/div/div");
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"message_show_tab_col_btn\"]/div/div/div", "Message");
    }

    @Step("Checking dropdown menu column Rule type")
    public void checkDDMRuleType() {
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"rule_type_show_tab_col_btn\"]/div/div/div");
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"rule_type_show_tab_col_btn\"]/div/div/div", "Rule type");
    }

    @Step("Checking dropdown menu column Id")
    public void checkDDMId() {
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"id_show_tab_col_btn\"]/div/div/div");
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"id_show_tab_col_btn\"]/div/div/div", "Id");
    }

    @Step("Checking dropdown menu column Trigger again after")
    public void checkDDMTriggerAgainAfter() {
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"trigger_again after_show_tab_col_btn\"]/div/div/div");
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"trigger_again after_show_tab_col_btn\"]/div/div/div", "Trigger again after");
    }

    @Step("Checking dropdown menu column Acknowledgement last")
    public void checkDAMAcknowledgementLast() {
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"acknowledgement_lasts_show_tab_col_btn\"]/div/div/div");
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"acknowledgement_lasts_show_tab_col_btn\"]/div/div/div", "Acknowledgement last");
    }

    /*=================Поверка правил===================*/
                 /*1st Step*/

    @Step("Click on the floating button")
    public void floatingButton() {
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[2]/span/div/div/div/button");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[2]/span/div/div/div/button/div/div")).click();
    }

    @Step("Click on the New rule button")
    public void createNewRule() {
        //waits_asserts.waitForVisibilityByCSS(driver,"#new_rule_float_btn");
        driver.findElement(By.cssSelector("#new_rule_float_btn")).click();
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[2]/div/div/div/div[1]/div[1]/h3/span",
                "Please, select the desired rule type");
    }

    @Step("Check Rules that presented")
    public void ruleCheck() {
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[2]/div/div/div/div[1]/div[1]/div[1]/div");
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[2]/div/div/div/div[1]/div[1]/div[1]/div/p/text()",
                "The rule monitors whether the equipment has abnormal vibrations above the Alarm or Abort thresholds");
    }

    @Step("Create Abnormal vibrations rule")
    public void createRuleAbnormalVibration() {
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[2]/div/div/div/div[1]/div[1]/div[1]/div/div/div/button");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[2]/div/div/div/div[1]/div[1]/div[1]/div/div/div/button")).click();
        //waits_asserts.waitForVisibilityByXpath(driver,"//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[1]/div[3]/span/text()");
        //waits_asserts.assertTextByXpath(driver,"//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[1]/div[3]/span/text()","Main settings");
    }

            /*2nd Step "Main settings"*/

    @Step("Insert name of rule")
    public void insertName() {
        driver.findElement(By.xpath("//*[@id=\"new_rule_name\"]")).click();
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"new_rule_name\"]");
        driver.findElement(By.xpath("//*[@id=\"new_rule_name\"]")).sendKeys("Abnormal vibration");
    }

    @Step("Insert description of rule")
    public void insertDescription() {
        driver.findElement(By.xpath("//*[@id=\"new_rule_description\"]")).click();
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"new_rule_description\"]");
        driver.findElement(By.xpath("//*[@id=\"new_rule_description\"]")).sendKeys("Big BOOOM");
    }

    @Step("Step 3")
    public void clickContinue() {

        waits_asserts.waitForClickableByXpath(driver, "//*[@id=\"continueundefined\"]");

        driver.findElement(By.xpath("//*[@id=\"continueundefined\"]")).click();
    }
            /*KOSTblJIb*/
    public void clickContinue2() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('#continueundefined').setAttribute('style','border: 10px;box-sizing: border-box;display: inline-block;font-family: Roboto, sans-serif;-webkit-tap-highlight-color: rgba(0, 0, 0, 0);cursor: pointer;text-decoration: none;margin: 0px;padding: 0px;outline: none;font-size: inherit;font-weight: inherit;transform: translate(0px, 0px);position: relative;height: 36px;line-height: 36px;width: 100%;border-radius: 2px;transition: all 450ms cubic-bezier(0.23, 1, 0.32, 1) 0ms;background-color: rgb(25, 118, 210);text-align: center;z-index: 100500');");
        waits_asserts.waitForClickableByXpath(driver, "//*[@id=\"continueundefined\"]");
        driver.findElement(By.xpath("//*[@id=\"continueundefined\"]")).click();
    }

            /*3-d Step "Select equipment"*/

    @Step("Add equipment with floating button")
    public void clickOnFloatingButton() {
        waits_asserts.waitForClickableByXpath(driver, "//*[@id=\"add_equipments_float_btn\"]");
        driver.findElement(By.xpath("//*[@id=\"add_equipments_float_btn\"]")).click();
    }

    @Step("Add from list")
    public void chooseEquip() {
        waits_asserts.waitForClickableByXpath(driver, "/html/body/div[2]/div/div[1]/div/div/div[1]/span/div/div[3]/div[2]/table/tbody/tr[1]/td[1]");
        waits_asserts.assertTextByXpath(driver, "/html/body/div[2]/div/div[1]/div/div/div[1]/span/div/div[3]/div[2]/table/tbody/tr[1]/td[1]", "Pump D13");
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/div[1]/span/div/div[3]/div[2]/table/tbody/tr[1]/td[1]")).click();
    }

    @Step("Click on button add")
    public void clickAdd() {
        waits_asserts.waitForClickableByXpath(driver, "/html/body/div[2]/div/div[1]/div/div/div[2]/button[2]");
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/div[2]/button[2]")).click();
    }

    @Step("Check if the added Equipment is present")
    public void checkAddedEquip() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[2]/div/div/div/div[1]/div[1]/div[2]/div/div[3]/div[2]/table/tbody/tr/td[1]", "Pump D13");
    }

    @Step("Select chanel")
    public void selectChannelCheck() {
        driver.findElement(By.xpath("//*[@id=\"undefined-undefined-channel-41093\"]/div[1]/div[2]")).click();
        waits_asserts.waitForVisibilityByXpath(driver, "/html/body/div[7]/div/div");
        waits_asserts.assertTextByXpath(driver, "/html/body/div[7]/div/div/div/div[1]/span/div/div/div", "Any");
        waits_asserts.assertTextByXpath(driver, "/html/body/div[7]/div/div/div/div[2]/span/div/div/div", "Main");
        waits_asserts.assertTextByXpath(driver, "/html/body/div[7]/div/div/div/div[3]/span/div/div/div", "Blower");

    }

    @Step("Select Main")
    public void selectMain() {
        driver.findElement(By.xpath("/html/body/div[7]/div/div/div/div[2]/span")).click();
    }

    @Step("Select Blower")
    public void selectBlower() {
        driver.findElement(By.xpath("/html/body/div[7]/div/div/div/div[3]/span")).click();
    }

            /*4-th Step "Notification settings"*/

    @Step("Notification settings")
    public void checkGlobalNotification() {
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[2]/div/div/div/div[1]/div[1]/div[1]/h4/div");
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[2]/div/div/div/div[1]/div[1]/div[1]/h4/div", "Notification settings");
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[2]/div/div/div/div[1]/div[1]/div[2]/h4/div[1]", "Send SMS notifications");
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[2]/div/div/div/div[1]/div[1]/div[3]/h4/div[1]", "Send Email notifications");
    }
}