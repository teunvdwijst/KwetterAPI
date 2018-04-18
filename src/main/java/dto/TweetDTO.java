package dto;

import domain.Account;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Teun
 */
public class TweetDTO {

    private Long id;
    private String content;
    private String published;
    private String tweetedBy;
    private List<String> tags;
    private List<String> likedBy;
    private List<String> mentions;

    public TweetDTO() {
    }

    public TweetDTO(Long id, String content, String published, List<String> tags, String tweetedBy, List<Account> likedBy, List<Account> mentions) {
        this.id = id;
        this.content = content;
        this.published = published;
        this.tags = tags;
        this.tweetedBy = tweetedBy;
        this.likedBy = new ArrayList<>();
        likedBy.forEach((u) -> {
            this.likedBy.add(u.getUsername());
        });
        this.mentions = new ArrayList<>();
        mentions.forEach((u) -> {
            this.mentions.add(u.getUsername());
        });
    }

    public List<String> getLikedBy() {
        return likedBy;
    }

    public void setLikedBy(List<String> likedBy) {
        this.likedBy = likedBy;
    }

    public List<String> getMentions() {
        return mentions;
    }

    public void setMentions(List<String> mentions) {
        this.mentions = mentions;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getTweetedBy() {
        return tweetedBy;
    }

    public void setTweetedBy(String tweetedBy) {
        this.tweetedBy = tweetedBy;
    }
}
