package com.realdolmen;

import static org.junit.Assert.assertNotNull;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Test;

import com.realdolmen.cditest.XClass;
import com.realdolmen.course.FortuneService;
import com.realdolmen.course.service.PersonServiceBean;

public class Demo {
	
	@Test
	public void testWeldTest() {		
		Weld newWeld = new Weld().packages(FortuneService.class);
		WeldContainer newContainer = newWeld.initialize();
		FortuneService fortuneService = newContainer.instance().select(FortuneService.class).get();
		assertNotNull(fortuneService);
	}
}