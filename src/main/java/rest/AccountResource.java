/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;
import service.AccountService;

/**
 *
 * @author Teun
 */
@Path("account")
@Stateless
public class AccountResource {

    @Inject
    AccountService accountService;
}
