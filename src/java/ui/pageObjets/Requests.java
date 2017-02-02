package ui.pageObjets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;
import ui.utils.WaitsAsserts;
import ui.utils.WebDriverManager;

public class Requests {
    private WaitsAsserts waits_asserts = new WaitsAsserts();
    private WebDriver driver;

    public Requests() {this.driver = WebDriverManager.getDriver();}



    @Step("Chcking out reuests")
    public  void checkRequest(){
        //Check out if there is expected user
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[2]/table/tbody/tr/td[2]","Oleg Kutafin");
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[2]/table/tbody/tr/td[3]","geloksmmm@gmail.com");
    }
    @Step
    public void acceptUser(){
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[2]/table/tbody/tr/td[5]/div/button/div/span")).click();
        waits_asserts.waitForClickableByXpath(driver,"/html/body/div[5]/div/div/div/div/div/div[1]/span/div/div");
        driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div/div/div[1]/span/div/div")).click();
        waits_asserts.assertTextByXpath(driver,"//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div/div[3]/div[2]/table/tbody/tr/td","Table is empty");
    }
}
