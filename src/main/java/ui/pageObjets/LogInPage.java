package ui.pageObjets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.allure.annotations.Step;
import ui.utils.WebDriverFactory;
import ui.utils.WebDriverManager;
import ui.utils.WaitsAsserts;

import java.net.URL;

public class LogInPage {
    private WaitsAsserts  waits_asserts = new WaitsAsserts();

    private WebDriver driver;

   public LogInPage(){this.driver = WebDriverManager.getDriver();}
    private String mail = "kov.ossystem@gmail.com";
    private String mail2 = "geloksmmm@gmail.com";
    private String pass = "q125478963Q";
    private String pass2 = "Q125478963q";


    @Step("Get on Start Page")
    public void getToIoTPage(){
        // open start page
        driver.get("https://dashboard.dev.iotsyst.com/");                    //dev
        //driver.get("https://dashboard.wstaging.iotsyst.com");              // stage

        // checking out that we are ou the right page
        waits_asserts.assertByTitle(driver, "IoT Systems App");
    }

    @Step("Authorise with Google Acc, as admin")
    public void enterGoogleCred() {
            //Click on button "Login with Google acc"|
            driver.findElement(By.xpath("//*[@id=\"grey-background\"]/div[2]/div/div/div[3]/div/div[2]/div/a/div")).click();
            //Google acc login
            driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys(mail);
            driver.findElement(By.xpath("//*[@id=\"next\"]")).click();
            //driver.findElement(By.xpath("//*[@id=\"Passwd\"]")).sendKeys(pass);
            driver.findElement(By.cssSelector("#Passwd")).sendKeys(pass);
            driver.findElement(By.xpath("//*[@id=\"signIn\"]")).click();
            //Checkout of where we are
            waits_asserts.assertTextByXpath(driver, "//*[@id=\"root\"]/div/div[1]/div/div[3]/div/div[2]/div[1]/div/p[2]/span", "Administrator");
            waits_asserts.assertTextByXpath(driver, "//*[@id=\"naviCrumb\"]", "Dashboard");
        }

    @Step("Authorise with second Google Acc, as regular")
    public void enterGoogleCred2() {
        //Click on button "Login with Google acc"|
        driver.findElement(By.xpath("//*[@id=\"grey-background\"]/div[2]/div/div/div[3]/div/div[2]/div/a/div")).click();
        //Google acc login
        driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys(mail2);
        driver.findElement(By.xpath("//*[@id=\"next\"]")).click();
        //driver.findElement(By.xpath("//*[@id=\"Passwd\"]")).sendKeys(pass2);
        driver.findElement(By.cssSelector("#Passwd")).sendKeys(pass2);
        driver.findElement(By.xpath("//*[@id=\"signIn\"]")).click();
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"naviCrumb\"]", "Dashboard");
    }
    @Step("Refresh browser")
    public void refresh(){driver.navigate().refresh();}

    @Step("Driver close and get new")
    public void openNewDriver(){
        driver.close();
        WebDriver driver = new ChromeDriver();
        driver.get("https://dashboard.dev.iotsyst.com/#/?_k=1ccout");
    }

    @Step("Get back on log in page ")
    public void goToLogInPage(){
        driver.findElement(By.xpath("//*[@id=\"grey-background\"]/div[2]/div/div/div[3]/div/div[2]/a/span")).click();
    }

    @Step("Authorise with AWS")
    public void autoriseWithAWS(){
        driver.findElement(By.xpath("//*[@id=\"grey-background\"]/div[2]/div/div/div[3]/div/div[1]/div/a/div/div")).click();

        driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys(mail);
        driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys(pass);
        driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"root\"]/div/div[1]/div/div[3]/div/div[2]/div[1]/div/p[2]/span", "Regular");
    }

}
