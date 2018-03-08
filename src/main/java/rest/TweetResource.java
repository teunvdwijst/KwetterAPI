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
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import service.TweetService;

/**
 *
 * @author Teun
 */
@Path("tweets")
@Stateless
public class TweetResource {

    @Inject
    TweetService tweetService;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Tweet getTweet(@PathParam("id") int id) {
        return tweetService.getTweet(id);
    }

    @GET
    @Path("getbyuser/{limit}/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tweet> getRecentTweetsByUser(@PathParam("limit") int limit, @PathParam("email") String userEmail) {
        return tweetService.getRecentTweetsByUser(limit, userEmail);
    }

    @GET
    @Path("getrecent/{limit}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tweet> getRecentTweets(@PathParam("limit") int limit) {
        return tweetService.getRecentTweets(limit);
    }

    @POST
    @Path("update")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateTweet(Tweet tweet) {
        tweetService.updateTweet(tweet);
    }

    @POST
    @Path("create")
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertTweet(Tweet tweet) {
        tweetService.insertTweet(tweet);
    }

    @POST
    @Path("delete")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteTweet(Tweet tweet) {
        tweetService.deleteTweet(tweet);
    }
}
