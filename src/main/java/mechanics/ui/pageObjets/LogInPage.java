package mechanics.ui.pageObjets;

import mechanics.system.constant.AssembledUrls;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.allure.annotations.Step;
import mechanics.system.readers.Credentials;
import mechanics.ui.utils.SessionStorage;
import mechanics.ui.utils.WaitsAsserts;
import mechanics.ui.utils.WebDriverManager;

import java.util.HashMap;

import static mechanics.system.http.RequestSender.awsCredentials;


public class LogInPage {
    private WaitsAsserts waits_asserts = new WaitsAsserts();
    private WebDriver driver;

    private String mail = null;
    private String pass = null;

    public LogInPage() {
        this.driver = WebDriverManager.getDriver();
        Credentials credentials = new Credentials();
        HashMap<String, String> map = credentials.getCredentials();

        mail = map.get("test_email");
        pass = map.get("test_password");
    }


    @Step("Get on Start Page")
    public void getToIoTPage() {
        // open start page
        driver.get(AssembledUrls.redirectClientURI);                    //dev
        //driver.get("https://dashboard.wstaging.iotsyst.com");              // stage

        // checking out that we are ou the right page
        waits_asserts.assertByTitle(driver, "IoT Systems App");
    }

    @Step("Get on Start Page")
    public void getToIoTPageLoad() {
        // open start page
        driver.get(AssembledUrls.redirectClientURI);                    //load

        // checking out that we are ou the right page
        waits_asserts.assertByTitle(driver, "IoT Systems App");
    }

    @Step("Authorise with Google Acc, as admin")
    public void enterGoogleCred() {
        //Click on button "Login with Google acc"

        waits_asserts.assertXpathVisible(driver, "//*[@id=\"btn-google\"]");
        driver.findElement(By.xpath("//*[@id=\"btn-google\"]")).click();

        //Google acc login
        waits_asserts.assertXpathVisible(driver, "//*[@id=\"identifierId\"]");
        driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys(mail);

        waits_asserts.assertXpathVisible(driver, "//*[@id=\"identifierNext\"]/content/span");
        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/content/span")).click();

        driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys(pass);

        waits_asserts.assertXpathVisible(driver, "//*[@id=\"passwordNext\"]/content/span");
        driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/content/span")).click();

//        //comment these 3 lines after travis success
//        //these steps for entering recovery email, when google wants you to confirm your identity
//        //only for accounts with recovery emails and without phone number
//        driver.findElement(By.xpath("//*[@name=\"email\"]")).click();
//        driver.findElement(By.xpath("//*[@name=\"email\"]")).sendKeys("geloksmmm@gmail.com");
//        driver.findElement(By.id("submit")).click();

        //Check where we are
        waits_asserts.assertTextByXpath(driver, "//*[@id=\"naviCrumb\"]", "Dashboard");
    }

    @Step("Authorise with second Google Acc, as regular user")
    public void enterGoogleCred2() {
        //Click on button "Login with Google acc"|
        driver.findElement(By.xpath("//*[@id=\"btn-google\"]")).click();
        //Google acc login
        driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys(mail);
        driver.findElement(By.xpath("//*[@id=\"next\"]")).click();
        waits_asserts.waitForVisibilityByCSS(driver, "#Passwd");
        driver.findElement(By.cssSelector("#Passwd")).sendKeys(pass);
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
        driver.get(AssembledUrls.redirectClientURI+"#/?_k=1ccout");
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
