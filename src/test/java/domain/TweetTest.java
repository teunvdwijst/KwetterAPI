/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Teun
 */
public class TweetTest {

    public TweetTest() {
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

    @Test
    public void testHashcode() {
        Account user = new Account();
        Tweet tweet1 = new Tweet("1", user);
        Tweet tweet2 = new Tweet("2", user);
        Tweet tweet3 = new Tweet("1", user);
        assertFalse(tweet1.hashCode() == tweet2.hashCode());
        assertTrue(tweet1.hashCode() == tweet3.hashCode());
    }

    /**
     * Test of equals method, of class Tweet.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");

        Account user1 = new Account("1", "");
        Account user2 = new Account("2", "");
        Tweet tweet1 = new Tweet("message1", user1, new Date(0));
        Tweet tweet2 = new Tweet("message2", user1, new Date(0));

        boolean equals = tweet1.equals(tweet2);
        assertFalse(equals);

        equals = tweet1.equals(tweet1);
        assertTrue(equals);

        equals = tweet1.equals(null);
        assertFalse(equals);

        equals = tweet1.equals(user1);
        assertFalse(equals);

        tweet2 = new Tweet("message2", user2, new Date(0));
        equals = tweet1.equals(tweet2);
        assertFalse(equals);

        tweet2 = new Tweet("message1", user1, new Date(1));
        equals = tweet1.equals(tweet2);
        assertFalse(equals);

        tweet2 = new Tweet("message1", user2, new Date(0));
        equals = tweet1.equals(tweet2);
        assertFalse(equals);
    }

    /**
     * Test of getContent method, of class Tweet.
     */
    @Test
    public void testGetContent() {
        System.out.println("getContent");
        Tweet instance = new Tweet("", null);
        String expResult = "";
        String result = instance.getContent();
        assertEquals(expResult, result);

        expResult = "test";
        instance = new Tweet(expResult, null);
        result = instance.getContent();
        assertEquals(expResult, result);
    }

    /**
     * Test of setContent method, of class Tweet.
     */
    @Test
    public void testSetContent() {
        System.out.println("setContent");
        String content = "setContent";
        Tweet instance = new Tweet("", null);
        assertEquals("", instance.getContent());
        instance.setContent(content);
        assertEquals(instance.getContent(), content);

        instance.setContent(null);
        assertNull(instance.getContent());
    }

    /**
     * Test of getPublished method, of class Tweet.
     */
    @Test
    public void testGetPublished() {
        System.out.println("getPublished");
        Date d = new Date(946681200);
        Tweet instance = new Tweet("", null, d);
        Date expResult = new Date(946681200);
        Date result = instance.getPublished();
        assertEquals(expResult, result);

        instance = new Tweet();
        assertNull(instance.getPublished());
    }

    /**
     * Test of setPublished method, of class Tweet.
     */
    @Test
    public void testSetPublished() {
        System.out.println("setPublished");
        Date published = new Date(946681200);
        Tweet instance = new Tweet();
        assertNull(instance.getPublished());
        instance.setPublished(published);
        assertEquals(instance.getPublished(), published);
    }

    /**
     * Test of getTags method, of class Tweet.
     */
    @Test
    public void testGetTags() {
        System.out.println("getTags");
        Tweet instance = new Tweet("#1 #2", null, new Date(0));
        List<String> expResult = new ArrayList<>();
        expResult.add("1");
        expResult.add("2");
        List<String> result = instance.getTags();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLikes method, of class Tweet.
     */
    @Test
    public void testGetLikes() {
        System.out.println("getLikes");
        Tweet instance = new Tweet("", null, new Date(0));
        List<Account> expResult = new ArrayList<>();
        List<Account> result = instance.getLikedBy();
        assertEquals(expResult, result);

        Account a = new Account("", "");
        instance.addLike(a);
        expResult.add(a);
        result = instance.getLikedBy();
        assertEquals(expResult, result);
    }

    /**
     * Test of addLike method, of class Tweet.
     */
    @Test
    public void testAddLike() {
        System.out.println("addLike");
        Account a = new Account("", "");
        Tweet instance = new Tweet("", null, new Date(0));
        List<Account> expResult = new ArrayList<>();
        assertEquals(instance.getLikedBy(), expResult);
        instance.addLike(a);
        expResult.add(a);
        assertEquals(instance.getLikedBy(), expResult);

        instance.addLike(a);
        assertEquals(instance.getLikedBy(), expResult);
    }

    /**
     * Test of removeLike method, of class Tweet.
     */
    @Test
    public void testRemoveLike() {
        System.out.println("removeLike");
        Account a = new Account("", "");
        Tweet instance = new Tweet("", null);
        instance.removeLike(a);

        instance.addLike(a);
        assertEquals(1, instance.getLikedBy().size());
        instance.removeLike(a);
        assertEquals(0, instance.getLikedBy().size());
    }

    /**
     * Test of getLikedBy method, of class Tweet.
     */
    @Test
    public void testGetLikedBy() {
        System.out.println("getLikedBy");
        Tweet instance = new Tweet();
        List<Account> expResult = new ArrayList<>();
        List<Account> result = instance.getLikedBy();
        assertEquals(expResult, result);

        Account a = new Account();
        instance.addLike(a);
        expResult.add(a);
        result = instance.getLikedBy();
        assertEquals(expResult.size(), result.size());
    }

    /**
     * Test of getTweetedBy method, of class Tweet.
     */
    @Test
    public void testGetTweetedBy() {
        System.out.println("getTweetedBy");
        Tweet instance = new Tweet("", null);
        Account expResult = null;
        Account result = instance.getTweetedBy();
        assertEquals(expResult, result);

        Account a = new Account("test", "");
        a.addTweet("test");
        assertEquals(a, a.getTweets().get(0).getTweetedBy());
    }
}
