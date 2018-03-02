package service;

import dao.AccountDAO;
import domain.Account;
import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.ejb.Singleton;
import javax.inject.Inject;

/**
 *
 * @author Teun
 */
@Startup
@Singleton
public class Init {

    @Inject
    AccountDAO accountDao;

    @PostConstruct
    public void init() {
        Account a1 = new Account("testings@gmail.com", "passw1", "user1", "Eindhoven", "my personal life sux", "reddit.com", "c://avatar.jpg");
        Account a2 = new Account("user2@gmail.com", "herrow", "user2", "Eindhoven", "my personal life sux", "reddit.com", "c://avatar.jpg");
        Account a3 = new Account("user3@gmail.com", "wacist", "user3", "Eindhoven", "my personal life sux", "reddit.com", "c://avatar.jpg");
        Account a4 = new Account("user4@gmail.com", "rorrypop", "user4", "Eindhoven", "my personal life sux", "reddit.com", "c://avatar.jpg");
        Account a5 = new Account("user5@gmail.com", "asdf", "user5", "Eindhoven", "my personal life sux", "reddit.com", "c://avatar.jpg");
        Account a6 = new Account("user6@gmail.com", "zxcv", "user6", "Eindhoven", "my personal life sux", "reddit.com", "c://avatar.jpg");
        Account a7 = new Account("user7@gmail.com", "rtyu", "user7", "Eindhoven", "my personal life sux", "reddit.com", "c://avatar.jpg");
        Account a8 = new Account("user8@gmail.com", "fdhgfkk", "user8", "Eindhoven", "my personal life sux", "reddit.com", "c://avatar.jpg");

        a1.addTweet("Sup mah dudes.");
        a1.addTweet("yoyo");
        a2.addTweet("Allo Allo #tweeting");
        a2.addTweet("#testing yoyo");
        a1.getTweets().get(0).addLike(a3);
        a1.addFollowing(a3);
        
        accountDao.insertAccount(a1);
        accountDao.insertAccount(a2);
        accountDao.insertAccount(a3);
        accountDao.insertAccount(a4);
        accountDao.insertAccount(a5);
        accountDao.insertAccount(a6);
        accountDao.insertAccount(a7);
        accountDao.insertAccount(a8);
    }
}
