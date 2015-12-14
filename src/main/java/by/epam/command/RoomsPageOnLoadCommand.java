package by.epam.command;

import by.epam.entities.Room;
import by.epam.interfaces.ActionCommand;
import by.epam.logic.RoomLogic;
import by.epam.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by zpYura on 13.12.2015.
 */
public class RoomsPageOnLoadCommand implements ActionCommand {
    public String execute(HttpServletRequest request) {
        String page = null;
        List<Room> rooms = RoomLogic.getAllRooms();
        request.setAttribute("roomsList", rooms.toArray());
        page = ConfigurationManager.get("page_admin_rooms");
        return page;
    }
}
