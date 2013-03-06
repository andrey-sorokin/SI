package ru.rstyle.si.splitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.integration.Message;
import org.springframework.integration.message.GenericMessage;
import org.springframework.integration.splitter.AbstractMessageSplitter;

public class MessageSplitter extends AbstractMessageSplitter {

	@Override
	protected Object splitMessage(Message<?> message) {
		List<Message> chunks = new ArrayList<Message>();
		byte[] payload = (byte[]) message.getPayload();

		byte[][] chunk = divideArray(payload, 1048576);

		for (byte[] c : chunk) {
			chunks.add(new GenericMessage(c));
		}

		return chunks;
	}

	public static byte[][] divideArray(byte[] source, int chunksize) {

		byte[][] ret = new byte[(int) Math.ceil(source.length
				/ (double) chunksize)][chunksize];

		int start = 0;

		for (int i = 0; i < ret.length; i++) {
			ret[i] = Arrays.copyOfRange(source, start, start + chunksize);
			start += chunksize;
		}

		return ret;
	}

}