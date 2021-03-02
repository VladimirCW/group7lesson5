package test.java.helpers;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 1;
    private final int COUNTER = 2;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if(retryCount < COUNTER) {
            retryCount++;
            return true;
        } else  {
            return false;
        }
    }
}
