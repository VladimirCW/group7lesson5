package test.java.lesson7;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class A_Start_Browser {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("--window-size=1300,1080");
        chromeOptions.addArguments("--incognito");
        By priceLocator = By.cssSelector(".a-offscreen");
        By burgerMenuLocator = By.id("nav-hamburger-menu");
        By computerOptionLocator = By.cssSelector("a[data-menu-id='6']");
        By dataStorageOptionLocator = By.xpath("//a[text()='Data Storage']");
        //By price = By.xpath("//*[@class='a-price-whole']");
        //By price = By.className("a-price-whole");

        WebDriver driver = new ChromeDriver(chromeOptions);

        //driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(500, 500));

        driver.get("https://www.amazon.com");
        driver.findElement(burgerMenuLocator).click();
        driver.findElement(computerOptionLocator).click();
        Thread.sleep(5000);
        driver.findElement(dataStorageOptionLocator).click();


        Thread.sleep(10000);
        WebElement price = driver.findElement(priceLocator);
        String text = price.getText();
        System.out.printf("The price is: '%s'%n", text);

        //System.out.println(driver.findElement(priceLocator).getText());


        driver.quit();
    }
}
