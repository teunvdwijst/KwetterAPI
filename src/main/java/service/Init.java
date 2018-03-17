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
        Account a1 = new Account("francisco.richardson83@gmail.com", "gymnastic", "franciscorichardson", "2943 FS Eindhoven", "I Like rowing and fancy dinners", "reddit.com", "c://avatar.jpg");
        Account a2 = new Account("marsha_32@gmail.com", "maryland", "marshajackson", "6148 ST Eindhoven", "Find me on Tinder ;)", "tinder.com", "c://avatar.jpg");
        Account a3 = new Account("bernicenichols66@gmail.com", "plastics45", "bernicenichols", "4074 TL Eindhoven", "I <3 photoshopping and good coffee in the afternoon", "pinterest.com", "c://avatar.jpg");
        Account a4 = new Account("carr1990@gmail.com", "photo12", "scottcarr", "6810 EL Eindhoven", "DM me for donger", "", "c://avatar.jpg");
        Account a5 = new Account("rolandlowe@gmail.com", "asdf", "rolandlowe", "2012 CS Eindhoven", "", "reddit.com", "c://avatar.jpg");
        Account a6 = new Account("mariestevens.70@gmail.com", "biggles", "mariestevens", "6417 EP Veldhoven", "I like turtles", "", "c://avatar.jpg");
        Account a7 = new Account("breyes@gmail.com", "icecream", "brettreyes", "Mystery island", "my personal life sux", "reddit.com", "c://avatar.jpg");
        Account a8 = new Account("teunvdwijst@gmail.com", "skrrrrrt", "teunvdwijst", "Venhorst", "Als dat jasje van je beschadigd is...", "Fontys.nl", "c://avatar.jpg");

        a2.addFollowing(a3);
        a2.addFollowing(a4);
        a2.addFollowing(a5);
        a5.addFollowing(a2);
        a6.addFollowing(a2);

        Tweet t1 = new Tweet("TESTING #tags", a1);
        Tweet t2 = new Tweet("mentioning @franciscorichardson", a1);
        Tweet t3 = new Tweet("TESTING @teunvdwijst", a2);
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
