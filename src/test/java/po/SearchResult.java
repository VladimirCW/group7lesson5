package test.java.po;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResult extends BasePage {

    By minInputLocator = By.xpath("//input[@placeholder='Min']");
    By maxInputLocator = By.xpath("//input[@placeholder='Max']");
    By goBtnLocator = By.xpath("//input[@class='a-button-input' and @type='submit']");
    By searchResultLocator = By.cssSelector("div[data-component-type='s-search-result']");
    By priceLocator = By.cssSelector(".a-price span[aria-hidden='true']");
    Logger logger = LogManager.getLogger(BasePage.class);

    public SearchResult(WebDriver driver) {
        super(driver);
        logger.debug("Initialized Search page");
    }

    @Override
    public BasePage open() {
        driver.get("");
        return this;
    }

    public SearchResult setMinPrice(String price) {
        logger.info(String.format("Set Min Price '%s'", price));
        wait.until(ExpectedConditions.elementToBeClickable(minInputLocator));
        driver.findElement(minInputLocator).sendKeys(price);
        return this;
    }

    public SearchResult setMaxPrice(String price) {
        logger.info(String.format("Set Max price '%s'", price));
        wait.until(ExpectedConditions.elementToBeClickable(maxInputLocator));
        driver.findElement(maxInputLocator).sendKeys(price);
        return this;
    }

    public SearchResult clickGo() {
        logger.info("Click 'Go' button");
        wait.until(ExpectedConditions.elementToBeClickable(goBtnLocator));
        driver.findElement(goBtnLocator).click();
        logger.trace("Button clicked, wait for elements load ...");
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
        //wait.until(driver -> driver.findElement(searchResultLocator).findElement(priceLocator).getText().contains("$"));
        logger.debug("Button 'Go' was clicked, elements loaded");
        return this;
    }

    public String getFirstResultPrice() {
        logger.info("Get First result price");
        return driver
                .findElement(searchResultLocator)
                .findElement(priceLocator)
                .getText();
    }
}
