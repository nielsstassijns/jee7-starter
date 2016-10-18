package com.realdolmen.course;

import static org.junit.Assert.assertNotNull;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Before;
import org.junit.Test;

public class FortuneTest {
	
	private WeldContainer newContainer;

	@Before
	public void init(){
		Weld weld = new Weld();
		newContainer = weld.initialize();
	}
	
	@Test
	public void fortuneYieldsProfaneMessage() {		
		
		FortuneService fortuneService = newContainer.instance().select(FortuneService.class).get();
		String message = fortuneService.fortune();
		assertNotNull(message);
	}
}