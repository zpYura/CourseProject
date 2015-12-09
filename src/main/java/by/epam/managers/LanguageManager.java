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

    public static void formMenu(Locale current, HttpSession session) {
        try {
                session.setAttribute("hello", LanguageManager.getBundleValue(current, "hello"));
                session.setAttribute("hotel", LanguageManager.getBundleValue(current, "hotel"));
                session.setAttribute("rooms", LanguageManager.getBundleValue(current, "rooms"));
                session.setAttribute("reservation", LanguageManager.getBundleValue(current, "reservation"));
                session.setAttribute("contact", LanguageManager.getBundleValue(current, "contact"));
        } catch (UnsupportedEncodingException e) {
            System.err.println(e.getMessage());
        }
    }
    public static void formLogin(Locale current, HttpSession session) {
        try {
            session.setAttribute("login_message", LanguageManager.getBundleValue(current, "login_message"));
            session.setAttribute("login_login", LanguageManager.getBundleValue(current, "login_login"));
            session.setAttribute("login_password", LanguageManager.getBundleValue(current, "login_password"));
            session.setAttribute("login_language", LanguageManager.getBundleValue(current, "login_language"));
            session.setAttribute("login_language_ru", LanguageManager.getBundleValue(current, "login_language_ru"));
            session.setAttribute("login_language_en", LanguageManager.getBundleValue(current, "login_language_en"));
            session.setAttribute("login_submit", LanguageManager.getBundleValue(current, "login_submit"));
            session.setAttribute("login_refresh", LanguageManager.getBundleValue(current, "login_refresh"));
            session.setAttribute("login_footer", LanguageManager.getBundleValue(current, "login_footer"));
            session.setAttribute("login_registlink", LanguageManager.getBundleValue(current, "login_registlink"));
        } catch (UnsupportedEncodingException e) {
            System.err.println(e.getMessage());
        }
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
