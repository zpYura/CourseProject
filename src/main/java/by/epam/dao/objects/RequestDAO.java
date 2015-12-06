package by.epam.dao.objects;

import by.epam.dao.factory.AbstractDAO;
import by.epam.enums.ApartmentType;
import by.epam.entities.Request;
import by.epam.pool.ConnectionPool;
import by.epam.settings.AppSettings;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.sql.*;
import java.sql.Date;
import java.util.*;

/**
 * Override methods to work with request's table in data base
 *
 * @version 1.2 Added logging 24 Nov 2015
 * @author Yury Druzenok
 */
public class RequestDAO extends AbstractDAO<Integer,Request> {
    private static final String SQL_SELECT_ALL_REQUESTS = AppSettings.get("request.selectAll");
    private static ConnectionPool pool;
    private static final String SQL_SELECT_REQUESTS_BY_ID = AppSettings.get("request.selectById");
    private static final String SQL_DELETE_REQUESTS_BY_ID = AppSettings.get("request.deleteById");
    private static final String SQL_INSERT_REQUESTS = AppSettings.get("request.insert");
    private static final String SQL_UPDATE_REQUESTS = AppSettings.get("request.update");
    static{
        new DOMConfigurator().doConfigure("log4j.xml", LogManager.getLoggerRepository());
    }
    static Logger logger = Logger.getLogger(RequestDAO.class);

    public RequestDAO(ConnectionPool pool){
        this.pool= pool;
    }

    @Override
    public List<Request> findAll() throws SQLException {
        List<Request> requests = new ArrayList<Request>();
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = pool.getConnection();
            st = cn.prepareStatement(SQL_SELECT_ALL_REQUESTS);
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int beds= resultSet.getInt(2);
                String type = resultSet.getString(3);
                Date inDate = resultSet.getDate(4);
                Date date = resultSet.getDate(5);
                int max = resultSet.getInt(6);
                int min = resultSet.getInt(7);
                int clientId = resultSet.getInt(8);
                int adminId = resultSet.getInt(9);
                requests.add(new Request(id, beds, ApartmentType.valueOf(type), inDate, date, max, min, clientId, adminId));
            }
        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
            logger.error("SQL exception (request or table failed):", e);
        } finally {
            if(st != null)
            st.close();
            pool.putConnection(cn);
        }
        logger.info(String.format("%d requests were selected", requests.size()));
        return requests;
    }

    @Override
    public Request findEntityById(Integer id) throws SQLException {
        Request request = null;
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = pool.getConnection();
            st = cn.prepareStatement(SQL_SELECT_REQUESTS_BY_ID +id);
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {

                int beds= resultSet.getInt(2);
                String type = resultSet.getString(3);
                Date inDate = resultSet.getDate(4);
                Date date = resultSet.getDate(5);
                int max = resultSet.getInt(6);
                int min = resultSet.getInt(7);
                int clientId = resultSet.getInt(8);
                int adminId = resultSet.getInt(9);
                request = new Request(id, beds, ApartmentType.valueOf(type), inDate, date, max, min, clientId, adminId);
            }
        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
            logger.error("SQL exception (request or table failed):", e);
        } finally {
            if(st != null)
            st.close();
            pool.putConnection(cn);
        }
        logger.info(String.format("Request with id %d was selected", id));
        return request;
    }

    @Override
    public boolean delete(Integer id) throws SQLException {
        boolean success = false;
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = pool.getConnection();
            st = cn.prepareStatement(SQL_DELETE_REQUESTS_BY_ID + id);
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
        logger.info(String.format("Request with id %d was deleted", id));
        return success;
    }

    @Override
    public boolean delete(Request entity) throws SQLException {
        boolean success = false;
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = pool.getConnection();
            st = cn.prepareStatement(SQL_DELETE_REQUESTS_BY_ID + entity.getId());
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
        logger.info(String.format("Request with id %d was deleted", entity.getId()));
        return success;
    }

    @Override
    public boolean create(Request entity) throws SQLException {
        boolean success = false;
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = pool.getConnection();
            st = cn.prepareStatement(SQL_INSERT_REQUESTS);
            st.setInt(1, entity.getNumberOfbeds());
            st.setString(2, entity.getType().toString());
            st.setDate(3, new java.sql.Date(entity.getInDate().getTime()));
            st.setDate(4, new java.sql.Date(entity.getOutDate().getTime()));
            st.setInt(5, entity.getMaxCost());
            st.setInt(6, entity.getMinCost());
            st.setInt(7, entity.getClientId());
            st.setInt(8, entity.getAdminId());
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
        logger.info(String.format("Request with id %d was added", entity.getId()));
        return success;
    }

    @Override
    public boolean update(Request entity) throws SQLException {
        boolean success = false;
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = pool.getConnection();
            st = cn.prepareStatement(SQL_UPDATE_REQUESTS + entity.getId());
            st.setInt(1, entity.getNumberOfbeds());
            st.setString(2, entity.getType().toString());
            st.setDate(3, new java.sql.Date(entity.getInDate().getTime()));
            st.setDate(4, new java.sql.Date(entity.getOutDate().getTime()));
            st.setInt(5, entity.getMaxCost());
            st.setInt(6, entity.getMinCost());
            st.setInt(7, entity.getClientId());
            st.setInt(8, entity.getAdminId());
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
        logger.info(String.format("Request with id %d was changed", entity.getId()));
        return success;
    }
}
