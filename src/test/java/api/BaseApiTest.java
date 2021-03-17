package test.java.api;

import org.testng.annotations.BeforeClass;

public class BaseApiTest {

    protected String TOKEN;

    protected String getToken () {
        return "74620c6fd4c6f8357de86c61a915ba72f1465645";
    }

    @BeforeClass
    public void setUp() {
        this.TOKEN = this.getToken();
    }
}
