package dto.hateoas;

import domain.Account;

/**
 *
 * @author Teun
 */
public class TweetDTO {

    private final String apiUri = "http://localhost:8080/KwetterS62/api/";

    private Long id;
    private String content;
    private String published;
    private String tweetedByUri;
    private String tagsUri;
    private String likedByUri;
    private String mentionsUri;

    public TweetDTO() {
    }

    public TweetDTO(Long id, String content, String published, Account tweetedBy) {
        this.id = id;
        this.content = content;
        this.published = published;
        this.tagsUri = apiUri + "tweets/" + id + "?tags=10";
        this.tweetedByUri = apiUri + "accounts/username/" + tweetedBy.getUsername();
        this.likedByUri = apiUri + "tweets/" + id + "?likedby=10";
        this.mentionsUri = apiUri + "tweets/" + id + "?mentions=10";
    }

    public String getTagsUri() {
        return tagsUri;
    }

    public void setTagsUri(String tagsUri) {
        this.tagsUri = tagsUri;
    }

    public String getLikedByUri() {
        return likedByUri;
    }

    public void setLikedByUri(String likedByUri) {
        this.likedByUri = likedByUri;
    }

    public String getMentionsUri() {
        return mentionsUri;
    }

    public void setMentionsUri(String mentionsUri) {
        this.mentionsUri = mentionsUri;
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

    public String getTweetedByUri() {
        return tweetedByUri;
    }

    public void setTweetedByUri(String tweetedByUri) {
        this.tweetedByUri = tweetedByUri;
    }
}
