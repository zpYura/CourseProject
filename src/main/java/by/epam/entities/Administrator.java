package by.epam.entities;

import java.io.Serializable;
import java.util.Date;

/**
 * Describes entity Administrator
 *
 * @version 1.0 11 Nov 2015
 * @author Yury Druzenok
 */
public class Administrator extends Human implements Serializable {
    Date entryInThePostDate;

    public Administrator() {
    }

    public Administrator(int id, String lastName, String firstName, String middleName,
                         Date birthDate, String address, String phoneNumber,
                         Date entryInThePostDate, String login, String password) {
        super(id, lastName, firstName, middleName, birthDate, address, phoneNumber, login, password);
        this.entryInThePostDate = entryInThePostDate;
    }

    public Date getEntryInThePostDate() {
        return entryInThePostDate;
    }

    public void setEntryInThePostDate(Date entryInThePostDate) {
        this.entryInThePostDate = entryInThePostDate;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "entryInThePostDate=" + entryInThePostDate +
                "} " + super.toString();
    }
}
