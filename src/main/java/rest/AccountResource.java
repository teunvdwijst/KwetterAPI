/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import domain.Account;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import service.AccountService;

/**
 *
 * @author Teun
 */
@Stateless
@Path("accounts")
public class AccountResource {

    @Inject
    AccountService accountService;

    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response login(@FormParam("username") String username, @FormParam("password") String password) {
        boolean result = accountService.validateCredentials(username, password);

        if (result) {
            String webToken = accountService.getWebToken(username);
            return Response.ok().header(HttpHeaders.AUTHORIZATION, "Bearer " + webToken).build();
        }

        return Response.status(Response.Status.UNAUTHORIZED).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{limit}")
    public List<Account> getAllAccounts(@PathParam("limit") int limit) {
        return accountService.getAllAccounts(limit);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("username/{username}")
    public Account getAccountByUsername(@PathParam("username") String username) {
        return accountService.getAccountByUsername(username);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("email/{email}")
    public Account getAccountByEmail(@PathParam("email") String email) {
        return accountService.getAccountByEmail(email);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("followers/{email}")
    public List<Account> getAccountFollowers(@PathParam("email") String email) {
        return accountService.getAccountFollowers(email);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("following/{email}")
    public List<Account> getAccountFollowing(@PathParam("email") String email) {
        return accountService.getAccountFollowing(email);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertAccount(Account user) {
        accountService.insertAccount(user);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateAccount(Account user) {
        accountService.updateAccount(user);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public void deleteAccount(@PathParam("id") String id) {
        accountService.deleteAccount(id);
    }
}
