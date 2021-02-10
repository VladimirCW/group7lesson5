package test.java;

import main.java.Server;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ServerSetAgeTest {
    Server server;

    @BeforeClass
    public void beforeClass() {
        System.out.println("BEFORE CLASS");
        server = new Server();
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("BEFORE METHOD");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("AFTER METHOD");
    }


    @Test
    public void testSetAgeFirst1() {
        server.setAge(0);
        int expectedAge = 10;
        int actualAge = server.getAge();
        assertEquals(actualAge, expectedAge);
    }

    @Test
    public void testSetAgeFirst2() {
        server.setAge(-10);
        int expectedAge = 10;
        int actualAge = server.getAge();
        assertEquals(actualAge, expectedAge);
    }


    @Test
    public void testSetAgeFirst3() {
        server.setAge(101);
        int expectedAge = 10;
        int actualAge = server.getAge();
        assertEquals(actualAge, expectedAge);
    }


    @Test
    public void testSetAgeFirst4() {
        server.setAge(100);
        int expectedAge = 100;
        int actualAge = server.getAge();
        assertEquals(actualAge, expectedAge);
    }

    @Test
    public void testSetAgeFirst5() {
        server.setAge(50);
        int expectedAge = 50;
        int actualAge = server.getAge();
        assertEquals(actualAge, expectedAge);
    }
}
