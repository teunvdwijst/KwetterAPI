/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import dao.AccountDAO;
import domain.Account;
import java.io.UnsupportedEncodingException;
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

    public boolean validateCredentials(String username, String password) {
        Account temp = getAccountByUsername(username);

        if (temp != null) {
            return password.equals(temp.getPassword());
        }
        return false;
    }

    public String getWebToken(String login) {
        String webToken = "";

        try {
            Algorithm a = Algorithm.HMAC512("Auth_0_JWT_secret");
            webToken = JWT.create().withSubject(login).withIssuer("KwetterBV").sign(a); //.withExpiresAt(new Date(System.currentTimeMillis() + 900000))
        } catch (UnsupportedEncodingException ex) {
            LOGGER.log(Level.FINE, "ERROR while performing getWebToken operation; {0}", ex.getMessage());
        }
        return webToken;
    }

    public List<Account> getAllAccounts(int limit) {
        try {
            return accountDao.getAllAccounts(limit);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getAllAccounts operation; {0}", pe.getMessage());
            return null;
        }
    }

    public List<Account> getAccountFollowers(String username) {
        try {
            return accountDao.getAccountFollowers(username);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getAccountFollowers operation; {0}", pe.getMessage());
            return null;
        }
    }

    public void addAccountFollowing(String username, String following) {
        try {
            accountDao.addAccountFollowing(username, following);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing addAccountFollowing operation; {0}", pe.getMessage());
        }
    }

    public void removeAccountFollowing(String username, String following) {
        try {
            accountDao.removeAccountFollowing(username, following);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing removeAccountFollowing operation; {0}", pe.getMessage());
        }
    }

    public List<Account> getAccountFollowing(String username) {
        try {
            return accountDao.getAccountFollowing(username);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getAccountFollowing operation; {0}", pe.getMessage());
            return null;
        }
    }

    public Account getAccountByEmail(String email) {
        try {
            return accountDao.getAccountByEmail(email);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getAccountByEmail operation; {0}", pe.getMessage());
            return null;
        }
    }

    public Account getAccountByUsername(String username) {
        try {
            return accountDao.getAccountByUsername(username);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getAccountByUsername operation; {0}", pe.getMessage());
            return null;
        }
    }

    public void updateAccount(Account user) {
        try {
            accountDao.updateAccount(user);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing updateAccount operation; {0}", pe.getMessage());
        }
    }

    public void insertAccount(Account user) {
        try {
            accountDao.insertAccount(user);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing insertAccount operation; {0}", pe.getMessage());
        }
    }

    public void deleteAccount(String username) {
        try {
            Account temp = accountDao.getAccountByUsername(username);
            accountDao.deleteAccount(temp);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing deleteAccount operation; {0}", pe.getMessage());
        }
    }
}
