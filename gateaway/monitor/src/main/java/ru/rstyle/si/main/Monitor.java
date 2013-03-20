package ru.rstyle.si.main;

import org.apache.log4j.Logger;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Monitor {

	private static final Logger logger = Logger.getLogger(Monitor.class);

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"spring.cfg.xml");
		logger.info("The application is started");
	}

}