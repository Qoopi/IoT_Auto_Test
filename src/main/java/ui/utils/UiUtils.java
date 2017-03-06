package ui.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static ui.utils.WaitsAsserts.sleep;

public class UiUtils {

    public void makeScreenshot(WebDriver driver, String name){
        sleep(1000);
        File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screen, new File("/target/screenshots/"+ getTime() +"/"+name+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void scrollPageUp(WebDriver driver){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0, -250);");
    }
    public String getTime(){
        DateFormat dateFormat = new SimpleDateFormat("(dd.MM.yyyy) HH-mm-ss");
        Date date = new Date();
        String today = dateFormat.format(date);
        return today;
    }

    public void menuReports(){
        String reportsTitleActive = "//*[@id=\"report_title_show_tab_col_btn\"]/div/div/svg";
        String reportsScheduleActive = "//*[@id=\"report_schedule_show_tab_col_btn\"]/div/div/svg";
        String equipmentItemsActive = "//*[@id=\"equipment_items_show_tab_col_btn\"]/div/div/svg";
        String recipientsActive = "//*[@id=\"recipients_show_tab_col_btn\"]/div/div/svg";
        String excelIncludedActive = "//*[@id=\"excel_included_show_tab_col_btn\"]/div/div/svg";
    }

    public boolean checkActive(WebDriver driver, String xpath){
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        System.out.println(xpath);
        boolean exists = !driver.findElements(By.xpath(xpath)).isEmpty();
        System.out.println(exists);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        return exists;
    }
}
