package test.java;

import main.java.Server;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class ServerTest {

    @Test
    public void setAgeTestForStudent() {
        Server server = new Server();
        server.setAge(15);

        String expectedStatus = "student";
        String actualStatus = server.getStatus();

        assertEquals(actualStatus, expectedStatus);
    }

    @Test
    public void setAgeTestForWorker() {
        Server server = new Server();
        server.setAge(25);

        String expectedStatus = "worker";
        String actualStatus = server.getStatus();

        assertEquals(actualStatus, expectedStatus);
    }

    @Test
    public void setAgeTestForPensioner() {
        Server server = new Server();
        server.setAge(65);

        String expectedStatus = "pensioner";
        String actualStatus = server.getStatus();

        assertEquals(actualStatus, expectedStatus);
    }
}
