package ui.pageObjets.dashboard;

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

    public Equipment() {this.driver = WebDriverManager.getDriver();}

    @Step("Checking out default columns in Equipment")
    public void sortEquipByName() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"equipment_name_tab_col\"]/span/span[1]", "Equipment name");
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"equipment_name_tab_col\"]");
        driver.findElement(By.xpath("//*[@id=\"equipment_name_tab_col\"]/span/span[1]")).click();
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"equipment_name_tab_col\"]/span/span[1]")).click();
    }

    @Step("Checking out default columns in Equipment")
    public void sortEquipById() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"equipment_id_tab_col\"]/span/span[1]", "Equipment id");
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"equipment_id_tab_col\"]");
        driver.findElement(By.xpath("//*[@id=\"equipment_id_tab_col\"]/span/span[1]")).click();
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"equipment_id_tab_col\"]/span/span[1]")).click();
    }

    @Step("Checking out default columns in Equipment")
    public void sortEquipByType() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"equipment_type_tab_col\"]/span/span[1]", "Equipment type");
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"equipment_type_tab_col\"]");
        driver.findElement(By.xpath("//*[@id=\"equipment_type_tab_col\"]/span/span[1]")).click();
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"equipment_type_tab_col\"]/span/span[1]")).click();
    }

    @Step("Checking out default columns in Equipment")
    public void sortEquipByGroup() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"group_tab_col\"]/span/span[1]", "Group");
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"group_tab_col\"]");
        driver.findElement(By.xpath("//*[@id=\"group_tab_col\"]/span/span[1]")).click();
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"group_tab_col\"]/span/span[1]")).click();

    }
    @Step("Checking out default columns in Equipment")
    public void sortEquipByActive() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"active_tab_col\"]/span/span[1]", "Active");
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"active_tab_col\"]");
        driver.findElement(By.xpath("//*[@id=\"active_tab_col\"]/span/span[1]")).click();
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"active_tab_col\"]/span/span[1]")).click();
    }
    @Step("Checking out default columns in Equipment")
    public void sortEquipByUpdatedAt() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"updated_at_tab_col\"]/span/span[1]", "Updated at");
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"updated_at_tab_col\"]");
        driver.findElement(By.xpath("//*[@id=\"updated_at_tab_col\"]/span/span[1]")).click();
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"updated_at_tab_col\"]/span/span[1]")).click();
    }
    @Step("Checking out columns in upper right menu of table ")
    public void checkEquipmentNameInMenu() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"equipment_name_show_tab_col_btn\"]/div/div/div", "Equipment name");
    }
    @Step("Checking out columns in upper right menu of table ")
    public void checkEquipmentIdInMenu() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"equipment_id_show_tab_col_btn\"]/div/div/div", "Equipment id");
    }
    @Step("Checking out columns in upper right menu of table ")
    public void checkEquipmentTypeInMenu() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"equipment_type_show_tab_col_btn\"]/div/div/div", "Equipment type");
    }
    @Step("Checking out columns in upper right menu of table ")
    public void checkEquipmentGroupInMenu() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"group_show_tab_col_btn\"]/div/div/div", "Group");
    }
    @Step("Checking out columns in upper right menu of table ")
    public void checkEquipmentUpdatedAtInMenu() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"updated_at_show_tab_col_btn\"]/div/div/div", "Updated at");
    }
    @Step("Checking out columns in upper right menu of table ")
    public void checkEquipmentCreatedInMenu(){
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"created_show_tab_col_btn\"]/div/div/div","Created");

    }
    @Step("Checking out columns in upper right menu of table ")
    public void checkEquipmentActiveInMenu() {
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"active_show_tab_col_btn\"]/div/div/div","Active");
    }

}