package by.epam.managers;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * Provides logging
 *
 * @author Yury Druzenok
 * @version 1.0  16 Dec 2015
 */
public class Log4jManager {
    static {
        new DOMConfigurator().doConfigure("log4j.xml", org.apache.log4j.LogManager.getLoggerRepository());

    }

    // logger for this class
    private static Logger logger = Logger.getRootLogger();

    public synchronized static void error(String message) {
        logger.error(message);
    }

    public synchronized static void info(String message) {
        logger.info(message);
    }
}
