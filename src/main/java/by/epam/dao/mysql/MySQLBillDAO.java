package by.epam.dao.mysql;

import by.epam.dao.factory.AbstractDAO;
import by.epam.dao.objects.BillDAO;
import by.epam.entities.Bill;

import java.sql.SQLException;
import java.util.List;

/**
 * Override methods to work with bill's table in MySQL data base
 *
 * @version 1.0 1 Dec 2015
 * @author Yury Druzenok
 */
public class MySQLBillDAO extends AbstractDAO<Integer, Bill> {
    @Override
    public List<Bill> findAll() throws SQLException {
        return new BillDAO(MySQLDAOFactory.pool).findAll();
    }

    @Override
    public Bill findEntityById(Integer id) throws SQLException {
        return new BillDAO(MySQLDAOFactory.pool).findEntityById(id);
    }

    @Override
    public boolean delete(Integer id) throws SQLException {
        return new BillDAO(MySQLDAOFactory.pool).delete(id);
    }

    @Override
    public boolean delete(Bill entity) throws SQLException {
        return new BillDAO(MySQLDAOFactory.pool).delete(entity);
    }

    @Override
    public boolean create(Bill entity) throws SQLException {
        return new BillDAO(MySQLDAOFactory.pool).create(entity);
    }

    @Override
    public boolean update(Bill entity) throws SQLException {
        return new BillDAO(MySQLDAOFactory.pool).update(entity);
    }
}
