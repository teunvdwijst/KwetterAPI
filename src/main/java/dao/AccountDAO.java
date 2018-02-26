/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Account;
import java.util.List;

/**
 *
 * @author Teun
 */
public interface AccountDAO {

    public List<Account> allAccounts();
}
