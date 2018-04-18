/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import domain.Account;
import domain.Tweet;
import dto.TweetDTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import service.AccountService;
import service.TweetService;
import util.DomainToDto;

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

    @Inject
    AccountService accountService;

    @Context
    SecurityContext securityContext;

    @GET
    @Path("{id}")
    public Response getTweet(@PathParam("id") int id) {
        TweetDTO dto = DomainToDto.tweetToDto(tweetService.getTweet(id));
        return Response.ok(dto).build();
    }

    @GET
    @Path("username/{username}")
    public Response getRecentTweetsByUser(
            @DefaultValue("0") @QueryParam("offset") int offset,
            @DefaultValue("20") @QueryParam("limit") int limit,
            @PathParam("username") String username) {
        List<TweetDTO> dtos = DomainToDto.tweetsToDtos(tweetService.getRecentTweetsByUser(limit, offset, username));
        return Response.ok(dtos).build();
    }

    @GET
    @JWToken
    @Path("timeline")
    public Response getUserTimeline(
            @DefaultValue("0") @QueryParam("offset") int offset,
            @DefaultValue("20") @QueryParam("limit") int limit) {
        String username = securityContext.getUserPrincipal().getName();
        List<TweetDTO> dtos = DomainToDto.tweetsToDtos(tweetService.getTimeline(limit, offset, username));
        return Response.ok(dtos).build();
    }

    @GET
    @Path("recent")
    public Response getRecentTweets(
            @DefaultValue("0") @QueryParam("offset") int offset,
            @DefaultValue("20") @QueryParam("limit") int limit) {
        List<TweetDTO> dtos = DomainToDto.tweetsToDtos(tweetService.getRecentTweets(limit, offset));
        return Response.ok(dtos).build();
    }

    @GET
    @Path("tag/{tag}")
    public Response getRecentTweetsByTag(
            @DefaultValue("0") @QueryParam("offset") int offset,
            @DefaultValue("20") @QueryParam("limit") int limit,
            @PathParam("tag") String tag) {
        List<TweetDTO> dtos = DomainToDto.tweetsToDtos(tweetService.getRecentTweetsByTag(limit, offset, tag));
        return Response.ok(dtos).build();
    }

    @POST
    @JWToken
    @Path("unlike")
    public Response unlikeTweet(TweetDTO tweet) {
        TweetDTO dto = DomainToDto.tweetToDto(tweetService.unlikeTweet(tweet, securityContext.getUserPrincipal().getName()));
        return Response.ok(dto).build();
    }

    @POST
    @JWToken
    @Path("like")
    public Response likeTweet(TweetDTO tweet) {
        TweetDTO dto = DomainToDto.tweetToDto(tweetService.likeTweet(tweet, securityContext.getUserPrincipal().getName()));
        return Response.ok(dto).build();
    }

    @POST
    @JWToken
    public Response insertTweet(TweetDTO tweet) {
        String username = securityContext.getUserPrincipal().getName();
        Account account = accountService.getAccountByUsername(username);

        if (account == null || tweet == null || tweet.getContent() == null || tweet.getContent().isEmpty()) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

        Tweet temp = account.addTweet(tweet.getContent());
        Tweet persistedTweet = tweetService.insertTweet(temp);
        TweetDTO persistedTweetDto = DomainToDto.tweetToDto(persistedTweet);
        return Response.ok(persistedTweetDto).build();
    }
}
