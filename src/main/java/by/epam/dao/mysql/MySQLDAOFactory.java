package by.epam.dao.mysql;

import by.epam.dao.factory.AbstractDAO;
import by.epam.dao.factory.DAOFactory;
import by.epam.enums.DataBaseType;
import by.epam.pool.ConnectionPool;

/**
 * Provide access to all dao objects for MySQL data base
 *
 * @author Yury Druzenok
 * @version 1.3 Changed whole structure 10 Nov 2015
 */
public class MySQLDAOFactory extends DAOFactory {
    public static ConnectionPool pool;

    public MySQLDAOFactory(DataBaseType type) {

        pool = ConnectionPool.getConnectionPool(type);
    }

    @Override
    public AbstractDAO getClientDAO() {

        return new MySQLClientDAO();
    }

    @Override
    public AbstractDAO getAdministratorDAO() {

        return new MySQLAdministratorDAO();
    }

    @Override
    public AbstractDAO getBillDAO() {
        return new MySQLBillDAO();
    }

    @Override
    public AbstractDAO getRequestDAO() {

        return new MySQLRequestDAO();
    }

    @Override
    public AbstractDAO getRoomDAO() {

        return new MySQLRoomDAO();
    }

    @Override
    public AbstractDAO getRoomGuideDAO() {

        return new MySQLRoomGuideDAO();
    }
}
