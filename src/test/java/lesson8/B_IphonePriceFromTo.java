package test.java.lesson8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import test.java.TestBaseSetup;

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

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        Actions action = new Actions(driver);
        action
                .moveToElement(driver.findElement(flagLocator))
                .perform();
        Thread.sleep(30000);
        driver.findElement(deutshOptionLocator).click();
        action
                .moveToElement(driver.findElement(flagLocator))
                .perform();
        Thread.sleep(2000);
        driver.findElement(enOptionLocator).click();
        WebElement input = driver.findElement(inputLocator);
        /*input.sendKeys("Samsung");
        driver.navigate().refresh();
        driver.findElement(inputLocator).sendKeys("iPhone");*/
        driver.findElement(inputLocator).sendKeys("Phone");
        driver.findElement(searchBtnLocator).click();
        driver.findElement(minInputLocator).sendKeys("10");
        driver.findElement(maxInputLocator).sendKeys("11");
        driver.findElement(goBtnLocator).click();
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
