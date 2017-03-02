package ui.pageObjets.dashboard.Equipments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;
import ui.utils.WaitsAsserts;
import ui.utils.WebDriverManager;
import ui.utils.uiUtils;

public class Equipment {
    private WaitsAsserts waits_asserts = new WaitsAsserts();
    private uiUtils utils = new uiUtils();
    private WebDriver driver;

    public Equipment() {
        this.driver = WebDriverManager.getDriver();
    }

    /*Проверка колонок таблицы Equipment*/

    @Step("Checking out Equipment name column in Equipment")
    public void sortEquipByName() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"equipment_name_tab_col\"]/span/span[1]", "Equipment name");
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"equipment_name_tab_col\"]");
        driver.findElement(By.xpath("//*[@id=\"equipment_name_tab_col\"]/span/span[1]")).click();
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"equipment_name_tab_col\"]/span/span[1]")).click();
    }

    @Step("Checking out Equipment id column in Equipment")
    public void sortEquipById() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"equipment_id_tab_col\"]/span/span[1]", "Equipment id");
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"equipment_id_tab_col\"]");
        driver.findElement(By.xpath("//*[@id=\"equipment_id_tab_col\"]/span/span[1]")).click();
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"equipment_id_tab_col\"]/span/span[1]")).click();
    }

    @Step("Checking out Equipment type column in Equipment")
    public void sortEquipByType() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"equipment_type_tab_col\"]/span/span[1]", "Equipment type");
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"equipment_type_tab_col\"]");
        driver.findElement(By.xpath("//*[@id=\"equipment_type_tab_col\"]/span/span[1]")).click();
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"equipment_type_tab_col\"]/span/span[1]")).click();
    }

    @Step("Checking out Group column in Equipment")
    public void sortEquipByGroup() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"group_tab_col\"]/span/span[1]", "Group");
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"group_tab_col\"]");
        driver.findElement(By.xpath("//*[@id=\"group_tab_col\"]/span/span[1]")).click();
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"group_tab_col\"]/span/span[1]")).click();

    }

    @Step("Checking out Active column in Equipment List")
    public void sortEquipByActive() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"active_tab_col\"]/span/span[1]", "Active");
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"active_tab_col\"]");
        driver.findElement(By.xpath("//*[@id=\"active_tab_col\"]/span/span[1]")).click();
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"active_tab_col\"]/span/span[1]")).click();
    }

    @Step("Checking out Updated At column in Equipment")
    public void sortEquipByUpdatedAt() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"updated_at_tab_col\"]/span/span[1]", "Updated at");
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"updated_at_tab_col\"]");
        driver.findElement(By.xpath("//*[@id=\"updated_at_tab_col\"]/span/span[1]")).click();
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"updated_at_tab_col\"]/span/span[1]")).click();
    }

    /*Правое верхнее меню таблицы*/

    @Step("Checking out Equipment name column in upper right menu of table ")
    public void checkEquipmentNameInMenu() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"equipment_name_show_tab_col_btn\"]/div/div/div", "Equipment name");
    }

    @Step("Checking out Equipment id column in upper right menu of table ")
    public void checkEquipmentIdInMenu() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"equipment_id_show_tab_col_btn\"]/div/div/div", "Equipment id");
    }

    @Step("Checking out Equipment type column in upper right menu of table ")
    public void checkEquipmentTypeInMenu() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"equipment_type_show_tab_col_btn\"]/div/div/div", "Equipment type");
    }

    @Step("Checking out Group column in upper right menu of table ")
    public void checkEquipmentGroupInMenu() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"group_show_tab_col_btn\"]/div/div/div", "Group");
    }

    @Step("Checking out Updated at column in upper right menu of table ")
    public void checkEquipmentUpdatedAtInMenu() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"updated_at_show_tab_col_btn\"]/div/div/div", "Updated at");
    }

    @Step("Checking out Created column in upper right menu of table ")
    public void checkEquipmentCreatedInMenu() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"created_show_tab_col_btn\"]/div/div/div", "Created");
    }

    @Step("Checking out Active columns in upper right menu of table ")
    public void checkEquipmentActiveInMenu() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"active_show_tab_col_btn\"]/div/div/div", "Active");
    }

    /*Доавление/удалеение колоки Created */

    @Step("Add column Created to Equipment")
    public void addCreatedColumn() {
        waits_asserts.waitForClickableByXpath(driver, "//*[@id=\"created_show_tab_col_btn\"]");
        driver.findElement(By.xpath("//*[@id=\"created_show_tab_col_btn\"]")).click();
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"created_tab_col\"]/span/span[1]", "Created");

        waits_asserts.waitForClickableByXpath(driver, "//*[@id=\"created_tab_col\"]");
        driver.findElement(By.xpath("//*[@id=\"created_tab_col\"]/span/span[1]")).click();

        waits_asserts.waitForClickableByXpath(driver, "//*[@id=\"created_tab_col\"]");
        driver.findElement(By.xpath("//*[@id=\"created_tab_col\"]/span/span[1]")).click();
        waits_asserts.sleep(1000);
    }

    @Step("Dismiss column Created from Equipment")
    public void dismissCreated() {
        waits_asserts.waitForClickableByXpath(driver, "//*[@id=\"created_show_tab_col_btn\"]");
        driver.findElement(By.xpath("//*[@id=\"created_show_tab_col_btn\"]")).click();
    }

                /*Проверка на просмотр или редактирование оборудования*/

    @Step("Look for additional info of equip")
    public void viewEquip() {
        waits_asserts.waitForClickableByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[2]/table/tbody/tr[1]/td[7]/div/button");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[2]/table/tbody/tr[1]/td[7]/div/button")).click();
        waits_asserts.assertTextByXpath(driver, "/html/body/div[5]/div/div/div/div/div/div/span/div/div/span", "View");
        driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div/div/div/span")).click();
    }

    @Step("Checking out if we are on the right place")
    public void checkEquipment() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div[1]/h3/span/span", "Edit equipment information");
        waits_asserts.waitForClickableByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div[2]/div[2]/span/div/button/div/div");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div[2]/div[2]/span/div/button/div/div")).click();
    }

    @Step("Look for additional info of equip in Equip List")
    public void editEquip() {
        waits_asserts.waitForClickableByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[2]/table/tbody/tr[1]/td[8]");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[2]/table/tbody/tr[1]/td[8]/div/button")).click();
        waits_asserts.assertTextByXpath(driver, "/html/body/div[5]/div/div/div/div/div/div/span/div/div/span", "Edit");
        driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div/div/div/span")).click();
    }

    @Step("Checking out if we are on the right place")
    public void checkEquipEdition() {
        //waits_asserts.assertTextByXpath(driver,"//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div/div[1]/div[1]/button[1]/div/div/text()","Base settings");
        //driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div/div[1]/div[1]/button[1]/div/div/text()")).click();
        //waits_asserts.assertTextByXpath(driver,"//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div/div[1]/div[1]/button[2]/div/div/text()","Edit labels");
        waits_asserts.waitForClickableByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div/div[6]/span/div[1]/button/div/div");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div/div[6]/span/div[1]/button/div/div")).click();
    }
}