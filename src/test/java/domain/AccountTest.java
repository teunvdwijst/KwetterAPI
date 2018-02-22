/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.Role;
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
        Account instance = new Account("", "", "");
        String expResult = "";
        String result = instance.getUserName();
        assertEquals(expResult, result);

        expResult = "Account";
        instance = new Account(expResult, "", "");
        result = instance.getUserName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUserName method, of class Account.
     */
    @org.junit.Test
    public void testSetUserName() {
        System.out.println("setUserName");
        String userName = "setUserName";
        Account instance = new Account("", "", "");
        assertEquals(instance.getUserName(), "");
        instance.setUserName(userName);
        assertEquals(instance.getUserName(), userName);

        instance.setUserName(null);
        assertNull(instance.getUserName());
    }

    /**
     * Test of getEmail method, of class Account.
     */
    @org.junit.Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Account instance = new Account("", "", "");
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);

        expResult = "getEmail";
        instance = new Account("", expResult, "");
        result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmail method, of class Account.
     */
    @org.junit.Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "setEmail";
        Account instance = new Account("", "", "");
        assertEquals(instance.getEmail(), "");
        instance.setEmail(email);
        assertEquals(instance.getEmail(), email);

        instance.setEmail(null);
        assertNull(instance.getEmail());
    }

    /**
     * Test of getEncryptedPassword method, of class Account.
     */
    @org.junit.Test
    public void testGetEncryptedPassword() {
        System.out.println("getEncryptedPassword");
        Account instance = new Account("", "", "");
        String expResult = "";
        String result = instance.getEncryptedPassword();
        assertEquals(expResult, result);

        expResult = "getEncryptedPassword";
        instance = new Account("", "", expResult);
        result = instance.getEncryptedPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEncryptedPassword method, of class Account.
     */
    @org.junit.Test
    public void testSetEncryptedPassword() {
        System.out.println("setEncryptedPassword");
        String encryptedPassword = "setEncryptedPassword";
        Account instance = new Account("", "", "");
        assertEquals(instance.getEncryptedPassword(), "");
        instance.setEncryptedPassword(encryptedPassword);
        assertEquals(instance.getEncryptedPassword(), encryptedPassword);

        instance.setEncryptedPassword(null);
        assertNull(instance.getEncryptedPassword());
    }

    /**
     * Test of getLocation method, of class Account.
     */
    @org.junit.Test
    public void testGetLocation() {
        System.out.println("getLocation");
        Account instance = new Account("", "", "", "", "", "", "", Role.USER);
        String expResult = "";
        String result = instance.getLocation();
        assertEquals(expResult, result);

        expResult = "getLocation";
        instance = new Account("", "", "", expResult, "", "", "", Role.USER);
        result = instance.getLocation();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLocation method, of class Account.
     */
    @org.junit.Test
    public void testSetLocation() {
        System.out.println("setLocation");
        String location = "setLocation";
        Account instance = new Account("", "", "", "", "", "", "", Role.USER);
        assertEquals(instance.getLocation(), "");
        instance.setLocation(location);
        assertEquals(instance.getLocation(), location);

        instance.setLocation(null);
        assertNull(instance.getLocation());
    }

    /**
     * Test of getBio method, of class Account.
     */
    @org.junit.Test
    public void testGetBio() {
        System.out.println("getBio");
        Account instance = new Account("", "", "", "", "", "", "", Role.USER);
        String expResult = "";
        String result = instance.getBio();
        assertEquals(expResult, result);

        expResult = "getBio";
        instance = new Account("", "", "", "", expResult, "", "", Role.USER);
        result = instance.getBio();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBio method, of class Account.
     */
    @org.junit.Test
    public void testSetBio() {
        System.out.println("setBio");
        String bio = "setBio";
        Account instance = new Account("", "", "", "", "", "", "", Role.USER);
        assertEquals(instance.getBio(), "");
        instance.setBio(bio);
        assertEquals(instance.getBio(), bio);

        instance.setBio(null);
        assertNull(instance.getBio());
    }

    /**
     * Test of getWebsite method, of class Account.
     */
    @org.junit.Test
    public void testGetWebsite() {
        System.out.println("getWebsite");
        Account instance = new Account("", "", "", "", "", "", "", Role.USER);
        String expResult = "";
        String result = instance.getWebsite();
        assertEquals(expResult, result);

        expResult = "getWebsite";
        instance = new Account("", "", "", "", "", expResult, "", Role.USER);
        assertEquals(instance.getWebsite(), expResult);
    }

    /**
     * Test of setWebsite method, of class Account.
     */
    @org.junit.Test
    public void testSetWebsite() {
        System.out.println("setWebsite");
        String website = "setWebsite";
        Account instance = new Account("", "", "", "", "", "", "", Role.USER);
        assertEquals(instance.getWebsite(), "");
        instance.setWebsite(website);
        assertEquals(instance.getWebsite(), website);

        instance.setWebsite(null);
        assertNull(instance.getWebsite());
    }

    /**
     * Test of getAvatarPath method, of class Account.
     */
    @org.junit.Test
    public void testGetAvatarPath() {
        System.out.println("getAvatarPath");
        Account instance = new Account("", "", "", "", "", "", "", Role.USER);
        String expResult = "";
        String result = instance.getAvatarPath();
        assertEquals(expResult, result);

        expResult = "getAvatarPath";
        instance = new Account("", "", "", "", "", "", expResult, Role.USER);
        assertEquals(instance.getAvatarPath(), expResult);
    }

    /**
     * Test of setAvatarPath method, of class Account.
     */
    @org.junit.Test
    public void testSetAvatarPath() {
        System.out.println("setAvatarPath");
        String avatarPath = "setAvatarPath";
        Account instance = new Account("", "", "", "", "", "", "", Role.USER);
        assertEquals(instance.getAvatarPath(), "");
        instance.setAvatarPath(avatarPath);
        assertEquals(instance.getAvatarPath(), avatarPath);

        instance.setAvatarPath(null);
        assertNull(instance.getAvatarPath());
    }

    /**
     * Test of getUserRole method, of class Account.
     */
    @org.junit.Test
    public void testGetUserRole() {
        System.out.println("getUserRole");
        Account instance = new Account("", "", "", "", "", "", "", Role.USER);
        Role expResult = Role.USER;
        Role result = instance.getUserRole();
        assertEquals(expResult, result);

        expResult = Role.MODERATOR;
        instance = new Account("", "", "", "", "", "", "", Role.MODERATOR);
        assertEquals(instance.getUserRole(), expResult);

        expResult = Role.ADMIN;
        instance = new Account("", "", "", "", "", "", "", Role.ADMIN);
        assertEquals(instance.getUserRole(), expResult);
    }

    /**
     * Test of setUserRole method, of class Account.
     */
    @org.junit.Test
    public void testSetUserRole() {
        System.out.println("setUserRole");
        Role userRole = Role.MODERATOR;
        Account instance = new Account("", "", "", "", "", "", "", Role.USER);
        assertEquals(instance.getUserRole(), Role.USER);
        instance.setUserRole(userRole);
        assertEquals(instance.getUserRole(), userRole);
    }

    /**
     * Test of getFollowingAccounts method, of class Account.
     */
    @org.junit.Test
    public void testGetFollowingAccounts() {
        System.out.println("getFollowingAccounts");
        Account instance = new Account();
        int expResult = 0;
        int result = instance.getFollowingAccounts().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of followAccount method, of class Account.
     */
    @org.junit.Test
    public void testFollowAccount() {
        System.out.println("followAccount");
        Account a = new Account();
        Account instance = new Account();
        int expResult = 0;
        assertEquals(instance.getFollowingAccounts().size(), expResult);
        instance.followAccount(a);
        expResult = 1;
        assertEquals(instance.getFollowingAccounts().size(), expResult);
    }
}
