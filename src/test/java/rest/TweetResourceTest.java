/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import domain.Tweet;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.client.methods.HttpUriRequest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.apache.http.HttpResponse;
import util.DatabaseCleaner;

/**
 *
 * @author Teun
 */
public class TweetResourceTest {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("KwetterS62TestPU");
    private HttpUriRequest request;
    private ObjectMapper om;

    public TweetResourceTest() {
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

    @Test
    public void testGetTweet() throws Exception {
        System.out.println("getTweet");
        try {
            request = new HttpGet("http://localhost:8080/KwetterS62/api/tweets/1");
            HttpResponse response = HttpClientBuilder.create().build().execute(request);

            Tweet t = om.readValue(response.getEntity().getContent(), Tweet.class);

            assertNotNull(t.getId());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    @Test
    public void testGetRecentTweetsByUser() throws Exception {
        System.out.println("getRecentTweetsByUser");
        try {
            request = new HttpGet("http://localhost:8080/KwetterS62/api/tweets/getbyuser/1/testings@gmail.com");
            HttpResponse response = HttpClientBuilder.create().build().execute(request);

            List<Tweet> t = om.readValue(response.getEntity().getContent(), TypeFactory.defaultInstance().constructCollectionType(List.class, Tweet.class));

            assertNotNull(t.get(0).getId());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    @Test
    public void testGetRecentTweets() throws Exception {
        System.out.println("getRecentTweets");
        try {
            request = new HttpGet("http://localhost:8080/KwetterS62/api/tweets/getrecent/1");
            HttpResponse response = HttpClientBuilder.create().build().execute(request);

            Tweet t = om.readValue(response.getEntity().getContent(), Tweet.class);

            assertNotNull(t.getId());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    @Test
    public void testUpdateTweet() throws Exception {
        System.out.println("updateTweet");
        System.out.println("NOT IMPLEMENTED");
    }
    
    @Test
    public void testInsertTweet() throws Exception {
        System.out.println("insertTweet");
        System.out.println("NOT IMPLEMENTED");
    }
    
    @Test
    public void testDeleteTweet() throws Exception {
        System.out.println("deleteTweet");
        System.out.println("NOT IMPLEMENTED");
    }

}
