package by.epam.logic;

import by.epam.dao.factory.DAOFactory;
import by.epam.entities.Administrator;
import by.epam.entities.Client;
import by.epam.enums.DataBaseType;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.sql.SQLException;
import java.util.List;

/**
 * Works directly with dao layer, check login and password
 *
 * @version 1.0 7 Dec 2015
 * @author Yury Druzenok
 */
public class LoginLogic {
    static{
        new DOMConfigurator().doConfigure("log4j.xml", LogManager.getLoggerRepository());
    }
    static Logger logger = Logger.getLogger(SigUpLogic.class);

    public static boolean checkLogin(String login, String password){
        boolean success = false;
        DAOFactory dao = DAOFactory.getDAOFactory(DataBaseType.MYSQL);
        try{
            List<Client> clients = dao.getClientDAO().findAll();
            for(Client c:clients)
            {
                if(c.getLogin().equals(login)&&c.getPassword().equals(password))
                {
                    success = true;
                }
            }

        }
        catch (SQLException exp){
            System.err.print(exp.getMessage());
            logger.error("SQL exception (request or table failed):", exp);
        }

        return success;
    }
}
