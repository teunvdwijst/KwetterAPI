/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.AccountDAO;
import dao.TweetDAO;
import domain.Account;
import domain.Tweet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

/**
 *
 * @author Teun
 */
@Stateless
public class TweetService {

    @Inject
    TweetDAO tweetDao;

    @Inject
    AccountDAO accountDao;

    @Context
    SecurityContext securityContext;

    private static final Logger LOGGER = Logger.getLogger(AccountService.class.getName());

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
    public List<Tweet> getRecentTweetsByUser(int limit, int offset, String username) {
        try {
            return tweetDao.getRecentTweetsByUsername(limit, offset, username);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getRecentTweetsByUser operation; {0}", pe.getMessage());
            return null;
        }
    }

    /**
     * Fetches 'limit' amount of tweets posted with the corresponding 'tag'
     * Tweets are sorted by publish date descending. Returns an empty list if no
     * Tweets were found
     *
     * @param limit
     * @param tag
     * @return List of Tweets
     */
    public List<Tweet> getRecentTweetsByTag(int limit, int offset, String tag) {
        try {
            return tweetDao.getRecentTweetsByTag(limit, offset, tag);
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
    public List<Tweet> getRecentTweets(int limit, int offset) {
        try {
            return tweetDao.getRecentTweets(limit, offset);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getRecentTweets operation; {0}", pe.getMessage());
            return null;
        }
    }

    /**
     * Fetches 'limit' amount of Tweets. Only tweets posted by 'email' or
     * Accounts followed by 'email'. Tweets are sorted by publish date
     * descending. Returns an empty list if no Tweets were found
     *
     * @param limit
     * @param username
     * @return List of Tweets
     */
    public List<Tweet> getTimeline(int limit, int offset, String username) {
        try {
            return tweetDao.getTimeline(limit, offset, username);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getTimeline operation; {0}", pe.getMessage());
            return null;
        }
    }

    /**
     * Updates a Tweet object in the database, if update fails this function
     * does nothing
     *
     * @param tweet
     */
    public Tweet updateTweet(Tweet tweet) {
        try {
            for (Account a : findMentions(tweet.getContent())) {
                tweet.addMention(a);
            }
            return tweetDao.updateTweet(tweet);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing updateTweet operation; {0}", pe.getMessage());
            return new Tweet();
        }
    }

    public Tweet likeTweet(Tweet tweet, String username) {
        try {
            Account a = accountDao.getAccountByUsername(username);
            tweet.addLike(a);
            accountDao.updateAccount(a);
            return updateTweet(tweet);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing likeTweet operation; {0}", pe.getMessage());
            return new Tweet();
        }
    }

    public Tweet unlikeTweet(Tweet tweet, String username) {
        try {
            Account a = accountDao.getAccountByUsername(username);
            tweet.removeLike(a);
            accountDao.updateAccount(a);
            return updateTweet(tweet);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing unlikeTweet operation; {0}", pe.getMessage());
            return new Tweet();
        }
    }

    /**
     * Inserts a Tweet object in the database, if the insert fails this function
     * does nothing
     *
     * @param tweet
     */
    public Tweet insertTweet(Tweet tweet, String username) {
        try {
            for (Account a : findMentions(tweet.getContent())) {
                tweet.addMention(a);
            }
            tweet.setTweetedBy(accountDao.getAccountByUsername(username));
            tweet.setPublished(new Date());
            return tweetDao.insertTweet(tweet);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing insertTweet operation; {0}", pe.getMessage());
            return new Tweet();
        }
    }

    public Tweet insertTweet(Tweet tweet) {
        try {
            for (Account a : findMentions(tweet.getContent())) {
                tweet.addMention(a);
            }
            tweet.setPublished(new Date());
            return tweetDao.insertTweet(tweet);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing insertTweet operation; {0}", pe.getMessage());
            return new Tweet();
        }
    }

    /**
     * Removes a Tweet object in the database, if the insert fails this function
     * does nothing
     *
     * @param tweet
     */
    public void deleteTweet(int id) {
        try {
            Tweet temp = tweetDao.getTweetById(id);
            tweetDao.deleteTweet(temp);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing removeTweet operation; {0}", pe.getMessage());
        }
    }

    private List<Account> findMentions(String message) {
        List<Account> mentions = new ArrayList<>();
        String prefix = " ".concat(message);
        Matcher m = Pattern.compile("(?:\\@)([A-Za-z0-9_]+)").matcher(prefix);

        while (m.find()) {
            Account user = accountDao.getAccountByUsername(m.group(1));
            if (user != null) {
                mentions.add(user);
            }
        }
        return mentions;
    }
}
