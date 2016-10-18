package com.realdolmen.course.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;

import com.realdolmen.course.utilities.persistence.JpaPersistenceTest;

public class TweetDBPersistenceTest extends JpaPersistenceTest{
	
	@Test
	public void tweetCanBeRetrieved() throws Exception {
		EntityManager em = entityManager();
		TweetDB tweet = em.find(TweetDB.class, 1000L);
		assertEquals("Blablabla", tweet.getMessage());
		assertEquals("Jimi", tweet.getUsername());
	}
	
	@Test
	public void tweetCanBePersisted() throws Exception {
		EntityManager em = entityManager();
		TweetDB d = new TweetDB("Blebleble","Ringo",Status.ACTIVE);
		em.persist(d);
	}
	
	@Test
	public void tweetCanBePersistedWithTags() throws Exception {
		EntityManager em = entityManager();
		List<String> tagsList = new ArrayList<String>();
		tagsList.add("tag 1");
		tagsList.add("tag 2");
		tagsList.add("tag 3");
		TweetDB d = new TweetDB("Blobloblo","John",tagsList,Status.ACTIVE);
		em.persist(d);
		em.flush();
	}

}
