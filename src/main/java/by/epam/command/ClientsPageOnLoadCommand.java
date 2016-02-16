package by.epam.command;

import by.epam.entities.Client;
import by.epam.interfaces.ActionCommand;
import by.epam.logic.ClientLogic;
import by.epam.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Loads list of clients when clients.jsp load
 *
 * @author Yury Druzenok
 * @version 1.0  15 Dec 2015
 */
public class ClientsPageOnLoadCommand implements ActionCommand {
    public String execute(HttpServletRequest request) {
        String page = null;
        //get all clients and put them into table on the page
        List<Client> clients = ClientLogic.getAllClients();
        request.setAttribute("clientsList", clients.toArray());
        page = ConfigurationManager.get("page_admin_clients");
        return page;
    }
}
