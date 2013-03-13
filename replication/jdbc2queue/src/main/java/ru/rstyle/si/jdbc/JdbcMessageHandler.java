package ru.rstyle.si.jdbc;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class JdbcMessageHandler {

    @ServiceActivator
    public String handleJdbcMessage(List<Map<String, Object>> message) {
    	
    	StringBuilder sb = new StringBuilder();
    	
        for (Map<String, Object> resultMap : message) {
            //System.out.println("Row");
            for (String column : resultMap.keySet()) {
                //System.out.println("column: " + column + " value: " + resultMap.get(column));
            	sb.append(column + ":" + resultMap.get(column));
            }
        }
        
        System.out.println("sb contents: " + sb);
        
        sb.setLength(0);
        
        return sb.toString();
        
    }
}
