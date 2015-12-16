package by.epam.pool;

import by.epam.managers.ConfigurationManager;
import org.sqlite.SQLiteDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Represent new connection pool for SQLite data base
 *
 * @author Yury Druzenok
 * @version 1.0 30 Nov 2015
 */
public class SQLiteConnectionPool extends ConnectionPool {
    SQLiteDataSource sqLiteDataSource;

    public SQLiteConnectionPool() {
        sqLiteDataSource = new SQLiteDataSource();
        sqLiteDataSource.setUrl(ConfigurationManager.get("sqlitedb.host"));
    }

    @Override
    public synchronized Connection getConnection() throws SQLException {
        return sqLiteDataSource.getConnection();
    }

    @Override
    public synchronized void putConnection(Connection connection) throws SQLException {
        connection.close();
    }
}
