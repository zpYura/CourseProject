package by.epam.logic;

import by.epam.dao.factory.DAOFactory;
import by.epam.entities.Client;
import by.epam.enums.DataBaseType;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.sql.SQLException;

/**
 * Works directly with dao layer, create new client in data base
 *
 * @version 1.0 7 Dec 2015
 * @author Yury Druzenok
 */
public class SigUpLogic {
    static{
        new DOMConfigurator().doConfigure("log4j.xml", LogManager.getLoggerRepository());
    }
    static Logger logger = Logger.getLogger(SigUpLogic.class);

    public static boolean createClient(Client client)
    {
        boolean success = false;
        DAOFactory dao = DAOFactory.getDAOFactory(DataBaseType.MYSQL);
        try{
            success = dao.getClientDAO().create(client);
        }
        catch (SQLException exp){
            System.err.print(exp.getMessage());
            logger.error("SQL exception (request or table failed):", exp);
        }

        return success;
    }
}
