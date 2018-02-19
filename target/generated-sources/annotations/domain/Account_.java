package domain;

import domain.Account;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-19T14:21:36")
@StaticMetamodel(Account.class)
public class Account_ { 

    public static volatile SingularAttribute<Account, String> website;
    public static volatile SingularAttribute<Account, String> avatarPath;
    public static volatile ListAttribute<Account, Account> followingAccounts;
    public static volatile SingularAttribute<Account, String> bio;
    public static volatile SingularAttribute<Account, String> location;
    public static volatile SingularAttribute<Account, Long> id;
    public static volatile SingularAttribute<Account, String> userName;
    public static volatile SingularAttribute<Account, String> email;
    public static volatile SingularAttribute<Account, String> encryptedPassword;

}