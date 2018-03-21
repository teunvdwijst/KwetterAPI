package controller;

import domain.Account;
import domain.UserGroup;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import service.AccountService;
import service.UserGroupService;

/**
 *
 * @author Teun
 */
@Named
@ViewScoped
public class AccountController implements Serializable {

    @Inject
    AccountService accountService;

    @Inject
    UserGroupService userGroupService;

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
        FacesContext context = FacesContext.getCurrentInstance();
        if (selectedUser == null) {
            context.addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No Account selected."));
            return;
        }

        String groupToAdd = selectedUser.promoteUserGroup();
        if (groupToAdd != null) {
            UserGroup temp = userGroupService.getUserGroup(groupToAdd);
            selectedUser.addUserGroup(temp);
            accountService.updateAccount(selectedUser);
            userGroupService.updateUserGroup(temp);
            init();
        }
    }

    public void demoteUser() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (selectedUser == null) {
            context.addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No Account selected."));
            return;
        }

        String groupToRemove = selectedUser.demoteUserGroup();
        if (groupToRemove != null) {
            UserGroup temp = userGroupService.getUserGroup(groupToRemove);
            selectedUser.removeUserGroup(temp);
            accountService.updateAccount(selectedUser);
            userGroupService.updateUserGroup(temp);
            init();
        }
    }
}
