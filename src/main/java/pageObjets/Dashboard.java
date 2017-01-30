package pageObjets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;
import utils.WebDriverManager;
import utils.WaitsAsserts;

/**
 * Created by User on 27.01.2017.
 */
public class Dashboard {
    WaitsAsserts waits_asserts = new WaitsAsserts();

    public WebDriver driver;

    public Dashboard(){this.driver = WebDriverManager.getDriver();}
@Step
    public void openAdministration(){
    driver.findElement(new By.ByXPath("//*[@id=\"root\"]/div/div[4]/div/div/div[1]/div/div/div[1]/div[5]/span/div/div")).click();

}
@Step
    public void openUserList(){
    driver.findElement(new By.ByXPath("//*[@id=\"root\"]/div/div[4]/div/div/div[1]/div/div/div[1]/div[5]/div/div[2]/span/div/div")).click();
}
@Step
    public void checkOutFilters(){
    //open menu
    driver.findElement(new By.ByXPath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[1]/span/div/button")).click();
    waits_asserts.sleep(5000);
}
@Step
public void addOrDissmissServices(){
    //open menu
    driver.findElement(new By.ByXPath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[1]/span/div/button")).click();
    //wait for Service
    waits_asserts.waitForClickableByXpath(driver,"/html/body/div[5]/div/div/div/div/div/div[5]/span/div/div");
    //add new column service
    driver.findElement(new By.ByXPath("/html/body/div[5]/div/div/div/div/div/div[5]/span/div/div")).click();

}
@Step
    public void addOrDIsmissUpdatedAt(){
    //open menu
    driver.findElement(new By.ByXPath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[1]/span/div/button")).click();
    //wait for Service
    waits_asserts.waitForClickableByXpath(driver,"/html/body/div[5]/div/div/div/div/div/div[6]/span/div/div/span");
    //add new column service
    driver.findElement(new By.ByXPath("/html/body/div[5]/div/div/div/div/div/div[6]/span/div/div/span")).click();
}
}
