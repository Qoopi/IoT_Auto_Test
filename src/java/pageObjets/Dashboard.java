package pageObjets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;
import utils.WebDriverManager;
import utils.WaitsAsserts;

/**
 * Created by User on 27.01.2017.
 */
public class Dashboard {
    WaitsAsserts waits_asserts = new WaitsAsserts();

    public WebDriver driver;

    public Dashboard() {
        this.driver = WebDriverManager.getDriver();
    }

    @Step
    public void openAdministration() {
        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[1]/div/div/div[1]/div[5]/span/div/div");
        driver.findElement(new By.ByXPath("//*[@id=\"root\"]/div/div[4]/div/div/div[1]/div/div/div[1]/div[5]/span/div/div")).click();
    }

}