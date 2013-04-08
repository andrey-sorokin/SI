package ru.rstyle.si.filter;

import org.springframework.integration.Message;
import org.springframework.integration.core.MessageSelector;

public class ApiFilter implements MessageSelector {
	public boolean accept(Message<?> message) {
		Object fileName = message.getHeaders().get("file_name");
		return (fileName.equals("null"));
	}
}
