package com.realdolmen.course.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;

import com.realdolmen.course.utilities.persistence.JpaPersistenceTest;

public class TweetDBPersistenceTest extends JpaPersistenceTest{

	
	@Test
	public void tweetCanBePersisted() throws Exception {
		EntityManager em = entityManager();
		Tag tagOne = new Tag("newTag1");
		Tag tagTwo = new Tag("newTag2");
		List<Tag> tagsList = new ArrayList<Tag>();
		tagsList.add(tagOne);
		tagsList.add(tagTwo);
		Person p = new Person("Ringo","Starr","test123","ringo@ringo.com");
		TweetDB d = new TweetDB("New tweet by ringo",p,tagsList,Status.ACTIVE);
		em.persist(d);
	}
	
	@Test
	public void testBiDirectional() throws Exception {
		EntityManager em = entityManager();
		TweetDB tweet = em.find(TweetDB.class, 1000L);
		tweet.addTag(em.find(Tag.class, 2000L));
		em.merge(tweet);
		Tag tag	= em.find(Tag.class, 2000L);
		List<TweetDB> tweets = tag.getTweets();
		for(TweetDB t:tweets){
			if(t.getId().equals(1000L)){
				System.out.println("Joepie!");
			}
		}
	}	
}
