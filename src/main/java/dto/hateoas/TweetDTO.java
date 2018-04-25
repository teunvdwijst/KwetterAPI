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

    public String getApiUri() {
        return apiUri;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getPublished() {
        return published;
    }

    public String getTweetedByUri() {
        return tweetedByUri;
    }

    public String getTagsUri() {
        return tagsUri;
    }

    public String getLikedByUri() {
        return likedByUri;
    }

    public String getMentionsUri() {
        return mentionsUri;
    }
}
