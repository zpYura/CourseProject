package by.epam.managers;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Class for accessing main property file
 *
 * @version 1.0 22 Nov 2015
 * @author Yury Druzenok
 */
public class ConfigurationManager {
    private ResourceBundle resourceBundle;

    private static ConfigurationManager singleton;

    static {
        singleton = new ConfigurationManager();
    }

    private ConfigurationManager() {
        resourceBundle = ResourceBundle.getBundle("config",Locale.getDefault() );
    }

    public static String get(String key) {
        return singleton.resourceBundle.getString(key);
    }
}
