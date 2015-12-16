package by.epam.command;

import by.epam.interfaces.ActionCommand;
import by.epam.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Clear session
 *
 * @author Yury Druzenok
 * @version 1.0  14 Dec 2015
 */
public class LogOutCommand implements ActionCommand {
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.get("page_index");
       //destroy session
        request.getSession().invalidate();
        return page;
    }
}
