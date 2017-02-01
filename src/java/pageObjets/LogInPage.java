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
    String mail = "kov.ossystem@gmail.com";
    String pass = "q125478963Q";


    @Step("Get on Start Page")
    public void getToIoTPage(){
        // open start page
        driver.get("https://dashboard.dev.iotsyst.com/");                    //dev
        //driver.get("https://dashboard.wstaging.iotsyst.com");              // stage

        // cheking out that we are ou the right page
        waits_asserts.assertByTitle(driver, "IoT Systems App");
    }

    @Step("Autorise with Google Acc")
                public void enterGoogleCred() {
            //Click on button "Login with Google acc"|
            driver.findElement(new By.ByXPath("//*[@id=\"grey-background\"]/div[2]/div/div/div[3]/div/div[2]/div/a/div")).click();
            //Google acc login
            driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys(mail);
            driver.findElement(By.xpath("//*[@id=\"next\"]")).click();
            driver.findElement(By.xpath("//*[@id=\"Passwd\"]")).sendKeys(pass);
            driver.findElement(By.xpath("//*[@id=\"signIn\"]")).click();
            //Checkout of where we are
            waits_asserts.assertTextByXpath(driver, "//*[@id=\"root\"]/div/div[1]/div/div[3]/div/div[2]/div[1]/div/p[2]/span", "Administrator");
        }


    @Step("Autorise with AWS")
    public void autoriseWithAWS(){

    }

}
