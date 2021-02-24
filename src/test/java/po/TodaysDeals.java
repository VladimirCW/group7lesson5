package test.java.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TodaysDeals extends BasePage{

    private final By checkboxDevicesLocator = By.xpath("//input[@type='checkbox' and following-sibling::span[contains(text(),'Devices')]]");
    private final By logoLocator = By.id("nav-logo-sprites");

    public TodaysDeals(WebDriver driver) {
        super(driver);
    }

    @Override
    public TodaysDeals open() {
        driver.get("https://www.amazon.com/international-sales-offers/b/?ie=UTF8&node=15529609011&ref_=nav_cs_gb_intl_52df97a2eee74206a8343034e85cd058");
        return this;
    }

    public TodaysDeals clickCheckbox() {
        wait.until(ExpectedConditions.elementToBeClickable(checkboxDevicesLocator)).click();
        return this;
    }

    public TodaysDeals clickLogo() {
        wait.until(ExpectedConditions.elementToBeClickable(logoLocator)).click();
        return this;
    }
}
