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

    private List<UserGroup> groups;
    private UserGroup selectedGroup;

    public AccountController() {
    }

    @PostConstruct
    private void init() {
        users = accountService.getAllAccounts(0);
        groups = userGroupService.getAllUserGroups();
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

    public UserGroup getSelectedGroup() {
        return selectedGroup;
    }

    public void setSelectedGroup(UserGroup selectedGroup) {
        this.selectedGroup = selectedGroup;
    }

    public List<UserGroup> getGroups() {
        return groups;
    }

    public void promoteUser() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (selectedUser == null) {
            context.addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No Account selected."));
            return;
        }
        if (selectedGroup == null) {
            context.addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No UserGroup selected."));
            return;
        }
        selectedUser.addUserGroup(selectedGroup);
        accountService.updateAccount(selectedUser);
        init();

    }

    public void demoteUser() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (selectedUser == null) {
            context.addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No Account selected."));
            return;
        }
        if (selectedGroup == null) {
            context.addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No UserGroup selected."));
            return;
        }
        selectedUser.removeUserGroup(selectedGroup);
        accountService.updateAccount(selectedUser);
        init();
    }
}
