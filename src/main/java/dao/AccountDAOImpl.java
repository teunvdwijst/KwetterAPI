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
public class AccountDAOImpl {

    @PersistenceContext
    EntityManager em;

    public List<Account> allAccounts() {
        return em.createNamedQuery("Account.allAccounts").getResultList();
    }
}
