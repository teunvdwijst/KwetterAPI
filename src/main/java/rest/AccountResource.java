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
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
public class AccountResource {

    @Inject
    AccountService accountService;

    @GET
    @Path("{limit}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Account> getAllAccounts(@PathParam("limit") int limit) {
        return accountService.getAllAccounts(limit);
    }

    @GET
    @Path("getbyusername/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Account> getAccountByUsername(@PathParam("username") String username) {
        return accountService.getAccountByUsername(username);
    }

    @GET
    @Path("getbyemail/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Account> getAccountByEmail(@PathParam("email") String email) {
        return accountService.getAccountByEmail(email);
    }

    @GET
    @Path("getfollowers/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Account> getAccountFollowers(@PathParam("email") String email) {
        return accountService.getAccountFollowers(email);
    }

    @GET
    @Path("getfollowing/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Account> getAccountFollowing(@PathParam("email") String email) {
        return accountService.getAccountFollowing(email);
    }

    @POST
    @Path("create")
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertAccount(Account user) {
        accountService.insertAccount(user);
    }

    @POST
    @Path("update")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateAccount(Account user) {
        accountService.updateAccount(user);
    }

    @POST
    @Path("delete")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteAccount(Account user) {
        accountService.deleteAccount(user);
    }
}
