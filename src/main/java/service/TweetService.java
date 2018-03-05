/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.TweetDAO;
import domain.Tweet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.PersistenceException;

/**
 *
 * @author Teun
 */
@Stateless
public class TweetService {

    @Inject
    TweetDAO tweetDao;
    
    private static final Logger LOGGER = Logger.getLogger(AccountService.class.getName());

    public TweetService() {
    }

    /**
     * Fetches a tweet which matches the id from the database. returns null if
     * no tweet matching the id was found.
     *
     * @param id
     * @return Tweet
     */
    public Tweet getTweet(int id) {
        try {
            return tweetDao.getTweetById(id);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getTweet operation; {0}", pe.getMessage());
            return null;
        }
    }

    /**
     * Fetches 'limit' amount of Tweets posted by the Account with 'userEmail'.
     * Tweets are sorted by publish date descending. Returns an empty list if no
     * Tweets were found
     *
     * @param limit
     * @param userEmail
     * @return List of Tweets
     */
    public List<Tweet> getRecentTweetsByUser(int limit, String userEmail)  {
        try {
            return tweetDao.getRecentTweetsByEmail(limit, userEmail);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getRecentTweetsByUser operation; {0}", pe.getMessage());
            return null;
        }
    }

    /**
     * Fetches 'limit' amount of Tweets. Tweets are sorted by publish date
     * descending. Returns an empty list if no Tweets were found
     *
     * @param limit
     * @return List of Tweets
     */
    public List<Tweet> getRecentTweets(int limit) {
        try {
            return tweetDao.getRecentTweets(limit);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getRecentTweets operation; {0}", pe.getMessage());
            return null;
        }
    }

    /**
     * Updates a Tweet object in the database, if update fails this function
     * does nothing
     *
     * @param tweet
     */
    public void updateTweet(Tweet tweet) {
        try {
            tweetDao.updateTweet(tweet);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing updateTweet operation; {0}", pe.getMessage());
        }
    }

    /**
     * Inserts a Tweet object in the database, if the insert fails this function
     * does nothing
     *
     * @param tweet
     */
    public void insertTweet(Tweet tweet) {
        try {
            tweetDao.insertTweet(tweet);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing insertTweet operation; {0}", pe.getMessage());
        }
    }

    /**
     * Removes a Tweet object in the database, if the insert fails this function
     * does nothing
     *
     * @param tweet
     */
    public void deleteTweet(Tweet tweet)  {
        try {
            tweetDao.deleteTweet(tweet);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing removeTweet operation; {0}", pe.getMessage());
        }
    }
}
