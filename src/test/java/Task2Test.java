package test.java;

import main.java.Task2;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Task2Test {

    @Parameters({"browser", "version"})
    @Test
    public void SecondTestMethod(@Optional("firefox") String browser, @Optional("88") String version) {
        System.out.println(String.format("The Browser is: '%s'", browser));
        Task2 task2 = new Task2();
        String names = task2.someMethod();

        int expectedValue = 5;
        int actualValue = names.split("\n").length;
        assertEquals(actualValue, expectedValue);
    }
}
