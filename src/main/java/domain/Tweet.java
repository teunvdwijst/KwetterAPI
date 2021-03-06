/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.enterprise.inject.Model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.Transient;

/**
 *
 * @author Teun
 */
@Entity
@Model
@NamedQueries({
    @NamedQuery(name = "Tweet.findById", query = "SELECT t FROM Tweet t WHERE t.id = :id")
    ,
    @NamedQuery(name = "Tweet.findRecent", query = "SELECT t FROM Tweet t order by t.published desc")
    ,
    @NamedQuery(name = "Tweet.findRecentByEmail", query = "SELECT t FROM Tweet t WHERE t.tweetedBy = (SELECT a.id FROM Account a WHERE a.email = :email) order by t.published desc")
    ,
    @NamedQuery(name = "Tweet.findRecentByTag", query = "SELECT t FROM Tweet t WHERE t.content LIKE :tag order by t.published desc")
    ,
    @NamedQuery(name = "Tweet.timeline", query = "SELECT t FROM Tweet t WHERE t.tweetedBy IN (SELECT f FROM Account a JOIN a.following f WHERE a.email = :email)")
})
public class Tweet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String content;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date published;
    @Transient
    private final List<String> tags = new ArrayList<>();
    @ManyToOne
    private Account tweetedBy;
    @OneToMany
    @JoinTable(name = "tweet_likes")
    private final List<Account> likedBy = new ArrayList<>();
    @OneToMany
    @JoinTable(name = "tweet_mentions")
    private final List<Account> mentions = new ArrayList<>();

    // <editor-fold desc="Getters and Setters" defaultstate="collapsed">
    public List<Account> getLikedBy() {
        return Collections.unmodifiableList(likedBy);
    }

    public List<Account> getMentions() {
        return Collections.unmodifiableList(mentions);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getTweetedBy() {
        return tweetedBy;
    }

    public void setTweetedBy(Account a) {
        this.tweetedBy = a;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublished() {
        return published;
    }

    public void setPublished(Date published) {
        this.published = published;
    }

    public List<String> getTags() {
        return Collections.unmodifiableList(tags);
    }

    public Long getId() {
        return id;
    }
    // </editor-fold>

    public Tweet() {
    }

    public Tweet(String content, Account tweetedBy) {
        this.tweetedBy = tweetedBy;
        this.content = content;
        this.published = new Date(System.currentTimeMillis());
        findTags(content);
    }

    public Tweet(String content, Account tweetedBy, Date published) {
        this.tweetedBy = tweetedBy;
        this.content = content;
        this.published = published;
        findTags(content);
    }

    /**
     * Finds tags preceded with a '#' and sets the Tags list
     *
     * @param message String
     */
    private void findTags(String message) {
        this.tags.clear();
        this.tags.addAll(findRegexMatches(message, "(?:\\#)([A-Za-z0-9_]+)"));
    }

    /**
     * Searches for passed regex matches in the message and returns them as a
     * list
     *
     * @param message String
     * @param regex String
     * @return List of String objects
     */
    private List<String> findRegexMatches(String message, String regex) {
        List<String> matches = new ArrayList<>();
        String prefixedString = " ".concat(message);
        Matcher m = Pattern.compile(regex).matcher(prefixedString);
        while (m.find()) {
            matches.add(m.group(1));
        }
        return matches;
    }

    /**
     * Adds an Account to the list of accounts that were mentioned in this tweet
     *
     * @param a Account
     */
    public void addMention(Account a) {
        if (!mentions.contains(a)) {
            mentions.add(a);
        }
    }

    /**
     * Removes an Account to the list of accounts that were mentioned in this
     * tweet
     *
     * @param a Account
     */
    public void removeMention(Account a) {
        if (mentions.contains(a)) {
            mentions.remove(a);
        }
    }

    /**
     * Adds an Account to the list of accounts that liked this tweet
     *
     * @param a Account
     */
    public void addLike(Account a) {
        if (!likedBy.contains(a)) {
            likedBy.add(a);
        }
    }

    /**
     * Removes an Account from the list of accounts that liked this tweet
     *
     * @param a
     */
    public void removeLike(Account a) {
        if (likedBy.contains(a)) {
            likedBy.remove(a);
        }
    }

    public String getLikedByString() {
        if (this.getLikedBy().size() > 0) {
            StringBuilder sb = new StringBuilder();
            for (Account a : this.getLikedBy()) {
                sb.append(a.getUsername());
                sb.append(" - ");
            }
            return sb.substring(0, sb.length() - 3);
        }
        return "";
    }

    @Override
    public boolean equals(Object obj) {
        if ((obj == null) || (!(obj instanceof Tweet))) {
            return false;
        } else if (this == obj) {
            return true;
        }

        final Tweet other = (Tweet) obj;

        return !((!Objects.equals(this.content, other.content)) || (!Objects.equals(this.published, other.published)) || (!Objects.equals(this.tweetedBy, other.tweetedBy)));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.content);
        hash = 67 * hash + Objects.hashCode(this.published);
        hash = 67 * hash + Objects.hashCode(this.tags);
        hash = 67 * hash + Objects.hashCode(this.tweetedBy);
        hash = 67 * hash + Objects.hashCode(this.likedBy);
        hash = 67 * hash + Objects.hashCode(this.mentions);
        return hash;
    }
}
