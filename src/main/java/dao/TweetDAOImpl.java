/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Tweet;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Teun
 */
@Stateless
public class TweetDAOImpl implements TweetDAO {

    @PersistenceContext(name = "KwetterS62PU")
    EntityManager em;

    public TweetDAOImpl() {
    }

    @Override
    public List<Tweet> getTweetById(int id) {
        return em.createNamedQuery("Tweet.findById").setParameter("id", id).getResultList();
    }

    @Override
    public List<Tweet> getRecentTweetsByEmail(int limit, String userEmail) {
        return em.createNamedQuery("Tweet.findRecentByEmail").setParameter("email", userEmail).setMaxResults(limit).getResultList();
    }

    @Override
    public void updateTweet(Tweet tweet) {
        em.merge(tweet);
    }

    @Override
    public void insertTweet(Tweet tweet) {
        em.persist(tweet);
    }

    @Override
    public void removeTweet(Tweet tweet) {
        em.remove(tweet);
    }

    @Override
    public List<Tweet> getRecentTweets(int limit) {
        return em.createNamedQuery("Tweet.findRecent").setMaxResults(limit).getResultList();
    }

    @Override
    public List<Tweet> getRecentTweetsByTag(int limit, String tag) {
        return em.createNamedQuery("Tweet.findRecentByTag").setParameter("tag", tag).setMaxResults(limit).getResultList();
    }

}
