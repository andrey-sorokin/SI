package ru.rstyle.si.processor;

import org.springframework.integration.Message;

import ru.rstyle.api.RStyle;

public class ExternalAPIProcessor {

	public void confirmParcel(Message<?> message) {

		byte[] byte_payload = (byte[]) message.getPayload();

		String string_payload = new String(byte_payload);

		new RStyle().main(string_payload);

	}

}
