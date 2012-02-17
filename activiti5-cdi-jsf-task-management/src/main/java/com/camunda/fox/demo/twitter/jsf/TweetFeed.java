package com.camunda.fox.demo.twitter.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

@ApplicationScoped
public class TweetFeed {

  private List<String> lastTweets = new ArrayList<String>();

  public void addTweet(String tweet) {
    lastTweets.add(tweet);
    if (lastTweets.size() > 10) {
      lastTweets.remove(lastTweets.get(0));
    }
  }

  @Produces
  @Named("lastTweets")
  public List<String> getLastTweets() {
    return lastTweets;
  }

}
