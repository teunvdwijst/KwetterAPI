package util;

import domain.Account;
import domain.Tweet;
import dto.AccountDTO;
import dto.TweetDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Teun
 */
public class DomainToDto {

    public static List<AccountDTO> accountsToDtos(List<Account> accounts) {
        List<AccountDTO> accountDtos = new ArrayList<>();
        if (accounts == null || accounts.isEmpty()) {
            return accountDtos;
        }

        for (Account a : accounts) {
            AccountDTO dto = new AccountDTO(
                    Math.toIntExact(a.getId()),
                    a.getUsername(),
                    a.getEmail(),
                    a.getUserGroupsString(),
                    a.getPassword(),
                    a.getLocation(),
                    a.getBio(),
                    a.getWebsite(),
                    a.getAvatarPath());
            accountDtos.add(dto);
        }
        return accountDtos;
    }

    public static List<TweetDTO> tweetsToDtos(List<Tweet> tweets) {
        List<TweetDTO> tweetDtos = new ArrayList<>();
        if (tweets == null || tweets.isEmpty()) {
            return tweetDtos;
        }

        for (Tweet t : tweets) {
            TweetDTO dto = new TweetDTO(
                    Math.toIntExact(t.getId()),
                    t.getContent(),
                    t.getPublished().toString(),
                    t.getTags(),
                    t.getTweetedBy().getUsername(),
                    t.getLikedBy(),
                    t.getMentions());
            tweetDtos.add(dto);
        }
        return tweetDtos;
    }
}
