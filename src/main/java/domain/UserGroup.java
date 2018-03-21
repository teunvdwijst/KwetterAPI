package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author Teun
 */
@Entity
public class UserGroup implements Serializable {

    @Id
    private String groupname;

    @ManyToMany
    @JoinTable(name = "USER_GROUP",
            joinColumns = @JoinColumn(name = "groupname", referencedColumnName = "groupname"),
            inverseJoinColumns = @JoinColumn(name = "username", referencedColumnName = "username"))
    private final List<Account> users = new ArrayList<>();

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getGroupname() {
        return groupname;
    }

    public void addUser(Account user) {
        if (user != null) {
            this.users.add(user);
        }
    }

    public void removeUser(Account user) {
        if (user != null) {
            this.users.remove(user);
        }
    }

    public UserGroup() {
    }

    public UserGroup(String name) {
        this.groupname = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null) {
            UserGroup temp = (UserGroup) obj;
            return this.getGroupname().equals(temp.getGroupname());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.groupname);
        hash = 59 * hash + Objects.hashCode(this.users);
        return hash;
    }
}
