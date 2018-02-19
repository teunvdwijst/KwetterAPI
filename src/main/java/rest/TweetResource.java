/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;
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
}
