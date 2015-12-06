package by.epam.dao.sqlite;

import by.epam.dao.factory.AbstractDAO;
import by.epam.dao.objects.RoomDAO;
import by.epam.entities.Room;

import java.sql.SQLException;
import java.util.List;

/**
 * Override methods to work with room's table in SQLite data base
 *
 * @version 1.0 1 Dec 2015
 * @author Yury Druzenok
 */
public class SQLiteRoomDAO extends AbstractDAO<Integer, Room> {
    @Override
    public List<Room> findAll() throws SQLException {
        return new RoomDAO(SQLiteDAOFactory.pool).findAll();
    }

    @Override
    public Room findEntityById(Integer id) throws SQLException {
        return  new RoomDAO(SQLiteDAOFactory.pool).findEntityById(id);
    }

    @Override
    public boolean delete(Integer id) throws SQLException {
        return  new RoomDAO(SQLiteDAOFactory.pool).delete(id);
    }

    @Override
    public boolean delete(Room entity) throws SQLException {
        return  new RoomDAO(SQLiteDAOFactory.pool).delete(entity);
    }

    @Override
    public boolean create(Room entity) throws SQLException {
        return  new RoomDAO(SQLiteDAOFactory.pool).create(entity);
    }

    @Override
    public boolean update(Room entity) throws SQLException {
        return  new RoomDAO(SQLiteDAOFactory.pool).update(entity);
    }
}
