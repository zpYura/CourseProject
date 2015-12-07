package by.epam.command;

import by.epam.interfaces.ActionCommand;
import by.epam.logic.LoginLogic;

import javax.servlet.http.HttpServletRequest;

/**
 * Compute login command
 *
 * @version 1.0 7 Dec 2015
 * @author Yury Druzenok
 */
public class LoginCommand implements ActionCommand {
    private static final String PARAM_NAME_LOGIN = "userLogin";
    private static final String PARAM_NAME_PASSWORD = "userPassword";
    public String execute(HttpServletRequest request) {
        String page = null;
        // извлечение из запроса логина и пароля
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
        // проверка логина и пароля
        if (LoginLogic.checkLogin(login, pass)) {
            request.setAttribute("user", login);
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
