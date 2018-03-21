package service;

import dao.UserGroupDAO;
import domain.UserGroup;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.PersistenceException;

/**
 *
 * @author Teun
 */
@Stateless
public class UserGroupService {

    @Inject
    UserGroupDAO userGroupDao;

    private static final Logger LOGGER = Logger.getLogger(AccountService.class.getName());

    public UserGroup getUserGroup(String name) {
        try {
            return userGroupDao.getUserGroup(name);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getAllUserGroups operation; {0}", pe.getMessage());
            return null;
        }
    }

    public List<UserGroup> getAllUserGroups() {
        try {
            return userGroupDao.getAllUserGroups();
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getAllUserGroups operation; {0}", pe.getMessage());
            return null;
        }
    }

    public void updateUserGroup(UserGroup group) {
        try {
            userGroupDao.updateUserGroup(group);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing updateUserGroup operation; {0}", pe.getMessage());
        }
    }

    public void insertUserGroup(UserGroup group) {
        try {
            userGroupDao.insertUserGroup(group);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing insertUserGroup operation; {0}", pe.getMessage());
        }
    }

    public void deleteUserGroup(UserGroup group) {
        try {
            userGroupDao.insertUserGroup(group);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing deleteUserGroup operation; {0}", pe.getMessage());
        }
    }

}
