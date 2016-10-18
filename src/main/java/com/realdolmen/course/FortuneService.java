package com.realdolmen.course;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

@Named("myFortuneService")
public class FortuneService {
	
	@Profane
	@Inject
	MessageSupplier supplier;
	
	@Inject
	@ShitHappend
	private Event<String> shitHappend;
	
	public String fortune(){
		String shitMessage = "Shit happend!";
		String message = supplier.supplyRandomMessage();
		if (message.contains("shit") || message.contains("Shit")){
			shitHappend.fire(shitMessage);
		}
		return message;
	}

}