package com.realdolmen.course.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class TweetDB {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String message;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST})  
	@JoinColumn(name = "person_fk")
	private Person user;
	
	@ManyToMany(cascade = {CascadeType.PERSIST})
	@JoinTable(name = "jnd_tweet_tag",  joinColumns = @JoinColumn(name = "tag_fk"),  
	inverseJoinColumns = @JoinColumn(name = "tweet_fk")) 
	private List<Tag> tags = new ArrayList<Tag>();
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	@Enumerated(EnumType.STRING)
	private Status status;
	
	
	
	public TweetDB() {
		super();
	}



	public TweetDB(String message, Person user,List<Tag> tags, Status status) {
		super();
		this.message = message;
		this.user = user;
		this.status = status;
		this.tags = tags;
		date = new Date();
	}



	public Long getId() {
		return id;
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public Person getUser() {
		return user;
	}



	public void setUser(Person user) {
		this.user = user;
	}



	public List<Tag> getTags() {
		return tags;
	}

	public void addTag(Tag tag){
		this.tags.add(tag);
		tag.addTweet(this);
	}


	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public Status getStatus() {
		return status;
	}



	public void setStatus(Status status) {
		this.status = status;
	}
	
}
