package by.epam.dao.sqlite;

import by.epam.dao.factory.AbstractDAO;
import by.epam.dao.objects.RoomGuideDAO;
import by.epam.entities.RoomGuide;

import java.sql.SQLException;
import java.util.List;

/**
 * Override methods to work with roomguide's table in SQLite data base
 *
 * @version 1.0 1 Dec 2015
 * @author Yury Druzenok
 */
public class SQLiteRoomGuideDAO extends AbstractDAO<Integer, RoomGuide> {
    @Override
    public List<RoomGuide> findAll() throws SQLException {
        return new RoomGuideDAO(SQLiteDAOFactory.pool).findAll();
    }

    @Override
    public RoomGuide findEntityById(Integer id) throws SQLException {
        return new RoomGuideDAO(SQLiteDAOFactory.pool).findEntityById(id);
    }

    @Override
    public boolean delete(Integer id) throws SQLException {
        return new RoomGuideDAO(SQLiteDAOFactory.pool).delete(id);
    }

    @Override
    public boolean delete(RoomGuide entity) throws SQLException {
        return new RoomGuideDAO(SQLiteDAOFactory.pool).delete(entity);
    }

    @Override
    public boolean create(RoomGuide entity) throws SQLException {
        return new RoomGuideDAO(SQLiteDAOFactory.pool).create(entity);
    }

    @Override
    public boolean update(RoomGuide entity) throws SQLException {
        return new RoomGuideDAO(SQLiteDAOFactory.pool).update(entity);
    }
}
