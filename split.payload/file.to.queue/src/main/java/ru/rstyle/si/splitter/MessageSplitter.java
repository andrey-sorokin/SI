package ru.rstyle.si.splitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.integration.Message;
import org.springframework.integration.message.GenericMessage;
import org.springframework.integration.splitter.AbstractMessageSplitter;

public class MessageSplitter extends AbstractMessageSplitter {

	@Override
	protected List<Message> splitMessage(Message<?> message) {
		final int chunkSize = 1048576;
		List<Message> chunks;

		byte[] payload = (byte[]) message.getPayload();

		if (payload.length <= chunkSize) {
			chunks = new ArrayList<Message>();
			chunks.add(new GenericMessage(payload));
			return chunks;
		}

		chunks = splitArray(payload, chunkSize);

		return chunks;
	}

	public static List splitArray(byte[] array, int max) {

		int x = array.length / max;

		int lower = 0;
		int upper = 0;

		List list = new ArrayList();

		for (int i = 0; i < x; i++) {

			upper += max;

			list.add(Arrays.copyOfRange(array, lower, upper));

			lower = upper;
		}

		if (upper < array.length - 1) {

			lower = upper;

			upper = array.length;

			list.add(Arrays.copyOfRange(array, lower, upper));
		}

		return list;
	}

}