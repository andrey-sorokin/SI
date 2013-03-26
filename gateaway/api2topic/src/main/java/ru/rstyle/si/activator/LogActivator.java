package ru.rstyle.si.activator;

import java.sql.Timestamp;
import java.util.Date;
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

			int rowCount = new JdbcTemplate(dataSource)
					.queryForInt("select count(0) from domain");

			UUID correlationId = (UUID) message.getHeaders().get(
					"correlationId");
			String file_name = (String) message.getHeaders().get("file_name");

			JdbcTemplate insert = new JdbcTemplate(dataSource);

			for (int i = 1; i <= rowCount; i++) {
				insert.update(
						"INSERT INTO status_table (CORRELATION_ID, DOMAIN_ID, PARCEL_NAME, SEND_TIME) VALUES(?,?,?,?)",
						new Object[] {correlationId.toString(), i, file_name, getCurrentTimeStamp()});
			}

		}

	}
	
	private synchronized static Timestamp getCurrentTimeStamp() {
		return new java.sql.Timestamp(new Date().getTime());
	 
	}
	
}
