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

    public boolean checkActiveCSS(WebDriver driver, String css){
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        boolean exists = !driver.findElements(By.cssSelector(css)).isEmpty();
        System.out.println(exists + " <====> " + css);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        return exists;
    }
}
