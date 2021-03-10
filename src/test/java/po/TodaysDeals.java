package test.java.po;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TodaysDeals extends BasePage{

    private final By checkboxDevicesLocator = By.xpath("//input[@type='checkbox' and following-sibling::span[contains(text(),'Baby')]]");
    private final By logoLocator = By.id("nav-logo-sprites");
    Logger logger = LogManager.getLogger(TodaysDeals.class);

    public TodaysDeals(WebDriver driver) {
        super(driver);
        logger.debug("Initialized Todays Deal page");
    }

    @Override
    public TodaysDeals open() {
        driver.get("https://www.amazon.com/international-sales-offers/b/?ie=UTF8&node=15529609011&ref_=nav_cs_gb_intl_52df97a2eee74206a8343034e85cd058");
        return this;
    }

    @Step("Click checkbox button")
    public TodaysDeals clickCheckbox() {
        logger.info("Click checkbox");
        wait.until(ExpectedConditions.elementToBeClickable(checkboxDevicesLocator)).click();
        return this;
    }

    @Step("Click logo")
    public TodaysDeals clickLogo() {
        logger.info("Click Logo");
        wait.until(ExpectedConditions.elementToBeClickable(logoLocator)).click();
        return this;
    }
}
