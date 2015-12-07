package by.epam.command;

import by.epam.entities.Client;
import by.epam.interfaces.ActionCommand;
import by.epam.logic.SigUpLogic;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Compute sign up command
 *
 * @version 1.0 7 Dec 2015
 * @author Yury Druzenok
 */
public class SignUpCommand implements ActionCommand {
    private static final String PARAM_NAME_LOGIN = "userLogin";
    private static final String PARAM_NAME_PASSWORD = "userPassword";
    private static final String PARAM_NAME_LAST_NAME = "userLastName";
    private static final String PARAM_NAME_FIRST_NAME = "userFirstName";
    private static final String PARAM_NAME_MIDDLE_NAME = "userMiddleName";
    private static final String PARAM_NAME_BIRTH_DATE = "userBirthDate";
    private static final String PARAM_NAME_ADDRESS = "userAddress";
    private static final String PARAM_NAME_PHONE_NUMBER = "userPhoneNumber";
    private static final String PARAM_NAME_EMAIL = "userEmail";

    static{
        new DOMConfigurator().doConfigure("log4j.xml", LogManager.getLoggerRepository());
    }
    static Logger logger = Logger.getLogger(SignUpCommand.class);

    public String execute(HttpServletRequest request) {
        String page = null;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        // get parameters
        String lastName = request.getParameter(PARAM_NAME_LAST_NAME);
        String firstName = request.getParameter(PARAM_NAME_FIRST_NAME);
        String middleName = request.getParameter(PARAM_NAME_MIDDLE_NAME);
        Date birthDate = null;
        try{
            birthDate = formatter.parse(request.getParameter(PARAM_NAME_BIRTH_DATE));
        }
        catch (ParseException e) {
            System.err.println(e.getMessage());
            logger.error("Parse exception:", e);
        }
        String address = request.getParameter(PARAM_NAME_ADDRESS);
        String phoneNumber = request.getParameter(PARAM_NAME_PHONE_NUMBER);
        String email = request.getParameter(PARAM_NAME_EMAIL);
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
        Client client = new Client(-1, lastName, firstName, middleName, birthDate, address, phoneNumber, email, login, pass);
        // create new client account
        if (SigUpLogic.createClient(client)) {
            //request.setAttribute("user", login);
        // определение пути к main.jsp
//            page = ConfigurationManager.getProperty("path.page.main");
            page = "/jsp/common/login.jsp";
        } else {
//            request.setAttribute("errorLoginPassMessage",
//                    MessageManager.getProperty("message.loginerror"));
//            page = ConfigurationManager.getProperty("path.page.login");
        }
        return page;
    }
}
