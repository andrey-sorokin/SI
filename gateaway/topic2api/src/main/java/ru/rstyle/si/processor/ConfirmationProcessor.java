package ru.rstyle.si.processor;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.integration.Message;
import org.springframework.integration.support.MessageBuilder;

public class ConfirmationProcessor {
	private static final Logger LOGGER = Logger
			.getLogger(ConfirmationProcessor.class);

	public Message<Map<String, String>> confirmParcel(Message<?> message) {

		String domain = null;
		Map<String, String> domainName = new HashMap<String, String>();

		try {
			domain = InetAddress.getLocalHost().getCanonicalHostName();
			domainName.put("domain.name", domain);
		} catch (UnknownHostException e) {
			LOGGER.error(e.getMessage(), e);
		}

		// Create a Msg using MessageBuilder
		Message<Map<String, String>> inetAddressMsg = MessageBuilder
				.withPayload(domainName).build();
		return inetAddressMsg;
	}

}
