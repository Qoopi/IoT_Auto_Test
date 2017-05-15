package mechanics.ui.pageObjets.administration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;
import mechanics.ui.utils.WaitsAsserts;
import mechanics.ui.utils.WebDriverManager;

public class Requests {
    private WaitsAsserts waits_asserts = new WaitsAsserts();
    private WebDriver driver;

    public Requests() {
        this.driver = WebDriverManager.getDriver();
    }


    @Step("Checking out requests")
    public void checkRequest() {
        //Check out if there is expected user
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[2]/table/tbody/tr/td[2]", "Oleg Kutafin");
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[2]/table/tbody/tr/td[3]", "geloksmmm@gmail.com");
    }

    @Step("Accept new User")
    public void acceptUser() {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[2]/table/tbody/tr/td[1]/div/input")).click();
        waits_asserts.waitForClickableByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[2]/span/div/div/div/button/div/div");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[2]/span/div/div/div/button/div/div")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[2]/span/div[2]/div[1]/div[1]/span[2]/div/button/div/div/i")).click();
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[2]/table/tbody/tr/td", "Table is empty");
    }
}
