package by.epam.dao.objects;

import by.epam.dao.factory.AbstractDAO;
import by.epam.entities.Bill;
import by.epam.pool.ConnectionPool;
import by.epam.settings.AppSettings;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Override methods to work with bill's table in data base
 *
 * @version 1.2 Added logging 24 Nov 2015
 * @author Yury Druzenok
 */
public class BillDAO extends AbstractDAO<Integer,Bill> {
    private static final String SQL_SELECT_ALL_BILLS = AppSettings.get("bill.selectAll");
    private static ConnectionPool pool;
    private static final String SQL_SELECT_BILLS_BY_ID = AppSettings.get("bill.selectById");
    private static final String SQL_DELETE_BILLS_BY_ID = AppSettings.get("bill.deleteById");
    private static final String SQL_INSERT_BILLS = AppSettings.get("bill.insert");
    private static final String SQL_UPDATE_BILLS = AppSettings.get("bill.update");
    static{
        new DOMConfigurator().doConfigure("log4j.xml", LogManager.getLoggerRepository());
    }
    static Logger logger = Logger.getLogger(BillDAO.class);

    public BillDAO(ConnectionPool pool){
        this.pool= pool;
    }

    @Override
    public List<Bill> findAll() throws SQLException {
        List<Bill> bills = new ArrayList<Bill>();
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = pool.getConnection();
            st = cn.prepareStatement(SQL_SELECT_ALL_BILLS);
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int cost = resultSet.getInt(2);
                bills.add(new Bill(id, cost));
            }
        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
            logger.error("SQL exception (request or table failed):", e);
        } finally {
            if(st != null)
            st.close();
            pool.putConnection(cn);
        }
        logger.info(String.format("%d bills were selected", bills.size()));
        return bills;
    }

    @Override
    public Bill findEntityById(Integer id) throws SQLException {
        Bill bill = null;
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = pool.getConnection();
            st = cn.prepareStatement(SQL_SELECT_BILLS_BY_ID +id);
            ResultSet resultSet = st.executeQuery();
            int cost = resultSet.getInt(2);
            bill = new Bill(id, cost);

        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
            logger.error("SQL exception (request or table failed):", e);
        } finally {
            if(st != null)
            st.close();
            pool.putConnection(cn);
        }
        logger.info(String.format("Bill with id %d was selected", id));
        return bill;

    }

    @Override
    public boolean delete(Integer id) throws SQLException {
        boolean success = false;
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = pool.getConnection();
            st = cn.prepareStatement(SQL_DELETE_BILLS_BY_ID + id);
            st.executeUpdate();
            success = true;
        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
            logger.error("SQL exception (request or table failed):", e);
        } finally {
            if(st != null)
            st.close();
            pool.putConnection(cn);
        }
        logger.info(String.format("Bill with id %d was deleted", id));
        return success;
    }

    @Override
    public boolean delete(Bill entity) throws SQLException {
        boolean success = false;
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = pool.getConnection();
            st = cn.prepareStatement(SQL_DELETE_BILLS_BY_ID + entity.getId());
            st.executeUpdate();
            success = true;
        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
            logger.error("SQL exception (request or table failed):", e);
        } finally {
            if(st != null)
            st.close();
            pool.putConnection(cn);
        }
        logger.info(String.format("Bill with id %d was deleted", entity.getId()));
        return success;
    }

    @Override
    public boolean create(Bill entity) throws SQLException {
        boolean success = false;
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = pool.getConnection();
            st = cn.prepareStatement(SQL_INSERT_BILLS);
            st.setInt(1, entity.getCost());
            st.executeUpdate();
            success = true;
        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
            logger.error("SQL exception (request or table failed):", e);
        } finally {
            if(st != null)
            st.close();
            pool.putConnection(cn);
        }
        logger.info(String.format("Bill with id %d was added", entity.getId()));
        return success;
    }

    @Override
    public boolean update(Bill entity) throws SQLException {
        boolean success = false;
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = pool.getConnection();
            st = cn.prepareStatement(SQL_UPDATE_BILLS + entity.getId());
            st.setInt(1, entity.getCost());
            st.executeUpdate();
            success = true;
        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
            logger.error("SQL exception (request or table failed):", e);
        } finally {
            if(st != null)
            st.close();
            pool.putConnection(cn);
        }
        logger.info(String.format("Bill with id %d was changed", entity.getId()));
        return success;
    }
}
