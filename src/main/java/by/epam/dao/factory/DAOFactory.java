package by.epam.dao.factory;


import by.epam.dao.mysql.MySQLDAOFactory;
import by.epam.dao.sqlite.SQLiteDAOFactory;
import by.epam.enums.DataBaseType;

/**
 * Abstract class DAOFactory
 *
 * @author Yury Druzenok
 * @version 1.0 11 Nov 2015
 */
public abstract class DAOFactory {
    public abstract AbstractDAO getClientDAO();

    public abstract AbstractDAO getAdministratorDAO();

    public abstract AbstractDAO getBillDAO();

    public abstract AbstractDAO getRequestDAO();

    public abstract AbstractDAO getRoomDAO();

    public abstract AbstractDAO getRoomGuideDAO();

    public static DAOFactory getDAOFactory(DataBaseType type) {
        DAOFactory dao;
        switch (type) {
            case MYSQL: {
                dao = new MySQLDAOFactory(DataBaseType.MYSQL);
            }
            break;
            case SQLITE: {
                dao = new SQLiteDAOFactory(DataBaseType.SQLITE);
            }
            break;
            default: {
                dao = null;
            }
        }

        return dao;
    }
}
