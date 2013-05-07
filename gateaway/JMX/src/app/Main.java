package app;

import java.net.URLDecoder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
public class Main {
 
 public static void main(String[] args) {
 
	 
		String xxx = "%7B%22actions%22%3A%5B%7B%22action%22%3A%22com.rstyle.rsdoc.action.CreateObjectAction%22%2C+%22body%22%3A%5B%7B%22records%22%3A%5B%7B%22classmnemo%22%3A%22DocumentGroupClassifier%22%2C+%22rows%22%3A+%5B%7B%22XML%22%3A%22%253C%253Fxml%2520version%253D%25221.0%2522%2520encoding%253D%2522UTF-8%2522%253F%253E%250A%253Cgroup%252F%253E%22%2C%22ID_SEQUENCE%22%3A%2253%22%2C%22CODE%22%3A%22%25D1%2583%25D1%2583%25D1%2583%22%2C%22GROUP_NAME%22%3A%22%25D1%2583%25D1%2583%25D1%2583%22%2C%22DESCRIPTION%22%3A%22%25D1%2583%25D1%2583%25D1%2583%22%7D%5D%7D%5D%7D%5D%7D%5D%7D";
		
		System.out.println(URLDecoder.decode(xxx));
	 
		
		
  /*ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
   
  QueueSizeCounter queueCounter = (QueueSizeCounter) ctx.getBean("queueCounter");
 
  String queueName = "CONFIRM.FOO";
  long queueSize = queueCounter.getQueueSize(queueName);
 
  System.out.println("Size of " + queueName + " : " + queueSize);*/
 }
}