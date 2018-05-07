package util;

import domain.Account;
import domain.Tweet;
import dto.hateoas.AccountDTO;
import dto.hateoas.TweetDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Teun
 */
public class DomainToHateoasDto {

    public static List<AccountDTO> accountsToDtos(List<Account> accounts) {
        List<AccountDTO> accountDtos = new ArrayList<>();
        if (accounts == null || accounts.isEmpty()) {
            return accountDtos;
        }

        for (Account a : accounts) {
            AccountDTO dto = new AccountDTO(
                    a.getId(),
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

    public static AccountDTO accountToDto(Account account) {
        if (account == null) {
            return new AccountDTO();
        }

        return new AccountDTO(
                account.getId(),
                account.getUsername(),
                account.getEmail(),
                account.getUserGroupsString(),
                account.getPassword(),
                account.getLocation(),
                account.getBio(),
                account.getWebsite(),
                account.getAvatarPath());
    }

    public static List<TweetDTO> tweetsToDtos(List<Tweet> tweets) {
        List<TweetDTO> tweetDtos = new ArrayList<>();
        if (tweets == null || tweets.isEmpty()) {
            return tweetDtos;
        }

        for (Tweet t : tweets) {
            TweetDTO dto = new TweetDTO(
                    t.getId(),
                    t.getContent(),
                    t.getPublished().toString(),
                    t.getTweetedBy(),
                    t.getLikedBy());
            tweetDtos.add(dto);
        }
        return tweetDtos;
    }

    public static TweetDTO tweetToDto(Tweet tweet) {
        if (tweet == null) {
            return new TweetDTO();
        }

        return new TweetDTO(
                tweet.getId(),
                tweet.getContent(),
                tweet.getPublished().toString(),
                tweet.getTweetedBy(),
                tweet.getLikedBy());
    }

    public static List<TweetDTO> tweetsToDtos(List<Tweet> tweets, String loggedInUser) {
        List<TweetDTO> tweetDtos = new ArrayList<>();
        if (tweets == null || tweets.isEmpty()) {
            return tweetDtos;
        }

        for (Tweet t : tweets) {
            TweetDTO dto = new TweetDTO(
                    t.getId(),
                    t.getContent(),
                    t.getPublished().toString(),
                    t.getTweetedBy(),
                    t.getLikedBy());
            for (Account a : t.getLikedBy()) {
                if (a.getUsername().equals(loggedInUser)) {
                    dto.setHasBeenLiked(true);
                    break;
                }
            }
            tweetDtos.add(dto);
        }
        return tweetDtos;
    }

    public static TweetDTO tweetToDto(Tweet tweet, String loggedInUser) {
        if (tweet == null) {
            return new TweetDTO();
        }

        TweetDTO dto = new TweetDTO(
                tweet.getId(),
                tweet.getContent(),
                tweet.getPublished().toString(),
                tweet.getTweetedBy(),
                tweet.getLikedBy());

        for (Account a : tweet.getLikedBy()) {
            if (a.getUsername().equals(loggedInUser)) {
                dto.setHasBeenLiked(true);
                break;
            }
        }
        return dto;
    }
}
