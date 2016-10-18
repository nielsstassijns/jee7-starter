package com.realdolmen.course.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class TweetDB {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String message;
	private String username;
	@ElementCollection
	@CollectionTable(name = "Tags")  
	@Column(name = "Value")
	private List<String> tags = new ArrayList<String>();
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	@Enumerated(EnumType.STRING)
	private Status status;
	
	
	protected TweetDB() {
		super();
	}



	public TweetDB(String message, String username, List<String> tags, Status status) {
		super();
		this.message = message;
		this.username = username;
		this.tags.addAll(tags);
		this.status = status;
	}



	public TweetDB(String message, String username, Status status) {
		super();
		this.message = message;
		this.username = username;
		this.status = status;
		date = new Date();
	}



	public TweetDB(Long id, String message, String username) {
		super();
		this.id = id;
		this.message = message;
		this.username = username;
		date = new Date();
	}

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public List<String> getTags() {
		return tags;
	}



	public void setTags(List<String> tags) {
		this.tags = tags;
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
