package ru.rstyle.si.main;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.rstyle.si.domain.Parcel;
import ru.rstyle.si.gateway.ITradeGatewayAsync;

public class Sender {
	private static final Logger logger = Logger.getLogger(Sender.class);
	private ApplicationContext ctx = null;

	private ITradeGatewayAsync asyncTradeGateway = null;

	public Sender() {
		ctx = new ClassPathXmlApplicationContext("spring.cfg.xml");

		asyncTradeGateway = ctx.getBean("asyncTradeGateway",
				ITradeGatewayAsync.class);

		logger.info("Async Gateway obtained: " + asyncTradeGateway);
	}

	public void publishTradeAsync(Parcel parcel) {

		Future<Parcel> f = asyncTradeGateway.processTrade(parcel);

		Parcel ft = null;
		try {
			ft = f.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		logger.info("Trade Message published (Reply). " + ft.getName());
	}

	public static void main(String[] args) {

		Sender test = new Sender();
		String xml = null;
		
/*		try {
			xml = URLEncoder.encode("<?xml version=\"1.0\" encoding=\"UTF-8\"?><group/>","UTF-8");
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}
		
		String json = "{\"actions\":[{\"action\":\"com.rstyle.rsdoc.action.CreateObjectAction\", \"body\":[{\"records\":[{\"classmnemo\":\"DocumentGroupClassifier\", \"rows\": [{\"XML\":\" " + xml  + " \",\"ID_SEQUENCE\":\"54\",\"CODE\":\"13\",\"GROUP_NAME\": \"Внутренняя переписка \",\"DESCRIPTION\":\" Внутренняя переписка \"}]}]}]}]}";
		byte[] input = json.getBytes();
		Parcel parcel = new Parcel("null", input);
		test.publishTradeAsync(parcel);
        System.out.println(json);*/
		try {
			
			String fileName = "C://tmp//input//тест.xml";
			File file = new File(fileName);
			byte[] input = FileUtils.readFileToByteArray(file);
			Parcel parcel = new Parcel("тест.xml", input);
			test.publishTradeAsync(parcel);
            

			/*fileName = "C://tmp//input//7z917-x64.msi";
			file = new File(fileName);
			input = FileUtils.readFileToByteArray(file);
			parcel = new Parcel("7z917-x64.msi", input);
			test.publishTradeAsync(parcel);*/

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
