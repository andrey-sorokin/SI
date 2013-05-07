package ru.rstyle.si.main;

import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import org.apache.activemq.broker.jmx.BrokerViewMBean;
import org.apache.activemq.broker.jmx.QueueViewMBean;

public class Stats {

	public static void main(String[] args) throws Exception {
		
		JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://172.16.9.110:1099/jmxrmi");
		
		JMXConnector connector = JMXConnectorFactory.connect(url);

		MBeanServerConnection connection = connector.getMBeanServerConnection();
		System.out.println(connection.getMBeanCount());
		
		System.out.println(connection.getDefaultDomain());
		
		ObjectName name = new ObjectName(
				"org.apache.activemq:type=Broker,brokerName=localhost");
		
		BrokerViewMBean mbean = (BrokerViewMBean) MBeanServerInvocationHandler
				.newProxyInstance(connection, name, BrokerViewMBean.class, true);
		
		System.out.println("Statistics for broker " + mbean.getBrokerId()
				+ " - " + mbean.getBrokerName());
		System.out.println("\n-----------------\n");
		System.out.println("Total message count: "
				+ mbean.getTotalMessageCount() + "\n");
		System.out.println("Total number of consumers: "
				+ mbean.getTotalConsumerCount());
		System.out.println("Total number of Queues: "
				+ mbean.getQueues().length);

		for (ObjectName queueName : mbean.getQueues()) {
			System.out.println(queueName);
			QueueViewMBean queueMbean = (QueueViewMBean) MBeanServerInvocationHandler
					.newProxyInstance(connection, queueName,
							QueueViewMBean.class, true);
			System.out.println("\n-----------------\n");
			System.out.println("Statistics for queue " + queueMbean.getName());
			System.out.println("Size: " + queueMbean.getQueueSize());
			System.out.println("Number of consumers: "
					+ queueMbean.getConsumerCount());
			
		}
	}

}
