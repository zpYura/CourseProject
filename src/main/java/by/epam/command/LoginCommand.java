package by.epam.command;

import by.epam.interfaces.ActionCommand;
import by.epam.logic.LoginLogic;
import by.epam.managers.LanguageManager;
import by.epam.managers.MessageManager;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.UnknownFormatConversionException;

/**
 * Compute login command
 *
 * @version 1.0 7 Dec 2015
 * @author Yury Druzenok
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
        // извлечение из запроса логина и пароля
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
        String language = request.getParameter(PARAM_NAME_LANGUAGE);
        // проверка логина и пароля
        int id = LoginLogic.checkLogin(login, pass);
        if (id != -1) {
            //request.setAttribute("user", login);
            request.getSession().setAttribute("user", login);
            request.getSession().setAttribute("userId", id);
            if(language.equals(RUSSIAN))
            {
                current = new Locale("ru","RU");
            }
            if(language.equals(ENGLISH))
            {
                current = new Locale("en","US");
            }
            LanguageManager.setLanguage(current,request.getSession());
        // определение пути к main.jsp
            //page = ConfigurationManager.getProperty("path.page.main");
            page = "/jsp/client/main.jsp";
        } else {
            try {
                request.setAttribute("errorLoginPassMessage",
                        MessageManager.getProperty("login_error"));
                page = "/jsp/common/login.jsp";
            }
            catch (UnsupportedEncodingException e){
                System.err.println(e.getMessage());
            }
        }
        return page;
    }
}
