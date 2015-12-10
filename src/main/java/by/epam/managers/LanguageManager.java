package by.epam.managers;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

/**
 * Created by zpYura on 08.12.2015.
 */
public class LanguageManager {
    private static ResourceBundle LanguageReourceBundle;
    private static LanguageManager singleton;

    static {
        singleton = new LanguageManager();
    }

    private LanguageManager() {
        LanguageReourceBundle = ResourceBundle.getBundle("text", Locale.getDefault() );
    }

    public static String getBundleValue(Locale current, String key) throws UnsupportedEncodingException {
        LanguageReourceBundle = ResourceBundle.getBundle("text",current );
        return new String(LanguageReourceBundle.getString(key).getBytes("ISO-8859-1"),"UTF-8");
    }

    public static void setLanguage(Locale current, HttpSession session){
        Set<String> keys = LanguageReourceBundle.keySet();
        try{
            for(String key : keys){
                session.setAttribute(key,getBundleValue(current,key));
            }
        }
        catch (UnsupportedEncodingException e) {
            System.err.println(e.getMessage());
        }
    }
}
