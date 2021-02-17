package test.java.lesson8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.TestBaseSetup;

import static org.testng.Assert.assertEquals;

public class A_Intro extends TestBaseSetup {
    By inputLocator = By.id("twotabsearchtextbox");
    By searchFormLocator = By.id("nav-search-bar-form");

    @Test
    public void checkSearchBorderWhenSelected() {
        driver.get("https://www.amazon.com/");
        WebElement input = driver.findElement(inputLocator);
        input.click();
        input.sendKeys("iPhone");
        /*driver.findElement(inputLocator).click();
        driver.findElement(inputLocator).sendKeys("dsfdsfdsf");*/
        WebElement searchForm = driver.findElement(searchFormLocator);
        String expectedColor = "rgb(15, 17, 17)";
        String actualColor = searchForm.getCssValue("border-color");
        assertEquals(actualColor, expectedColor);
    }
}
