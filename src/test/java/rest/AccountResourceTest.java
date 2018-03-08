/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Account;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.embeddable.EJBContainer;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.DatabaseCleaner;

/**
 *
 * @author Teun
 */
public class AccountResourceTest {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("KwetterS62TestPU");
    private HttpUriRequest request;
    private ObjectMapper om;

    public AccountResourceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        try {
            new DatabaseCleaner(emf.createEntityManager()).clean();
        } catch (SQLException ex) {
            Logger.getLogger(TweetResourceTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        om = new ObjectMapper();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getAllAccounts method, of class AccountResource.
     */
    @Test
    public void testGetAllAccounts() throws Exception {
        System.out.println("getAllAccounts");
        try {
            request = new HttpGet("http://localhost:8080/KwetterS62/api/tweets/1");
            HttpResponse response = HttpClientBuilder.create().build().execute(request);

            Account a = om.readValue(response.getEntity().getContent(), Account.class);

            assertNotNull(a.getId());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Test of getAccountByEmail method, of class AccountResource.
     */
    @Test
    public void testGetAccountByEmail() throws Exception {
        System.out.println("getAccountByEmail");
        String email = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        AccountResource instance = (AccountResource) container.getContext().lookup("java:global/classes/AccountResource");
        List<Account> expResult = null;
        List<Account> result = instance.getAccountByEmail(email);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAccountByUsername method, of class AccountResource.
     */
    @Test
    public void testGetAccountByUsername() throws Exception {
        System.out.println("getAccountByUsername");
        String username = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        AccountResource instance = (AccountResource) container.getContext().lookup("java:global/classes/AccountResource");
        List<Account> expResult = null;
        List<Account> result = instance.getAccountByUsername(username);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAccountFollowers method, of class AccountResource.
     */
    @Test
    public void testGetAccountFollowers() throws Exception {
        System.out.println("getAccountFollowers");
        String email = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        AccountResource instance = (AccountResource) container.getContext().lookup("java:global/classes/AccountResource");
        List<Account> expResult = null;
        List<Account> result = instance.getAccountFollowers(email);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAccountFollowing method, of class AccountResource.
     */
    @Test
    public void testGetAccountFollowing() throws Exception {
        System.out.println("getAccountFollowing");
        String email = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        AccountResource instance = (AccountResource) container.getContext().lookup("java:global/classes/AccountResource");
        List<Account> expResult = null;
        List<Account> result = instance.getAccountFollowing(email);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertAccount method, of class AccountResource.
     */
    @Test
    public void testInsertAccount() throws Exception {
        System.out.println("insertAccount");
        Account user = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        AccountResource instance = (AccountResource) container.getContext().lookup("java:global/classes/AccountResource");
        instance.insertAccount(user);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateAccount method, of class AccountResource.
     */
    @Test
    public void testUpdateAccount() throws Exception {
        System.out.println("updateAccount");
        Account user = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        AccountResource instance = (AccountResource) container.getContext().lookup("java:global/classes/AccountResource");
        instance.updateAccount(user);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteAccount method, of class AccountResource.
     */
    @Test
    public void testDeleteAccount() throws Exception {
        System.out.println("deleteAccount");
        Account user = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        AccountResource instance = (AccountResource) container.getContext().lookup("java:global/classes/AccountResource");
        instance.deleteAccount(user);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
