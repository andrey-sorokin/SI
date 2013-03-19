package ru.rstyle.si.processor;

import org.springframework.integration.Message;

public class ConfirmationProcessor {

	public String confirmParcel(Message message) {
		String file_name = (String) message.getHeaders().get("file_name");
		System.out.println(file_name);
		return file_name;

	}

}
