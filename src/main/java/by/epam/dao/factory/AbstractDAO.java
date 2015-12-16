package by.epam.dao.factory;

import by.epam.entities.Entity;

import java.sql.SQLException;
import java.util.List;

/**
 * Interface that provide common methods for database access
 *
 * @author Yury Druzenok
 * @version 1.0 11 Nov 2015
 */
public abstract class AbstractDAO<K extends Integer, T extends Entity> {
    public abstract List<T> findAll() throws SQLException;

    public abstract T findEntityById(K id) throws SQLException;

    public abstract boolean delete(K id) throws SQLException;

    public abstract boolean delete(T entity) throws SQLException;

    public abstract boolean create(T entity) throws SQLException;

    public abstract boolean update(T entity) throws SQLException;
}