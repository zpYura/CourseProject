package by.epam.pool;

import by.epam.managers.ConfigurationManager;
import org.sqlite.SQLiteDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Represent new connection pool for SQLite data base
 *
 * @version 1.0 30 Nov 2015
 * @author Yury Druzenok
 */
public class SQLiteConnectionPool extends ConnectionPool {
    SQLiteDataSource sqLiteDataSource;

    public SQLiteConnectionPool() {
        sqLiteDataSource = new SQLiteDataSource();
        sqLiteDataSource.setUrl(ConfigurationManager.get("sqlitedb.host"));
    }

    @Override
    public Connection getConnection() throws SQLException {
       return sqLiteDataSource.getConnection();
    }

    @Override
    public void putConnection(Connection connection) throws SQLException {
        connection.close();
    }
}
