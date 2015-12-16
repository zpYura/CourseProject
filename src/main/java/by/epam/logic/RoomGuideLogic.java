package by.epam.logic;

import by.epam.dao.factory.DAOFactory;
import by.epam.entities.Room;
import by.epam.entities.RoomGuide;
import by.epam.enums.DataBaseType;
import by.epam.managers.Log4jManager;

import java.sql.SQLException;
import java.util.List;

/**
 * Provides methods to work with roomGuides
 *
 * @author Yury Druzenok
 * @version 1.0  14 Dec 2015
 */
public class RoomGuideLogic {
    public static List<RoomGuide> getAllRoomGuides() {
        List<RoomGuide> roomGuides = null;
        DAOFactory dao = DAOFactory.getDAOFactory(DataBaseType.MYSQL);
        try {
            roomGuides = dao.getRoomGuideDAO().findAll();
        } catch (SQLException e) {
            System.err.print(e.getMessage());
            Log4jManager.error(e.getMessage());
        }

        return roomGuides;
    }

    public static boolean createRoomGuide(RoomGuide roomGuide) {
        boolean success = false;
        DAOFactory dao = DAOFactory.getDAOFactory(DataBaseType.MYSQL);
        try {
            success = dao.getRoomGuideDAO().create(roomGuide);
        } catch (SQLException e) {
            System.err.print(e.getMessage());
            Log4jManager.error(e.getMessage());
        }
        return success;
    }
}
