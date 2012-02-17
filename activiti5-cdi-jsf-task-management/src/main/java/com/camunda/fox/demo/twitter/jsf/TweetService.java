package com.camunda.fox.demo.twitter.jsf;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class TweetService {

  @Inject
  private TweetFeed tweetFeed;

  public void tweet(String tweetContent) {
    tweetFeed.addTweet(tweetContent);
  }

}
