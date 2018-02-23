/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.AccountDAOImpl;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Teun
 */
@Stateless
public class AccountService {

    @Inject
    AccountDAOImpl accountDao;

}
