package by.epam.dao.objects;

import by.epam.dao.factory.AbstractDAO;
import by.epam.entities.RoomGuide;
import by.epam.managers.DataBaseConfigurationManager;
import by.epam.pool.ConnectionPool;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Override methods to work with roomguide's table in data base
 *
 * @version 1.2 Added logging 24 Nov 2015
 * @author Yury Druzenok
 */
public class RoomGuideDAO extends AbstractDAO<Integer,RoomGuide> {
    private static final String SQL_SELECT_ALL_ROOM_GUIDE = DataBaseConfigurationManager.get("roomGuide.selectAll");
    private static ConnectionPool pool;
    private static final String SQL_SELECT_ROOM_GUIDE_BY_ID = DataBaseConfigurationManager.get("roomGuide.selectById");
    private static final String SQL_DELETE_ROOM_GUIDE_BY_ID = DataBaseConfigurationManager.get("roomGuide.deleteById");
    private static final String SQL_INSERT_ROOM_GUIDE = DataBaseConfigurationManager.get("roomGuide.insert");
    private static final String SQL_UPDATE_ROOM_GUIDE = DataBaseConfigurationManager.get("roomGuide.update");
    static{
        new DOMConfigurator().doConfigure("log4j.xml", LogManager.getLoggerRepository());
    }
    static Logger logger = Logger.getLogger(RoomGuideDAO.class);

    public RoomGuideDAO(ConnectionPool pool){
        this.pool= pool;
    }

    @Override
    public List<RoomGuide> findAll() throws SQLException {
        List<RoomGuide> roomGuides = new ArrayList<RoomGuide>();
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = pool.getConnection();
            st = cn.prepareStatement(SQL_SELECT_ALL_ROOM_GUIDE);
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int id1 = resultSet.getInt(2);
                int id2 = resultSet.getInt(3);
                int id3 = resultSet.getInt(4);
                roomGuides.add(new RoomGuide(id, id1, id2, id3));
            }
        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
            logger.error("SQL exception (request or table failed):", e);
        } finally {
            if(st != null)
            st.close();
            pool.putConnection(cn);
        }
        logger.info(String.format("%d roomGuides were selected", roomGuides.size()));
        return roomGuides;
    }

    @Override
    public RoomGuide findEntityById(Integer id) throws SQLException {
        RoomGuide roomGuide = null;
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = pool.getConnection();
            st = cn.prepareStatement(SQL_SELECT_ROOM_GUIDE_BY_ID +id);
            ResultSet resultSet = st.executeQuery();
            int id1 = resultSet.getInt(2);
            int id2 = resultSet.getInt(3);
            int id3 = resultSet.getInt(4);
            roomGuide = new RoomGuide(id, id1, id2,id3);

        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
            logger.error("SQL exception (request or table failed):", e);
        } finally {
            if(st != null)
            st.close();
            pool.putConnection(cn);
        }
        logger.info(String.format("RoomGuide with id %d was selected", id));
        return roomGuide;

    }

    @Override
    public boolean delete(Integer id) throws SQLException {
        boolean success = false;
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = pool.getConnection();
            st = cn.prepareStatement(SQL_DELETE_ROOM_GUIDE_BY_ID + id);
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
        logger.info(String.format("RoomGuide with id %d was deleted", id));
        return success;
    }

    @Override
    public boolean delete(RoomGuide entity) throws SQLException {
        boolean success = false;
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = pool.getConnection();
            st = cn.prepareStatement(SQL_DELETE_ROOM_GUIDE_BY_ID + entity.getId());
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
        logger.info(String.format("RoomGuide with id %d was deleted", entity.getId()));
        return success;
    }

    @Override
    public boolean create(RoomGuide entity) throws SQLException {
        boolean success = false;
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = pool.getConnection();
            st = cn.prepareStatement(SQL_INSERT_ROOM_GUIDE);
            st.setInt(1, entity.getRoomId());
            st.setInt(2, entity.getRequestId());
            st.setInt(3, entity.getBillId());
            st.executeUpdate();
            success = true;
        } catch (SQLException e) {
            logger.error("SQL exception (request or table failed):", e);
            System.err.println("SQL exception (request or table failed): " + e);
        } finally {
            if(st != null)
            st.close();
            pool.putConnection(cn);
        }
        logger.info(String.format("RoomGuide with id %d was added", entity.getId()));
        return success;
    }

    @Override
    public boolean update(RoomGuide entity) throws SQLException {
        boolean success = false;
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = pool.getConnection();
            st = cn.prepareStatement(SQL_UPDATE_ROOM_GUIDE + entity.getId());
            st.setInt(1, entity.getRoomId());
            st.setInt(2, entity.getRequestId());
            st.setInt(3, entity.getBillId());
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
        logger.info(String.format("RoomGuide with id %d was changed", entity.getId()));
        return success;
    }
}
