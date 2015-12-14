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
 * Created by zpYura on 14.12.2015.
 */
public class BillsPageOnLoadCommand implements ActionCommand {
    public String execute(HttpServletRequest request) {
        String page = null;
        List<Bill> bills = BillLogic.getAllBills();
        request.setAttribute("billsList", bills.toArray());
        List<RoomGuide> roomGuides = RoomGuideLogic.getAllRoomGuides();
        request.setAttribute("roomGuidesList", roomGuides.toArray());
        page = ConfigurationManager.get("page_admin_bills");
        return page;
    }
}
