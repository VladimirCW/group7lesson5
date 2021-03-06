package test.java.lesson9;

import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.java.TestBaseSetup;
import test.java.helpers.RetryAnalyzer;
import test.java.po.HomePage;
import test.java.po.SearchResult;
import test.java.po.TodaysDeals;

import static org.testng.Assert.assertTrue;

@Epic("Cart")
@Feature("Remove")
public class B_IphonePriceFromTo2 extends TestBaseSetup {
    HomePage homePage;
    TodaysDeals todaysDeals;
    SearchResult searchResult;

    @BeforeMethod
    public void setUp() {
        homePage = new HomePage(driver);
        todaysDeals = new TodaysDeals(driver);
        searchResult = new SearchResult(driver);
    }

    @TmsLinks({
            @TmsLink("http://jira.com/III-124"),
            @TmsLink("http://jira.com/III-125")
    })
    @Owner("Petya")
    @Severity(SeverityLevel.NORMAL)
    @Story("Remove single product")
    @Test
    public void parametrizedMethod(String param) {
        System.out.println("================================== Param: " + param);
        homePage
                .open()
                .clickTodaysDeal();
        assertTrue(true);
    }
}
