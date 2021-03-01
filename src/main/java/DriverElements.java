package main.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DriverElements {

    static By itemText = By.cssSelector("div[class='a-section a-spacing-medium'] h2 span");

    public static void main(String[] args) throws InterruptedException {
        String strs[] = new String[100000];

        /*strs[4] = "E";
        strs[1] = null;
        strs[2] = null;*/


        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com/s?k=iPhone&ref=nb_sb_noss_2");
        Thread.sleep(2000);

        List<WebElement> list = driver.findElements(itemText);

        for (WebElement element : list) {
            if (!element.getText().contains("iPhone")) {
                System.out.println(element.getText());
            }
        }


        //WebElement element[] = driver.findElements(itemText);

        /*WebElement element = driver.findElement(itemText);

        System.out.println(element.getText());*/

        driver.quit();
    }
}
