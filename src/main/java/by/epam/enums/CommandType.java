package by.epam.enums;

import by.epam.command.LoginCommand;
import by.epam.command.SignUpCommand;
import by.epam.interfaces.ActionCommand;

/**
 * Represents type of commands
 *
 * @version 1.0 7 Dec 2015
 * @author Yury Druzenok
 */
public enum CommandType {
    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },
    LOGOUT {
        {
//            this.command = new LogoutCommand();
        }
    },
    SIGN_UP {
        {
            this.command = new SignUpCommand();
        }
    };
    ActionCommand command;
    public ActionCommand getCurrentCommand() {
        return command;
    }
}
