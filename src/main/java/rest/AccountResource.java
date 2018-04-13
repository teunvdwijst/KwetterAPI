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
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import service.AccountService;

/**
 *
 * @author Teun
 */
@Stateless
@Path("accounts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AccountResource {

    @Inject
    AccountService accountService;

    @Context
    SecurityContext securityContext;

    @POST
    @Path("login")
    public Response login(Account account) {
        boolean result = accountService.validateCredentials(account.getUsername(), account.getPassword());

        if (result) {
            String webToken = accountService.getWebToken(account.getUsername());
            return Response.ok().header(HttpHeaders.AUTHORIZATION, webToken).header("Access-Control-Expose-Headers", "Authorization").build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }

    @GET
    @Path("{limit}")
    public List<Account> getAllAccounts(@PathParam("limit") int limit) {
        return accountService.getAllAccounts(limit);
    }

    @GET
    @Path("username/{username}")
    public Account getAccountByUsername(@PathParam("username") String username) {
        return accountService.getAccountByUsername(username);
    }

    @GET
    @Path("email/{email}")
    public Account getAccountByEmail(@PathParam("email") String email) {
        return accountService.getAccountByEmail(email);
    }

    @GET
    @Path("followers/{username}")
    public List<Account> getAccountFollowers(@PathParam("username") String username) {
        return accountService.getAccountFollowers(username);
    }

    @GET
    @Path("following/{username}")
    public List<Account> getAccountFollowing(@PathParam("username") String username) {
        return accountService.getAccountFollowing(username);
    }

    @POST
    @JWToken
    @Path("followers/{username}")
    public void addAccountFollowing(@PathParam("username") String username) {
        accountService.addAccountFollowing(securityContext.getUserPrincipal().getName(), username);
    }

    @DELETE
    @JWToken
    @Path("following/{username}")
    public void removeAccountFollowing(@PathParam("username") String username) {
        accountService.removeAccountFollowing(securityContext.getUserPrincipal().getName(), username);
    }

    @POST
    public void insertAccount(Account user) {
        accountService.insertAccount(user);
    }

    @PUT
    @JWToken
    public void updateAccount(Account user) {
        accountService.updateAccount(user);
    }

    @DELETE
    @JWToken
    @Path("{id}")
    public void deleteAccount(@PathParam("id") String id) {
        accountService.deleteAccount(id);
    }
}
