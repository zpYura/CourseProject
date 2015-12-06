package by.epam.dao.sqlite;

import by.epam.dao.factory.AbstractDAO;
import by.epam.dao.objects.RequestDAO;
import by.epam.entities.Request;

import java.sql.SQLException;
import java.util.List;

/**
 * Override methods to work with request's table in SQLite data base
 *
 * @version 1.0 1 Dec 2015
 * @author Yury Druzenok
 */
public class SQLiteRequestDAO extends AbstractDAO<Integer, Request> {
    @Override
    public List<Request> findAll() throws SQLException {
        return new RequestDAO(SQLiteDAOFactory.pool).findAll();
    }

    @Override
    public Request findEntityById(Integer id) throws SQLException {
        return new RequestDAO(SQLiteDAOFactory.pool).findEntityById(id);
    }

    @Override
    public boolean delete(Integer id) throws SQLException {
        return new RequestDAO(SQLiteDAOFactory.pool).delete(id);
    }

    @Override
    public boolean delete(Request entity) throws SQLException {
        return new RequestDAO(SQLiteDAOFactory.pool).delete(entity);
    }

    @Override
    public boolean create(Request entity) throws SQLException {
        return new RequestDAO(SQLiteDAOFactory.pool).create(entity);
    }

    @Override
    public boolean update(Request entity) throws SQLException {
        return new RequestDAO(SQLiteDAOFactory.pool).update(entity);
    }
}
