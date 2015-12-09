package by.epam.command;

import by.epam.entities.Request;
import by.epam.enums.ApartmentType;
import by.epam.interfaces.ActionCommand;
import by.epam.logic.BookLogic;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.IllegalFormatException;

/**
 * Created by zpYura on 09.12.2015.
 */
public class BookCommand implements ActionCommand {
    private static final String PARAM_NAME_CHECK_IN = "check_in";
    private static final String PARAM_NAME_CHECK_OUT = "check_out";
    private static final String PARAM_NAME_ROOM_TYPE = "roomType";
    private static final String PARAM_NAME_NUMBERS_OF_ROOMS = "numberOfRooms";
    private static final String PARAM_NAME_MAX_COST = "maxCost";
    private static final String PARAM_NAME_MIN_COST = "minCost";

    public String execute(HttpServletRequest request) {
        String page = null;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        // get parameters
        int number_of_rooms = 0;
        int maxCost = 0;
        int minCost = 0;
        ApartmentType type = null;
        int id = -1;
        Date inDate = null;
        Date outDate = null;
        try{
            number_of_rooms = Integer.parseInt(request.getParameter(PARAM_NAME_NUMBERS_OF_ROOMS));
            maxCost = Integer.parseInt(request.getParameter(PARAM_NAME_MAX_COST));
            minCost = Integer.parseInt(request.getParameter(PARAM_NAME_MIN_COST));
            type = ApartmentType.valueOf(request.getParameter(PARAM_NAME_ROOM_TYPE));
            inDate = formatter.parse(request.getParameter(PARAM_NAME_CHECK_IN));
            outDate = formatter.parse(request.getParameter(PARAM_NAME_CHECK_OUT));
            id = Integer.parseInt(request.getSession().getAttribute("userId").toString());
        }
        catch (ParseException e) {
            System.err.println(e.getMessage());
        }
        Request bookRequest = new Request(-1,number_of_rooms, type, inDate, outDate, maxCost, minCost, id, 1);
        if(BookLogic.createRequest(bookRequest))
            page = "/jsp/client/main.jsp";

        return page;
    }
}
