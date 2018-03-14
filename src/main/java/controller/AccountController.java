package controller;

import domain.Account;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
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

    public AccountController() {
    }

    @PostConstruct
    private void init() {
        users = accountService.getAllAccounts(0);
    }

    public List<Account> getAccounts() {
        return users;
    }
}
