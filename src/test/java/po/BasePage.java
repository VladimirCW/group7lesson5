package test.java.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected final WebDriver driver;
    protected final WebDriverWait wait;
    private final By languagePopup = By.id("nav-flyout-icp");
    private final By flagLocator = By.id("icp-nav-flyout");
    private final By inputLocator = By.id("twotabsearchtextbox");
    private final By searchBtnLocator = By.id("nav-search-submit-button");

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10, 500);
    }

    abstract BasePage open();

    public BasePage selectLanguage(String language) {
        By langOptionLocator = By.xpath(String.format("//span[text()='%s']", language));
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
                ExpectedConditions.elementToBeClickable(langOptionLocator),
                ExpectedConditions.visibilityOfElementLocated(languagePopup)
        ));
        driver.findElement(langOptionLocator).click();
        return this;
    }

    public BasePage setSearch(String search) {
        WebElement input = driver.findElement(inputLocator);
        input.clear();
        input.sendKeys(search);
        ///driver.navigate().refresh();
        return this;
    }

    public BasePage clickSearch() {
        driver.findElement(searchBtnLocator).click();
        return this;
    }
}