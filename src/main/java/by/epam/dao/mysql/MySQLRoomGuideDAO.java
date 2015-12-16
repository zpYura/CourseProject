package by.epam.dao.mysql;

import by.epam.dao.factory.AbstractDAO;
import by.epam.dao.objects.RoomGuideDAO;
import by.epam.entities.RoomGuide;

import java.sql.SQLException;
import java.util.List;

/**
 * Override methods to work with roomguide's table in MySQl data base
 *
 * @author Yury Druzenok
 * @version 1.0 1 Dec 2015
 */
public class MySQLRoomGuideDAO extends AbstractDAO<Integer, RoomGuide> {
    @Override
    public List<RoomGuide> findAll() throws SQLException {
        return new RoomGuideDAO(MySQLDAOFactory.pool).findAll();
    }

    @Override
    public RoomGuide findEntityById(Integer id) throws SQLException {
        return new RoomGuideDAO(MySQLDAOFactory.pool).findEntityById(id);
    }

    @Override
    public boolean delete(Integer id) throws SQLException {
        return new RoomGuideDAO(MySQLDAOFactory.pool).delete(id);
    }

    @Override
    public boolean delete(RoomGuide entity) throws SQLException {
        return new RoomGuideDAO(MySQLDAOFactory.pool).delete(entity);
    }

    @Override
    public boolean create(RoomGuide entity) throws SQLException {
        return new RoomGuideDAO(MySQLDAOFactory.pool).create(entity);
    }

    @Override
    public boolean update(RoomGuide entity) throws SQLException {
        return new RoomGuideDAO(MySQLDAOFactory.pool).update(entity);
    }
}
