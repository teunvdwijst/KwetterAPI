/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Teun
 */
@Entity
@NamedQuery(name = "Account.allAccounts", query = "SELECT a FROM Account a")
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String userName;
    @Column(unique = true)
    private String email;
    @Enumerated(EnumType.ORDINAL)
    private Role userRole;
    private String encryptedPassword;
    private String location;
    private String bio;
    private String website;
    private String avatarPath;
    @OneToMany
    private final List<Account> following = new ArrayList<>();
    @OneToMany
    private final List<Tweet> tweets = new ArrayList<>();

    // <editor-fold desc="Getters and Setters" defaultstate="collapsed">
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    public Role getUserRole() {
        return userRole;
    }

    public void setUserRole(Role userRole) {
        this.userRole = userRole;
    }

    public List<Account> getFollowing() {
        return Collections.unmodifiableList(following);
    }

    public List<Tweet> getTweets() {
        return Collections.unmodifiableList(tweets);
    }
    // </editor-fold>

    public Account() {

    }

    public Account(String email, String encryptedPassword) {
        this.email = email;
        this.encryptedPassword = encryptedPassword;
    }

    public Account(String email, String encryptedPassword, String userName, String location, String bio, String website, String avatarPath, Role userRole) {
        this(email, encryptedPassword);
        this.userName = userName;
        this.location = location;
        this.bio = bio;
        this.website = website;
        this.avatarPath = avatarPath;
        this.userRole = userRole;
    }

    /**
     * Adds an Account to the list of following accounts
     *
     * @param a Account
     */
    public void addFollowing(Account a) {
        if (!following.contains(a)) {
            following.add(a);
        }
    }

    /**
     * Removes an Account from the list of following accounts
     *
     * @param a
     */
    public void removeFollowing(Account a) {
        if (following.contains(a)) {
            following.remove(a);
        }
    }

    /**
     * Adds a Tweet to the list of Tweets owned by this account
     *
     * @param message String
     */
    public void addTweet(String message) {
        Tweet t = new Tweet(message, this);
        tweets.add(t);
    }

    /**
     * Removes a Tweet from the list of tweets owned by this account
     *
     * @param id
     */
    public void removeTweet(int id) {
        for (Tweet t : tweets) {
            if (t.getId() == id) {
                tweets.remove(t);
            }
        }
    }

    public Role promote() {
        switch (userRole) {
            case USER:
                userRole = Role.MODERATOR;
                break;
            case MODERATOR:
                userRole = Role.ADMIN;
                break;
            case ADMIN:
                break;
            default:
                break;
        }
        return userRole;
    }

    public Role demote() {
        switch (userRole) {
            case MODERATOR:
                userRole = Role.USER;
                break;
            case ADMIN:
                userRole = Role.MODERATOR;
                break;
            case USER:
                break;
            default:
                break;
        }
        return userRole;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Account)) {
            return false;
        }
        Account otherUser = (Account) obj;
        if (this.email == null || otherUser.email == null) {
            return false;
        }
        return this.email.equals(otherUser.email);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.userName);
        hash = 53 * hash + Objects.hashCode(this.email);
        hash = 53 * hash + Objects.hashCode(this.userRole);
        hash = 53 * hash + Objects.hashCode(this.encryptedPassword);
        hash = 53 * hash + Objects.hashCode(this.location);
        hash = 53 * hash + Objects.hashCode(this.bio);
        hash = 53 * hash + Objects.hashCode(this.website);
        hash = 53 * hash + Objects.hashCode(this.avatarPath);
        return hash;
    }
}
