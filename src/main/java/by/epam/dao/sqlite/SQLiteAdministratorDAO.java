package by.epam.dao.sqlite;

import by.epam.dao.factory.AbstractDAO;
import by.epam.dao.objects.AdministratorDAO;
import by.epam.entities.Administrator;

import java.sql.SQLException;
import java.util.List;

/**
 * Override methods to work with administrator's table in  SQLite data base
 *
 * @version 1.0  30 Nov 2015
 * @author Yury Druzenok
 */
public class SQLiteAdministratorDAO extends AbstractDAO<Integer, Administrator> {

    @Override
    public List<Administrator> findAll() throws SQLException {
      return new AdministratorDAO(SQLiteDAOFactory.pool).findAll();
    }

    @Override
    public Administrator findEntityById(Integer id) throws SQLException {
       return new AdministratorDAO(SQLiteDAOFactory.pool).findEntityById(id);
    }

    @Override
    public boolean delete(Integer id) throws SQLException {
        return  new AdministratorDAO(SQLiteDAOFactory.pool).delete(id);
    }

    @Override
    public boolean delete(Administrator entity) throws SQLException {
        return new AdministratorDAO(SQLiteDAOFactory.pool).delete(entity);
    }

    @Override
    public boolean create(Administrator entity) throws SQLException {
        return new AdministratorDAO(SQLiteDAOFactory.pool).create(entity);
    }

    @Override
    public boolean update(Administrator entity) throws SQLException {
        return new AdministratorDAO(SQLiteDAOFactory.pool).update(entity);
    }
}
