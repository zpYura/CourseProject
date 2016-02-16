package by.epam.command;

import by.epam.interfaces.ActionCommand;
import by.epam.logic.LoginLogic;
import by.epam.managers.ConfigurationManager;
import by.epam.managers.LanguageManager;
import by.epam.managers.Log4jManager;
import by.epam.managers.MessageManager;
import by.epam.validation.Validator;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

/**
 * Compute login command
 *
 * @author Yury Druzenok
 * @version 1.0 7 Dec 2015
 */
public class LoginCommand implements ActionCommand {
    private static final String PARAM_NAME_LOGIN = "userLogin";
    private static final String PARAM_NAME_LANGUAGE = "language";
    private static final String PARAM_NAME_PASSWORD = "userPassword";
    private static final String RUSSIAN = "ru";
    private static final String ENGLISH = "en";

    public String execute(HttpServletRequest request) {
        Locale current = Locale.getDefault();
        String page = null;
        // get login and password from request
        String login = null;
        String pass = null;
        String language = request.getParameter(PARAM_NAME_LANGUAGE);
        try {
            login = Validator.getString(request.getParameter(PARAM_NAME_LOGIN));
            pass = Validator.getString(request.getParameter(PARAM_NAME_PASSWORD));
        } catch (UnsupportedEncodingException e) {
            System.err.println(e.getMessage());
            Log4jManager.error(e.getMessage());
        }
        //check login and password
        int id = LoginLogic.checkLogin(login, pass);
        if (id != -1) {
            request.getSession().setAttribute("user", login);
            request.getSession().setAttribute("userId", id);
            // set language according to user's choice
            if (language.equals(RUSSIAN)) {
                current = new Locale("ru", "RU");
            }
            if (language.equals(ENGLISH)) {
                current = new Locale("en", "US");
            }
            LanguageManager.setLanguage(current, request.getSession());
            request.getSession().setAttribute("current_locale", current);
            //get path
            if (LoginLogic.isAdmin) {
                page = ConfigurationManager.get("page_admin_main");
            } else
                page = ConfigurationManager.get("page_client_main");
        } else {
            try {
                request.setAttribute("errorLoginPassMessage",
                        MessageManager.getProperty((Locale) request.getSession().getAttribute("current_locale"), "login_error"));
                page = ConfigurationManager.get("page_login");
            } catch (UnsupportedEncodingException e) {
                System.err.println(e.getMessage());
                Log4jManager.error(e.getMessage());
            }
        }
        return page;
    }
}
