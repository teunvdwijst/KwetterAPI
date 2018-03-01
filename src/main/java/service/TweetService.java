/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.TweetDAO;
import domain.Tweet;
import java.util.ArrayList;
import java.util.List;
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

    public TweetService() {
    }

    /**
     * Fetches a tweet which matches the id from the database. returns null if
     * no tweet matching the id was found.
     *
     * @param id
     * @return Tweet
     * @throws java.lang.Exception
     */
    public Tweet getTweet(int id) throws Exception {
        try {
            return tweetDao.getTweetById(id).get(0);
        } catch (PersistenceException pe) {
            throw new Exception(pe);
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
     * @throws java.lang.Exception
     */
    public List<Tweet> getRecentTweetsByUser(int limit, String userEmail) throws Exception {
        try {
            return tweetDao.getRecentTweetsByEmail(limit, userEmail);
        } catch (PersistenceException pe) {
            throw new Exception(pe);
        }
    }

    /**
     * Fetches 'limit' amount of Tweets. Tweets are sorted by publish date
     * descending. Returns an empty list if no Tweets were found
     *
     * @param limit
     * @return List of Tweets
     * @throws java.lang.Exception
     */
    public List<Tweet> getRecentTweets(int limit) throws Exception {
        try {
            return tweetDao.getRecentTweets(limit);
        } catch (PersistenceException pe) {
            throw new Exception(pe);
        }
    }

    /**
     * Updates a Tweet object in the database, if update fails this function
     * does nothing
     *
     * @param tweet
     * @throws java.lang.Exception
     */
    public void updateTweet(Tweet tweet) throws Exception {
        try {
            tweetDao.updateTweet(tweet);
        } catch (PersistenceException pe) {
            throw new Exception(pe);
        }
    }

    /**
     * Inserts a Tweet object in the database, if the insert fails this function
     * does nothing
     *
     * @param tweet
     * @throws java.lang.Exception
     */
    public void insertTweet(Tweet tweet) throws Exception {
        try {
            tweetDao.insertTweet(tweet);
        } catch (PersistenceException pe) {
            throw new Exception(pe);
        }
    }

    /**
     * Removes a Tweet object in the database, if the insert fails this function
     * does nothing
     *
     * @param tweet
     * @throws java.lang.Exception
     */
    public void removeTweet(Tweet tweet) throws Exception {
        try {
            tweetDao.removeTweet(tweet);
        } catch (PersistenceException pe) {
            throw new Exception(pe);
        }
    }
}
