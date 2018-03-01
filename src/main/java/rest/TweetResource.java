/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import domain.Tweet;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import service.TweetService;

/**
 *
 * @author Teun
 */
@Path("tweet")
@Stateless
public class TweetResource {

    @Inject
    TweetService tweetService;

    @GET
    @Path("gettweet/{id}")
    public Tweet getTweet(@PathParam("id") int id) {
        return tweetService.getTweet(id);
    }

    @GET
    @Path("gettweetsbyuser/{limit}/{email}")
    public List<Tweet> getRecentTweetsByUser(@PathParam("limit") int limit, @PathParam("email") String userEmail) {
        return tweetService.getRecentTweetsByUser(limit, userEmail);
    }

    @GET
    @Path("getrecenttweets/{limit}")
    public List<Tweet> getRecentTweets(@PathParam("limit") int limit) {
        return tweetService.getRecentTweets(limit);
    }

    @POST
    public void updateTweet(Tweet tweet) {
        tweetService.updateTweet(tweet);
    }

    @POST
    public void insertTweet(Tweet tweet) {
        tweetService.insertTweet(tweet);
    }

    @POST
    public void removeTweet(Tweet tweet) {
        tweetService.removeTweet(tweet);
    }
}
