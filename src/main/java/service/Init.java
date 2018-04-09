package service;

import domain.Account;
import domain.Tweet;
import domain.UserGroup;
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

    @Inject
    UserGroupService groupService;

    @PostConstruct
    public void init() {
        UserGroup user = new UserGroup("USER");
        UserGroup admins = new UserGroup("ADMIN");
        UserGroup mods = new UserGroup("MODERATOR");

        Account a1 = new Account("francisco.richardson83@gmail.com", "gymnastic", "franciscorichardson", "2943 FS Eindhoven", "I Like rowing and fancy dinners", "reddit.com", "c://avatar.jpg", user);
        Account a2 = new Account("marsha_32@gmail.com", "maryland", "marshajackson", "6148 ST Eindhoven", "Find me on Tinder ;)", "tinder.com", "c://avatar.jpg", user);
        Account a3 = new Account("bernicenichols66@gmail.com", "plastics45", "bernicenichols", "4074 TL Eindhoven", "I <3 photoshopping and good coffee in the afternoon", "pinterest.com", "c://avatar.jpg", user);
        Account a4 = new Account("carr1990@gmail.com", "photo12", "scottcarr", "6810 EL Eindhoven", "DM me for donger", "", "c://avatar.jpg", user);
        Account a5 = new Account("rolandlowe@gmail.com", "asdf", "rolandlowe", "2012 CS Eindhoven", "", "reddit.com", "c://avatar.jpg", user);
        Account a6 = new Account("mariestevens.70@gmail.com", "biggles", "mariestevens", "6417 EP Veldhoven", "I like turtles", "", "c://avatar.jpg", user);
        Account a7 = new Account("breyes@gmail.com", "test", "mod", "Mystery island", "my personal life sux", "reddit.com", "c://avatar.jpg", user);
        Account a8 = new Account("teunvdwijst@gmail.com", "test", "teunvdwijst", "Venhorst", "Als dat jasje van je beschadigd is...", "Fontys.nl", "c://avatar.jpg", user);

        a2.addFollowing(a3);
        a2.addFollowing(a4);
        a2.addFollowing(a5);
        a5.addFollowing(a2);
        a6.addFollowing(a2);
        a4.addFollowing(a8);
        a5.addFollowing(a8);
        a8.addFollowing(a4);
        a8.addFollowing(a5);
        
        a8.addUserGroup(admins);
        a8.addUserGroup(mods);
        a7.addUserGroup(mods);

        Tweet t1 = new Tweet("TESTING #tags", a1);
        Tweet t2 = new Tweet("mentioning @franciscorichardson", a1);
        Tweet t3 = new Tweet("TESTING @teunvdwijst", a2);
        Tweet t4 = new Tweet("TESTING #tags", a3);
        Tweet t5 = new Tweet("I ate spagetti today", a4);
        Tweet t6 = new Tweet("LUL https://dumpert.nl", a3);
        Tweet t7 = new Tweet("TESTING #tags", a3);
        Tweet t8 = new Tweet("Deploying on Payara Server", a4);
        Tweet t9 = new Tweet("BUILD SUCCESS", a4);
        Tweet t10 = new Tweet("Webapp assembled in [484 msecs]", a5);
        Tweet t11 = new Tweet("Processing war project", a5);
        Tweet t12 = new Tweet("Packaging webapp", a6);
        Tweet t13 = new Tweet("Analyzed bundle 'KwetterS62' with 16 classes", a6);
        Tweet t14 = new Tweet("Tests run: 6, Failures: 0, Errors: 0, Skipped: 6", a8);
        Tweet t15 = new Tweet("T E S T S", a8);

        t1.addLike(a8);
        t1.addLike(a3);

        groupService.insertUserGroup(user);
        groupService.insertUserGroup(admins);
        groupService.insertUserGroup(mods);

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
        tweetService.insertTweet(t7);
        tweetService.insertTweet(t8);
        tweetService.insertTweet(t9);
        tweetService.insertTweet(t10);
        tweetService.insertTweet(t11);
        tweetService.insertTweet(t12);
        tweetService.insertTweet(t13);
        tweetService.insertTweet(t14);
        tweetService.insertTweet(t15);
    }
}
