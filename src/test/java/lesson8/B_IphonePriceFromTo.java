package test.java.lesson8;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.TestBaseSetup;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class B_IphonePriceFromTo extends TestBaseSetup {

    By inputLocator = By.id("twotabsearchtextbox");
    By searchBtnLocator = By.id("nav-search-submit-button");
    By minInputLocator = By.xpath("//input[@placeholder='Min']");
    By maxInputLocator = By.xpath("//input[@placeholder='Max']");
    By goBtnLocator = By.xpath("//input[@class='a-button-input' and @type='submit']");
    By searchResultLocator = By.cssSelector("div[data-component-type='s-search-result']");
    By priceLocator = By.cssSelector(".a-price span[aria-hidden='true']");
    By flagLocator = By.id("icp-nav-flyout");
    By enOptionLocator = By.xpath("//span[text()='English - EN']");
    By deutshOptionLocator = By.xpath("//span[text()='Deutsch - DE']");
    By languagePopup = By.id("nav-flyout-icp");
    By todaysDeal = By.xpath("//a[text()=\"Today's Deals\"]");
    By checkboxDevicesLocator = By.xpath("//input[@type='checkbox' and following-sibling::span[contains(text(),'Devices')]]");
    By logoLocator = By.id("nav-logo-sprites");
    By locationPopupCancelLocator = By.xpath("//input[@type='submit' and following-sibling::span[contains(text(),\"Don't Change\")]]");

    @BeforeMethod
    public void setUp() {
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.MILLISECONDS);
//        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        WebDriverWait wait = new WebDriverWait(driver, 10, 500);
        wait.until(ExpectedConditions.elementToBeClickable(locationPopupCancelLocator)).click();

        wait.until(ExpectedConditions.elementToBeClickable(todaysDeal)).click();
        wait.until(ExpectedConditions.elementToBeClickable(checkboxDevicesLocator)).click();
        wait.until(ExpectedConditions.elementToBeClickable(logoLocator)).click();

        Actions action = new Actions(driver);
        action
                .moveToElement(driver.findElement(flagLocator))
                .perform();
        // Thread.sleep(2000);
        //wait.until(ExpectedConditions.presenceOfElementLocated(languagePopup));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(languagePopup));
//        wait.until(ExpectedConditions.elementToBeClickable(deutshOptionLocator));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(languagePopup));
        wait.until(ExpectedConditions.and(
                ExpectedConditions.elementToBeClickable(deutshOptionLocator),
                ExpectedConditions.visibilityOfElementLocated(languagePopup)
        ));
        driver.findElement(deutshOptionLocator).click();
        action
                .moveToElement(driver.findElement(flagLocator))
                .perform();
        wait.until(ExpectedConditions.elementToBeClickable(enOptionLocator));
        driver.findElement(enOptionLocator).click();
        WebElement input = driver.findElement(inputLocator);
        /*input.sendKeys("Samsung");
        driver.navigate().refresh();
        driver.findElement(inputLocator).sendKeys("iPhone");*/
        driver.findElement(inputLocator).sendKeys("Phone");
        driver.findElement(searchBtnLocator).click();
        wait.until(ExpectedConditions.elementToBeClickable(minInputLocator));
        driver.findElement(minInputLocator).sendKeys("10");
        wait.until(ExpectedConditions.elementToBeClickable(maxInputLocator));
        driver.findElement(maxInputLocator).sendKeys("11");
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
        String actualPriceAsString = driver
                .findElement(searchResultLocator)
                .findElement(priceLocator)
                .getText()
                .replace("\n", ".")
                .replace("$", "");
        float actualPrice = Float.parseFloat(actualPriceAsString);
        assertTrue(
                actualPrice > 10.00 && actualPrice < 11.00,
                String.format("Expected actual price '%s' to be more than 10 and less than 11", actualPrice));
    }
}
