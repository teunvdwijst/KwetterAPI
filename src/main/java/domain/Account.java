/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

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
    private String email;
    private String encryptedPassword;
    private String location;
    private String bio;
    private String website;
    private String avatarPath;
    private List<Account> followingAccounts = new ArrayList<>();

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
    // </editor-fold>

    public Account() {

    }

    public Account(String userName, String email, String encryptedPassword, String location, String bio, String website, String avatarPath) {
        this.userName = userName;
        this.email = email;
        this.encryptedPassword = encryptedPassword;
        this.location = location;
        this.bio = bio;
        this.website = website;
        this.avatarPath = avatarPath;
    }

    /**
     * Adds an Account to the list of following accounts
     *
     * @param a Account
     */
    public void followAccount(Account a) {
        followingAccounts.add(a);
    }

}
