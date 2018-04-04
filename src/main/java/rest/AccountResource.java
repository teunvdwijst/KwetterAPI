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
import javax.ws.rs.core.MediaType;
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
    @Path("followers/{email}")
    public List<Account> getAccountFollowers(@PathParam("email") String email) {
        return accountService.getAccountFollowers(email);
    }

    @GET
    @Path("following/{email}")
    public List<Account> getAccountFollowing(@PathParam("email") String email) {
        return accountService.getAccountFollowing(email);
    }

    @POST
    public void insertAccount(Account user) {
        accountService.insertAccount(user);
    }

    @PUT
    public void updateAccount(Account user) {
        accountService.updateAccount(user);
    }

    @DELETE
    @Path("{id}")
    public void deleteAccount(@PathParam("id") String id) {
        accountService.deleteAccount(id);
    }
}
