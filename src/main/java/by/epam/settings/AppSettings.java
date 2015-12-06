package by.epam.settings;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import java.io.FileInputStream;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Class for accessing main property file
 *
 * @version 1.0 22 Nov 2015
 * @author Yury Druzenok
 */
public class AppSettings {
    static Logger logger;
    private Properties dataBase;
   // static ResourceBundle resourceBundle;
    private static AppSettings singleton;

    static {
        singleton = new AppSettings();
    }

    private AppSettings() {
        FileInputStream fis = null;
        dataBase = new Properties();
        new DOMConfigurator().doConfigure("log4j.xml", LogManager.getLoggerRepository());
        logger = Logger.getLogger(AppSettings.class);
        try {
            fis = new FileInputStream("resources/mysqlconfig.properties");
            dataBase.load(fis);
            if(fis != null)
                fis.close();
        }
        catch (Exception e) {
            logger.error("File not found exception:", e);
        }
    }

    public static String get(String key) {
        return singleton.dataBase.getProperty(key);
    }
//    public static void createBundle(Locale current) {
//        resourceBundle = ResourceBundle.getBundle("resources.text", current);
//    }
    public static String getBundleValue(Locale current, String key){
        ResourceBundle resourceBundle = ResourceBundle.getBundle("text", current);
        return resourceBundle.getString(key);
    }
}
