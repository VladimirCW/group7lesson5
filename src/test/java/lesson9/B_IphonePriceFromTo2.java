package test.java.lesson9;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.TestBaseSetup;
import test.java.helpers.RetryAnalyzer;
import test.java.po.HomePage;
import test.java.po.SearchResult;
import test.java.po.TodaysDeals;

import static org.testng.Assert.assertTrue;

public class B_IphonePriceFromTo2 extends TestBaseSetup {
    HomePage homePage;
    TodaysDeals todaysDeals;
    SearchResult searchResult;

    @BeforeMethod
    public void setUp() {
        homePage = new HomePage(driver);
        todaysDeals = new TodaysDeals(driver);
        searchResult = new SearchResult(driver);
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.MILLISECONDS);
//        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    @Test
    public void test1(String dpValue) throws InterruptedException {
        System.out.println("DP value is: " + dpValue);
        Thread.sleep(15000);
        homePage
                .open()
                .clickTodaysDeal();
        assertTrue(false);
    }
}
