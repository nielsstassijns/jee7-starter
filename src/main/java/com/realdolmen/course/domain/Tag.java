package com.realdolmen.course.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tag {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@ManyToMany(mappedBy = "tags") 
	private List<TweetDB> tweets = new ArrayList<TweetDB>();

	
	
	public Tag() {
		super();
	}



	public Tag(String name) {
		super();
		this.name = name;
	}



	public Tag(String name, List<TweetDB> tweets) {
		super();
		this.name = name;
		this.tweets = tweets;
	}



	public Long getId() {
		return id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public List<TweetDB> getTweets() {
		return tweets;
	}
	
	void addTweet(TweetDB tweetDB){
		this.tweets.add(tweetDB);
	}

	
	
	
	
}
