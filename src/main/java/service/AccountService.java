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
    public List<Account> getAllAccounts() {
        return null;
    }

    /**
     * 
     * @param email
     * @return 
     */
    public Account getAccountByEmail(String email) {
        return null;
    }

    /**
     * 
     * @param user
     * @return 
     */
    public Account updateAccount(Account user) {
        return null;
    }

    /**
     * 
     * @param user 
     */
    public void insertAccount(Account user) {
    }

    /**
     * 
     * @param user
     * @return 
     */
    public List<Account> getFollowers(Account user) {
        return null;
    }

}
