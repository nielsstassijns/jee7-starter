package com.realdolmen.course.domain;

import java.util.Arrays;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class Tweet {
	
	@Past
	private Date date; //{past}
	
	@NotNull
	@Size(min = 2)
	private String username; //{Min 2}
	
	@NotNull
	@Size(max = 140)
	@AntiProfanity
	private String message; //{Max=140} & {AntiProfanityValidator}
	
	@Size(min = 1, groups = TagsGroup.class)
	private Set<String> tags; //group tags {size > 1}
	
	
	public Tweet() {
		super();
	}
	
	public Tweet(String username, String message, String... tags) {
		date = new Date();
		this.username = username;
		this.message = message;
		this.tags = new TreeSet<String>(Arrays.asList(tags));
	}
	
	public Tweet(Date date, String username, String message, Set<String> tags) {
		this.date = date;
		this.username = username;
		this.message = message;
		this.tags = tags;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Set<String> getTags() {
		return tags;
	}
	public void setTags(Set<String> tags) {
		this.tags = tags;
	}
	
	

}
