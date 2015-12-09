package by.epam.dao.objects;

import by.epam.dao.factory.AbstractDAO;
import by.epam.entities.Client;
import by.epam.managers.DataBaseConfigurationManager;
import by.epam.pool.ConnectionPool;
import org.apache.log4j.LogManager;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Override methods to work with client's table in data base
 *
 * @version 1.2 Added logging 24 Nov 2015
 * @author Yury Druzenok
 */
public class ClientDAO extends AbstractDAO<Integer,Client> {
    private static final String SQL_SELECT_ALL_CLIENTS = DataBaseConfigurationManager.get("client.selectAll");
    private static ConnectionPool pool;
    private static final String SQL_SELECT_CLIENTS_BY_ID = DataBaseConfigurationManager.get("client.selectById");
    private static final String SQL_DELETE_CLIENTS_BY_ID = DataBaseConfigurationManager.get("client.deleteById");
    private static final String SQL_INSERT_CLIENTS = DataBaseConfigurationManager.get("client.insert");
    private static final String SQL_UPDATE_CLIENTS = DataBaseConfigurationManager.get("client.update");
    static{
        new DOMConfigurator().doConfigure("log4j.xml", LogManager.getLoggerRepository());
    }
    static Logger logger = Logger.getLogger(ClientDAO.class);

    public ClientDAO(ConnectionPool pool){
        this.pool= pool;
    }

    @Override
    public List<Client> findAll() throws SQLException{
        List<Client> clients = new ArrayList<Client>();
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = pool.getConnection();
            st = cn.prepareStatement(SQL_SELECT_ALL_CLIENTS);
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name1 = resultSet.getString(2);
                String name2 = resultSet.getString(3);
                String name3 = resultSet.getString(4);
                Date date = resultSet.getDate(5);
                String address = resultSet.getString(6);
                String phone = resultSet.getString(7);
                String mail = resultSet.getString(8);
                String login = resultSet.getString(9);
                String password = resultSet.getString(10);
                clients.add(new Client(id, name1, name2, name3, date, address, phone, mail, login, password));
            }
        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
            logger.error("SQL exception (request or table failed):", e);
        } finally {
            if(st != null)
            st.close();
            pool.putConnection(cn);
        }
        logger.info(String.format("%d clients were selected", clients.size()));
        return clients;

    }

    @Override
    public Client findEntityById(Integer id) throws SQLException {
        Client client = null;
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = pool.getConnection();
            st = cn.prepareStatement(SQL_SELECT_CLIENTS_BY_ID +id);
            ResultSet resultSet = st.executeQuery();
                String name1 = resultSet.getString(2);
                String name2 = resultSet.getString(3);
                String name3 = resultSet.getString(4);
                Date date = resultSet.getDate(5);
                String address = resultSet.getString(6);
                String phone = resultSet.getString(7);
                String mail = resultSet.getString(8);
                String login = resultSet.getString(9);
                String password = resultSet.getString(10);
                client = new Client(id, name1, name2, name3, date, address ,phone, mail, login, password);

        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
            logger.error("SQL exception (request or table failed):", e);
        } finally {
            if(st != null)
            st.close();
            pool.putConnection(cn);
        }
        logger.info(String.format("Client with id %d was selected", id));
        return client;

    }

    @Override
    public boolean delete(Integer id) throws SQLException{
        boolean success = false;
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = pool.getConnection();
            st = cn.prepareStatement(SQL_DELETE_CLIENTS_BY_ID + id);
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
        logger.info(String.format("Client with id %d was deleted", id));
        return success;
    }

    @Override
    public boolean delete(Client entity) throws SQLException{
        boolean success = false;
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = pool.getConnection();
            st = cn.prepareStatement(SQL_DELETE_CLIENTS_BY_ID + entity.getId());
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
        logger.info(String.format("Client with id %d was deleted", entity.getId()));
        return success;
    }

    @Override
    public boolean create(Client entity) throws SQLException{
        boolean success = false;
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = pool.getConnection();
            st = cn.prepareStatement(SQL_INSERT_CLIENTS);
            st.setString(1, entity.getLastName());
            st.setString(2, entity.getFirstName());
            st.setString(3, entity.getMiddleName());
            st.setDate(4, new java.sql.Date(entity.getBirthDate().getTime()));
            st.setString(5, entity.getAddress());
            st.setString(6, entity.getPhoneNumber());
            st.setString(7, entity.getEmail());
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
        logger.info(String.format("Client with id %d was added", entity.getId()));
        return success;
    }

    @Override
    public boolean update(Client entity) throws SQLException{

        boolean success = false;
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = pool.getConnection();
            st = cn.prepareStatement(SQL_UPDATE_CLIENTS + entity.getId());
            st.setString(1, entity.getLastName());
            st.setString(2, entity.getFirstName());
            st.setString(3, entity.getMiddleName());
            st.setDate(4, new java.sql.Date(entity.getBirthDate().getTime()));
            st.setString(5, entity.getAddress());
            st.setString(6, entity.getPhoneNumber());
            st.setString(7, entity.getEmail());
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
        logger.info(String.format("Client with id %d was changed", entity.getId()));
        return success;
    }
}
