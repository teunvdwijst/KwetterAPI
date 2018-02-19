/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.UserDAO;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class CoffeeService {

    @Inject
    UserDAO userDao;

}
