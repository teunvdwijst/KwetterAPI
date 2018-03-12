/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Teun
 */
@Ignore
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
     * Test of hashCode method, of class Account.
     */
    @org.junit.Test
    public void testHashCode() {
        System.out.println("hashCode");
        Account a1 = new Account("1", "", "", "", "", "", "");
        Account a2 = new Account("2", "", "", "", "", "", "");
        Account a3 = new Account("1", "", "", "", "", "", "");
        assertFalse(a1.hashCode() == a2.hashCode());
        assertTrue(a1.hashCode() == a3.hashCode());
    }

    /**
     * Test of equals method, of class Account.
     */
    @org.junit.Test
    public void testEquals() {
        System.out.println("equals");
        Object ojb = null;
        Account instance = new Account("1", "", "", "", "", "", "");
        Account other = new Account("2", "", "", "", "", "", "");
        Account another = new Account();

        boolean equals = instance.equals(ojb);
        assertFalse(equals);

        equals = instance.equals(other);
        assertFalse(equals);

        equals = instance.equals(another);
        assertFalse(equals);

        equals = instance.equals(instance);
        assertTrue(equals);
    }

    /**
     * Test of getUserName method, of class Account.
     */
    @org.junit.Test
    public void testGetUserName() {
        System.out.println("getUserName");
        Account instance = new Account("", "", "", "", "", "", "");
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(expResult, result);

        expResult = "Account";
        instance = new Account("", "", expResult, "", "", "", "");
        result = instance.getUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUserName method, of class Account.
     */
    @org.junit.Test
    public void testSetUserName() {
        System.out.println("setUserName");
        String userName = "setUserName";
        Account instance = new Account("", "", "", "", "", "", "");
        assertEquals("", instance.getUsername());
        instance.setUsername(userName);
        assertEquals(userName, instance.getUsername());

        instance.setUsername(null);
        assertNull(instance.getUsername());
    }

    /**
     * Test of getEmail method, of class Account.
     */
    @org.junit.Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Account instance = new Account("", "");
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);

        expResult = "getEmail";
        instance = new Account(expResult, "");
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
        Account instance = new Account("", "");
        assertEquals("", instance.getEmail());
        instance.setEmail(email);
        assertEquals(email, instance.getEmail());

        instance.setEmail(null);
        assertNull(instance.getEmail());
    }

    /**
     * Test of getLocation method, of class Account.
     */
    @org.junit.Test
    public void testGetLocation() {
        System.out.println("getLocation");
        Account instance = new Account("", "", "", "", "", "", "");
        String expResult = "";
        String result = instance.getLocation();
        assertEquals(expResult, result);

        expResult = "getLocation";
        instance = new Account("", "", "", expResult, "", "", "");
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
        Account instance = new Account("", "", "", "", "", "", "");
        assertEquals("", instance.getLocation());
        instance.setLocation(location);
        assertEquals(location, instance.getLocation());

        instance.setLocation(null);
        assertNull(instance.getLocation());
    }

    /**
     * Test of getBio method, of class Account.
     */
    @org.junit.Test
    public void testGetBio() {
        System.out.println("getBio");
        Account instance = new Account("", "", "", "", "", "", "");
        String expResult = "";
        String result = instance.getBio();
        assertEquals(expResult, result);

        expResult = "getBio";
        instance = new Account("", "", "", "", expResult, "", "");
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
        Account instance = new Account("", "", "", "", "", "", "");
        assertEquals("", instance.getBio());
        instance.setBio(bio);
        assertEquals(bio, instance.getBio());

        instance.setBio(null);
        assertNull(instance.getBio());
    }

    /**
     * Test of getWebsite method, of class Account.
     */
    @org.junit.Test
    public void testGetWebsite() {
        System.out.println("getWebsite");
        Account instance = new Account("", "", "", "", "", "", "");
        String expResult = "";
        String result = instance.getWebsite();
        assertEquals(expResult, result);

        expResult = "getWebsite";
        instance = new Account("", "", "", "", "", expResult, "");
        assertEquals(expResult, instance.getWebsite());
    }

    /**
     * Test of setWebsite method, of class Account.
     */
    @org.junit.Test
    public void testSetWebsite() {
        System.out.println("setWebsite");
        String website = "setWebsite";
        Account instance = new Account("", "", "", "", "", "", "");
        assertEquals("", instance.getWebsite());
        instance.setWebsite(website);
        assertEquals(website, instance.getWebsite());

        instance.setWebsite(null);
        assertNull(instance.getWebsite());
    }

    /**
     * Test of getAvatarPath method, of class Account.
     */
    @org.junit.Test
    public void testGetAvatarPath() {
        System.out.println("getAvatarPath");
        Account instance = new Account("", "", "", "", "", "", "");
        String expResult = "";
        String result = instance.getAvatarPath();
        assertEquals(expResult, result);

        expResult = "getAvatarPath";
        instance = new Account("", "", "", "", "", "", expResult);
        assertEquals(expResult, instance.getAvatarPath());
    }

    /**
     * Test of setAvatarPath method, of class Account.
     */
    @org.junit.Test
    public void testSetAvatarPath() {
        System.out.println("setAvatarPath");
        String avatarPath = "setAvatarPath";
        Account instance = new Account("", "", "", "", "", "", "");
        assertEquals("", instance.getAvatarPath());
        instance.setAvatarPath(avatarPath);
        assertEquals(avatarPath, instance.getAvatarPath());

        instance.setAvatarPath(null);
        assertNull(instance.getAvatarPath());
    }

    /**
     * Test of getUserRole method, of class Account.
     */
    @org.junit.Test
    public void testGetUserRole() {
        System.out.println("getUserRole");
        Account instance = new Account("", "", "", "", "", "", "");
        Role expResult = Role.USER;
        Role result = instance.getUserRole();
        assertEquals(expResult, result);

        expResult = Role.MODERATOR;
        instance.promote();
        assertEquals(expResult, instance.getUserRole());

        expResult = Role.ADMIN;
        instance.promote();
        assertEquals(expResult, instance.getUserRole());
    }

    /**
     * Test of setUserRole method, of class Account.
     */
    @org.junit.Test
    public void testSetUserRole() {
        System.out.println("setUserRole");
        Role userRole = Role.MODERATOR;
        Account instance = new Account("", "", "", "", "", "", "");
        assertEquals(Role.USER, instance.getUserRole());
        instance.setUserRole(userRole);
        assertEquals(userRole, instance.getUserRole());
    }

    /**
     * Test of addFollowing method, of class Account.
     */
    @Test
    public void testAddFollowing() {
        System.out.println("addFollowing");
        Account a = new Account("test1", "");
        Account instance = new Account("test2", "");
        int expResult = 0;
        assertEquals(expResult, instance.getFollowing().size());
        instance.addFollowing(a);
        expResult = 1;
        assertEquals(expResult, instance.getFollowing().size());
        instance.addFollowing(a);
        assertEquals(expResult, instance.getFollowing().size());
        instance.addFollowing(instance);
        expResult = 2;
        assertEquals(expResult, instance.getFollowing().size());
    }

    /**
     * Test of getFollowing method, of class Account.
     */
    @Test
    public void testGetFollowing() {
        System.out.println("getFollowing");
        Account a = new Account();
        Account instance = new Account();
        List<Account> expResult = new ArrayList<>();
        List<Account> result = instance.getFollowing();
        assertEquals(expResult, result);

        instance.addFollowing(a);
        assertEquals(1, instance.getFollowing().size());
    }

    /**
     * Test of removeFollowing method, of class Account.
     */
    @Test
    public void testRemoveFollowing() {
        System.out.println("removeFollowing");
        Account a = new Account("test", "");
        Account instance = new Account("", "");
        instance.removeFollowing(a);

        instance.addFollowing(a);
        assertEquals(1, instance.getFollowing().size());
        instance.removeFollowing(a);
        assertEquals(0, instance.getFollowing().size());
    }

    /**
     * Test of getTweets method, of class Account.
     */
    @Test
    public void testGetTweets() {
        System.out.println("getTweets");
        Account instance = new Account();
        List<Tweet> expResult = new ArrayList<>();
        List<Tweet> result = instance.getTweets();
        assertEquals(expResult, result);

        instance.addTweet("tweet");
        expResult.add(new Tweet("tweet", instance));
        assertEquals(instance.getTweets(), expResult);
    }

    /**
     * Test of addTweet method, of class Account.
     */
    @Test
    public void testAddTweet() {
        System.out.println("addTweet");
        String message = "Tweet1";
        Account instance = new Account("", "");
        Tweet t1 = new Tweet(message, instance);

        assertEquals(0, instance.getTweets().size());
        instance.addTweet(message);
        assertEquals(1, instance.getTweets().size());
        instance.addTweet("Tweet2");
        assertEquals(2, instance.getTweets().size());
        instance.addTweet("Tweet3");
        assertEquals(3, instance.getTweets().size());
        instance.addTweet("Tweet4");
        assertEquals(4, instance.getTweets().size());
        instance.addTweet("Tweet5");
        assertEquals(5, instance.getTweets().size());
        instance.addTweet("Tweet6");
        assertEquals(6, instance.getTweets().size());
        instance.addTweet("Tweet7");
        assertEquals(7, instance.getTweets().size());
        instance.addTweet("Tweet8");
        assertEquals(8, instance.getTweets().size());
        instance.addTweet("Tweet9");
        assertEquals(9, instance.getTweets().size());
        instance.addTweet("Tweet10");
        assertEquals(10, instance.getTweets().size());
        assertEquals(t1, instance.getTweets().get(0));
    }

    /**
     * Test of promote method, of class Account.
     */
    @Test
    public void testPromote() {
        System.out.println("promote");
        Role expResult = Role.USER;
        Account instance = new Account("", "", "", "", "", "", "");

        assertEquals(expResult, instance.getUserRole());
        instance.promote();
        expResult = Role.MODERATOR;
        assertEquals(expResult, instance.getUserRole());
        instance.promote();
        expResult = Role.ADMIN;
        assertEquals(expResult, instance.getUserRole());
        instance.promote();
        assertEquals(expResult, instance.getUserRole());
    }

    /**
     * Test of demote method, of class Account.
     */
    @Test
    public void testDemote() {
        System.out.println("demote");
        Role expResult = Role.ADMIN;
        Account instance = new Account("", "", "", "", "", "", "");
        instance.promote();
        instance.promote();

        assertEquals(expResult, instance.getUserRole());
        instance.demote();
        expResult = Role.MODERATOR;
        assertEquals(expResult, instance.getUserRole());
        instance.demote();
        expResult = Role.USER;
        assertEquals(expResult, instance.getUserRole());
        instance.demote();
        assertEquals(expResult, instance.getUserRole());
    }

    /**
     * Test of getId method, of class Account.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Account instance = new Account();
        instance.setId(0L);
        long expResult = 0L;
        long result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Account.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        long id = 0L;
        Account instance = new Account();
        instance.setId(id);
        assertEquals(id, instance.getId());
    }

    /**
     * Test of getUsername method, of class Account.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        Account instance = new Account("", "", "user", "", "", "", "");
        String expResult = "user";
        String result = instance.getUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUsername method, of class Account.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "testing";
        Account instance = new Account("", "", "user", "", "", "", "");
        instance.setUsername(username);
        assertEquals(username, instance.getUsername());
    }

    /**
     * Test of getPassword method, of class Account.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Account instance = new Account("email", "pass", "user", "", "", "", "");
        String result = instance.getPassword();
        assertTrue(BCrypt.checkpw("pass", result));
    }

    /**
     * Test of setPassword method, of class Account.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "newpass";
        Account instance = new Account("email", "pass", "user", "", "", "", "");
        instance.setPassword(password);
        String result = instance.getPassword();
        assertTrue(BCrypt.checkpw("newpass", result));
    }

    /**
     * Test of getFollowers method, of class Account.
     */
    @Test
    public void testGetFollowers() {
        System.out.println("getFollowers");
        Account instance = new Account();
        List<Account> expResult = new ArrayList<>();
        List<Account> result = instance.getFollowers();
        assertEquals(expResult, result);
    }

    /**
     * Test of addFollower method, of class Account.
     */
    @Test
    public void testAddFollower() {
        System.out.println("addFollower");
        Account a = null;
        Account instance = new Account();
        instance.addFollower(a);
        assertEquals(1, instance.getFollowers().size());
        instance.addFollower(a);
        assertEquals(1, instance.getFollowers().size());
    }

    /**
     * Test of removeFollower method, of class Account.
     */
    @Test
    public void testRemoveFollower() {
        System.out.println("removeFollower");
        Account a = null;
        Account instance = new Account();
        instance.removeFollower(a);
        assertEquals(0, instance.getFollowers().size());
        instance.addFollower(a);
        instance.removeFollower(a);
        assertEquals(0, instance.getFollowers().size());
    }

    /**
     * Test of removeTweet method, of class Account.
     */
    @Test
    public void testRemoveTweet() {
        System.out.println("removeTweet");
        long id = 1L;
        Account instance = new Account();
        instance.addTweet("message");
        instance.getTweets().get(0).setId(1L);
        instance.removeTweet(id);
        assertEquals(0, instance.getTweets().size());
    }

    /**
     * Test of verifyPassword method, of class Account.
     */
    @Test
    public void testVerifyPassword() {
        System.out.println("verifyPassword");
        String password = "test";
        Account instance = new Account("email", "pass");
        boolean expResult = false;
        boolean result = instance.verifyPassword(password);
        assertEquals(expResult, result);

        instance.setPassword("test");
        expResult = true;
        result = instance.verifyPassword(password);
        assertEquals(expResult, result);
    }
}
