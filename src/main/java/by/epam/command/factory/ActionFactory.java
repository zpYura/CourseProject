package by.epam.command.factory;

import by.epam.enums.CommandType;
import by.epam.interfaces.ActionCommand;
import by.epam.managers.Log4jManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import javax.servlet.http.HttpServletRequest;

/**
 * Define the command type
 *
 * @author Yury Druzenok
 * @version 1.0  7 Dec 2015
 */
public class ActionFactory {

    public ActionCommand defineCommand(HttpServletRequest request) {
        ActionCommand current = null;
        // get the name command
        String action = request.getParameter("command");
        if (action == null || action.isEmpty()) {
            // если команда не задана в текущем запросе
            return current;
        }
        // get the object, based on the command type
        try {
            CommandType currentEnum = CommandType.valueOf(action.toUpperCase());
            current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            Log4jManager.error("Action exception:" + e);
        }
        return current;
    }
}
