package domain;

import domain.Account;
import domain.Role;
import domain.Tweet;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-28T09:33:48")
@StaticMetamodel(Account.class)
public class Account_ { 

    public static volatile SingularAttribute<Account, String> website;
    public static volatile ListAttribute<Account, Account> following;
    public static volatile SingularAttribute<Account, String> avatarPath;
    public static volatile SingularAttribute<Account, String> bio;
    public static volatile SingularAttribute<Account, String> location;
    public static volatile SingularAttribute<Account, Long> id;
    public static volatile SingularAttribute<Account, String> userName;
    public static volatile SingularAttribute<Account, Role> userRole;
    public static volatile ListAttribute<Account, Tweet> tweets;
    public static volatile SingularAttribute<Account, String> email;
    public static volatile SingularAttribute<Account, String> encryptedPassword;

}