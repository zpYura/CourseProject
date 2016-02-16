package by.epam.command;

import by.epam.logic.LoginLogic;
import by.epam.managers.ConfigurationManager;
import by.epam.managers.Log4jManager;
import by.epam.validation.Validator;
import by.epam.entities.Client;
import by.epam.interfaces.ActionCommand;
import by.epam.logic.SigUpLogic;
import by.epam.managers.MessageManager;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Compute sign up command
 *
 * @author Yury Druzenok
 * @version 1.0 7 Dec 2015
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

    public String execute(HttpServletRequest request) {
        boolean flag = false;
        String page;
        String lastName = null;
        String firstName = null;
        String middleName = null;
        Date birthDate = null;
        String address = null;
        String phoneNumber = null;
        String email = null;
        String login = null;
        String pass = null;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        // get parameters
        try {
            lastName = Validator.getString(request.getParameter(PARAM_NAME_LAST_NAME));
            // check if all data is valid
            if (!Validator.checkTextField(lastName)) {
                flag = true;
                request.setAttribute("errorRegistrationLastName", MessageManager.getProperty((Locale) request.getSession().getAttribute("current_locale"), "registration_text_field_error"));
            }
            firstName = Validator.getString(request.getParameter(PARAM_NAME_FIRST_NAME));
            if (!Validator.checkTextField(firstName)) {
                flag = true;
                request.setAttribute("errorRegistrationFirstName", MessageManager.getProperty((Locale) request.getSession().getAttribute("current_locale"), "registration_text_field_error"));
            }
            middleName = Validator.getString(request.getParameter(PARAM_NAME_MIDDLE_NAME));
            if (!Validator.checkTextField(middleName)) {
                flag = true;
                request.setAttribute("errorRegistrationMiddleName", MessageManager.getProperty((Locale) request.getSession().getAttribute("current_locale"), "registration_text_field_error"));
            }
            try {
                birthDate = formatter.parse(request.getParameter(PARAM_NAME_BIRTH_DATE));
            } catch (ParseException e) {
                System.err.println(e.getMessage());
                request.setAttribute("errorRegistrationDate", MessageManager.getProperty((Locale) request.getSession().getAttribute("current_locale"), "registration_date_error"));
                flag = true;
                Log4jManager.error(e.getMessage());
            }
            address = Validator.getString(request.getParameter(PARAM_NAME_ADDRESS));
            if (address.isEmpty()) {
                flag = true;
                request.setAttribute("errorRegistrationEmpty", MessageManager.getProperty((Locale) request.getSession().getAttribute("current_locale"), "registration_empty_error"));
            }
            phoneNumber = request.getParameter(PARAM_NAME_PHONE_NUMBER);
            if (!Validator.checkPhoneNumber(phoneNumber)) {
                flag = true;
                request.setAttribute("errorRegistrationPhoneNumber", MessageManager.getProperty((Locale) request.getSession().getAttribute("current_locale"), "registration_phone_error"));
            }
            email = request.getParameter(PARAM_NAME_EMAIL);
            if (!Validator.checkEmail(email)) {
                flag = true;
                request.setAttribute("errorRegistrationEmail", MessageManager.getProperty((Locale) request.getSession().getAttribute("current_locale"), "registration_email_error"));
            }
            login = Validator.getString(request.getParameter(PARAM_NAME_LOGIN));
            if (LoginLogic.checkLogin(login) || login.isEmpty()) {
                flag = true;
                request.setAttribute("errorRegistrationLogin", MessageManager.getProperty((Locale) request.getSession().getAttribute("current_locale"), "registration_login_error"));
            }
            pass = Validator.getString(request.getParameter(PARAM_NAME_PASSWORD));
            if (pass.isEmpty())
                flag = true;
        } catch (UnsupportedEncodingException e) {
            System.err.println(e.getMessage());
            Log4jManager.error(e.getMessage());
        }

        Client client = new Client(-1, lastName, firstName, middleName, birthDate, address, phoneNumber, email, login, pass);
        // create new client account
        if (!flag && SigUpLogic.createClient(client)) {
            page = ConfigurationManager.get("page_login");
        } else {
            page = ConfigurationManager.get("page_registration");

        }
        return page;
    }
}
