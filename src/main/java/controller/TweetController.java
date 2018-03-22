package controller;

import domain.Tweet;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import service.TweetService;

/**
 *
 * @author Teun
 */
@Named
@RequestScoped
public class TweetController {

    @Inject
    TweetService tweetService;

    private List<Tweet> tweets;
    private Tweet selectedTweet;

    public TweetController() {
    }

    @PostConstruct
    private void init() {
        tweets = tweetService.getRecentTweets(0);
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    public void setSelectedTweet(Tweet selected) {
        if (selected != null) {
            this.selectedTweet = selected;
        }
    }

    public Tweet getSelectedTweet() {
        if (selectedTweet != null) {
            return selectedTweet;
        }
        return null;
    }

    public void removeTweet() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (selectedTweet == null) {
            context.addMessage("msg2", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No Tweet selected."));
            return;
        }
        tweetService.deleteTweet(selectedTweet);
        init();
    }
}
