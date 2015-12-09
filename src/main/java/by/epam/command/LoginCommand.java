package by.epam.command;

import by.epam.interfaces.ActionCommand;
import by.epam.logic.LoginLogic;
import by.epam.managers.LanguageManager;

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
        if (LoginLogic.checkLogin(login, pass)) {
            //request.setAttribute("user", login);
            request.getSession().setAttribute("user", login);
            if(language.equals(RUSSIAN))
            {
                current = new Locale("ru","RU");
            }
            if(language.equals(ENGLISH))
            {
                current = new Locale("en","US");
            }
            LanguageManager.formMenu(current,request.getSession());
        // определение пути к main.jsp
            //page = ConfigurationManager.getProperty("path.page.main");
            page = "/jsp/client/main.jsp";
        } else {
//            request.setAttribute("errorLoginPassMessage",
//                    MessageManager.getProperty("message.loginerror"));
//            page = ConfigurationManager.getProperty("path.page.login");
        }
        return page;
    }
}
