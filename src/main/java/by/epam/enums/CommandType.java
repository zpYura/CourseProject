package by.epam.enums;

import by.epam.command.*;
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
            this.command = new LogOutCommand();
        }
    },
    SIGN_UP {
        {
            this.command = new SignUpCommand();
        }
    },
    BOOK {
        {
            this.command = new BookCommand();
        }
    },
    REQUEST_ALL {
        {
            this.command = new RequestsPageOnLoadCommand();
        }
    },
    REQUEST_SEARCH {
        {
            this.command = new SearchRequestsCommand();
        }
    },
    ROOMS_ALL {
        {
            this.command = new RoomsPageOnLoadCommand();
        }
    },
    BILLS_ALL {
        {
            this.command = new BillsPageOnLoadCommand();
        }
    },
    COMPUTE_REQUEST {
        {
            this.command = new ComputeRequestCommand();
        }
    };
    ActionCommand command;
    public ActionCommand getCurrentCommand() {
        return command;
    }
}
