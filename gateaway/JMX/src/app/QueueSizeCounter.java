package app;

import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
 
import org.apache.log4j.Logger;
 
public class QueueSizeCounter {
 
 private MBeanServerConnection mBeanServerConnection;
 
 private Logger logger = Logger.getLogger(QueueSizeCounter.class);
 
 public Long getQueueSize(String queueName) {
  Long queueSize = null;
  try {
 
   ObjectName objectNameRequest = new ObjectName(
     "org.apache.activemq:BrokerName=localhost,Type=Queue,Destination=" + queueName);
 
   queueSize = (Long) mBeanServerConnection.getAttribute(objectNameRequest, "QueueSize");
 
   return queueSize;
  }
  catch (Exception e) {
   logger.error(e.getMessage());
  }
  return queueSize;
 }
 
 public void setmBeanServerConnection(MBeanServerConnection mBeanServerConnection) {
  this.mBeanServerConnection = mBeanServerConnection;
 }
 
}