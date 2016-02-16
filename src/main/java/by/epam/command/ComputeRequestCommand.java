package by.epam.command;

import by.epam.entities.Request;
import by.epam.entities.Room;
import by.epam.interfaces.ActionCommand;
import by.epam.logic.RequestLogic;
import by.epam.logic.RoomLogic;
import by.epam.managers.ConfigurationManager;
import by.epam.managers.Log4jManager;
import by.epam.managers.MessageManager;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Create list of rooms that suit to client's request
 *
 * @author Yury Druzenok
 * @version 1.0  14 Dec 2015
 */
public class ComputeRequestCommand implements ActionCommand {
    private static final String PARAM_NAME_REQUEST_ID = "request_id";
    private static final String PARAM_NAME_ADMIN_ID = "userId";

    public String execute(HttpServletRequest request) {
        String page = null;
        // get request id
        int requestId = Integer.parseInt(request.getParameter(PARAM_NAME_REQUEST_ID));
        request.getSession().setAttribute("requestId", requestId);
        // get admin id
        int adminId = Integer.parseInt(request.getSession().getAttribute(PARAM_NAME_ADMIN_ID).toString());
        Request currentRequest = RequestLogic.getUpdateRequestById(requestId, adminId);
        List<Request> requestList = new ArrayList<Request>();
        requestList.add(currentRequest);
        // get all rooms that suit this request
        List<Room> rooms = RoomLogic.getSuitableRooms(currentRequest);
        // use array because standart tags can't work with ArrayLists
        request.setAttribute("requestsList", requestList.toArray());
        // if there are no suitable rooms
        if (rooms.size() == 0) {
            try {
                // set error message
                request.setAttribute("rooms_lis_empty_error", MessageManager.getProperty((Locale) request.getSession().getAttribute("current_locale"), "rooms_lis_empty_error"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                Log4jManager.error(e.getMessage());
            }
            // we have no rooms so we have to declare it
            request.setAttribute("roomsList", null);
        } else {
            request.setAttribute("roomsList", rooms.toArray());
        }
        page = ConfigurationManager.get("page_admin_compute_request");
        return page;
    }
}
