package by.epam.logic;

import by.epam.dao.factory.DAOFactory;
import by.epam.entities.RoomGuide;
import by.epam.enums.DataBaseType;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by zpYura on 14.12.2015.
 */
public class RoomGuideLogic {
    public static List<RoomGuide> getAllRoomGuides(){
        List<RoomGuide> roomGuides = null;
        DAOFactory dao = DAOFactory.getDAOFactory(DataBaseType.MYSQL);
        try{
            roomGuides = dao.getRoomGuideDAO().findAll();
        }
        catch (SQLException exp){
            System.err.print(exp.getMessage());

        }

        return roomGuides;
    }
}
