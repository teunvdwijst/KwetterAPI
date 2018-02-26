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

    @PersistenceContext
    EntityManager em;

    public TweetDAOImpl() {
    }

    @Override
    public Tweet getTweet(int id) {
        return em.find(Tweet.class, id);
    }

    @Override
    public List<Tweet> getRecentTweetsByUser(int limit, String userEmail) {
        return em.createNamedQuery("Select t from Tweet t where where tweetedby_id = (select id from account where email = :email)) order by published desc limit :limit", Tweet.class)
                .setParameter("email", userEmail)
                .setParameter("limit", limit)
                .getResultList();
    }

    @Override
    public void update(Tweet tweet) {
        em.merge(tweet);
    }

    @Override
    public void insert(Tweet tweet) {
        em.persist(tweet);
    }

    @Override
    public void remove(Tweet tweet) {
        em.remove(tweet);
    }

    @Override
    public List<Tweet> getRecentTweets(int limit) {
        return em.createNamedQuery("Select t from Tweet t order by published desc limit :limit")
                .setParameter("limit", limit)
                .getResultList();
    }

}
