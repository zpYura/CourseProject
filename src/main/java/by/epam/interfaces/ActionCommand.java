package by.epam.interfaces;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zpYura on 07.12.2015.
 */
public interface ActionCommand {
    String execute(HttpServletRequest request);
}
