package api;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import system.http.RequestSender;
import ui.pageObjets.LogInPage;
import ui.utils.WaitsAsserts;
import ui.utils.WebDriverFactory;
import ui.utils.WebDriverManager;

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
        String browserName = context.getCurrentXmlTest().getParameter("browserName");
        String useGrid = context.getCurrentXmlTest().getParameter("useGrid");
        Boolean boo = useGrid.contentEquals("true");
        WebDriver driver = WebDriverFactory.createInstance(browserName, boo);
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
        log.enterGoogleCred2();
        log.getRequestSigns();
        RequestManagerAPI requestManager = new RequestManagerAPI();
        requestManager.setUpBaseApiGateway();
    }

}
