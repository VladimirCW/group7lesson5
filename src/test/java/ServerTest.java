package test.java;

import main.java.Server;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class ServerTest {
    Server server;

    @BeforeMethod
    public void setUp() {
        server = new Server();
    }

    @Test(dataProvider = "dataProvider")
    public void setAgeTestForStudent(int age, String expectedStatus) {
        server.setAge(age);
        String actualStatus = server.getStatus();
        assertEquals(actualStatus, expectedStatus);
    }

    @DataProvider(name = "dataProvider")
    public Object[][] dp() {
        return new Object[][] {
                { 15, "student" },
                { 25, "worker" },
                { 65, "pensioner" },
                { 0, "student" },
                { -1, "student" },
                { 101, "student" },
                { 100, "pensioner" },
        };
    }

}
