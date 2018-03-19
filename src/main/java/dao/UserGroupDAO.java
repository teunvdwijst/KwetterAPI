package dao;

import domain.UserGroup;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author Teun
 */
public interface UserGroupDAO {

    List<UserGroup> getAllUserGroups() throws PersistenceException;

    void updateUserGroup(UserGroup group) throws PersistenceException;

    void insertUserGroup(UserGroup group) throws PersistenceException;

    void deleteUserGroup(UserGroup group) throws PersistenceException;
}
