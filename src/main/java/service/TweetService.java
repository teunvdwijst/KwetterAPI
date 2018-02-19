/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.TweetDAO;
import domain.Tweet;
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

    public List<Tweet> allTweets() {
        return tweetDao.allTweets();
    }
}
