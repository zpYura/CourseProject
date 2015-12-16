package by.epam.logic;

import by.epam.dao.factory.DAOFactory;
import by.epam.entities.Administrator;
import by.epam.entities.Client;
import by.epam.enums.DataBaseType;
import by.epam.managers.Log4jManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.sql.SQLException;
import java.util.List;

/**
 * Works directly with dao layer, check login and password
 *
 * @author Yury Druzenok
 * @version 1.0 7 Dec 2015
 */
public class LoginLogic {
    public static boolean isAdmin = false;

    public static int checkLogin(String login, String password) {
        int id = -1;
        DAOFactory dao = DAOFactory.getDAOFactory(DataBaseType.MYSQL);
        try {
            List<Client> clients = dao.getClientDAO().findAll();
            List<Administrator> administrators = dao.getAdministratorDAO().findAll();
            for (Client c : clients) {
                if (c.getLogin().equals(login) && c.getPassword().equals(password)) {
                    id = c.getId();
                }
            }
            for (Administrator c : administrators) {
                if (c.getLogin().equals(login) && c.getPassword().equals(password)) {
                    id = c.getId();
                    isAdmin = true;
                }
            }

        } catch (SQLException e) {
            System.err.print(e.getMessage());
            Log4jManager.error(e.getMessage());
        }

        return id;
    }

    public static boolean checkLogin(String login) {
        boolean success = false;
        DAOFactory dao = DAOFactory.getDAOFactory(DataBaseType.MYSQL);
        try {
            List<Client> clients = dao.getClientDAO().findAll();
            List<Administrator> administrators = dao.getAdministratorDAO().findAll();

            for (Client c : clients) {
                if (c.getLogin().equals(login)) {
                    success = true;
                }
            }

            for (Administrator c : administrators) {
                if (c.getLogin().equals(login)) {
                    success = true;
                }
            }
        } catch (SQLException e) {
            System.err.print(e.getMessage());
            Log4jManager.error(e.getMessage());
        }

        return success;
    }
}
