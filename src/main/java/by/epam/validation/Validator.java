package by.epam.validation;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zpYura on 10.12.2015.
 */
public class Validator {

    public static String getString(String value) throws UnsupportedEncodingException {
        return new String(value.getBytes("ISO-8859-1"),"UTF-8");
    }

    private static boolean check(String value, String pattern){
        boolean success = false;
        Pattern textField = Pattern.compile(pattern);
        Matcher matcher = textField.matcher(value);
        success = matcher.matches();
        return success;
    }

    public static boolean checkTextField(String value){
        String pattern = "([a-zA-Zа-яА-я]+)";
        return check(value,pattern);
    }

    public static boolean checkDate(String value){
        String pattern = "\\d\\d/\\d\\d/\\d\\d";
        return check(value,pattern);
    }
    public static boolean checkPhoneNumber(String value){
        String pattern = "^\\+\\d{12}$";
        return check(value,pattern);
    }

    public static boolean checkEmail(String value){
        String patttern = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
        return check(value,patttern);
    }
}
