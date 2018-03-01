/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Account;
import domain.Role;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import util.DatabaseCleaner;

/**
 *
 * @author Teun
 */
public class AccountDAOImplTest {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("KwetterS62TestPU");
    private EntityManager em;
    private EntityTransaction et;

    public AccountDAOImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws NamingException {
        try {
            new DatabaseCleaner(emf.createEntityManager()).clean();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        em = emf.createEntityManager();
        et = em.getTransaction();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testInsertAccount() throws Exception {
        Account a = new Account("login1", "pass");

        et.begin();
        em.persist(a);
        et.commit();

        Assert.assertTrue(em.createNamedQuery("Account.findAll").getResultList().size() == 1);
    }

    @Test
    public void testUpdateAccount() throws Exception {
        Account a = new Account("login1", "pass");

        et.begin();
        em.persist(a);
        et.commit();

        Assert.assertTrue(em.createNamedQuery("Account.findAll").getResultList().size() == 1);

        et.begin();
        a.setEmail("login2");
        em.merge(a);
        et.commit();

        Assert.assertTrue(em.createNamedQuery("Account.findByEmail").setParameter("email", a.getEmail()).getResultList().size() == 1);
    }

    @Test
    public void testGetAccountByEmail() throws Exception {
        Account a = new Account("login1", "pass");

        et.begin();
        em.persist(a);
        et.commit();

        Assert.assertTrue(em.createNamedQuery("Account.findByEmail").setParameter("email", a.getEmail()).getResultList().size() == 1);
    }

    @Test
    public void testGetAllAccounts() throws Exception {
        Account a = new Account("login1", "pass");
        Account b = new Account("login2", "pass");
        Account c = new Account("login3", "pass");
        Account d = new Account("login4", "pass");

        et.begin();
        em.persist(a);
        em.persist(b);
        em.persist(c);
        em.persist(d);
        et.commit();

        Assert.assertTrue(em.createNamedQuery("Account.findAll").getResultList().size() == 4);
    }

    @Test
    public void testGetAccountByUsername() throws Exception {
        Account a = new Account("user1", "user1", "USERNAME", "user1", "user1", "user1", "user1", Role.USER);

        et.begin();
        em.persist(a);
        et.commit();

        Assert.assertTrue(em.createNamedQuery("Account.findByUsername").setParameter("username", a.getUsername()).getResultList().size() == 1);
    }
    
    @Test
    public void testDeleteAccount() throws Exception {
        Account a = new Account("user1", "user1", "USERNAME", "user1", "user1", "user1", "user1", Role.USER);

        et.begin();
        em.persist(a);
        et.commit();

        Assert.assertTrue(em.createNamedQuery("Account.findByUsername").setParameter("username", a.getUsername()).getResultList().size() == 1);
        
        
        et.begin();
        em.remove(a);
        et.commit();

        Assert.assertTrue(em.createNamedQuery("Account.findByUsername").setParameter("username", a.getUsername()).getResultList().isEmpty());
    }

}
