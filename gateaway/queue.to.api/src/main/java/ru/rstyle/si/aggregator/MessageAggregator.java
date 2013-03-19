package ru.rstyle.si.aggregator;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class MessageAggregator {

	public Object aggregateMessages(List<Object> chunks) throws IOException {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try {

			for (Object chunk : chunks) {
				baos.write((byte[]) chunk);
			}

			return baos.toByteArray();

		} finally {
			baos.close();
		}

	}

}