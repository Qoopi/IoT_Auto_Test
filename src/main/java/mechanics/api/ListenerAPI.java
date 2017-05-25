package mechanics.api;

import com.jayway.restassured.response.Response;
import mechanics.system.http.RequestSender;
import mechanics.system.jar.Args;
import mechanics.ui.pageObjets.LogInPage;
import mechanics.ui.utils.WaitsAsserts;
import mechanics.ui.utils.WebDriverFactory;
import mechanics.ui.utils.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Created by user on 20.04.2017.
 */
public class ListenerAPI implements ITestListener{
    @Override
    public void onTestStart(ITestResult result) {
    RequestSender.checkExpired();
    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {
        if (RequestManagerAPI.idOfCreatedNotificationRule != null) {
            RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
            Response response = requestManagerAPI.notificationRulesRead(false);
            if (response.asString().contains(RequestManagerAPI.idOfCreatedNotificationRule)){
                requestManagerAPI.notificationRuleDelete(RequestManagerAPI.idOfCreatedNotificationRule);
            }
            requestManagerAPI.notificationListDeleteAllAssertless();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        //for browser launch
        String browserName = Args.browser;
        Boolean useGrid = Args.grid;
        WebDriver driver = WebDriverFactory.createInstance(browserName, useGrid);
        WebDriverManager.setWebDriver(driver);

        getCreds();
        RequestSender.setStartDate();
    }

    @Override
    public void onFinish(ITestContext context) {
        //for browser
        WebDriver driver = WebDriverManager.getDriver();
        WaitsAsserts.sleep(5000);
        if (driver != null) {
            driver.quit();
        }
    }

    private void getCreds(){
        LogInPage log = new LogInPage();
        log.getToIoTPage();
        log.enterGoogleCred();
        log.getRequestSigns();
        RequestManagerAPI requestManager = new RequestManagerAPI();
        requestManager.setUpBaseApiGateway();
    }

}
