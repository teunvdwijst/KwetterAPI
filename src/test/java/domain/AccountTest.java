/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

/**
 *
 * @author Teun
 */
public class AccountTest {
    
    public AccountTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getUserName method, of class Account.
     */
    @org.junit.Test
    public void testGetUserName() {
        System.out.println("getUserName");
        Account instance = new Account();
        String expResult = "";
        String result = instance.getUserName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserName method, of class Account.
     */
    @org.junit.Test
    public void testSetUserName() {
        System.out.println("setUserName");
        String userName = "";
        Account instance = new Account();
        instance.setUserName(userName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class Account.
     */
    @org.junit.Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Account instance = new Account();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class Account.
     */
    @org.junit.Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        Account instance = new Account();
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEncryptedPassword method, of class Account.
     */
    @org.junit.Test
    public void testGetEncryptedPassword() {
        System.out.println("getEncryptedPassword");
        Account instance = new Account();
        String expResult = "";
        String result = instance.getEncryptedPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEncryptedPassword method, of class Account.
     */
    @org.junit.Test
    public void testSetEncryptedPassword() {
        System.out.println("setEncryptedPassword");
        String encryptedPassword = "";
        Account instance = new Account();
        instance.setEncryptedPassword(encryptedPassword);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLocation method, of class Account.
     */
    @org.junit.Test
    public void testGetLocation() {
        System.out.println("getLocation");
        Account instance = new Account();
        String expResult = "";
        String result = instance.getLocation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLocation method, of class Account.
     */
    @org.junit.Test
    public void testSetLocation() {
        System.out.println("setLocation");
        String location = "";
        Account instance = new Account();
        instance.setLocation(location);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBio method, of class Account.
     */
    @org.junit.Test
    public void testGetBio() {
        System.out.println("getBio");
        Account instance = new Account();
        String expResult = "";
        String result = instance.getBio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBio method, of class Account.
     */
    @org.junit.Test
    public void testSetBio() {
        System.out.println("setBio");
        String bio = "";
        Account instance = new Account();
        instance.setBio(bio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWebsite method, of class Account.
     */
    @org.junit.Test
    public void testGetWebsite() {
        System.out.println("getWebsite");
        Account instance = new Account();
        String expResult = "";
        String result = instance.getWebsite();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWebsite method, of class Account.
     */
    @org.junit.Test
    public void testSetWebsite() {
        System.out.println("setWebsite");
        String website = "";
        Account instance = new Account();
        instance.setWebsite(website);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAvatarPath method, of class Account.
     */
    @org.junit.Test
    public void testGetAvatarPath() {
        System.out.println("getAvatarPath");
        Account instance = new Account();
        String expResult = "";
        String result = instance.getAvatarPath();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAvatarPath method, of class Account.
     */
    @org.junit.Test
    public void testSetAvatarPath() {
        System.out.println("setAvatarPath");
        String avatarPath = "";
        Account instance = new Account();
        instance.setAvatarPath(avatarPath);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserRole method, of class Account.
     */
    @org.junit.Test
    public void testGetUserRole() {
        System.out.println("getUserRole");
        Account instance = new Account();
        Role expResult = null;
        Role result = instance.getUserRole();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserRole method, of class Account.
     */
    @org.junit.Test
    public void testSetUserRole() {
        System.out.println("setUserRole");
        Role userRole = null;
        Account instance = new Account();
        instance.setUserRole(userRole);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of followAccount method, of class Account.
     */
    @org.junit.Test
    public void testFollowAccount() {
        System.out.println("followAccount");
        Account a = null;
        Account instance = new Account();
        instance.followAccount(a);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFollowingAccounts method, of class Account.
     */
    @org.junit.Test
    public void testGetFollowingAccounts() {
        System.out.println("getFollowingAccounts");
        Account instance = new Account();
        List<Account> expResult = null;
        List<Account> result = instance.getFollowingAccounts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
