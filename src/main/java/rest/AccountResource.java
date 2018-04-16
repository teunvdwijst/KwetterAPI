/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import domain.Account;
import dto.AccountDTO;
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
import util.DomainToDto;

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
    public Response login(AccountDTO account) {
        if (account != null && !account.getUsername().isEmpty() && !account.getPassword().isEmpty()) {
            boolean result = accountService.validateCredentials(account.getUsername(), account.getPassword());

            if (result) {
                String webToken = accountService.getWebToken(account.getUsername());
                return Response.ok().header(HttpHeaders.AUTHORIZATION, "Bearer " + webToken).header("Access-Control-Expose-Headers", "Authorization").build();
            }
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }

    @GET
    @Path("{limit}")
    public Response getAllAccounts(@PathParam("limit") int limit) {
        List<AccountDTO> dtos = DomainToDto.accountsToDtos(accountService.getAllAccounts(limit));
        return Response.ok(dtos).build();
    }

    @GET
    @Path("username/{username}")
    public Response getAccountByUsername(@PathParam("username") String username) {
        AccountDTO dto = DomainToDto.accountToDto(accountService.getAccountByUsername(username));
        return Response.ok(dto).build();
    }

    @GET
    @Path("email/{email}")
    public Response getAccountByEmail(@PathParam("email") String email) {
        AccountDTO dto = DomainToDto.accountToDto(accountService.getAccountByEmail(email));
        return Response.ok(dto).build();
    }

    @GET
    @Path("followers/{username}")
    public Response getAccountFollowers(@PathParam("username") String username) {
        List<AccountDTO> dtos = DomainToDto.accountsToDtos(accountService.getAccountFollowers(username));
        return Response.ok(dtos).build();
    }

    @GET
    @Path("following/{username}")
    public Response getAccountFollowing(@PathParam("username") String username) {
        List<AccountDTO> dtos = DomainToDto.accountsToDtos(accountService.getAccountFollowing(username));
        return Response.ok(dtos).build();
    }

    @POST
    @JWToken
    @Path("follow/{username}")
    public void addAccountFollowing(@PathParam("username") String username) {
        accountService.addAccountFollowing(securityContext.getUserPrincipal().getName(), username);
    }

    @POST
    @JWToken
    @Path("unfollow/{username}")
    public void removeAccountFollowing(@PathParam("username") String username) {
        accountService.removeAccountFollowing(securityContext.getUserPrincipal().getName(), username);
    }

    @POST
    public Response insertAccount(AccountDTO user) {
        Account newAccount = new Account(user.getEmail(), user.getPassword(), user.getUsername(), null, null, null, null);
        AccountDTO dto = DomainToDto.accountToDto(accountService.insertAccount(newAccount));
        return Response.ok(dto).build();
    }

    @PUT
    @JWToken
    public Response updateAccount(AccountDTO user) {
        Account updatedAccount = new Account(user.getEmail(), user.getPassword(), user.getUsername(), user.getLocation(), user.getBio(), user.getWebsite(), user.getAvatarPath());
        AccountDTO dto = DomainToDto.accountToDto(accountService.updateAccount(updatedAccount));
        return Response.ok(dto).build();
    }

    @DELETE
    @JWToken
    @Path("{id}")
    public void deleteAccount(@PathParam("id") String id) {
        accountService.deleteAccount(id);
    }
}
