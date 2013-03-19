package ru.rstyle.si.activator;

import java.util.UUID;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.integration.Message;
import org.springframework.jdbc.core.JdbcTemplate;

public class LogActivator {

	private BasicDataSource dataSource;

	public LogActivator(BasicDataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void logParcel(Message message) {
		Integer sequenceNumber = (Integer) message.getHeaders().get(
				"sequenceNumber");

		if (sequenceNumber == 1) {
			UUID correlationId = (UUID) message.getHeaders().get(
					"correlationId");
			String file_name = (String) message.getHeaders().get("file_name");

			JdbcTemplate insert = new JdbcTemplate(dataSource);
			insert.update(
					"INSERT INTO status_table (CORRELATION_ID, PARCEL_NAME) VALUES(?,?)",
					new Object[] { correlationId.toString(), file_name });
		}

	}
}
