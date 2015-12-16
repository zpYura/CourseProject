package by.epam.command;

import by.epam.entities.Request;
import by.epam.enums.ApartmentType;
import by.epam.interfaces.ActionCommand;
import by.epam.logic.RequestLogic;
import by.epam.managers.ConfigurationManager;
import by.epam.managers.Log4jManager;
import by.epam.managers.MessageManager;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Compute client's requests
 *
 * @author Yury Druzenok
 * @version 1.0  14 Dec 2015
 */
public class BookCommand implements ActionCommand {
    private static final String PARAM_NAME_CHECK_IN = "check_in";
    private static final String PARAM_NAME_CHECK_OUT = "check_out";
    private static final String PARAM_NAME_ROOM_TYPE = "roomType";
    private static final String PARAM_NAME_NUMBERS_OF_ROOMS = "numberOfRooms";
    private static final String PARAM_NAME_MAX_COST = "maxCost";
    private static final String PARAM_NAME_MIN_COST = "minCost";

    public String execute(HttpServletRequest request) {
        boolean flag = false;
        String page = null;
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");
        // get parameters
        int number_of_rooms = 0;
        int maxCost = 0;
        int minCost = 0;
        ApartmentType type = null;
        int id = -1;
        Date inDate = null;
        Date outDate = null;
        try {
            number_of_rooms = Integer.parseInt(request.getParameter(PARAM_NAME_NUMBERS_OF_ROOMS));
            maxCost = Integer.parseInt(request.getParameter(PARAM_NAME_MAX_COST));
            minCost = Integer.parseInt(request.getParameter(PARAM_NAME_MIN_COST));
            type = ApartmentType.valueOf(request.getParameter(PARAM_NAME_ROOM_TYPE));
            inDate = formatter.parse(request.getParameter(PARAM_NAME_CHECK_IN));
            outDate = formatter.parse(request.getParameter(PARAM_NAME_CHECK_OUT));
            id = Integer.parseInt(request.getSession().getAttribute("userId").toString());
        } catch (ParseException e) {
            System.err.println(e.getMessage());
            flag = true;
            Log4jManager.error(e.getMessage());
        }
        Request bookRequest = new Request(-1, number_of_rooms, type, inDate, outDate, maxCost, minCost, id, -1);
        try {
            //if all data is valid and request was created, send result message to client
            if (!flag && RequestLogic.createRequest(bookRequest))
                request.setAttribute("book_result_message", MessageManager.getProperty((Locale) request.getSession().getAttribute("current_locale"), "book_page_true"));
            else {
                request.setAttribute("book_result_message", MessageManager.getProperty((Locale) request.getSession().getAttribute("current_locale"), "book_page_false"));
            }

        } catch (UnsupportedEncodingException e) {
            System.err.println(e.getMessage());
            Log4jManager.error(e.getMessage());
        }
        page = ConfigurationManager.get("page_client_main");
        return page;
    }
}
