/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Account;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Teun
 */
@Stateless
public class AccountDAOImpl implements AccountDAO {

    @PersistenceContext
    EntityManager em;

    public AccountDAOImpl() {
    }

    @Override
    public List<Account> getAllAccounts() {
        return em.createQuery("Select a from Account a", Account.class).getResultList();
    }

    @Override
    public Account getAccountByEmail(String email) {
        return em.find(Account.class, email);
    }

    @Override
    public void updateAccount(Account user) {
        em.merge(user);
    }

    @Override
    public void insertAccount(Account user) {
        em.persist(user);
    }

    @Override
    public List<Account> getFollowers(Account user) {
        return em.find(Account.class, user.getEmail()).getFollowing();
    }
}
