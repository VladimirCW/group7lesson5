package test.java.lesson9;

import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.TestBaseSetup;
import test.java.po.HomePage;
import test.java.po.SearchResult;
import test.java.po.TodaysDeals;

import static org.testng.Assert.assertTrue;

@Epic("Payment")
@Feature("MasterCard")
public class B_IphonePriceFromTo3 extends TestBaseSetup {
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

    @Severity(SeverityLevel.MINOR)
    @Story("Negative - zero balance")
    @Test
    public void test1() {
        homePage
                .open()
                .clickTodaysDeal();
        assertTrue(false);
    }
}
