package by.epam.logic;

import by.epam.dao.factory.DAOFactory;
import by.epam.entities.Bill;
import by.epam.enums.DataBaseType;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by zpYura on 14.12.2015.
 */
public class BillLogic {
    public static List<Bill> getAllBills(){
        List<Bill> bills = null;
        DAOFactory dao = DAOFactory.getDAOFactory(DataBaseType.MYSQL);
        try{
            bills = dao.getBillDAO().findAll();
        }
        catch (SQLException exp){
            System.err.print(exp.getMessage());

        }

        return bills;
    }
}
