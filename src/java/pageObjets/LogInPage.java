package pageObjets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;
import utils.WebDriverManager;
import utils.WaitsAsserts;

public class LogInPage {
    WaitsAsserts  waits_asserts = new WaitsAsserts();

    public WebDriver driver;

   public LogInPage(){this.driver = WebDriverManager.getDriver();}

    @Step("autoriseGoogle")
    public void autoriseWithGoogle(){

        // open start page
        driver.get("https://dashboard.dev.iotsyst.com/"); //dev
        //driver.get("https://dashboard.wstaging.iotsyst.com"); // stage
        // cheking out that we are ou the right page
        String title = "IoT Systems App"; // Expected title
        waits_asserts.assertByTitle(driver, title);
        //Click on button "Login with Google acc"|
        driver.findElement(new By.ByXPath("//*[@id=\"grey-background\"]/div[2]/div/div/div[3]/div/div[2]/div/a/div")).click();
        //Google acc login
        driver.findElement(new By.ByXPath("//*[@id=\"Email\"]")).sendKeys("kov.ossystem@gmail.com");
        driver.findElement(new By.ByXPath("//*[@id=\"next\"]")).click();
        driver.findElement(new By.ByXPath("//*[@id=\"Passwd\"]")).sendKeys("q125478963Q");
        driver.findElement(new By.ByXPath("//*[@id=\"signIn\"]")).click();
//        checkout admin acc
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"root\"]/div/div[1]/div/div[3]/div/div[2]/div[1]/div/p[2]/span","Administrator");



    }
    @Step("autoriseAWS")
    public void autoriseWithAWS(){

    }

}
