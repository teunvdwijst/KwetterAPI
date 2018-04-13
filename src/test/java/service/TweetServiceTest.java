package service;

import dao.TweetDAO;
import domain.Tweet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Teun
 */
@Ignore
public class TweetServiceTest {

    @Mock
    private TweetDAO tweetDao;

    @InjectMocks
    private TweetService tweetService;

    public TweetServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getTweet method, of class TweetResource.
     */
    @Test
    public void testGetTweet() throws Exception {
        System.out.println("getTweet");
        tweetService.getTweet(1);

        verify(tweetDao, times(1)).getTweetById(1);
    }

    /**
     * Test of getRecentTweetsByUser method, of class TweetResource.
     */
    @Test
    public void testGetRecentTweetsByUser() throws Exception {
        System.out.println("getRecentTweetsByUser");
        tweetService.getRecentTweetsByUser(1, 0, "user");

        verify(tweetDao, times(1)).getRecentTweetsByUsername(1, 0, "user");
    }

    /**
     * Test of getRecentTweets method, of class TweetResource.
     */
    @Test
    public void testGetRecentTweets() throws Exception {
        System.out.println("getRecentTweets");
        tweetService.getRecentTweets(1, 0);

        verify(tweetDao, times(1)).getRecentTweets(1, 0);
    }

    /**
     * Test of updateTweet method, of class TweetResource.
     */
    @Test
    public void testUpdateTweet() throws Exception {
        System.out.println("updateTweet");
        Tweet tweet = new Tweet("tweet", null);
        tweetService.updateTweet(tweet);

        verify(tweetDao, times(1)).updateTweet(tweet);
    }

    /**
     * Test of insertTweet method, of class TweetResource.
     */
    @Test
    public void testInsertTweet() throws Exception {
        System.out.println("insertTweet");
        Tweet tweet = new Tweet("tweet", null);
        tweetService.insertTweet(tweet);

        verify(tweetDao, times(1)).insertTweet(tweet);
    }

    /**
     * Test of deleteTweet method, of class TweetResource.
     */
    @Test
    public void testDeleteTweet() throws Exception {
        System.out.println("deleteTweet");
        Tweet tweet = new Tweet("tweet", null);
        tweet.setId(1L);

        tweetService.deleteTweet(1);

        verify(tweetDao, times(1)).deleteTweet(tweet);
    }
}
