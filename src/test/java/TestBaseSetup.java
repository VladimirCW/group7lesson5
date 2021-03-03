package test.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import test.java.helpers.Screenshot;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBaseSetup {

    protected WebDriver driver;

    @BeforeMethod
    public void beforeMethod(ITestContext iTestContext) {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--window-size=1300,1080");


        //driver = new ChromeDriver(chromeOptions);
        try {
            driver = new RemoteWebDriver(new URL("http://ec2-3-133-59-40.us-east-2.compute.amazonaws.com:4444/wd/hub"), chromeOptions);
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
