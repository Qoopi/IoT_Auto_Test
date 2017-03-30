package load;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ui.pageObjets.LogInPage;
import ui.utils.WaitsAsserts;
import ui.utils.WebDriverFactory;
import ui.utils.WebDriverManager;

public class LoadListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("============Test started============");
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        System.out.println("============Test passed successful============");
    }


    @Override
    public void onTestFailure(ITestResult tr) {
        System.out.println("============Test failed============");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("============Test skipped============");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("======Test failed, but that the expected result=======");
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("============Starting testing process============");
        //for browser launch
        String browserName = iTestContext.getCurrentXmlTest().getParameter("browserName");
        String useGrid = iTestContext.getCurrentXmlTest().getParameter("useGrid");
        Boolean boo = useGrid.contentEquals("true");
        WebDriver driver = WebDriverFactory.createInstance(browserName, boo);
        WebDriverManager.setWebDriver(driver);

        getCreds();
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("==========Finishing testing process ============");
        //for browser
        WebDriver driver = WebDriverManager.getDriver();
        WaitsAsserts waits = new WaitsAsserts();
        waits.sleep(5000);
        if (driver != null) {
            driver.quit();
        }
    }

    public void getCreds(){
        LogInPage log = new LogInPage();
        log.getToIoTPage();
        log.enterGoogleCred();
        log.getRequestSigns();
        RequestManager requestManager = new RequestManager();
        requestManager.writeCredsTofile();
        requestManager.setUpBaseApiGateway();
    }
}