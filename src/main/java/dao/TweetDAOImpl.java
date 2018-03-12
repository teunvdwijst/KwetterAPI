/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Account;
import domain.Tweet;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

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
    public Tweet getTweetById(int id) {
        return (Tweet) em.createNamedQuery("Tweet.findById").setParameter("id", id).getSingleResult();
    }

    @Override
    public List<Tweet> getRecentTweetsByEmail(int limit, String userEmail) {
        return em.createNamedQuery("Tweet.findRecentByEmail").setParameter("email", userEmail).setMaxResults(limit).getResultList();
    }

    @Override
    public List<Tweet> getRecentTweets(int limit) {
        return em.createNamedQuery("Tweet.findRecent").setMaxResults(limit).getResultList();
    }

    @Override
    public List<Tweet> getRecentTweetsByTag(int limit, String tag) {
        return em.createNamedQuery("Tweet.findRecentByTag").setParameter("tag", "%" + tag + "%").setMaxResults(limit).getResultList();
    }

    @Override
    public List<Tweet> getTimeline(int limit, String userEmail) throws PersistenceException {
        return em.createNamedQuery("Tweet.findRecentByTag").setParameter("email", userEmail).setMaxResults(limit).getResultList();
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
    public void deleteTweet(Tweet tweet) {
        Tweet temp = em.find(Tweet.class, tweet.getId());
        for (Account a : temp.getLikedBy()) {
            tweet.removeLike(a);
        }
        for (Account a : temp.getMentions()) {
            tweet.removeMention(a);
        }
        em.remove(temp);
    }
}
