package by.epam.logic;

import by.epam.dao.factory.DAOFactory;
import by.epam.entities.Client;
import by.epam.enums.DataBaseType;
import by.epam.managers.Log4jManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.sql.SQLException;

/**
 * Works directly with dao layer, create new client in data base
 *
 * @author Yury Druzenok
 * @version 1.0 7 Dec 2015
 */
public class SigUpLogic {
    public static boolean createClient(Client client) {
        boolean success = false;
        DAOFactory dao = DAOFactory.getDAOFactory(DataBaseType.MYSQL);
        try {
            success = dao.getClientDAO().create(client);
        } catch (SQLException e) {
            System.err.print(e.getMessage());
            Log4jManager.error(e.getMessage());
        }

        return success;
    }
}
