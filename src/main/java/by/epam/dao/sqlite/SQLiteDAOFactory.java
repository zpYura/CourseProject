package by.epam.dao.sqlite;

import by.epam.dao.factory.AbstractDAO;
import by.epam.dao.factory.DAOFactory;
import by.epam.enums.DataBaseType;
import by.epam.pool.ConnectionPool;

/**
 * Provide access to all dao objects for SQLite data base
 *
 * @version 1.0  30 Nov 2015
 * @author Yury Druzenok
 */
public class SQLiteDAOFactory extends DAOFactory {
    public static ConnectionPool pool;

    public SQLiteDAOFactory(DataBaseType type) {
        pool = ConnectionPool.getConnectionPool(type);
    }

    @Override
    public AbstractDAO getClientDAO() {
        return new SQLiteClientDAO();
    }

    @Override
    public AbstractDAO getAdministratorDAO() {
        return new SQLiteAdministratorDAO();
    }

    @Override
    public AbstractDAO getBillDAO() {
        return new SQLiteBillDAO();
    }

    @Override
    public AbstractDAO getRequestDAO() {
       return new SQLiteRequestDAO();
    }

    @Override
    public AbstractDAO getRoomDAO() {
        return new SQLiteRoomDAO();
    }

    @Override
    public AbstractDAO getRoomGuideDAO() {
        return new SQLiteRoomGuideDAO();
    }
}
