package by.epam.command;

import by.epam.entities.Request;
import by.epam.entities.Room;
import by.epam.interfaces.ActionCommand;
import by.epam.logic.RequestLogic;
import by.epam.logic.RoomLogic;
import by.epam.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zpYura on 14.12.2015.
 */
public class ComputeRequestCommand implements ActionCommand {
    private static final String PARAM_NAME_REQUEST_ID = "request_id";
    private static final String PARAM_NAME_ADMIN_ID = "userId";

    public String execute(HttpServletRequest request) {
        String page = null;
        int requestId = Integer.parseInt(request.getParameter(PARAM_NAME_REQUEST_ID));
        request.getSession().setAttribute("requestId", requestId);
        int adminId = Integer.parseInt(request.getSession().getAttribute(PARAM_NAME_ADMIN_ID).toString());
        Request currentRequest = RequestLogic.getUpdateRequestById(requestId, adminId);
        List<Request> requestList = new ArrayList<Request>();
        requestList.add(currentRequest);
        List<Room> rooms = RoomLogic.getSuitableRooms(currentRequest);
        request.setAttribute("roomsList", rooms.toArray());
        request.setAttribute("requestsList", requestList.toArray());
        page = ConfigurationManager.get("page_admin_compute_request");
        return page;
    }
}
