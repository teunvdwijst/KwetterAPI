package dto.hateoas;

import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Teun
 */
public class AccountDTO {

    private final String apiUri = "http://localhost:8080/KwetterS62/api/";

    private Long id;
    private String username;
    private String email;
    private String groups;
    private String password;
    private String location;
    private String bio;
    private String website;
    private String avatarPath;
    private String tweetsUri;
    private String followingUri;
    private String followersUri;

    public AccountDTO() {
    }

    public AccountDTO(Long id, String username, String email, String groups, String password, String location, String bio, String website, String avatarPath) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.groups = groups;
        this.password = DigestUtils.sha512Hex(password);
        this.location = location;
        this.bio = bio;
        this.website = website;
        this.avatarPath = avatarPath;
        this.tweetsUri = apiUri + "tweets/username/" + username;
        this.followingUri = apiUri + "accounts/followers/" + username;
        this.followingUri = apiUri + "accounts/following/" + username;
    }

    public String getTweetsUri() {
        return tweetsUri;
    }

    public void setTweetsUri(String tweetsUri) {
        this.tweetsUri = tweetsUri;
    }

    public String getFollowingUri() {
        return followingUri;
    }

    public void setFollowingUri(String followingUri) {
        this.followingUri = followingUri;
    }

    public String getFollowersUri() {
        return followersUri;
    }

    public void setFollowersUri(String followersUri) {
        this.followersUri = followersUri;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getGroups() {
        return groups;
    }

    public void setGroups(String groups) {
        this.groups = groups;
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
}
