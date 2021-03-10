package test.java;

import com.beust.jcommander.Parameter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import test.java.helpers.Screenshot;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBaseSetup {

    protected WebDriver driver;

    @Parameters({"browser"})
    @BeforeMethod
    public void beforeMethod(ITestContext iTestContext, @Optional("chrome") String browser) {
        System.setProperty("webdriver.chrome.driver", "chromedriver");


        //driver = new ChromeDriver(chromeOptions);
        try {
            switch (browser) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--window-size=1300,1080");
                    driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), chromeOptions);
                    break;
                case "firefox":
                    FirefoxOptions ffOptions = new FirefoxOptions();
                    ffOptions.addArguments("--window-size=1300,1080");
                    driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), ffOptions);
                    break;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        iTestContext.setAttribute("driver", driver);
    }

    @AfterMethod
    public void afterMethod(ITestResult testResult) {
        /*Screenshot screenshot = new Screenshot(driver);
        screenshot.makeScreenshot(testResult);*/
        driver.quit();
    }
}
