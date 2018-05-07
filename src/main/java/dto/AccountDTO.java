package dto;

import java.io.Serializable;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Teun
 */
public class AccountDTO implements Serializable {

    private Long id;
    private String username;
    private String email;
    private String groups;
    private String password;
    private String location;
    private String bio;
    private String website;
    private String avatarPath;

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
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getGroups() {
        return groups;
    }

    public String getPassword() {
        return password;
    }

    public String getLocation() {
        return location;
    }

    public String getBio() {
        return bio;
    }

    public String getWebsite() {
        return website;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGroups(String groups) {
        this.groups = groups;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }
}
