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
     * @return
     */
    public List<Account> getAllAccounts(int limit) {
        return accountDao.getAllAccounts(limit);
    }

    /**
     *
     * @param email
     * @return
     */
    public List<Account> getAccountByEmail(String email) {
        return accountDao.getAccountByEmail(email);
    }

    /**
     *
     * @param user
     */
    public void updateAccount(Account user) {
        accountDao.updateAccount(user);
    }

    /**
     *
     * @param user
     */
    public void insertAccount(Account user) {
        accountDao.insertAccount(user);
    }

    /**
     *
     * @param user
     * @return
     */
    public List<Account> getAccountByUsername(String username) {
        return accountDao.getAccountByUsername(username);
    }

}
