package domain;

import domain.Account;
import java.util.Date;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-05T15:19:50")
@StaticMetamodel(Tweet.class)
public class Tweet_ { 

    public static volatile ListAttribute<Tweet, Account> likedBy;
    public static volatile ListAttribute<Tweet, Account> mentions;
    public static volatile SingularAttribute<Tweet, Account> tweetedBy;
    public static volatile SingularAttribute<Tweet, Long> id;
    public static volatile SingularAttribute<Tweet, Date> published;
    public static volatile SingularAttribute<Tweet, String> content;
    public static volatile SingularAttribute<Tweet, List> tags;

}