/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

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

    /**
     * Test of getMessage method, of class Tweet.
     */
    @Test
    public void testGetMessage() {
        System.out.println("getMessage");
        Tweet instance = new Tweet();
        String expResult = "";
        String result = instance.getMessage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMessage method, of class Tweet.
     */
    @Test
    public void testSetMessage() {
        System.out.println("setMessage");
        String message = "";
        Tweet instance = new Tweet();
        instance.setMessage(message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPublished method, of class Tweet.
     */
    @Test
    public void testGetPublished() {
        System.out.println("getPublished");
        Tweet instance = new Tweet();
        Date expResult = null;
        Date result = instance.getPublished();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPublished method, of class Tweet.
     */
    @Test
    public void testSetPublished() {
        System.out.println("setPublished");
        Date published = null;
        Tweet instance = new Tweet();
        instance.setPublished(published);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTags method, of class Tweet.
     */
    @Test
    public void testGetTags() {
        System.out.println("getTags");
        Tweet instance = new Tweet();
        List<String> expResult = null;
        List<String> result = instance.getTags();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTags method, of class Tweet.
     */
    @Test
    public void testSetTags() {
        System.out.println("setTags");
        List<String> tags = null;
        Tweet instance = new Tweet();
        instance.setTags(tags);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addLike method, of class Tweet.
     */
    @Test
    public void testAddLike() {
        System.out.println("addLike");
        Account a = null;
        Tweet instance = new Tweet();
        instance.addLike(a);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLikes method, of class Tweet.
     */
    @Test
    public void testGetLikes() {
        System.out.println("getLikes");
        Tweet instance = new Tweet();
        List<Account> expResult = null;
        List<Account> result = instance.getLikes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
