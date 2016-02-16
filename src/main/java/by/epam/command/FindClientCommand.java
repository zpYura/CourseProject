package by.epam.command;

import by.epam.entities.Client;
import by.epam.interfaces.ActionCommand;
import by.epam.logic.ClientLogic;
import by.epam.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Search for client,which request can't be fulfilled
 *
 * @author Yury Druzenok
 * @version 1.0  15 Dec 2015
 */
public class FindClientCommand implements ActionCommand {
    private static final String PARAM_NAME_CLIENT_ID = "clientId";

    public String execute(HttpServletRequest request) {
        String page = null;
        int id = Integer.parseInt(request.getParameter(PARAM_NAME_CLIENT_ID));
        // found client's information
        Client client = ClientLogic.getClientById(id);
        List<Client> clients = new ArrayList<Client>();
        clients.add(client);
        request.setAttribute("clientsList", clients.toArray());
        page = ConfigurationManager.get("page_admin_clients");
        return page;
    }
}
