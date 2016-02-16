package by.epam.command;

import by.epam.entities.Request;
import by.epam.interfaces.ActionCommand;
import by.epam.logic.RequestLogic;
import by.epam.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Load list of request when requests.jsp is loaded
 *
 * @author Yury Druzenok
 * @version 1.0  13 Dec 2015
 */
public class RequestsPageOnLoadCommand implements ActionCommand {
    public String execute(HttpServletRequest request) {
        String page = null;
        List<Request> requests = RequestLogic.getAllRequests();
        // put all requests on the page
        request.setAttribute("requestsList", requests.toArray());
        page = ConfigurationManager.get("page_request");
        return page;
    }
}
