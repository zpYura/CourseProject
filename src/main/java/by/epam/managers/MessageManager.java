package by.epam.managers;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by zpYura on 09.12.2015.
 */
public class MessageManager {
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
    // класс извлекает информацию из файла messages.properties
    private MessageManager() { }
    public static String getProperty(Locale current,String key) throws UnsupportedEncodingException {
        resourceBundle = ResourceBundle.getBundle("message",current);
        return new String(resourceBundle.getString(key).getBytes("ISO-8859-1"),"UTF-8");
    }
}
