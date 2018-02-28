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

    Tweet getTweet(int id);

    List<Tweet> getRecentTweetsByUser(int limit, String userEmail);

    List<Tweet> getRecentTweets(int limit);

    void update(Tweet tweet);

    void insert(Tweet tweet);

    void remove(Tweet tweet);
}
