package by.epam.enums;

import by.epam.command.*;
import by.epam.interfaces.ActionCommand;

/**
 * Represents type of commands
 *
 * @author Yury Druzenok
 * @version 1.0 7 Dec 2015
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
    },
    CLIENTS_ALL {
        {
            this.command = new ClientsPageOnLoadCommand();
        }
    },
    FIND_CLIENT {
        {
            this.command = new FindClientCommand();
        }
    },
    CREATE_BILL {
        {
            this.command = new CreateBillCommand();
        }
    };
    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
