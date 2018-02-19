/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;

/**
 *
 * @author Teun
 */
@Entity
@NamedQuery(name = "Tweet.allTweets", query = "SELECT t FROM Tweet t")
public class Tweet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String message;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date published;
    private List<String> tags;
    private List<Account> likedBy = new ArrayList<>();

    // <editor-fold desc="Getters and Setters" defaultstate="collapsed">
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getPublished() {
        return published;
    }

    public void setPublished(Date published) {
        this.published = published;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
    // </editor-fold>

    public Tweet() {
    }

    public Tweet(String message, Date published, List<String> tags) {
        this.message = message;
        this.published = published;
        this.tags = tags;
    }

    /**
     * Adds an Account to the list of accounts that liked this tweet
     *
     * @param a Account
     */
    public void LikeTweet(Account a) {
        likedBy.add(a);
    }

    /**
     * Returns a list of all accounts that liked this tweet
     *
     * @return List of Account objects
     */
    public List<Account> getLikedBy() {
        return likedBy;
    }

}
