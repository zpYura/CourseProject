package by.epam.dao.mysql;

import by.epam.dao.factory.AbstractDAO;
import by.epam.dao.objects.ClientDAO;
import by.epam.entities.Client;

import java.sql.SQLException;
import java.util.List;

/**
 * Override methods to work with client's table in  MySQL data base
 *
 * @version 1.0  1 Dec 2015
 * @author Yury Druzenok
 */
public class MySQLClientDAO extends AbstractDAO<Integer, Client> {
    @Override
    public List<Client> findAll() throws SQLException {
        return new ClientDAO(MySQLDAOFactory.pool).findAll();
    }

    @Override
    public Client findEntityById(Integer id) throws SQLException {
        return new ClientDAO(MySQLDAOFactory.pool).findEntityById(id);
    }

    @Override
    public boolean delete(Integer id) throws SQLException {
        return new ClientDAO(MySQLDAOFactory.pool).delete(id);
    }

    @Override
    public boolean delete(Client entity) throws SQLException {
        return new ClientDAO(MySQLDAOFactory.pool).delete(entity);
    }

    @Override
    public boolean create(Client entity) throws SQLException {
        return new ClientDAO(MySQLDAOFactory.pool).create(entity);
    }

    @Override
    public boolean update(Client entity) throws SQLException {
        return new ClientDAO(MySQLDAOFactory.pool).update(entity);
    }
}
