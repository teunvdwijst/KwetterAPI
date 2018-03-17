package controller;

import domain.Account;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import service.AccountService;

/**
 *
 * @author Teun
 */
@Named
@RequestScoped
public class AccountController {

    @Inject
    AccountService accountService;

    private List<Account> users;
    private Account selectedUser;

    public AccountController() {
    }

    @PostConstruct
    private void init() {
        users = accountService.getAllAccounts(0);
    }

    public List<Account> getAccounts() {
        return users;
    }

    public Account getSelectedUser() {
        if (selectedUser != null) {
            return selectedUser;
        }
        return null;
    }

    public void setSelectedUser(Account selectedUser) {
        if (selectedUser != null) {
            this.selectedUser = selectedUser;
        }
    }

    public void promoteUser() {
        if (selectedUser != null) {
            selectedUser.promote();
            accountService.updateAccount(selectedUser);
        }
    }

    public void demoteUser() {
        if (selectedUser != null) {
            selectedUser.demote();
            accountService.updateAccount(selectedUser);
        }
    }
}
