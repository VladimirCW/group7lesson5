package test.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import test.java.helpers.Screenshot;

public class TestBaseSetup {

    protected WebDriver driver;

    @BeforeMethod
    public void beforeMethod(ITestContext iTestContext) {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--window-size=1300,1080");
        driver = new ChromeDriver(chromeOptions);
        iTestContext.setAttribute("driver", driver);
    }

    @AfterMethod
    public void afterMethod(ITestResult testResult) {
        /*Screenshot screenshot = new Screenshot(driver);
        screenshot.makeScreenshot(testResult);*/
        driver.quit();
    }
}
