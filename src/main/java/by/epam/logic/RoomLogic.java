package by.epam.logic;

import by.epam.dao.factory.DAOFactory;
import by.epam.entities.Request;
import by.epam.entities.Room;
import by.epam.enums.DataBaseType;
import by.epam.managers.Log4jManager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides methods to work with rooms
 *
 * @author Yury Druzenok
 * @version 1.0  13 Dec 2015
 */
public class RoomLogic {
    public static List<Room> getAllRooms() {
        List<Room> rooms = null;
        DAOFactory dao = DAOFactory.getDAOFactory(DataBaseType.MYSQL);
        try {
            rooms = dao.getRoomDAO().findAll();
        } catch (SQLException e) {
            System.err.print(e.getMessage());
            Log4jManager.error(e.getMessage());
        }

        return rooms;
    }

    public static List<Room> getSuitableRooms(Request request) {
        List<Room> roomsRes = new ArrayList<Room>();
        DAOFactory dao = DAOFactory.getDAOFactory(DataBaseType.MYSQL);
        try {
            List<Room> rooms = dao.getRoomDAO().findAll();
            for (Room room : rooms) {
                if (request.getNumberOfbeds() <= room.getNumberOfbeds() && request.getType().equals(room.getType())
                        && request.getInDate().compareTo(room.getReleaseDate()) > 0 && room.getCostPerDay() <= request.getMaxCost()) {
                    roomsRes.add(room);
                }
            }
        } catch (SQLException e) {
            System.err.print(e.getMessage());
            Log4jManager.error(e.getMessage());
        }

        return roomsRes;
    }

    public static Room getRoomById(int id) {
        Room room = null;
        DAOFactory dao = DAOFactory.getDAOFactory(DataBaseType.MYSQL);
        try {
            room = (Room) dao.getRoomDAO().findEntityById(Integer.valueOf(id));
        } catch (SQLException e) {
            System.err.print(e.getMessage());
            Log4jManager.error(e.getMessage());
        }
        return room;
    }
}
