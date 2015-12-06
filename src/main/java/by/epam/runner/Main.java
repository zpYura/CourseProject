package by.epam.runner;

import by.epam.dao.factory.DAOFactory;
import by.epam.enums.DataBaseType;
//import by.epam.dao.mysql.MySQLDAOFactory;
//import by.epam.dao.objects.RoomDAO;
import by.epam.entities.Administrator;
import by.epam.settings.AppSettings;

import java.sql.SQLException;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        String language = "EN";
        if(language =="EN"){
            //AppSettings.createBundle(new Locale("US","EN"));
            // request.setAttribute("hotel", AppSettings.getBundleValue(new Locale("US","EN"),"hotel"));
            String dfd = AppSettings.getBundleValue(new Locale("EN","US"),"hotel");
        }
        if(language == "RU"){

        }
        DAOFactory dao = DAOFactory.getDAOFactory(DataBaseType.MYSQL);
        try{
//
//            Client client = (Client) dao.getClientDAO().findEntityById(1);
//            if(dao.getClientDAO().delete(1)){


//                List<Room> clients = (List<Room>)dao.getRoomDAO().findAll();
//            if(clients.size() != 0){
//                Iterator<Room> iterator = clients.iterator();
//                while(iterator.hasNext()){
//                    System.out.println(iterator.next().toString());
//                }
//            }
//            else
//            { System.out.print("Empty");
//            }
          //  Client client = new Client(5,"Kfdfk", "Kekk", "Kokk", new Date(100000), "street", "25525","mai;@");
           // dao.getClientDAO().update(client);
           //dao.getClientDAO().create(client);
            //dao.getClientDAO().delete(client);
           // dao.getClientDAO().delete(Integer.valueOf(1));
            //dao.getClientDAO().delete(Integer.valueOf(2));
            //dao.getClientDAO().delete(Integer.valueOf(3));
           Administrator client = new Administrator(5,"Kfdfk", "Kekk", "Kokk", new Date(100000), "street", "25525", Date.from(Instant.now()));
            dao.getAdministratorDAO().create(client);
        }
        catch (SQLException exp){
            System.err.print(exp.getMessage());
        }
    }
}
