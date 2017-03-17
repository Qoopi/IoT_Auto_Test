package ui.utils;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WebDriverFactory {

    public static WebDriver createInstance(String browserName, Boolean useGrid) {
        URL hostURL = null;
        try {
            hostURL = new URL("http://vzhost4:4444/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        DesiredCapabilities capability = null;
        WebDriver driver = null;
        if (useGrid) {
            if (browserName.toLowerCase().contains("firefox")) {
                capability = DesiredCapabilities.firefox();
                capability.setBrowserName("firefox");
                capability.setPlatform(Platform.LINUX);
            }
            if (browserName.toLowerCase().contains("ie")) {
                capability = DesiredCapabilities.internetExplorer();
            }
            if (browserName.toLowerCase().contains("chrome")) {
                capability = DesiredCapabilities.chrome();
                capability.setBrowserName("chrome");
                capability.setPlatform(Platform.LINUX);
            }
            driver = new RemoteWebDriver(hostURL, capability);
        } else {
            if (SystemUtils.IS_OS_WINDOWS) {
                System.out.println("OS is Windows");
                if (browserName.toLowerCase().contains("firefox")) {
                    System.setProperty("webdriver.gecko.driver", "src/main/resources/base/windows/geckodriver32.exe");
                    driver = new FirefoxDriver();
                }
                if (browserName.toLowerCase().contains("ie32")) {
                    System.setProperty("webdriver.ie.driver", "IEDriverServer32.exe");
                    driver = new InternetExplorerDriver();
                }
                if (browserName.toLowerCase().contains("ie64")) {
                    System.setProperty("webdriver.ie.driver", "IEDriverServer64.exe");
                    driver = new InternetExplorerDriver();
                }

                if (browserName.toLowerCase().contains("chrome")) {
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/base/windows/chromedriver.exe");
                    driver = new ChromeDriver();
                }
                if (browserName.toLowerCase().contains("edge")) {
                    System.setProperty("webdriver.edge.driver", "src/main/resources/base/windows/MicrosoftWebDriver.exe");
                    driver = new EdgeDriver();
                }
            }
        }
        if (SystemUtils.IS_OS_LINUX) {
            System.out.println("OS is Linux");
            System.out.println("The local driver configuration for linux is not fully implemented yet ");
            if (browserName.toLowerCase().contains("chrome")) {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/base/linux/chromedriver");
                driver = new ChromeDriver();
            }
            if (browserName.toLowerCase().contains("firefox")) {
                System.setProperty("webdriver.gecko.driver", "src/main/resources/base/linux/geckodriver");
                driver = new FirefoxDriver();
            }
        }


        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
}