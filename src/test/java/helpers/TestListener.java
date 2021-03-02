package test.java.helpers;

import org.openqa.selenium.WebDriver;
import org.testng.*;

public class TestListener implements ISuiteListener, ITestListener, IInvokedMethodListener {

    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

    }

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

    }

    @Override
    public void onStart(ISuite iSuite) {
        //System.out.println("Suite started");
    }

    @Override
    public void onFinish(ISuite iSuite) {
        //System.out.println("Suite finished");
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        //System.out.println("Test started");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        WebDriver driver = (WebDriver) iTestResult.getTestContext().getAttribute("driver");
        Screenshot screenshot = new Screenshot(driver);
        screenshot.makeScreenshot(iTestResult);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        //System.out.println("Test started");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        //System.out.println("Test finished");
    }
}
