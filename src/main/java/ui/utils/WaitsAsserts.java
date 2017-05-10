package ui.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class WaitsAsserts {

    public static void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void  assertByTitle(WebDriver driver, String title) {
        String currentTitle = driver.getTitle();
        assertEquals(currentTitle, title);

    }
    public void assertTextNotEqualsByXpath(WebDriver driver, String xpath, String text){
        //driver.navigate().refresh();
        waitForVisibilityByXpath(driver, xpath);
        String aIssueTitle = driver.findElement(By.xpath(xpath)).getText();
        assertFalse(aIssueTitle.contains(text));
    }
    public void assertTextByXpath(WebDriver driver, String xpath, String text) {
        // driver.navigate().refresh();
        waitForVisibilityByXpath(driver, xpath);
        String anElementTile = driver.findElement(By.xpath(xpath)).getText();
        assertTrue(anElementTile.contains(text));
    }
    public void waitForVisibilityByXpath(WebDriver driver, String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, 50 );
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }
    public void waitForVisibilityByCSS(WebDriver driver, String css) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(css)));
    }
    public void waitForClickableByXpath(WebDriver driver, String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }
    public void waitForClickableByCSS(WebDriver driver, String css) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(css)));
    }
    public void assertTextByCSS(WebDriver driver, String css, String text) {
       // driver.navigate().refresh();
        waitForVisibilityByXpath(driver, css);
        String anElementTile = driver.findElement(By.cssSelector(css)).getText();
        assertTrue(anElementTile.contains(text));
    }
}