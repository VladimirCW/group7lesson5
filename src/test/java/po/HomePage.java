package test.java.po;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import test.java.helpers.PropertyLoader;

public class HomePage extends BasePage{
    private final By locationPopupCancelLocator = By.xpath("//input[@type='submit' and following-sibling::span[contains(text(),\"Don't Change\")]]");
    private final By todaysDeal = By.xpath("//a[text()=\"Today's Deals\"]");
    private final Logger logger = LogManager.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {
        super(driver);
        logger.debug("Initialized Home page");
    }

    @Step("Open home page")
    public HomePage open() {
        logger.info("Open Home page");
        logger.warn("Warn error");
        logger.error("Error error");
        logger.fatal("Fatal error");
        driver.get(PropertyLoader.getProperty("url"));
        wait.until(ExpectedConditions.elementToBeClickable(locationPopupCancelLocator)).click();
        return this;
    }

    @Step("Click today's deal")
    public HomePage clickTodaysDeal() {
        logger.info("Click 'Todays deal'");
        wait.until(ExpectedConditions.elementToBeClickable(todaysDeal)).click();
        return this;
    }
}
