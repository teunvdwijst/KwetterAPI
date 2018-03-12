package service;

import domain.Account;
import domain.Tweet;
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
    AccountService accountService;

    @Inject
    TweetService tweetService;

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

        a2.addFollowing(a3);
        a2.addFollowing(a4);
        a2.addFollowing(a5);

        Tweet t1 = new Tweet("TESTING #tags", a1);
        Tweet t2 = new Tweet("mentioning @user2", a1);
        Tweet t3 = new Tweet("TESTING @user33", a2);
        Tweet t4 = new Tweet("TESTING #tags", a3);
        Tweet t5 = new Tweet("TESTING #tags", a4);
        Tweet t6 = new Tweet("TESTING #tags", a3);

        t1.addLike(a8);
        t1.addLike(a3);

        accountService.insertAccount(a1);
        accountService.insertAccount(a2);
        accountService.insertAccount(a3);
        accountService.insertAccount(a4);
        accountService.insertAccount(a5);
        accountService.insertAccount(a6);
        accountService.insertAccount(a7);
        accountService.insertAccount(a8);

        tweetService.insertTweet(t1);
        tweetService.insertTweet(t2);
        tweetService.insertTweet(t3);
        tweetService.insertTweet(t4);
        tweetService.insertTweet(t5);
        tweetService.insertTweet(t6);
    }
}
