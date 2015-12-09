package by.epam.logic;

import by.epam.dao.factory.DAOFactory;
import by.epam.entities.Request;
import by.epam.enums.DataBaseType;

import java.sql.SQLException;

/**
 * Created by zpYura on 09.12.2015.
 */
public class BookLogic {

    public static boolean createRequest(Request request)
    {
        boolean success = false;
        DAOFactory dao = DAOFactory.getDAOFactory(DataBaseType.MYSQL);
        try{
            success = dao.getRequestDAO().create(request);
        }
        catch (SQLException exp){
            System.err.print(exp.getMessage());

        }

        return success;
    }
}
