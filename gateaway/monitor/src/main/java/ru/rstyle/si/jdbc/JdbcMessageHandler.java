package ru.rstyle.si.jdbc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

@Component
public class JdbcMessageHandler {

	StringBuilder sb = new StringBuilder();
    List<String> outcome = new ArrayList <String> ();
	
	@ServiceActivator
	public List<String> handleJdbcMessage(List<Map<String, Object>> message) {

		for (Map<String, Object> resultMap : message) {
			for (String column : resultMap.keySet()) {
				sb.append("column_name=" + column + " " + "column_value=" + resultMap.get(column) + "|");
			}
			
			outcome.add(sb.toString());
			sb.setLength(0);
			
		}
        
		return outcome;

	}
}
