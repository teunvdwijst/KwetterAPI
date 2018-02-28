/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Tweet;
import java.util.List;

/**
 *
 * @author Teun
 */
public interface TweetDAO {

    List<Tweet> getTweetById(int id);

    List<Tweet> getRecentTweetsByEmail(int limit, String userEmail);

    List<Tweet> getRecentTweets(int limit);
    
    List<Tweet> getRecentTweetsByTag(int limit, String tag);

    void updateTweet(Tweet tweet);

    void insertTweet(Tweet tweet);

    void removeTweet(Tweet tweet);
}
