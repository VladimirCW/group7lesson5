package test.java.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{
    private final By locationPopupCancelLocator = By.xpath("//input[@type='submit' and following-sibling::span[contains(text(),\"Don't Change\")]]");
    private final By todaysDeal = By.xpath("//a[text()=\"Today's Deals\"]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open() {
        driver.get("https://www.amazon.com/");
        wait.until(ExpectedConditions.elementToBeClickable(locationPopupCancelLocator)).click();
        return this;
    }

    public HomePage clickTodaysDeal() {
        wait.until(ExpectedConditions.elementToBeClickable(todaysDeal)).click();
        return this;
    }
}
