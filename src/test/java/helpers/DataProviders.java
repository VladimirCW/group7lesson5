package test.java.helpers;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider
    public Object[][] smoke() {
        return new Object[][]{
                {"A"}
        };
    }

    @DataProvider
    public Object[][] regression() {
        return new Object[][] {
                {"A"},
                {"B"},
                {"C"}
        };
    }

}
