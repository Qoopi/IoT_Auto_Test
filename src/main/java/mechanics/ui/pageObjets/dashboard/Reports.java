package mechanics.ui.pageObjets.dashboard;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;
import mechanics.ui.utils.UiUtils;
import mechanics.ui.utils.WaitsAsserts;
import mechanics.ui.utils.WebDriverManager;

public class Reports {
    private WaitsAsserts waits_asserts = new WaitsAsserts();
    private UiUtils utils = new UiUtils();
    private WebDriver driver;

    public Reports() {
        this.driver = WebDriverManager.getDriver();
    }

             /*Проверка стандартных колонок таблицы Reports*/

    @Step("Check out Report Title column|+sort")
    public void checkReportTitleColumn() {
        String reportColumn = "//*[@id=\"report_title_tab_col\"]/span/span[1]";
        waits_asserts.assertTextByXpath(driver, reportColumn, "Report title");
        driver.findElement(By.xpath(reportColumn)).click();
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath(reportColumn)).click();
    }

    @Step("Check out Report Schedule column|+sort")
    public void checkReportScheduleColumn() {
        String reportScheduleColumn = "//*[@id=\"report_schedule_tab_col\"]/span/span[1]";
        waits_asserts.assertTextByXpath(driver, reportScheduleColumn, "Report schedule");
        driver.findElement(By.xpath(reportScheduleColumn)).click();
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath(reportScheduleColumn)).click();
    }

            /*Проверка дополнительных колонок в таблице*/

    @Step("Check out Report Title column in drop down menu")
    public void checkReportTitleColumnInDropDownMenu() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"report_title_show_tab_col_btn\"]/div/div/div", "Report title");
    }

    @Step("Check out Report Schedule column in drop down menu")
    public void checkReportScheduleColumnInDropDownMenu() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"report_schedule_show_tab_col_btn\"]/div/div/div", "Report schedule");
    }

    @Step("Check out Equipment Items column in drop down menu")
    public void checkEquipmentItemsColumnInDropDownMenu() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"equipment_items_show_tab_col_btn\"]/div/div/div", "Equipment items");
    }

    @Step("Check out Recipients column in drop down menu")
    public void checkRecipientsColumnInDropDownMenu() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"recipients_show_tab_col_btn\"]/div/div/div", "Recipients");
    }

    @Step("Check out Excel Include column in drop down menu")
    public void checkExcelIncludedColumnInDropDownMenu() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"excel_included_show_tab_col_btn\"]/div/div/div", "Excel Included");
    }

            /*Добавление/удаление дополнительных колонок и проверка сортировки по ним*/

    @Step("Add Equipment Items column")
    public void addEquipmentItemColumn() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"equipment_items_show_tab_col_btn\"]/div/div/div", "Equipment items");
        driver.findElement(By.xpath("//*[@id=\"equipment_items_show_tab_col_btn\"]")).click();
        waits_asserts.sleep(1000);
    }

    @Step("Checking if the columns is presented in table")
    public void checkAddedEquipItem() {
        String equipmentColumn = "//*[@id=\"equipment_items_tab_col\"]/span/span[1]";
        waits_asserts.assertTextByXpath(driver, equipmentColumn, "Equipment items");
        waits_asserts.waitForClickableByXpath(driver, equipmentColumn);
        driver.findElement(By.xpath(equipmentColumn)).click();
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath(equipmentColumn)).click();
        waits_asserts.sleep(1000);
    }

    @Step("Deleting column")
    public void dismissEquipmentItem() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"equipment_items_show_tab_col_btn\"]/div/div/div", "Equipment items");
        driver.findElement(By.xpath("//*[@id=\"equipment_items_show_tab_col_btn\"]")).click();
        waits_asserts.sleep(1000);
    }

    @Step("Add Recipients column")
    public void addRecipients() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"recipients_show_tab_col_btn\"]/div/div/div", "Recipients");
        driver.findElement(By.xpath("//*[@id=\"recipients_show_tab_col_btn\"]")).click();
        waits_asserts.sleep(1000);
    }

    @Step("Checking if the columns is presented in table")
    public void checkAddedRecipients() {
        String recepientsColumn = "//*[@id=\"recipients_tab_col\"]/span/span[1]";
        waits_asserts.assertTextByXpath(driver, recepientsColumn, "Recipients");
        waits_asserts.waitForClickableByXpath(driver, recepientsColumn);
        driver.findElement(By.xpath(recepientsColumn)).click();
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath(recepientsColumn)).click();
        waits_asserts.sleep(1000);
    }

    @Step("Deleting Recipients column")
    public void dismissRecipients() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"recipients_show_tab_col_btn\"]/div/div/div", "Recipients");
        driver.findElement(By.xpath("//*[@id=\"recipients_show_tab_col_btn\"]")).click();
        waits_asserts.sleep(1000);
    }

    @Step("Add Excel Included column")
    public void addExcelIncluded() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"excel_included_show_tab_col_btn\"]/div/div/div", "Excel Included");
        driver.findElement(By.xpath("//*[@id=\"excel_included_show_tab_col_btn\"]")).click();
        waits_asserts.sleep(1000);
    }

    @Step("Checking if the columns is presented in table")
    public void checkAddedExcelIncluded() {
        String excelIncludedColumn = "//*[@id=\"excel_included_tab_col\"]/span/span[1]";
        waits_asserts.assertTextByXpath(driver, excelIncludedColumn, "Excel Included");
        waits_asserts.waitForClickableByXpath(driver, excelIncludedColumn);
        driver.findElement(By.xpath(excelIncludedColumn)).click();
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath(excelIncludedColumn)).click();
        waits_asserts.sleep(1000);
    }

    @Step("Deleting Excel Included column")
    public void dismissExcelIncluded() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"excel_included_show_tab_col_btn\"]/div/div/div", "Excel Included");
        driver.findElement(By.xpath("//*[@id=\"excel_included_show_tab_col_btn\"]")).click();
        waits_asserts.sleep(1000);
    }
}