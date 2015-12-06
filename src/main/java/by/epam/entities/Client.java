package by.epam.entities;

import java.io.Serializable;
import java.util.Date;

/**
 * Describes entity Client
 *
 * @version 1.0 11 Nov 2015
 * @author Yury Druzenok
 */
public class Client extends Human implements Serializable{
    String email;

    public Client() {
    }

    public Client(int id, String lastName, String firstName, String middleName,
                  Date birthDate, String address, String phoneNumber, String email) {
        super(id, lastName, firstName, middleName, birthDate, address, phoneNumber);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client{" +
                "email='" + email + '\'' +
                "} " + super.toString();
    }
}
