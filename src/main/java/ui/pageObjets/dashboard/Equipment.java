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

    @Step
    public void sortEquipByName() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"equipment_name_tab_col\"]/span/span[1]", "Equipment name");
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"equipment_name_tab_col\"]");
        driver.findElement(By.xpath("//*[@id=\"equipment_name_tab_col\"]/span/span[1]")).click();
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"equipment_name_tab_col\"]/span/span[1]")).click();
    }

    @Step
    public void sortEquipById() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"equipment_id_tab_col\"]/span/span[1]", "Equipment id");
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"equipment_id_tab_col\"]");
        driver.findElement(By.xpath("//*[@id=\"equipment_id_tab_col\"]/span/span[1]")).click();
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"equipment_id_tab_col\"]/span/span[1]")).click();
    }

    @Step
    public void sortEquipByType() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"equipment_type_tab_col\"]/span/span[1]", "Equipment type");
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"equipment_type_tab_col\"]");
        driver.findElement(By.xpath("//*[@id=\"equipment_type_tab_col\"]/span/span[1]")).click();
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"equipment_type_tab_col\"]/span/span[1]")).click();
    }

    @Step
    public void sortEquipByGroup() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"group_tab_col\"]/span/span[1]", "Group");
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"group_tab_col\"]");
        driver.findElement(By.xpath("//*[@id=\"group_tab_col\"]/span/span[1]")).click();
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"group_tab_col\"]/span/span[1]")).click();

    }
    @Step
    public void sortEquipByActive() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[1]/table/thead/tr/th[6]", "Active");
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[2]");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[1]/table/thead/tr/th[6]/span")).click();
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[1]/table/thead/tr/th[6]/span")).click();
    }
    @Step
    public void sortEquipByUpdatedAt() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"updated_at_tab_col\"]/span/span[1]", "Updated at");
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"updated_at_tab_col\"]");
        driver.findElement(By.xpath("//*[@id=\"updated_at_tab_col\"]/span/span[1]")).click();
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"updated_at_tab_col\"]/span/span[1]")).click();
    }
    @Step
    public void checkEquipmentNameInMenu(){

        waits_asserts.assertTextByXpath(driver,"//*[@id=\"equipment_name_show_tab_col_btn\"]/div/div/div","Equipment name");
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"equipment_id_show_tab_col_btn\"]/div/div/div","Equipment id");
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"equipment_type_show_tab_col_btn\"]/div/div/div","Equipment type");
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"group_show_tab_col_btn\"]/div/div/div","Group");
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"updated_at_show_tab_col_btn\"]/div/div/div","Updated at");
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"created_show_tab_col_btn\"]/div/div/div","Created");

    }

}