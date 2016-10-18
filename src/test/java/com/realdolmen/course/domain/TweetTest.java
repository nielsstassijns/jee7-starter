package com.realdolmen.course.domain;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TweetTest {
	
	private ValidatorFactory factory;
	private Validator validator;
	
	@Before
	public void initValidatorInfrastructure(){
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	@After
	public void destroyValidatorInfrastructure(){
		factory.close();
	}


	
	@Test
	public void dateMustBeInThePast() throws Exception{
		Tweet t = new Tweet("jimi","blabalaba");
		Thread.sleep(10);
		Set<ConstraintViolation<Tweet>> violations = validator.validate(t);
		Assert.assertEquals(0, violations.size());
		System.out.println(violations);
	}

	@Test
	public void usernameIsMandatory(){
		Tweet t = new Tweet(null,"blabalaba");
		Set<ConstraintViolation<Tweet>> violations = validator.validate(t);
		Assert.assertEquals(1, violations.size());
		ConstraintViolation<Tweet> error = violations.iterator().next();
		Assert.assertEquals("may not be null", error.getMessage());
		System.out.println(violations);
	}
	
	@Test
	public void messageIsTooLong(){
		Tweet t = new Tweet("Jimi",
				"npcecdzlhcenmce,cml,qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
		Set<ConstraintViolation<Tweet>> violations = validator.validate(t);
		Assert.assertEquals(1, violations.size());
		ConstraintViolation<Tweet> error = violations.iterator().next();
		Assert.assertEquals("size must be between 0 and 140", error.getMessage());
		System.out.println(violations);
	}
	
	@Test
	public void profaneMessage(){
		Tweet t = new Tweet("Jimi",
				"shit message");
		Set<ConstraintViolation<Tweet>> violations = validator.validate(t);
		Assert.assertEquals(1, violations.size());
		ConstraintViolation<Tweet> error = violations.iterator().next();
		Assert.assertEquals("Profane message", error.getMessage());
		System.out.println(violations);
	}
	
	@Test
	public void tagsTest() throws Exception{
		Tweet t = new Tweet("Jimi",
				"new message", "tag");
		Set<ConstraintViolation<Tweet>> violations = validator.validate(t, TagsGroup.class);
		Assert.assertEquals(0, violations.size());
		//Assert.assertEquals(1, violations.size());
		//ConstraintViolation<Tweet> error = violations.iterator().next();
		//Assert.assertEquals("size must be between 1 and 2147483647", error.getMessage());
		System.out.println(violations);
	}
	
	
}
