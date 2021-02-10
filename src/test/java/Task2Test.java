package test.java;

import main.java.Task2;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Task2Test {

    @Test
    public void SecondTestMethod() {
        Task2 task2 = new Task2();
        String names = task2.someMethod();

        int expectedValue = 6;
        int actualValue = names.split("\n").length;
        assertEquals(actualValue, expectedValue);
    }
}
