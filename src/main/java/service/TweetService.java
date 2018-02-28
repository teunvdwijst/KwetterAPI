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
     */
    public Tweet getTweet(int id) {
        try {
            return tweetDao.getTweet(id);
        } catch (Exception ex) {
            //handle exception
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
    public List<Tweet> getRecentTweetsByUser(int limit, String userEmail) {
        try {
            return tweetDao.getRecentTweetsByUser(limit, userEmail);
        } catch (Exception ex) {
            //handle exception
            return new ArrayList<>();
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
        } catch (Exception ex) {
            //handle exception
            return new ArrayList<>();
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
            tweetDao.update(tweet);
        } catch (Exception ex) {
            //handle exception
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
            tweetDao.insert(tweet);
        } catch (Exception ex) {
            //handle exception
        }
    }

    /**
     * Removes a Tweet object in the database, if the insert fails this function
     * does nothing
     *
     * @param tweet
     */
    public void removeTweet(Tweet tweet) {
        try {
            tweetDao.remove(tweet);
        } catch (Exception ex) {
            //handle exception
        }
    }
}
