package mechanics.ui.pageObjets.dashboard.Notifications;


import mechanics.ui.utils.WaitsAsserts;
import mechanics.ui.utils.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

public class Notifications {

    private WaitsAsserts waits_asserts = new WaitsAsserts();
    private WebDriver driver;

    public Notifications() {
        this.driver = WebDriverManager.getDriver();
    }

    /*Проверка стандартных колонок таблицы Notification List*/

    @Step("Check out Name column")
    public void checkNameColumn() {
        String nameColumn = "//*[@id='name_tab_col']/span/span[1]";
        waits_asserts.assertTextByXpath(driver, nameColumn, "Name");
        driver.findElement(By.xpath(nameColumn)).click();
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath(nameColumn)).click();
    }

    @Step("Check out Message column")
    public void checkMessageColumn() {
        String messageColumn = "//*[@id='message_tab_col']/span/span[1]";
        waits_asserts.assertTextByXpath(driver, messageColumn, "Message");
        driver.findElement(By.xpath(messageColumn)).click();
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath(messageColumn)).click();
    }

    @Step("Check out Acknowledge column")
    public void checkAcknowledgeColumn() {
        String acknowledgedColumn = "//*[@id=\"acknowledged_tab_col\"]/span/span[1]";
        waits_asserts.assertTextByXpath(driver, acknowledgedColumn, "Acknowledged");
        driver.findElement(By.xpath(acknowledgedColumn)).click();
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath(acknowledgedColumn)).click();
    }

    @Step("Check out Time Triggered column")
    public void checkTimeTriggeredColumn() {
        String timeTriggeredColumn = "//*[@id='time_triggered_tab_col']/span/span[1]";
        waits_asserts.assertTextByXpath(driver, timeTriggeredColumn, "Time triggered");
        driver.findElement(By.xpath(timeTriggeredColumn)).click();
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath(timeTriggeredColumn)).click();
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
        String notificationSubjectColumn = "//*[@id=\"notification_subject_tab_col\"]/span/span[1]";
        waits_asserts.assertTextByXpath(driver, notificationSubjectColumn, "Notification subject");
        waits_asserts.waitForClickableByXpath(driver, notificationSubjectColumn);
        driver.findElement(By.xpath(notificationSubjectColumn)).click();
        waits_asserts.waitForClickableByXpath(driver, notificationSubjectColumn);
        driver.findElement(By.xpath(notificationSubjectColumn)).click();
    }

    @Step("Check out Message column")
    public void checkMessage() {
        String messageColumn = "//*[@id=\"message_tab_col\"]/span/span[1]";
        waits_asserts.waitForVisibilityByXpath(driver, messageColumn);
        waits_asserts.assertTextByXpath(driver, messageColumn, "Message");

        waits_asserts.waitForClickableByXpath(driver, messageColumn);
        driver.findElement(By.xpath(messageColumn)).click();
        waits_asserts.waitForClickableByXpath(driver, messageColumn);
        driver.findElement(By.xpath(messageColumn)).click();
    }

    @Step("Check out Active column")
    public void checkActive() {
        String activeColumn = "//*[@id=\"active_tab_col\"]/span/span[1]";
        waits_asserts.waitForVisibilityByXpath(driver, activeColumn);
        waits_asserts.assertTextByXpath(driver, activeColumn, "Active");

        waits_asserts.waitForClickableByXpath(driver, activeColumn);
        driver.findElement(By.xpath(activeColumn)).click();
        waits_asserts.waitForClickableByXpath(driver, activeColumn);
        driver.findElement(By.xpath(activeColumn)).click();
    }

    /*Провека дополнительных колонок в таблицу Notification Rule*/

    @Step("Checking dropdown menu column Notification Subject")
    public void checkDDMNotificationSubject() {
        String notificationSubjectShowButton = "//*[@id=\"notification_subject_show_tab_col_btn\"]/div/div/div";
        waits_asserts.waitForVisibilityByXpath(driver, notificationSubjectShowButton);
        waits_asserts.assertTextByXpath(driver, notificationSubjectShowButton, "Notification subject");
    }




    @Step("Checking dropdown menu column Message")
    public void checkDDMMessage() {
        String messageShowButton = "//*[@id=\"message_show_tab_col_btn\"]/div/div/div";
        waits_asserts.waitForVisibilityByXpath(driver,messageShowButton);
        waits_asserts.assertTextByXpath(driver, messageShowButton, "Message");
    }

    @Step("Checking dropdown menu column Active")
    public void checkDDMActive() {
        String activeShowTabCol = "//*[@id=\"active_show_tab_col_btn\"]/div/div/div";
        waits_asserts.waitForVisibilityByXpath(driver,  activeShowTabCol);
        waits_asserts.assertTextByXpath(driver,  activeShowTabCol, "Active");
    }

    @Step("Checking dropdown menu column Rule type")
    public void checkDDMRuleType() {
        String ruleTypeShowButton = "//*[@id=\"rule_type_show_tab_col_btn\"]/div/div/div";
        waits_asserts.waitForVisibilityByXpath(driver, ruleTypeShowButton);
        waits_asserts.assertTextByXpath(driver, ruleTypeShowButton, "Rule type");
    }

    @Step("Checking dropdown menu column Id")
    public void checkDDMId() {
        String idShowButton = "//*[@id=\"id_show_tab_col_btn\"]/div/div/div";
        waits_asserts.waitForVisibilityByXpath(driver, idShowButton);
        waits_asserts.assertTextByXpath(driver, idShowButton, "Id");
    }

    @Step("Checking dropdown menu column Trigger again after")
    public void checkDDMTriggerAgainAfter() {
        String triggerAgainAfterButton = "//*[@id=\"trigger_again after_show_tab_col_btn\"]/div/div/div";
        waits_asserts.waitForVisibilityByXpath(driver, triggerAgainAfterButton);
        waits_asserts.assertTextByXpath(driver, triggerAgainAfterButton, "Trigger again after");
    }

    @Step("Checking dropdown menu column Acknowledgement last")
    public void checkDAMAcknowledgementLast() {
        String acknowledgementLastsShowButton = "//*[@id=\"acknowledgement_lasts_show_tab_col_btn\"]/div/div/div";
        waits_asserts.waitForVisibilityByXpath(driver, acknowledgementLastsShowButton);
        waits_asserts.assertTextByXpath(driver, acknowledgementLastsShowButton, "Acknowledgement last");
    }

    /*=================Поверка правил===================*/
                 /*1st Step*/

    @Step("Click on the floating button")
    public void floatingButton() {
        String floatingButtonClosed = "//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[2]/span/div/div/div/button";
        waits_asserts.waitForVisibilityByXpath(driver, floatingButtonClosed);
        WebElement element = driver.findElement(By.xpath(floatingButtonClosed));
        element.click();
    }

    @Step("Click on the New rule button")
    public void createNewRule() {
        //waits_asserts.waitForVisibilityByCSS(driver,"#new_rule_float_btn");
        driver.findElement(By.cssSelector("#new_rule_float_btn")).click();
        //driver.findElement(By.cssSelector(".mainButton")).click();
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
        String ruleCreateButton = "//*[@id='root']/div/div[4]/div/div/div[2]/div/div[2]/div/div/div/div[1]/div[1]/div[1]/div/div/div/button";
        waits_asserts.waitForVisibilityByXpath(driver, ruleCreateButton);
        driver.findElement(By.xpath(ruleCreateButton)).click();
        //waits_asserts.waitForVisibilityByXpath(driver,"//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[1]/div[3]/span/text()");
        //waits_asserts.assertTextByXpath(driver,"//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[1]/div[3]/span/text()","Main settings");

    }

            /*2nd Step "Main settings"*/

    @Step("Insert name of rule")
    public void insertName() {
        String ruleNameField = "//*[@id='new_rule_name']";
        driver.findElement(By.xpath(ruleNameField)).click();
        waits_asserts.waitForVisibilityByXpath(driver, ruleNameField);
        driver.findElement(By.xpath(ruleNameField)).sendKeys("Abnormal vibration");
    }

    @Step("Insert description of rule")
    public void insertDescription() {
        String descriptionField = "//*[@id='new_rule_description']";
        driver.findElement(By.xpath(descriptionField)).click();
        waits_asserts.waitForVisibilityByXpath(driver, descriptionField);
        driver.findElement(By.xpath(descriptionField)).sendKeys("Big BOOOM");
    }

    @Step("Step 3")
    public void clickContinue() {
        String continueButton = "//*[@id='continueundefined']";
        waits_asserts.waitForClickableByXpath(driver, continueButton);
        driver.findElement(By.xpath(continueButton)).click();
    }
            /*KOSTblJIb*/

    @Step("Step 3 Continue")
    public void clickContinue2Chrome() {
        //works with chrome
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('#continueundefined').setAttribute('style','border: 10px;box-sizing: border-box;display: inline-block;font-family: Roboto, sans-serif;-webkit-tap-highlight-color: rgba(0, 0, 0, 0);cursor: pointer;text-decoration: none;margin: 0px;padding: 0px;outline: none;font-size: inherit;font-weight: inherit;transform: translate(0px, 0px);position: relative;height: 36px;line-height: 36px;width: 100%;border-radius: 2px;transition: all 450ms cubic-bezier(0.23, 1, 0.32, 1) 0ms;background-color: rgb(25, 118, 210);text-align: center;z-index: 100500');");
        waits_asserts.waitForClickableByXpath(driver, "//*[@id=\"continueundefined\"]");
        driver.findElement(By.xpath("//*[@id=\"continueundefined\"]")).click();
    }
    @Step("Step 3 Continue")
    public void clickContinue2FireFOx() {
        //works with FF
    waits_asserts.sleep(5500);
     driver.findElement(By.cssSelector("#continueundefined > div > div > span")).click();
    }

            /*3-d Step "Select equipment"*/

    @Step("Add equipment with floating button")
    public void clickOnFloatingButton() {
        String floatingButton = "//*[@id='add_equipments_float_btn']";
        waits_asserts.waitForClickableByXpath(driver, floatingButton);
        driver.findElement(By.xpath(floatingButton)).click();
    }

    @Step("Add from list")
    public void chooseEquip() {
        String equip = "/html/body/div[2]/div/div[1]/div/div/div[1]/span/div/div[3]/div[2]/table/tbody/tr[1]/td[1]";
        waits_asserts.waitForClickableByXpath(driver, equip);
        waits_asserts.assertTextByXpath(driver, equip, "Pump D13");
        driver.findElement(By.xpath(equip)).click();
    }

    @Step("Click on button add")
    public void clickAdd() {
        String addButton = "/html/body/div[2]/div/div[1]/div/div/div[2]/button[2]";
        waits_asserts.waitForClickableByXpath(driver, addButton);
        driver.findElement(By.xpath(addButton)).click();
    }

    @Step("Check if the added Equipment is present")
    public void checkAddedEquip() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[2]/div/div/div/div[1]/div[1]/div[2]/div/div[3]/div[2]/table/tbody/tr/td[1]", "Pump D13");
    }

    public void addChannel(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("document.querySelector('#channel_select_rule').setAttribute('style','display: block;font-size: inherit;height: 100%;font-family: inherit;outline: none;position: relative;transition: all 450ms cubic-bezier(0.23, 1, 0.32, 1) 0ms;-webkit-tap-highlight-color: rgba(0, 0, 0, 0);padding: 0px;width: 100%;border: none;background-color: rgba(0, 0, 0, 0);color: rgba(0, 0, 0, 0.870588);cursor: initial;font-style: inherit;font-variant: inherit;font-weight: inherit;font-stretch: inherit;line-height: inherit;box-sizing: border-box;margin-top: 14px;z-index: 100500');");
        driver.findElement(By.xpath("//*[@id='channel_select_rule']")).click();
        //js.executeScript("document.querySelector('#channel_select_rule > div:nth-child(1)').setAttribute('style','height: 100%;width: 100%; z-index: 0'');");
//        driver.findElement(By.cssSelector("body > div:nth-child(14) > div > div > div > div:nth-child(2) > span > div > div > div")).click();
        driver.findElement(By.cssSelector("body > div:nth-child(14) > div > div > div > div:nth-child(3) > span > div > div > div")).click();
    }

    @Step("Select chanel")
    public void selectChannelCheck() { JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('#channel_select_rule').setAttribute('style','display: block;font-size: inherit;height: 100%;font-family: inherit;outline: none;position: relative;transition: all 450ms cubic-bezier(0.23, 1, 0.32, 1) 0ms;-webkit-tap-highlight-color: rgba(0, 0, 0, 0);padding: 0px;width: 100%;border: none;background-color: rgba(0, 0, 0, 0);color: rgba(0, 0, 0, 0.870588);cursor: initial;font-style: inherit;font-variant: inherit;font-weight: inherit;font-stretch: inherit;line-height: inherit;box-sizing: border-box;margin-top: 14px;z-index: 100500');");
        driver.findElement(By.xpath("//*[@id='channel_select_rule']")).click();
        waits_asserts.waitForVisibilityByXpath(driver, "/html/body/div[7]/div");
        waits_asserts.assertTextByXpath(driver, "/html/body/div[7]/div/div/div/div[1]/span/div/div/div", "Any");
        waits_asserts.assertTextByXpath(driver, "/html/body/div[7]/div/div/div/div[2]/span/div/div/div", "Main");
        waits_asserts.assertTextByXpath(driver, "/html/body/div[7]/div/div/div/div[3]/span/div/div/div", "Blower");

    }

    @Step("Select Main")
    public void selectMain() {
        driver.findElement(By.xpath("/html/body/div[7]/div/div/div/div[2]/span/div/div/div")).click();
    }

    @Step("Select Blower")
    public void selectBlower() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('#channel_select_rule').setAttribute('style','display: block;font-size: inherit;height: 100%;font-family: inherit;outline: none;position: relative;transition: all 450ms cubic-bezier(0.23, 1, 0.32, 1) 0ms;-webkit-tap-highlight-color: rgba(0, 0, 0, 0);padding: 0px;width: 100%;border: none;background-color: rgba(0, 0, 0, 0);color: rgba(0, 0, 0, 0.870588);cursor: initial;font-style: inherit;font-variant: inherit;font-weight: inherit;font-stretch: inherit;line-height: inherit;box-sizing: border-box;margin-top: 14px;z-index: 100500');");
        driver.findElement(By.xpath("//*[@id='channel_select_rule']")).click();
        driver.findElement(By.cssSelector("body > div:nth-child(14) > div > div > div > div:nth-child(3) > span > div > div > div")).click();
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