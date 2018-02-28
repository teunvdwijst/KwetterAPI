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

    @PersistenceContext(name = "KwetterS62PU")
    EntityManager em;

    public AccountDAOImpl() {
    }

    @Override
    public List<Account> getAllAccounts(int limit) {
        return em.createNamedQuery("Account.findAll").setMaxResults(limit).getResultList();
    }

    @Override
    public List<Account> getAccountByEmail(String email) {
        return em.createNamedQuery("Account.findByEmail").setParameter("email", email).getResultList();
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
    public List<Account> getAccountByUsername(String username) {
        return em.createNamedQuery("Account.findByUsername").setParameter("username", username).getResultList();
    }

    @Override
    public void deleteAccount(Account user) {
        em.remove(user);
    }
}
