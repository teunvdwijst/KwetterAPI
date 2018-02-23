/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
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
     * Test of getContent method, of class Tweet.
     */
    @Test
    public void testGetContent() {
        System.out.println("getContent");
        Tweet instance = new Tweet("");
        String expResult = "";
        String result = instance.getContent();
        assertEquals(expResult, result);

        expResult = "test";
        instance = new Tweet(expResult);
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
        Tweet instance = new Tweet("");
        assertEquals(instance.getContent(), "");
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
        Tweet instance = new Tweet("", d, new ArrayList<String>());
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
        List<String> t = new ArrayList<>();
        t.add("1");
        t.add("2");
        Tweet instance = new Tweet("", new Date(0), t);
        List<String> expResult = new ArrayList<>();
        expResult.add("1");
        expResult.add("2");
        List<String> result = instance.getTags();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTags method, of class Tweet.
     */
    @Test
    public void testSetTags() {
        System.out.println("setTags");
        List<String> tags = new ArrayList<>();
        tags.add("1");
        tags.add("2");
        Tweet instance = new Tweet("", new Date(0), null);
        assertNull(instance.getTags());
        instance.setTags(tags);
        assertEquals(instance.getTags(), tags);
    }

    /**
     * Test of getLikes method, of class Tweet.
     */
    @Test
    public void testGetLikes() {
        System.out.println("getLikes");
        Tweet instance = new Tweet("", new Date(0), null);
        List<Account> expResult = new ArrayList<>();
        List<Account> result = instance.getLikes();
        assertEquals(expResult, result);

        Account a = new Account("", "");
        instance.addLike(a);
        expResult.add(a);
        result = instance.getLikes();
        assertEquals(expResult, result);
    }

    /**
     * Test of addLike method, of class Tweet.
     */
    @Test
    public void testAddLike() {
        System.out.println("addLike");
        Account a = new Account("", "");
        Tweet instance = new Tweet("", new Date(0), null);
        List<Account> expResult = new ArrayList<>();
        assertEquals(instance.getLikes(), expResult);
        instance.addLike(a);
        expResult.add(a);
        assertEquals(instance.getLikes(), expResult);
    }

    /**
     * Test of removeLike method, of class Tweet.
     */
    @Test
    public void testRemoveLike() {
        System.out.println("removeLike");
        Account a = new Account("", "");
        Tweet instance = new Tweet("");
        instance.removeLike(a);
        
        instance.addLike(a);
        assertEquals(instance.getLikes().size(), 1);
        instance.removeLike(a);
        assertEquals(instance.getLikes().size(), 0);
    }

}
