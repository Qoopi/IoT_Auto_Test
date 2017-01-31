package utils;

/**
 * Created by User on 26.01.2017.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class WaitsAsserts {
    public static void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitForVisibilityByXpath(WebDriver driver, String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public void waitForClickableByXpath(WebDriver driver, String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }
    public static void  assertByTitle(WebDriver driver, String title) {
        String currentTitle = driver.getTitle();
        assertEquals(currentTitle, title);

    }
    public void assertTextByXpath(WebDriver driver, String XPath, String text){
        driver.navigate().refresh();
        waitForVisibilityByXpath(driver, XPath);
        String anElementTile = driver.findElement(By.xpath(XPath)).getText();
        assertTrue(anElementTile.contains(text));

    }

}