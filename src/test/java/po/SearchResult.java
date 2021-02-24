package test.java.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResult extends BasePage {

    By minInputLocator = By.xpath("//input[@placeholder='Min']");
    By maxInputLocator = By.xpath("//input[@placeholder='Max']");
    By goBtnLocator = By.xpath("//input[@class='a-button-input' and @type='submit']");
    By searchResultLocator = By.cssSelector("div[data-component-type='s-search-result']");
    By priceLocator = By.cssSelector(".a-price span[aria-hidden='true']");

    public SearchResult(WebDriver driver) {
        super(driver);
    }

    @Override
    public BasePage open() {
        driver.get("");
        return this;
    }

    public SearchResult setMinPrice(String price) {
        wait.until(ExpectedConditions.elementToBeClickable(minInputLocator));
        driver.findElement(minInputLocator).sendKeys(price);
        return this;
    }

    public SearchResult setMaxPrice(String price) {
        wait.until(ExpectedConditions.elementToBeClickable(maxInputLocator));
        driver.findElement(maxInputLocator).sendKeys(price);
        return this;
    }

    public SearchResult clickGo() {
        wait.until(ExpectedConditions.elementToBeClickable(goBtnLocator));
        driver.findElement(goBtnLocator).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultLocator));
        //(new WebDriverWait(driver, 10)).until()
        /*class MyCondition implements ExpectedCondition {

            @NullableDecl
            @Override
            public Boolean apply(@NullableDecl WebDriver webDriver) {
                return webDriver.findElements(searchResultLocator).size() >= 3;
            }
        }
        MyCondition condition = new MyCondition();
        wait.until(condition);*/
        wait.until(driver -> driver.findElements(searchResultLocator).size() >= 3);
        wait.until(driver -> driver.findElement(searchResultLocator).findElement(priceLocator).getText().contains("$"));
        return this;
    }

    public String getFirstResultPrice() {
        return driver
                .findElement(searchResultLocator)
                .findElement(priceLocator)
                .getText();
    }
}
