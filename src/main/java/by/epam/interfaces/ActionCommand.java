package by.epam.interfaces;

import javax.servlet.http.HttpServletRequest;

/**
 * Provide method for all commands
 *
 * @author Yury Druzenok
 * @version 1.0  7 Dec 2015
 */
public interface ActionCommand {
    String execute(HttpServletRequest request);
}
