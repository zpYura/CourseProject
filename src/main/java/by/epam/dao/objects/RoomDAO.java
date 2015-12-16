package by.epam.dao.objects;

import by.epam.dao.factory.AbstractDAO;
import by.epam.enums.ApartmentType;
import by.epam.entities.Room;
import by.epam.managers.ConfigurationManager;
import by.epam.managers.Log4jManager;
import by.epam.pool.ConnectionPool;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Override methods to work with room's table in data base
 *
 * @author Yury Druzenok
 * @version 1.2 Added logging 24 Nov 2015
 */
public class RoomDAO extends AbstractDAO<Integer, Room> {
    private static final String SQL_SELECT_ALL_ROOMS = ConfigurationManager.get("room.selectAll");
    private static ConnectionPool pool;
    private static final String SQL_SELECT_ROOMS_BY_ID = ConfigurationManager.get("room.selectById");
    private static final String SQL_DELETE_ROOMS_BY_ID = ConfigurationManager.get("room.deleteById");
    private static final String SQL_INSERT_ROOMS = ConfigurationManager.get("room.insert");
    private static final String SQL_UPDATE_ROOMS = ConfigurationManager.get("room.update");
//    static{
//        new DOMConfigurator().doConfigure("log4j.xml", LogManager.getLoggerRepository());
//    }
//    static Logger logger = Logger.getLogger(RoomDAO.class);

    public RoomDAO(ConnectionPool pool) {
        this.pool = pool;
    }

    @Override
    public List<Room> findAll() throws SQLException {
        List<Room> rooms = new ArrayList<Room>();
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = pool.getConnection();
            st = cn.prepareStatement(SQL_SELECT_ALL_ROOMS);
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int beds = resultSet.getInt(2);
                String type = resultSet.getString(3);
                int cost = resultSet.getInt(4);
                Date date = resultSet.getDate(5);
                rooms.add(new Room(id, beds, ApartmentType.valueOf(type), cost, date));
            }
        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
            Log4jManager.error("SQL exception (request or table failed):" + e);
        } finally {
            if (st != null)
                st.close();
            pool.putConnection(cn);
        }
        Log4jManager.info(String.format("%d rooms were selected", rooms.size()));
        return rooms;
    }

    @Override
    public Room findEntityById(Integer id) throws SQLException {
        Room room = null;
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = pool.getConnection();
            st = cn.prepareStatement(SQL_SELECT_ROOMS_BY_ID + id);
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                int beds = resultSet.getInt(2);
                String type = resultSet.getString(3);
                int cost = resultSet.getInt(4);
                Date date = resultSet.getDate(5);
                room = new Room(id, beds, ApartmentType.valueOf(type), cost, date);
            }
        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
            Log4jManager.error("SQL exception (request or table failed):" + e);
        } finally {
            if (st != null)
                st.close();
            pool.putConnection(cn);
        }
        Log4jManager.info(String.format("Room with id %d was selected", id));
        return room;
    }

    @Override
    public boolean delete(Integer id) throws SQLException {
        boolean success = false;
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = pool.getConnection();
            st = cn.prepareStatement(SQL_DELETE_ROOMS_BY_ID + id);
            st.executeUpdate();
            success = true;
        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
            Log4jManager.error("SQL exception (request or table failed):" + e);
        } finally {
            if (st != null)
                st.close();
            pool.putConnection(cn);
        }
        Log4jManager.info(String.format("Room with id %d was deleted", id));
        return success;
    }

    @Override
    public boolean delete(Room entity) throws SQLException {
        boolean success = false;
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = pool.getConnection();
            st = cn.prepareStatement(SQL_DELETE_ROOMS_BY_ID + entity.getId());
            st.executeUpdate();
            success = true;
        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
            Log4jManager.error("SQL exception (request or table failed):" + e);
        } finally {
            if (st != null)
                st.close();
            pool.putConnection(cn);
        }
        Log4jManager.info(String.format("Room with id %d was deleted", entity.getId()));
        return success;
    }

    @Override
    public boolean create(Room entity) throws SQLException {
        boolean success = false;
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = pool.getConnection();
            st = cn.prepareStatement(SQL_INSERT_ROOMS);
            st.setInt(1, entity.getNumberOfbeds());
            st.setString(2, entity.getType().toString());
            st.setInt(3, entity.getCostPerDay());
            st.setDate(4, new java.sql.Date(entity.getReleaseDate().getTime()));
            st.executeUpdate();
            success = true;
        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
            Log4jManager.error("SQL exception (request or table failed):" + e);
        } finally {
            if (st != null)
                st.close();
            pool.putConnection(cn);
        }
        Log4jManager.info(String.format("Room with id %d was added", entity.getId()));
        return success;
    }

    @Override
    public boolean update(Room entity) throws SQLException {
        boolean success = false;
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = pool.getConnection();
            st = cn.prepareStatement(SQL_UPDATE_ROOMS + entity.getId());
            st.setInt(1, entity.getNumberOfbeds());
            st.setString(2, entity.getType().toString());
            st.setInt(3, entity.getCostPerDay());
            st.setDate(4, new java.sql.Date(entity.getReleaseDate().getTime()));
            st.executeUpdate();
            success = true;
        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
            Log4jManager.error("SQL exception (request or table failed):" + e);
        } finally {
            if (st != null)
                st.close();
            pool.putConnection(cn);
        }
        Log4jManager.info(String.format("Room with id %d was changed", entity.getId()));
        return success;
    }
}
