package by.epam.dao.objects;

import by.epam.dao.factory.AbstractDAO;
import by.epam.entities.Administrator;
import by.epam.managers.DataBaseConfigurationManager;
import by.epam.pool.ConnectionPool;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Override methods to work with administrator's table in data base
 *
 * @version 1.2 Added logging 24 Nov 2015
 * @author Yury Druzenok
 */
public class AdministratorDAO extends AbstractDAO<Integer,Administrator> {
    // keep string of select request
    private static final String SQL_SELECT_ALL_ADMINISTRATORS = DataBaseConfigurationManager.get("admin.selectAll");
    // connection pool link
    private static ConnectionPool pool;
    // keep string of select by id request
    private static final String SQL_SELECT_ADMINISTRATORS_BY_ID = DataBaseConfigurationManager.get("admin.selectById");
    // keep string of delete by id request
    private static final String SQL_DELETE_ADMINISTRATORS_BY_ID = DataBaseConfigurationManager.get("admin.deleteById");
    // keep string of insert request
    private static final String SQL_INSERT_ADMINISTRATORS = DataBaseConfigurationManager.get("admin.insert");
    // keep string of update request
    private static final String SQL_UPDATE_ADMINISTRATORS = DataBaseConfigurationManager.get("admin.update");

    public AdministratorDAO(ConnectionPool pool){
        this.pool= pool;
    }

    static{
        new DOMConfigurator().doConfigure("log4j.xml", LogManager.getLoggerRepository());
    }
    // logger for this class
    static Logger logger = Logger.getLogger(AdministratorDAO.class);

    @Override
    public List<Administrator> findAll() throws SQLException {
        List<Administrator> administrators = new ArrayList<Administrator>();
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = pool.getConnection();
            st = cn.prepareStatement(SQL_SELECT_ALL_ADMINISTRATORS);
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name1 = resultSet.getString(2);
                String name2 = resultSet.getString(3);
                String name3 = resultSet.getString(4);
                Date date = resultSet.getDate(5);
                String address = resultSet.getString(6);
                String phone = resultSet.getString(7);
                Date entryInThePostDate = resultSet.getDate(8);
                String login = resultSet.getString(9);
                String password = resultSet.getString(10);
                administrators.add(new Administrator(id, name1, name2, name3, date, address, phone, entryInThePostDate, login, password));
            }
        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
            logger.error("SQL exception (request or table failed):", e);
        } finally {
            if(st != null)
            st.close();
            pool.putConnection(cn);
        }
        logger.info(String.format("%d administrators were selected", administrators.size()));
        return administrators;

    }

    @Override
    public Administrator findEntityById(Integer id) throws SQLException {
        Administrator administrator = null;
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = pool.getConnection();
            st = cn.prepareStatement(SQL_SELECT_ADMINISTRATORS_BY_ID +id);
            ResultSet resultSet = st.executeQuery();
            String name1 = resultSet.getString(2);
            String name2 = resultSet.getString(3);
            String name3 = resultSet.getString(4);
            Date date = resultSet.getDate(5);
            String address = resultSet.getString(6);
            String phone = resultSet.getString(7);
            Date entryInThePostDate = resultSet.getDate(8);
            String login = resultSet.getString(9);
            String password = resultSet.getString(10);
            administrator = new Administrator(id, name1, name2,name3,date,address,phone,entryInThePostDate, login, password);

        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
            logger.error("SQL exception (request or table failed):", e);
        } finally {
            if(st != null)
            st.close();
            pool.putConnection(cn);
        }
        logger.info(String.format("Administrator with id %d was selected", id));
        return administrator;

    }

    @Override
    public boolean delete(Integer id) throws SQLException {
        boolean success = false;
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = pool.getConnection();
            st = cn.prepareStatement(SQL_DELETE_ADMINISTRATORS_BY_ID + id);
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
        logger.info(String.format("Administrator with id %d was deleted", id));
        return success;
    }

    @Override
    public boolean delete(Administrator entity) throws SQLException {
        boolean success = false;
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = pool.getConnection();
            st = cn.prepareStatement(SQL_DELETE_ADMINISTRATORS_BY_ID + entity.getId());
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
        logger.info(String.format("Administrator with id %d was deleted", entity.getId()));
        return success;
    }

    @Override
    public boolean create(Administrator entity) throws SQLException {
        boolean success = false;
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = pool.getConnection();
            st = cn.prepareStatement(SQL_INSERT_ADMINISTRATORS);
            st.setString(1, entity.getLastName());
            st.setString(2, entity.getFirstName());
            st.setString(3, entity.getMiddleName());
            st.setDate(4, new java.sql.Date(entity.getBirthDate().getTime()));
            st.setString(5, entity.getAddress());
            st.setString(6, entity.getPhoneNumber());
            st.setDate(7, new java.sql.Date(entity.getEntryInThePostDate().getTime()));
            st.setString(8, entity.getLogin());
            st.setString(9, entity.getPassword());
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
        logger.info(String.format("Administrator with id %d was added", entity.getId()));
        return success;
    }

    @Override
    public boolean update(Administrator entity) throws SQLException {
        boolean success = false;
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = pool.getConnection();
            st = cn.prepareStatement(SQL_UPDATE_ADMINISTRATORS + entity.getId());
            st.setString(1, entity.getLastName());
            st.setString(2, entity.getFirstName());
            st.setString(3, entity.getMiddleName());
            st.setDate(4, new java.sql.Date(entity.getBirthDate().getTime()));
            st.setString(5, entity.getAddress());
            st.setString(6, entity.getPhoneNumber());
            st.setDate(7, new java.sql.Date(entity.getEntryInThePostDate().getTime()));
            st.setString(8, entity.getLogin());
            st.setString(9, entity.getPassword());
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
        logger.info(String.format("Administrator with id %d was changed", entity.getId()));
        return success;
    }
}
