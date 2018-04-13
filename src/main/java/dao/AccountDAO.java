/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Account;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author Teun
 */
public interface AccountDAO {

    List<Account> getAllAccounts(int limit) throws PersistenceException;

    Account getAccountByEmail(String email) throws PersistenceException;

    Account getAccountByUsername(String username) throws PersistenceException;

    List<Account> getAccountFollowers(String username) throws PersistenceException;

    List<Account> getAccountFollowing(String username) throws PersistenceException;

    void removeAccountFollowing(String username, String following) throws PersistenceException;

    void addAccountFollowing(String username, String following) throws PersistenceException;

    void updateAccount(Account user) throws PersistenceException;

    void insertAccount(Account user) throws PersistenceException;

    void deleteAccount(Account user) throws PersistenceException;
}
