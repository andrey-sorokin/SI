package ru.rstyle.si.splitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.integration.Message;
import org.springframework.integration.splitter.AbstractMessageSplitter;

public class MessageSplitter extends AbstractMessageSplitter {

	private int chunkSize;

	public MessageSplitter(int chunkSize){
		this.chunkSize = chunkSize;
	}
	
	@Override
	protected List<byte[]> splitMessage(Message<?> message) {

		final List<byte[]> chunks;

		byte[] payload = (byte[]) message.getPayload();

		if (payload.length <= chunkSize) {

			chunks = new ArrayList<byte[]>();

			chunks.add(payload);

			return chunks;
		}

		chunks = splitArray(payload, chunkSize);

		return chunks;
	}

	public static List<byte[]> splitArray(byte[] array, int max) {

		int x = array.length / max;

		int lower = 0;
		int upper = 0;

		List<byte[]> list = new ArrayList<byte[]>();

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