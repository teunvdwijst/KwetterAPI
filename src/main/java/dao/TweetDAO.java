/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Account;
import domain.Tweet;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author Teun
 */
public interface TweetDAO {

    Tweet getTweetById(int id) throws PersistenceException;

    List<Tweet> getRecentTweetsByUsername(int limit, int offset, String username) throws PersistenceException;

    List<Tweet> getRecentTweets(int limit, int offset) throws PersistenceException;

    List<Tweet> getRecentTweetsByTag(int limit, int offset, String tag) throws PersistenceException;

    List<Tweet> getTimeline(int limit, int offset, String username) throws PersistenceException;

    void updateTweet(Tweet tweet) throws PersistenceException;

    void insertTweet(Tweet tweet) throws PersistenceException;

    void deleteTweet(Tweet tweet) throws PersistenceException;
}
