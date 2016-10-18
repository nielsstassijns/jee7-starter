package com.realdolmen.course;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.inject.Produces;

public class MessageListFactory {

	@Produces
	@Regular
	private static List<String> regularMessages = Arrays.asList(
			"regular message 1",
			"regular message 2",
			"regular message 3");

	@Produces
	@Profane
	private static List<String> profaneMessages = Arrays.asList(
			"profane message 1",
			"profane shit 2",
			"profane message 3");

}
