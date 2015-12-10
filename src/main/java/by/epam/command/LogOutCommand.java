package by.epam.command;

import by.epam.interfaces.ActionCommand;
import by.epam.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zpYura on 10.12.2015.
 */
public class LogOutCommand implements ActionCommand {
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.get("page_index");
        // уничтожение сессии
        request.getSession().invalidate();
        return page;
    }
}
