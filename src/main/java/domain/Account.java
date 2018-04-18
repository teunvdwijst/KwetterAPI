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
import javax.enterprise.inject.Model;
import javax.json.bind.annotation.JsonbTransient;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Teun
 */
@Entity
@Model
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a")
    ,
    @NamedQuery(name = "Account.findBySearchterm", query = "SELECT a FROM Account a WHERE (a.email LIKE :search) OR (a.username LIKE :search)")
    ,
    @NamedQuery(name = "Account.findByEmail", query = "SELECT a FROM Account a WHERE a.email LIKE :email")
    ,
    @NamedQuery(name = "Account.findByUsername", query = "SELECT a FROM Account a WHERE a.username LIKE :username")
    ,
    @NamedQuery(name = "Account.following", query = "SELECT f FROM Account a JOIN a.following f WHERE a.username = :username")
    ,
    @NamedQuery(name = "Account.followers", query = "SELECT a FROM Account a JOIN a.following f WHERE f.id = (SELECT a.id FROM Account a WHERE a.username = :username)")})
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String email;
    @ManyToMany(mappedBy = "users")
    private final List<UserGroup> groups = new ArrayList<>();
    private String password;
    private String location;
    private String bio;
    private String website;
    private String avatarPath;
    @OneToMany(cascade = ALL)
    @JoinTable(name = "following")
    private final List<Account> following = new ArrayList<>();
    @OneToMany(mappedBy = "tweetedBy", cascade = ALL)
    private final List<Tweet> tweets = new ArrayList<>();

    // <editor-fold desc="Getters and Setters" defaultstate="collapsed">
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = DigestUtils.sha512Hex(password);
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

    @JsonbTransient
    public List<UserGroup> getUserGroup() {
        return groups;
    }

    @JsonbTransient
    public List<Account> getFollowing() {
        return Collections.unmodifiableList(following);
    }

    @JsonbTransient
    public List<Tweet> getTweets() {
        return Collections.unmodifiableList(tweets);
    }

    // </editor-fold>
    public Account() {
    }

    public Account(String email, String password) {
        this.email = email;
        this.password = DigestUtils.sha512Hex(password);
    }

    public Account(String email, String password, String userName, String location, String bio, String website, String avatarPath) {
        this(email, password);
        this.username = userName;
        this.location = location;
        this.bio = bio;
        this.website = website;
        this.avatarPath = avatarPath;
    }

    public Account(String email, String password, String userName, String location, String bio, String website, String avatarPath, UserGroup group) {
        this(email, password);
        this.username = userName;
        this.location = location;
        this.bio = bio;
        this.website = website;
        this.avatarPath = avatarPath;
        this.addUserGroup(group);
    }

    public String getUserGroupsString() {
        if (this.getUserGroup().size() > 0) {
            StringBuilder sb = new StringBuilder();
            for (UserGroup ug : this.getUserGroup()) {
                sb.append(ug.getGroupname());
                sb.append(" - ");
            }
            return sb.substring(0, sb.length() - 3);
        }
        return "";
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
    public Tweet addTweet(String message) {
        Tweet temp = new Tweet(message, this);
        tweets.add(temp);
        return temp;
    }

    /**
     * Removes a Tweet from the list of tweets owned by this account
     *
     * @param id
     */
    public void removeTweet(long id) {
        for (Tweet t : tweets) {
            if (t.getId() == id) {
                tweets.remove(t);
                break;
            }
        }
    }

    public String promoteUserGroup() {
        boolean mod = false;
        boolean admin = false;
        for (UserGroup g : groups) {
            if (g.getGroupname().equals("MODERATOR")) {
                mod = true;
            } else if (g.getGroupname().equals("ADMIN")) {
                admin = true;
            }
        }
        if (!mod && !admin) {
            return "MODERATOR";
        } else if (mod && !admin) {
            return "ADMIN";
        }
        return null;
    }

    public void addUserGroup(UserGroup userGroup) {
        if (!this.groups.contains(userGroup)) {
            this.groups.add(userGroup);
            userGroup.addUser(this);
        }
    }

    public String demoteUserGroup() {
        boolean mod = false;
        boolean admin = false;
        for (UserGroup g : groups) {
            if (g.getGroupname().equals("MODERATOR")) {
                mod = true;
            } else if (g.getGroupname().equals("ADMIN")) {
                admin = true;
            }
        }
        if (mod && admin) {
            return "ADMIN";
        } else if (mod && !admin) {
            return "MODERATOR";
        }
        return null;
    }

    public void removeUserGroup(UserGroup userGroup) {
        if (this.groups.contains(userGroup)) {
            this.groups.remove(userGroup);
            userGroup.removeUser(this);
        }
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
        hash = 53 * hash + Objects.hashCode(this.username);
        hash = 53 * hash + Objects.hashCode(this.email);
        hash = 53 * hash + Objects.hashCode(this.location);
        hash = 53 * hash + Objects.hashCode(this.bio);
        hash = 53 * hash + Objects.hashCode(this.website);
        hash = 53 * hash + Objects.hashCode(this.avatarPath);
        return hash;
    }
}
