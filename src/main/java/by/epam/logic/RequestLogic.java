package by.epam.logic;

import by.epam.dao.factory.DAOFactory;
import by.epam.entities.Request;
import by.epam.enums.DataBaseType;
import by.epam.managers.Log4jManager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides methods to work with requests
 *
 * @author Yury Druzenok
 * @version 1.0  13 Dec 2015
 */
public class RequestLogic {
    public static List<Request> getAllRequests() {
        List<Request> requests = null;
        DAOFactory dao = DAOFactory.getDAOFactory(DataBaseType.MYSQL);
        try {
            requests = dao.getRequestDAO().findAll();
        } catch (SQLException e) {
            System.err.print(e.getMessage());
            Log4jManager.error(e.getMessage());
        }

        return requests;
    }

    public static List<Request> searchRequests() {
        List<Request> requests = new ArrayList<Request>();
        DAOFactory dao = DAOFactory.getDAOFactory(DataBaseType.MYSQL);
        try {
            List<Request> requestList = dao.getRequestDAO().findAll();
            for (Request request : requestList) {
                if (request.getAdminId() == -1) {
                    requests.add(request);
                }
            }
        } catch (SQLException e) {
            System.err.print(e.getMessage());
            Log4jManager.error(e.getMessage());
        }
        return requests;
    }

    public static Request getUpdateRequestById(int requestId, int adminId) {
        Request request = null;
        DAOFactory dao = DAOFactory.getDAOFactory(DataBaseType.MYSQL);
        try {
            request = (Request) dao.getRequestDAO().findEntityById(Integer.valueOf(requestId));
            request.setAdminId(adminId);
            dao.getRequestDAO().update(request);
        } catch (SQLException e) {
            System.err.print(e.getMessage());
            Log4jManager.error(e.getMessage());
        }
        return request;
    }

    public static Request getRequestById(int id) {
        Request request = null;
        DAOFactory dao = DAOFactory.getDAOFactory(DataBaseType.MYSQL);
        try {
            request = (Request) dao.getRequestDAO().findEntityById(Integer.valueOf(id));
        } catch (SQLException e) {
            System.err.print(e.getMessage());
            Log4jManager.error(e.getMessage());
        }
        return request;
    }

    public static boolean createRequest(Request request) {
        boolean success = false;
        DAOFactory dao = DAOFactory.getDAOFactory(DataBaseType.MYSQL);
        try {
            success = dao.getRequestDAO().create(request);
        } catch (SQLException e) {
            System.err.print(e.getMessage());
            Log4jManager.error(e.getMessage());
        }

        return success;
    }
}
