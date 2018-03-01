/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.AccountDAO;
import domain.Account;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.PersistenceException;

/**
 *
 * @author Teun
 */
@Stateless
public class AccountService {

    @Inject
    AccountDAO accountDao;

    public AccountService() {
    }

    /**
     *
     * @param limit
     * @return
     * @throws java.lang.Exception
     */
    public List<Account> getAllAccounts(int limit) throws Exception {
        try {
            return accountDao.getAllAccounts(limit);
        } catch (PersistenceException pe) {
            throw new Exception(pe);
        }
    }

    /**
     *
     * @param email
     * @return
     * @throws java.lang.Exception
     */
    public List<Account> getAccountByEmail(String email) throws Exception {
        try {
            return accountDao.getAccountByEmail(email);
        } catch (PersistenceException pe) {
            throw new Exception(pe);
        }
    }

    /**
     *
     * @param user
     * @throws java.lang.Exception
     */
    public void updateAccount(Account user) throws Exception {
        try {
            accountDao.updateAccount(user);
        } catch (PersistenceException pe) {
            throw new Exception(pe);
        }
    }

    /**
     *
     * @param user
     * @throws java.lang.Exception
     */
    public void insertAccount(Account user) throws Exception {
        try {
            accountDao.insertAccount(user);
        } catch (PersistenceException pe) {
            throw new Exception(pe);
        }
    }

    /**
     *
     * @param username
     * @return
     * @throws java.lang.Exception
     */
    public List<Account> getAccountByUsername(String username) throws Exception {
        try {
            return accountDao.getAccountByUsername(username);
        } catch (PersistenceException pe) {
            throw new Exception(pe);
        }
    }
}
