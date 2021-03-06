package test.java.lesson9;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.TestBaseSetup;
import test.java.helpers.RetryAnalyzer;
import test.java.po.HomePage;
import test.java.po.SearchResult;
import test.java.po.TodaysDeals;

import static org.testng.Assert.assertTrue;

@Epics({
        @Epic("Cart"),
        @Epic("Login")
})
@Features({
        @Feature("Add to cart"),
        @Feature("Login with USA user")
})
public class B_IphonePriceFromTo extends TestBaseSetup {
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

    @Flaky
    @Owner("Vova")
    @Description("sddadasdadsdasdasdasd\nfdsfsdfsdfsdfsdfdsf\nasdsadsadasdasdasd")
    @Link("https://example.org")
    @Link(name = "allure", type = "mylink")
    @TmsLink("http://tms.com/AAA-123")
    @Issue("http://jira.com/III-123")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Add phone to the cart")
    @Test
    public void test1() {
        homePage
                .open()
                .clickTodaysDeal();
        todaysDeals
                .clickCheckbox()
                .clickLogo();
        homePage
                .selectLanguage("Deutsch - DE")
                .selectLanguage("English - EN")
                .setSearch("Samsung")
                .setSearch("iPhone")
                .setSearch("Phone")
                .clickSearch();
        searchResult
                .setMinPrice("10")
                .setMaxPrice("11")
                .clickGo();

        String actualPriceAsString = searchResult.getFirstResultPrice()
                .replace("\n", ".")
                .replace("$", "");
        float actualPrice = Float.parseFloat(actualPriceAsString);
        assertTrue(
                actualPrice > 10.00 && actualPrice < 11.00,
                String.format("Expected actual price '%s' to be more than 10 and less than 11", actualPrice));
    }
}
