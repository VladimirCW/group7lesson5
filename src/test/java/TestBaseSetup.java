package test.java;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
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
        FirefoxOptions ffOptions = new FirefoxOptions();


        //driver = new ChromeDriver(chromeOptions);
        try {
            driver = new RemoteWebDriver(
                    new URL("http://127.0.0.1:4444/wd/hub"),
                    System.getProperty("browser").equals("chrome") ? chromeOptions : ffOptions
            );
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        iTestContext.setAttribute("driver", driver);
    }

    @AfterMethod
    public void afterMethod(ITestResult testResult) {
        /*Screenshot screenshot = new Screenshot(driver);
        screenshot.makeScreenshot(testResult);*/
        saveScreenshot();
        saveText();
        driver.quit();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot() {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment
    public String saveText() {
        return "Hello - I am a string attachment";
    }
}
