package com.realdolmen.course;

import javax.enterprise.event.Observes;
import javax.inject.Named;

@Named("myFortuneObserver")
public class FortuneObserver {
	
	public void addShitCount(@Observes String message) {
		System.out.println("Shit message!");
	}

}
