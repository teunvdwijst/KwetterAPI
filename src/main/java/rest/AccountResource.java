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
    @Path("username/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Account> getAccountByUsername(@PathParam("username") String username) {
        return accountService.getAccountByUsername(username);
    }

    @GET
    @Path("email/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Account> getAccountByEmail(@PathParam("email") String email) {
        return accountService.getAccountByEmail(email);
    }

    @GET
    @Path("following/{email}")
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

    @PUT
    @Path("update")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateAccount(Account user) {
        accountService.updateAccount(user);
    }

    @DELETE
    @Path("delete")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteAccount(Account user) {
        accountService.deleteAccount(user);
    }
}
