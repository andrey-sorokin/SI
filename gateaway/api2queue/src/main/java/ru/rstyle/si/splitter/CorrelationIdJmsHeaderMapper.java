package ru.rstyle.si.splitter;

import org.springframework.integration.MessageHeaders;
import org.springframework.integration.MessagingException;
import org.springframework.integration.jms.DefaultJmsHeaderMapper;

public class CorrelationIdJmsHeaderMapper extends DefaultJmsHeaderMapper {

    public void fromHeaders(MessageHeaders headers, javax.jms.Message jmsMessage) {
        super.fromHeaders(headers, jmsMessage);
        Object correlationId = headers.get(MessageHeaders.CORRELATION_ID);
        if (correlationId != null) {
            try {
                jmsMessage.setStringProperty("correlationId", correlationId.toString());
            }
            catch (Exception e) {
                throw new MessagingException("Problem setting 'correlationId' property", e);
            }
        }
    }

}