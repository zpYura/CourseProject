package by.epam.command;

import by.epam.entities.Bill;
import by.epam.entities.RoomGuide;
import by.epam.interfaces.ActionCommand;
import by.epam.logic.BillLogic;
import by.epam.logic.RoomGuideLogic;
import by.epam.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Loads lists of bills and roomGuides when bill.jsp load
 *
 * @author Yury Druzenok
 * @version 1.0  14 Dec 2015
 */
public class BillsPageOnLoadCommand implements ActionCommand {
    public String execute(HttpServletRequest request) {
        String page = null;
        List<Bill> bills = BillLogic.getAllBills();
        // get all bills and roomGuides and put them into attributes
        request.setAttribute("billsList", bills.toArray());
        List<RoomGuide> roomGuides = RoomGuideLogic.getAllRoomGuides();
        request.setAttribute("roomGuidesList", roomGuides.toArray());
        page = ConfigurationManager.get("page_admin_bills");
        return page;
    }
}
