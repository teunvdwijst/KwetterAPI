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
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import service.TweetService;

/**
 *
 * @author Teun
 */
@Stateless
@Path("tweets")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TweetResource {

    @Inject
    TweetService tweetService;
    
    @Context
    SecurityContext securityContext;

    @GET
    @Path("{id}")
    public Tweet getTweet(@PathParam("id") int id) {
        return tweetService.getTweet(id);
    }

    @GET
    @Path("user/{limit}/{username}")
    public List<Tweet> getRecentTweetsByUser(@PathParam("limit") int limit, @PathParam("username") String username) {
        return tweetService.getRecentTweetsByUser(limit, username);
    }

    @GET
    @Path("timeline/{limit}/{username}")
    public List<Tweet> getUserTimeline(@PathParam("username") int limit, @PathParam("username") String username) {
        return tweetService.getTimeline(limit, username);
    }

    @GET
    @Path("recent/{limit}")
    public List<Tweet> getRecentTweets(@PathParam("limit") int limit) {
        return tweetService.getRecentTweets(limit);
    }

    @GET
    @Path("tag/{limit}/{tag}")
    public List<Tweet> getRecentTweetsByTag(@PathParam("limit") int limit, @PathParam("tag") String tag) {
        return tweetService.getRecentTweetsByTag(limit, tag);
    }

    @PUT
    @JWToken
    public void updateTweet(Tweet tweet) {
        tweetService.updateTweet(tweet);
    }

    @POST
    @JWToken
    public void insertTweet(Tweet tweet) {
        tweetService.insertTweet(tweet);
    }

    @DELETE
    @JWToken
    @Path("{id}")
    public void deleteTweet(@PathParam("id") int id) {
        tweetService.deleteTweet(id);
    }
}
