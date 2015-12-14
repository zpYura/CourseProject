package by.epam.runner;

import by.epam.dao.factory.DAOFactory;
import by.epam.entities.Administrator;
import by.epam.entities.Client;
import by.epam.entities.Room;
import by.epam.enums.ApartmentType;
import by.epam.enums.DataBaseType;
//import by.epam.dao.mysql.MySQLDAOFactory;
//import by.epam.dao.objects.RoomDAO;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
//        String language = "EN";
//        String action = "sign_up";
//        try {
//            CommandType currentEnum = CommandType.valueOf(action.toUpperCase());
//            int g =0;
//
//        }
//        catch (IllegalArgumentException e){
//        System.err.println(e.getMessage());
//        }
//        if(language == "RU"){
//
//        }
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
         // Client client = new Client(5,"Kfdfk", "Kekk", "Kokk", new Date(100000), "street", "25525","mai;@", "dwwdw", "asas");

           // dao.getClientDAO().update(client);
           //dao.getClientDAO().create(client);
            //dao.getClientDAO().delete(client);
           // dao.getClientDAO().delete(Integer.valueOf(1));
            //dao.getClientDAO().delete(Integer.valueOf(2));
            //dao.getClientDAO().delete(Integer.valueOf(3));
//           Administrator client = new Administrator(5,"Главатский", "Никита", "Юрьевич", new Date(100000), "street", "25525", Date.from(Instant.now()),"admin","admin");
//           dao.getAdministratorDAO().create(client);
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
             Date birthDate = formatter.parse("17/12/15");
            Room room = new Room(1,1, ApartmentType.DOUBLE_ROOM, 120,birthDate);
            dao.getRoomDAO().create(room);
        }
        catch (SQLException exp){
            System.err.print(exp.getMessage());
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
