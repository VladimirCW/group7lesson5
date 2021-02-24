package test.java.po;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{
    private final By locationPopupCancelLocator = By.xpath("//input[@type='submit' and following-sibling::span[contains(text(),\"Don't Change\")]]");
    private final By todaysDeal = By.xpath("//a[text()=\"Today's Deals\"]");
    private final Logger logger = LogManager.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {
        super(driver);
        logger.debug("Initialized Home page");
    }

    public HomePage open() {
        logger.info("Open Home page");
        logger.warn("Warn error");
        logger.error("Error error");
        logger.fatal("Fatal error");
        driver.get("https://www.amazon.com/");
        wait.until(ExpectedConditions.elementToBeClickable(locationPopupCancelLocator)).click();
        return this;
    }

    public HomePage clickTodaysDeal() {
        logger.info("Click 'Todays deal'");
        wait.until(ExpectedConditions.elementToBeClickable(todaysDeal)).click();
        return this;
    }
}
