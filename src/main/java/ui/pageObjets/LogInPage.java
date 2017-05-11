package ui.pageObjets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.allure.annotations.Step;
import system.readers.CredentialCenter;
import ui.utils.SessionStorage;
import ui.utils.WaitsAsserts;
import ui.utils.WebDriverManager;

import java.util.HashMap;

import static system.constant.URLs.*;
import static system.http.RequestSender.awsCredentials;


public class LogInPage {
    private WaitsAsserts waits_asserts = new WaitsAsserts();
    private WebDriver driver;

    private String mail = null;
    private String mail2 = null;
    private String pass = null;
    private String pass2 = null;

    public LogInPage() {
        this.driver = WebDriverManager.getDriver();
        CredentialCenter credentialCenter = new CredentialCenter();
        HashMap<String, String> map = credentialCenter.readEnv();

        mail = map.get("email");
        pass = map.get("password");
        mail2 = map.get("email2");
        pass2 = map.get("password2");

        System.out.println(mail);
        System.out.println(mail2);
    }


    @Step("Get on Start Page")
    public void getToIoTPage() {
        // open start page
        driver.get(HttpsDashboardDev.getValue());                    //dev
        //driver.get("https://dashboard.wstaging.iotsyst.com");              // stage

        // checking out that we are ou the right page
        waits_asserts.assertByTitle(driver, "IoT Systems App");
    }

    @Step("Get on Start Page")
    public void getToIoTPageLoad() {
        // open start page
        driver.get(HttpsLoadDashboardApp.getValue());                    //load

        // checking out that we are ou the right page
        waits_asserts.assertByTitle(driver, "IoT Systems App");
    }

    @Step("Authorise with Google Acc, as admin")
    public void enterGoogleCred() {
        //Click on button "Login with Google acc"|
//        driver.findElement(By.xpath("//*[@id=\"grey-background\"]/div[2]/div/div/div[3]/div/div[2]/div/a/div")).click();

        waits_asserts.assertXpathVisible(driver, "//*[@id=\"btn-google\"]");
        driver.findElement(By.xpath("//*[@id=\"btn-google\"]")).click();

        //Google acc login
//        driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys(mail);

        waits_asserts.assertXpathVisible(driver, "//*[@id=\"identifierId\"]");
        driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys(mail2);

//        driver.findElement(By.xpath("//*[@id=\"next\"]")).click();

        waits_asserts.assertXpathVisible(driver, "//*[@id=\"identifierNext\"]/content/span");
        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/content/span")).click();

        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"Passwd\"]");
        driver.findElement(By.xpath("//*[@id=\"Passwd\"]")).sendKeys(pass2);
//        waits_asserts.waitForVisibilityByXpath(driver, "//*[@id=\"password\"]/div[1]/div/div[1]/div");
//        waits_asserts.assertXpathVisible(driver, "//*[@id=\"password\"]/div[1]/div/div[1]/div");
//        driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys(pass2);
//        driver.findElement(By.xpath("//*[@id=\"signIn\"]")).click();

        //delete this, after travis success
//        driver.findElement(By.xpath("//*[@id=\"challenge\"]/content/div/div[2]/input")).sendKeys("geloksmmm@gmail.com");

        waits_asserts.assertXpathVisible(driver, "//*[@id=\"passwordNext\"]/content/span");
        driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/content/span")).click();



        //Checkout of where we are
        //waits_asserts.assertTextByXpath(driver, "//*[@id=\"root\"]/div/div[1]/div/div[3]/div/div[2]/div[1]/div/p[2]/span", "Administrator");
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"naviCrumb\"]", "Dashboard");
    }

    @Step("Authorise with second Google Acc, as regular user")
    public void enterGoogleCred2() {
        //Click on button "Login with Google acc"|
        driver.findElement(By.xpath("//*[@id=\"grey-background\"]/div[2]/div/div/div[3]/div/div[2]/div/a/div")).click();
        //Google acc login
        driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys(mail2);
        driver.findElement(By.xpath("//*[@id=\"next\"]")).click();
        waits_asserts.waitForVisibilityByCSS(driver, "#Passwd");
        driver.findElement(By.cssSelector("#Passwd")).sendKeys(pass2);
        driver.findElement(By.xpath("//*[@id=\"signIn\"]")).click();
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"naviCrumb\"]", "Dashboard");
    }

    @Step("Refresh browser")
    public void refresh() {
        driver.navigate().refresh();
    }

    @Step("Driver close and get new")
    public void openNewDriver() {
        driver.close();
        WebDriver driver = new ChromeDriver();
        driver.get(HttpsDashboardDev.getValue("/#/?_k=1ccout"));
    }

    @Step("Get back on log in page ")
    public void goToLogInPage() {
        driver.findElement(By.xpath("//*[@id=\"grey-background\"]/div[2]/div/div/div[3]/div/div[2]/a/span")).click();
    }

    @Step("Authorise with AWS")
    public void autoriseWithAWS() {
        driver.findElement(By.xpath("//*[@id=\"grey-background\"]/div[2]/div/div/div[3]/div/div[1]/div/a/div/div")).click();

        driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys(mail);
        driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys(pass);
        driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"root\"]/div/div[1]/div/div[3]/div/div[2]/div[1]/div/p[2]/span", "Regular");
    }

    public void getRequestSigns(){
        //get system.aws credential from browser session storage after login and write to system.aws credential storage
        SessionStorage sessionStorage = new SessionStorage(driver);
        String accessKey = sessionStorage.getItemFromSessionStorage("access_key_id");
        String secretKey = sessionStorage.getItemFromSessionStorage("secret_access_key");
        String token = sessionStorage.getItemFromSessionStorage("session_token");

        awsCredentials.setAccessKeyId(accessKey);
        awsCredentials.setSecretAccessKey(secretKey);
        awsCredentials.setSessionToken(token);

        //close browser (for load tests we don't need it anymore)
        driver.quit();
    }

}
