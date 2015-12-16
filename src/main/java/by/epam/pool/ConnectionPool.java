package by.epam.pool;

import by.epam.enums.DataBaseType;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Represent new pool
 *
 * @author Yury Druzenok
 * @version 1.0 18 Nov 2015
 */
public abstract class ConnectionPool {
    public static ConnectionPool getConnectionPool(DataBaseType type) {
        ConnectionPool source;
        switch (type) {
            case MYSQL: {
                source = new MySQLConnectionPool();
            }
            break;
            case SQLITE: {
                source = new SQLiteConnectionPool();
            }
            break;
            default: {
                source = null;
            }
            break;
        }
        return source;

    }

    public abstract Connection getConnection() throws SQLException;

    public abstract void putConnection(Connection connection) throws SQLException;


}
