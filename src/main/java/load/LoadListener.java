package load;

import org.apache.commons.io.output.TeeOutputStream;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ui.pageObjets.LogInPage;
import ui.utils.WaitsAsserts;
import ui.utils.WebDriverFactory;
import ui.utils.WebDriverManager;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class LoadListener implements ITestListener {
    FileOutputStream fos = null;

    @Override
    public void onTestStart(ITestResult iTestResult) {
        gatlingInfoPrintUserStart();
//        System.out.println("============Test started============");
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        gatlingInfoPrintUserEnd();
//        System.out.println("============Test passed successful============");
    }


    @Override
    public void onTestFailure(ITestResult tr) {
        gatlingInfoPrintUserEnd();
//        System.out.println("============Test failed============");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        gatlingInfoPrintUserEnd();
//        System.out.println("============Test skipped============");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        gatlingInfoPrintUserEnd();
//        System.out.println("======Test failed, but that the expected result=======");
    }

    @Override
    public void onStart(ITestContext iTestContext) {
//        System.out.println("============Starting testing process============");
        //for browser launch
        String browserName = iTestContext.getCurrentXmlTest().getParameter("browserName");
        String useGrid = iTestContext.getCurrentXmlTest().getParameter("useGrid");
        Boolean boo = useGrid.contentEquals("true");
        WebDriver driver = WebDriverFactory.createInstance(browserName, boo);
        WebDriverManager.setWebDriver(driver);

        getCreds();

        try {
            fos = new FileOutputStream("loadReports/simulation.log");
            TeeOutputStream myOut = new TeeOutputStream(System.out, fos);
            PrintStream ps = new PrintStream(myOut);
            System.setOut(ps);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String name = "RecordedSimulation1";
        String nameof = "recordedsimulation1";
        System.out.println("RUN\t"+name+"\ts\t"+nameof+"\t"+System.currentTimeMillis()+"\ts\t2.0");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
//        System.out.println("==========Finishing testing process ============");
        //for browser
        WebDriver driver = WebDriverManager.getDriver();
        WaitsAsserts waits = new WaitsAsserts();
        waits.sleep(5000);
        if (driver != null) {
            driver.quit();
        }


        try {
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getCreds(){
        LogInPage log = new LogInPage();
        log.getToIoTPage();
        log.enterGoogleCred();
        log.getRequestSigns();
        RequestManager requestManager = new RequestManager();
        requestManager.writeCredsTofile();
        requestManager.setUpBaseApiGateway();
    }

    public void gatlingInfoPrintRun(){
        // RUN     | NAME | s      | nameof?   | TIMESTART | s | 2.0
        String name = "RecordedSimulation1";
        String nameof = "recordedsimulation1";
//            String timestart = "1490170460541";
        System.out.println("RUN\t"+name+"\ts\t"+nameof+"\t"+System.currentTimeMillis()+"\ts\t2.0");
    }

    private void gatlingInfoPrintUserStart(){
        // USER    | NAME | THREAD | START/END | TIMESTART | TIMESTART(onstart)/TIMESTOP(onstop)
        String name = "RecordedSimulation1";
        long thread = Thread.currentThread().getId();
        long timeStart = System.currentTimeMillis();
        String timeEnd = "1490170480541";

        System.out.println("USER\t"+name+"\t"+thread+"\tSTART\t"+timeStart+"\t"+timeStart);
    }

    private void gatlingInfoPrintUserEnd(){
        // USER    | NAME | THREAD | START/END | TIMESTART | TIMESTART(onstart)/TIMESTOP(onstop)
        String name = "RecordedSimulation1";
        long thread = Thread.currentThread().getId();
        long timeStart = System.currentTimeMillis();
        long timeEnd = System.currentTimeMillis();

        System.out.println("USER\t"+name+"\t"+thread+"\tEND\t"+timeStart+"\t"+timeEnd);
    }
}