package by.epam.logic;

import by.epam.dao.factory.DAOFactory;
import by.epam.entities.Request;
import by.epam.enums.DataBaseType;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zpYura on 13.12.2015.
 */
public class RequestLogic {
    public static List<Request> getAllRequests(){
        List<Request> requests = null;
        DAOFactory dao = DAOFactory.getDAOFactory(DataBaseType.MYSQL);
        try{
            requests = dao.getRequestDAO().findAll();
        }
        catch (SQLException exp){
            System.err.print(exp.getMessage());

        }

        return requests;
    }
    public static List<Request> searchRequests(){
        List<Request> requests = new ArrayList<Request>();
        DAOFactory dao = DAOFactory.getDAOFactory(DataBaseType.MYSQL);
        try{
            List<Request> requestList = dao.getRequestDAO().findAll();
            for(Request request: requestList){
                if (request.getAdminId() == -1){
                    requests.add(request);
                }
            }
        }
        catch (SQLException exp){
            System.err.print(exp.getMessage());

        }
        return requests;
    }

    public static Request getUpdateRequestById(int requestId, int adminId){
       Request request = null;
        DAOFactory dao = DAOFactory.getDAOFactory(DataBaseType.MYSQL);
        try{
            request = (Request) dao.getRequestDAO().findEntityById(Integer.valueOf(requestId));
            request.setAdminId(adminId);
            dao.getRequestDAO().update(request);
        }
        catch (SQLException exp){
            System.err.print(exp.getMessage());

        }
        return request;
    }
}
