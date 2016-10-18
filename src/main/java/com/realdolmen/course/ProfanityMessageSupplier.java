package com.realdolmen.course;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

@Profane
public class ProfanityMessageSupplier implements MessageSupplier {

	@Inject
	@Profane
	private List<String> messages = new ArrayList<String>();
	
	
	@Override
	public String supplyRandomMessage() {
		
		Random rand = new Random();
	    int randomNum = rand.nextInt(messages.size());
		
		return messages.get(randomNum);
	}

}
