/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.AccountDAO;
import domain.Account;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Teun
 */
@Ignore
public class AccountServiceTest {
    @Mock
    private AccountDAO accountDao;
    
    @InjectMocks
    private AccountService accountService;
    
    public AccountServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAllAccounts method, of class AccountService.
     */
    @Test
    public void testGetAllAccounts() throws Exception {
        System.out.println("getAllAccounts");
        accountService.getAllAccounts(999);
        
        verify(accountDao, times(1)).getAllAccounts(999);
    }

    /**
     * Test of getAccountByEmail method, of class AccountService.
     */
    @Test
    public void testGetAccountByEmail() throws Exception {
        System.out.println("getAccountByEmail");
        accountService.getAccountByEmail("email");
        
        verify(accountDao, times(1)).getAccountByEmail("email");
    }

    /**
     * Test of getAccountByUsername method, of class AccountService.
     */
    @Test
    public void testGetAccountByUsername() throws Exception {
        System.out.println("getAccountByUsername");
        accountService.getAccountByUsername("email");
        
        verify(accountDao, times(1)).getAccountByUsername("email");
    }

    /**
     * Test of updateAccount method, of class AccountService.
     */
    @Test
    public void testUpdateAccount() throws Exception {
        System.out.println("updateAccount");
        Account user = new Account("user", "pass");
        accountService.updateAccount(user);
        
        verify(accountDao, times(1)).updateAccount(user);
    }

    /**
     * Test of insertAccount method, of class AccountService.
     */
    @Test
    public void testInsertAccount() throws Exception {
        System.out.println("insertAccount");
        Account user = new Account("user", "pass");
        accountService.insertAccount(user);
        
        verify(accountDao, times(1)).insertAccount(user);
    }

    /**
     * Test of deleteAccount method, of class AccountService.
     */
    @Test
    public void testDeleteAccount() throws Exception {
        System.out.println("deleteAccount");
        Account user = new Account("user", "pass");
        accountService.deleteAccount(user);
        
        verify(accountDao, times(1)).deleteAccount(user);
    }   
}
