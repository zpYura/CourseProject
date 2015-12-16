package by.epam.logic;

import by.epam.dao.factory.DAOFactory;
import by.epam.entities.Bill;
import by.epam.enums.DataBaseType;
import by.epam.managers.Log4jManager;

import java.sql.SQLException;
import java.util.List;

/**
 * Provides methods to work with bills
 *
 * @author Yury Druzenok
 * @version 1.0  14 Dec 2015
 */
public class BillLogic {
    public static List<Bill> getAllBills() {
        List<Bill> bills = null;
        DAOFactory dao = DAOFactory.getDAOFactory(DataBaseType.MYSQL);
        try {
            bills = dao.getBillDAO().findAll();
        } catch (SQLException e) {
            System.err.print(e.getMessage());
            Log4jManager.error(e.getMessage());
        }
        return bills;
    }

    public static boolean createBill(Bill bill) {
        boolean success = false;
        DAOFactory dao = DAOFactory.getDAOFactory(DataBaseType.MYSQL);
        try {
            success = dao.getBillDAO().create(bill);
        } catch (SQLException e) {
            System.err.print(e.getMessage());
            Log4jManager.error(e.getMessage());
        }
        return success;
    }
}
