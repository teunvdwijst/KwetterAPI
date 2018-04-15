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
import javax.ws.rs.DefaultValue;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
    @Path("username/{username}")
    public List<Tweet> getRecentTweetsByUser(
            @DefaultValue("0") @QueryParam("offset") int offset,
            @DefaultValue("20") @QueryParam("limit") int limit,
            @PathParam("username") String username) {
        return tweetService.getRecentTweetsByUser(limit, offset, username);
    }

    @GET
    @JWToken
    @Path("timeline")
    public List<Tweet> getUserTimeline(
            @DefaultValue("0") @QueryParam("offset") int offset,
            @DefaultValue("20") @QueryParam("limit") int limit) {
        String username = securityContext.getUserPrincipal().getName();
        return tweetService.getTimeline(limit, offset, username);
    }

    @GET
    @Path("recent")
    public List<Tweet> getRecentTweets(
            @DefaultValue("0") @QueryParam("offset") int offset,
            @DefaultValue("20") @QueryParam("limit") int limit) {
        return tweetService.getRecentTweets(limit, offset);
    }

    @GET
    @Path("tag/{tag}")
    public List<Tweet> getRecentTweetsByTag(
            @DefaultValue("0") @QueryParam("offset") int offset,
            @DefaultValue("20") @QueryParam("limit") int limit,
            @PathParam("tag") String tag) {
        return tweetService.getRecentTweetsByTag(limit, offset, tag);
    }

    @POST
    @JWToken
    @Path("unlike")
    public Tweet unlikeTweet(Tweet tweet) {
        return tweetService.unlikeTweet(tweet, securityContext.getUserPrincipal().getName());
    }

    @POST
    @JWToken
    @Path("like")
    public Tweet likeTweet(Tweet tweet) {
        return tweetService.likeTweet(tweet, securityContext.getUserPrincipal().getName());
    }

    @PUT
    @JWToken
    public Tweet updateTweet(Tweet tweet) {
        return tweetService.updateTweet(tweet);
    }

    @POST
    @JWToken
    public Tweet insertTweet(Tweet tweet) {
        return tweetService.insertTweet(tweet, securityContext.getUserPrincipal().getName());
    }

    @DELETE
    @JWToken
    @Path("{id}")
    public void deleteTweet(@PathParam("id") int id) {
        tweetService.deleteTweet(id);
    }
}
