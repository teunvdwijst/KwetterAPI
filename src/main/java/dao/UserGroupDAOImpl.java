package dao;

import domain.UserGroup;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

/**
 *
 * @author Teun
 */
@Stateless
public class UserGroupDAOImpl implements UserGroupDAO {

    @PersistenceContext(name = "KwetterS62PU")
    EntityManager em;

    public UserGroupDAOImpl() {
    }

    @Override
    public UserGroup getUserGroup(String name) throws PersistenceException {
        return em.find(UserGroup.class, name);
    }

    @Override
    public List<UserGroup> getAllUserGroups() throws PersistenceException {
        return em.createQuery("SELECT g FROM UserGroup g").getResultList();
    }

    @Override
    public void updateUserGroup(UserGroup group) throws PersistenceException {
        em.merge(group);
    }

    @Override
    public void insertUserGroup(UserGroup group) throws PersistenceException {
        em.persist(group);
    }

    @Override
    public void deleteUserGroup(UserGroup group) throws PersistenceException {
        em.persist(group);
    }
}
