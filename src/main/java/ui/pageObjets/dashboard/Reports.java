package ui.pageObjets.dashboard;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;
import ui.utils.WaitsAsserts;
import ui.utils.WebDriverManager;
import ui.utils.uiUtils;

public class Reports {
    private WaitsAsserts waits_asserts = new WaitsAsserts();
    private uiUtils utils = new uiUtils();
    private WebDriver driver;

    public Reports() {this.driver = WebDriverManager.getDriver();}

             /*Проверка стандартных колонок таблицы Reports*/

    @Step("Check out Report Title column|+sort")
    public void checkReportTitleColumn(){
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"report_title_tab_col\"]/span/span[1]","Report title");
        driver.findElement(By.xpath("//*[@id=\"report_title_tab_col\"]/span/span[1]")).click();
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"report_title_tab_col\"]/span/span[1]")).click();
    }
    @Step("Check out Report Schedule column|+sort")
    public void checkReportScheduleColumn(){
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"report_schedule_tab_col\"]/span/span[1]","Report schedule");
        driver.findElement(By.xpath("//*[@id=\"report_schedule_tab_col\"]/span/span[1]")).click();
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"report_schedule_tab_col\"]/span/span[1]")).click();
    }

            /*Проверка дополнительных колонок в таблице*/

    @Step("Check out Report Title column in drop down menu")
    public void checkReportTitleColumnInDropDownMenu(){
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"report_title_show_tab_col_btn\"]/div/div/div","Report title");
    }
    @Step("Check out Report Schedule column in drop down menu")
    public void checkReportScheduleColumnInDropDownMenu(){
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"report_schedule_show_tab_col_btn\"]/div/div/div","Report schedule");
    }
    @Step("Check out Equipment Items column in drop down menu")
    public void checkEquipmentItemsColumnInDropDownMenu(){
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"equipment_items_show_tab_col_btn\"]/div/div/div","Equipment items");
    }
    @Step("Check out Recipients column in drop down menu")
    public void checkRecipientsColumnInDropDownMenu(){
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"recipients_show_tab_col_btn\"]/div/div/div","Recipients");
    }
    @Step("Check out Recipients column in drop down menu")
    public void checkExcelIncludedColumnInDropDownMenu(){
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"excel_included_show_tab_col_btn\"]/div/div/div","Excel Included");
    }

            /*Добавление/удаление дополнительных колонок и проверка сортировки по ним*/

    @Step("Add Equipment Items column")
    public void addEquipmentItemColumn(){
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"equipment_items_show_tab_col_btn\"]/div/div/div","Equipment Items");
        driver.findElement(By.xpath("//*[@id=\"equipment_items_show_tab_col_btn\"]")).click();
    }
            @Step
            public void checkAddedEqipItem(){
                waits_asserts.waitForClickableByXpath(driver,"//*[@id=\"equipment_items_tab_col\"]/span/span[1]");
                waits_asserts.assertTextByXpath(driver,"//*[@id=\"equipment_items_tab_col\"]/span/span[1]","Equipment Items");
                driver.findElement(By.xpath("//*[@id=\"equipment_items_tab_col\"]/span/span[1]")).click();
                waits_asserts.sleep(1000);
                driver.findElement(By.xpath("//*[@id=\"equipment_items_tab_col\"]/span/span[1]")).click();
                waits_asserts.sleep(1000);
            }
            @Step
            public void dismissEquipmetnItem(){
                waits_asserts.assertTextByXpath(driver,"//*[@id=\"equipment_items_show_tab_col_btn\"]/div/div/div","Equipment Items");
                driver.findElement(By.xpath("//*[@id=\"equipment_items_show_tab_col_btn\"]")).click();
            }
}