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
        if (limit == 0) {
            return em.createNamedQuery("Account.findAll").getResultList();
        }
        return em.createNamedQuery("Account.findAll").setMaxResults(limit).getResultList();
    }

    @Override
    public Account getAccountByEmail(String email) throws PersistenceException {
        return (Account) em.createNamedQuery("Account.findByEmail").setParameter("email", email).getSingleResult();
    }

    @Override
    public Account getAccountByUsername(String username) throws PersistenceException {
        return (Account) em.createNamedQuery("Account.findByUsername").setParameter("username", username).getSingleResult();
    }

    @Override
    public List<Account> getAccountFollowers(String username) throws PersistenceException {
        return em.createNamedQuery("Account.followers").setParameter("username", username).getResultList();
    }

    @Override
    public List<Account> getAccountFollowing(String username) throws PersistenceException {
        return em.createNamedQuery("Account.following").setParameter("username", username).getResultList();
    }

    @Override
    public Account updateAccount(Account user) throws PersistenceException {
        return em.merge(user);
    }

    @Override
    public Account insertAccount(Account user) throws PersistenceException {
        em.persist(user);
        return user;
    }

    @Override
    public void deleteAccount(Account user) throws PersistenceException {
        Account temp = em.find(Account.class, user.getId());
        for (Tweet t : temp.getTweets()) {
            em.remove(t);
        }
        for (Account a : temp.getFollowing()) {
            temp.removeFollowing(a);
        }
        em.remove(temp);
    }

    @Override
    public void removeAccountFollowing(String username, String following) throws PersistenceException {
        Account acc = getAccountByUsername(username);
        Account fol = getAccountByUsername(following);

        acc.removeFollowing(fol);

        updateAccount(fol);
        updateAccount(acc);
    }

    @Override
    public void addAccountFollowing(String username, String following) throws PersistenceException {
        Account acc = getAccountByUsername(username);
        Account fol = getAccountByUsername(following);

        acc.addFollowing(fol);

        updateAccount(fol);
        updateAccount(acc);
    }
}
