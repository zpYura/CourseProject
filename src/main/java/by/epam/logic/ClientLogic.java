package by.epam.logic;

import by.epam.dao.factory.DAOFactory;
import by.epam.entities.Client;
import by.epam.enums.DataBaseType;
import by.epam.managers.Log4jManager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides methods to work with clients
 *
 * @author Yury Druzenok
 * @version 1.0  15 Dec 2015
 */
public class ClientLogic {
    public static List<Client> getAllClients() {
        List<Client> clients = null;
        DAOFactory dao = DAOFactory.getDAOFactory(DataBaseType.MYSQL);
        try {
            clients = dao.getClientDAO().findAll();
        } catch (SQLException e) {
            System.err.print(e.getMessage());
            Log4jManager.error(e.getMessage());
        }

        return clients;
    }

    public static Client getClientById(int id) {
        Client client = null;
        DAOFactory dao = DAOFactory.getDAOFactory(DataBaseType.MYSQL);
        try {
            client = (Client) dao.getClientDAO().findEntityById(Integer.valueOf(id));
        } catch (SQLException e) {
            System.err.print(e.getMessage());
            Log4jManager.error(e.getMessage());
        }

        return client;
    }
}
