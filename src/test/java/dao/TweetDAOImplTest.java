/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Account;
import domain.Tweet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import util.DatabaseCleaner;

/**
 *
 * @author Teun
 */
public class TweetDAOImplTest {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("KwetterS62TestPU");
    private EntityManager em;
    private EntityTransaction et;

    public TweetDAOImplTest() {
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
            Logger.getLogger(AccountDAOImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        em = emf.createEntityManager();
        et = em.getTransaction();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getTweetById method, of class TweetDAOImpl.
     */
    @Test
    public void testGetTweetById() throws Exception {
        Account a = new Account("login1", "pass");
        a.addTweet("content");

        et.begin();
        em.persist(a);
        et.commit();

        Assert.assertTrue(em.createNamedQuery("Tweet.findById").setParameter("id", 1).getResultList().size() == 1);
    }

    /**
     * Test of getRecentTweetsByEmail method, of class TweetDAOImpl.
     */
    @Test
    public void testGetRecentTweetsByEmail() throws Exception {
        /*Account a = new Account("login1", "pass");
        a.addTweet("content");
        a.addTweet("and");
        a.addTweet("more");
        a.addTweet("CONTENT");

        et.begin();
        em.persist(a);
        et.commit();

        Assert.assertTrue(em.createNamedQuery("Tweet.findRecentByEmail").setParameter("email", a.getEmail()).getResultList().size() > 1);*/
    }

    /**
     * Test of updateTweet method, of class TweetDAOImpl.
     */
    @Test
    public void testUpdateTweet() throws Exception {
        Account a = new Account("login", "pass");
        a.addTweet("Content");

        et.begin();
        em.persist(a);
        et.commit();
        
        a.getTweets().get(1).setContent("new content");;
        
        et.begin();
        em.merge(a);
        et.commit();

        Assert.assertTrue(em.createNamedQuery("Tweet.findRecentByTag").setParameter("tag", "NewTag").getResultList().size() > 0);
    }

    /**
     * Test of insertTweet method, of class TweetDAOImpl.
     */
    @Test
    public void testInsertTweet() throws Exception {
        Account a = new Account("login", "pass");
        a.addTweet("Content");

        et.begin();
        em.persist(a);
        et.commit();

        Assert.assertTrue(em.createNamedQuery("Tweet.findRecent").getResultList().size() == 1);
    }

    /**
     * Test of removeTweet method, of class TweetDAOImpl.
     */
    @Test
    public void testRemoveTweet() throws Exception {
        Account a = new Account("login", "pass");
        a.addTweet("Content");

        et.begin();
        em.persist(a);
        et.commit();

        Assert.assertTrue(em.createNamedQuery("Tweet.findRecent").getResultList().size() == 1);

        a.removeTweet(1);

        et.begin();
        em.merge(a);
        et.commit();

        Assert.assertTrue(em.createNamedQuery("Tweet.findRecent").getResultList().isEmpty());
    }

    /**
     * Test of getRecentTweets method, of class TweetDAOImpl.
     */
    @Test
    public void testGetRecentTweets() throws Exception {
        Account a = new Account("login", "pass");
        a.addTweet("Content");

        et.begin();
        em.persist(a);
        et.commit();

        Assert.assertTrue(em.createNamedQuery("Tweet.findRecent").getResultList().size() == 1);
    }

    /**
     * Test of getRecentTweetsByTag method, of class TweetDAOImpl.
     */
    @Test
    public void testGetRecentTweetsByTag() throws Exception {
        Account a = new Account("login", "pass");
        a.addTweet("Content");

        et.begin();
        em.persist(a);
        et.commit();

        Assert.assertTrue(em.createNamedQuery("Tweet.findRecentByTag").setParameter("tag", "NewTag").getResultList().size() > 0);
    }

}
