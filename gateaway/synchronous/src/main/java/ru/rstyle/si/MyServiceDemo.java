package ru.rstyle.si;

import org.apache.log4j.Logger;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyServiceDemo {

	private static final Logger logger = Logger.getLogger(MyServiceDemo.class);

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"spring.cfg.postgres.xml");
		logger.info("The application is started");
	}

}