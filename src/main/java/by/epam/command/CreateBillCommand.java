package by.epam.command;

import by.epam.entities.Bill;
import by.epam.entities.Request;
import by.epam.entities.Room;
import by.epam.entities.RoomGuide;
import by.epam.interfaces.ActionCommand;
import by.epam.logic.BillLogic;
import by.epam.logic.RequestLogic;
import by.epam.logic.RoomGuideLogic;
import by.epam.logic.RoomLogic;
import by.epam.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Create new bills and roomGuides
 *
 * @author Yury Druzenok
 * @version 1.0  16 Dec 2015
 */
public class CreateBillCommand implements ActionCommand {
    private static final String PARAM_NAME_REQUEST_ID = "requestId";
    private static final String PARAM_NAME_ROOM_ID = "room_id";

    public String execute(HttpServletRequest request) {
        String page = null;
        Request requestCurrent = RequestLogic.getRequestById((Integer) request.getSession().getAttribute(PARAM_NAME_REQUEST_ID));
        Room room = RoomLogic.getRoomById(Integer.parseInt(request.getParameter(PARAM_NAME_ROOM_ID)));
        //compute numbers of days
        long difference = requestCurrent.getOutDate().getTime() - requestCurrent.getInDate().getTime();
        int days = (int) (difference / (24 * 60 * 60 * 1000));
        int cost = room.getCostPerDay() * days;
        Bill bill = new Bill(-1, cost);
        if (BillLogic.createBill(bill)) {
            List<Bill> bills = BillLogic.getAllBills();
            List<Bill> resultBill = new ArrayList<Bill>();
            for (int i = bills.size() - 1; i >= 0 && resultBill.size() == 0; i--) {
                if (bills.get(i).getCost() == cost)
                    resultBill.add(bills.get(i));
            }
            RoomGuide roomGuide = new RoomGuide(-1, room.getId(), requestCurrent.getId(), resultBill.get(0).getId());
            if (RoomGuideLogic.createRoomGuide(roomGuide)) {
                request.setAttribute("billsList", resultBill.toArray());
                List<RoomGuide> roomGuides = RoomGuideLogic.getAllRoomGuides();
                request.setAttribute("roomGuidesList", roomGuides.toArray());
                page = ConfigurationManager.get("page_admin_bills");
            }
        }
        return page;
    }
}
