package ui.pageObjets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;
import ui.utils.WaitsAsserts;
import ui.utils.WebDriverManager;
import ui.utils.uiUtils;

public class EquipmentList {
    private WaitsAsserts waits_asserts = new WaitsAsserts();
    private uiUtils utils = new uiUtils();
    private WebDriver driver;

    public EquipmentList() {this.driver = WebDriverManager.getDriver();}

    @Step
    public void sortEquipByName() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[1]/table/thead/tr/th[2]", "Equipment name");
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[2]");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[1]/table/thead/tr/th[2]/span")).click();
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[1]/table/thead/tr/th[2]/span")).click();
    }

    @Step
    public void sortEquipById() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[1]/table/thead/tr/th[3]", "Equipment id");
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[2]");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[1]/table/thead/tr/th[3]/span")).click();
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[1]/table/thead/tr/th[3]/span")).click();
    }

    @Step
    public void sortEquipByType() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[1]/table/thead/tr/th[4]", "Equipment type");
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[2]");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[1]/table/thead/tr/th[4]/span")).click();
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[1]/table/thead/tr/th[4]/span")).click();
    }

    @Step
    public void sortEquipByGroup() {
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[1]/table/thead/tr/th[5]", "Group");
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[2]");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[1]/table/thead/tr/th[5]/span")).click();
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[1]/table/thead/tr/th[5]/span")).click();

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
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[1]/table/thead/tr/th[6]", "Updated at");
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[2]");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[1]/table/thead/tr/th[6]/span")).click();
        waits_asserts.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[1]/table/thead/tr/th[6]/span")).click();
    }
}