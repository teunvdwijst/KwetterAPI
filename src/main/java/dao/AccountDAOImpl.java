/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Account;
import domain.Tweet;
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
public class AccountDAOImpl implements AccountDAO {

    @PersistenceContext(name = "KwetterS62PU")
    EntityManager em;

    public AccountDAOImpl() {
    }

    @Override
    public List<Account> getAllAccounts(int limit) throws PersistenceException {
        return em.createNamedQuery("Account.findAll").setMaxResults(limit).getResultList();
    }

    @Override
    public List<Account> getAccountByEmail(String email) throws PersistenceException {
        return em.createNamedQuery("Account.findByEmail").setParameter("email", email).getResultList();
    }

    @Override
    public List<Account> getAccountFollowers(String email) throws PersistenceException {
        List<Account> temp = em.createNamedQuery("Account.findByEmail").setParameter("email", email).getResultList();
        return temp.get(0).getFollowers();
    }

    @Override
    public List<Account> getAccountFollowing(String email) throws PersistenceException {
        List<Account> temp = em.createNamedQuery("Account.findByEmail").setParameter("email", email).getResultList();
        return temp.get(0).getFollowing();
    }

    @Override
    public void updateAccount(Account user) throws PersistenceException {
        em.merge(user);
    }

    @Override
    public void insertAccount(Account user) throws PersistenceException {
        em.persist(user);
    }

    @Override
    public List<Account> getAccountByUsername(String username) throws PersistenceException {
        return em.createNamedQuery("Account.findByUsername").setParameter("username", username).getResultList();
    }

    @Override
    public void deleteAccount(Account user) throws PersistenceException {
        for (Tweet t : user.getTweets()) {
            em.remove(t);
        }
        em.remove(user);
    }
}
