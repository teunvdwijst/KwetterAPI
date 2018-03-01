/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.AccountDAO;
import domain.Account;
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
public class AccountService {

    @Inject
    AccountDAO accountDao;

    private static final Logger LOGGER = Logger.getLogger(AccountService.class.getName());

    public AccountService() {
    }

    /**
     *
     * @param limit
     * @return
     */
    public List<Account> getAllAccounts(int limit) {
        try {
            return accountDao.getAllAccounts(limit);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getAllAccounts operation; {0}", pe.getMessage());
            return null;
        }
    }

    /**
     *
     * @param email
     * @return
     */
    public List<Account> getAccountByEmail(String email) {
        try {
            return accountDao.getAccountByEmail(email);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getAccountByEmail operation; {0}", pe.getMessage());
            return null;
        }
    }

    /**
     *
     * @param user
     */
    public void updateAccount(Account user) {
        try {
            accountDao.updateAccount(user);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing updateAccount operation; {0}", pe.getMessage());
        }
    }

    /**
     *
     * @param user
     */
    public void insertAccount(Account user) {
        try {
            accountDao.insertAccount(user);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing insertAccount operation; {0}", pe.getMessage());
        }
    }

    /**
     *
     * @param username
     * @return
     */
    public List<Account> getAccountByUsername(String username) {
        try {
            return accountDao.getAccountByUsername(username);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getAccountByUsername operation; {0}", pe.getMessage());
            return null;
        }
    }
}
