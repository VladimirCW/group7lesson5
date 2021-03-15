package test.java.helpers;

import java.util.ResourceBundle;

public class PropertyLoader {
    private static ResourceBundle res = ResourceBundle.getBundle("config");
    private static ResourceBundle resSecret = ResourceBundle.getBundle("secret");

    public static String getProperty(String key) {
        return res.getString(key);
    }

    public static String getPropertySecret(String key) {
        return res.getString(key);
    }
}
