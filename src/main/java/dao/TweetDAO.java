/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Account;
import domain.Tweet;
import java.util.List;

/**
 *
 * @author Teun
 */
public interface TweetDAO {

    Tweet getTweet(int id);

    List<Tweet> getRecentTweets(int limit, Account user);

    Tweet create(String content, Account user);

    Tweet create(String content, Account user, List<String> tags);

    boolean remove(Tweet tweet);
}
