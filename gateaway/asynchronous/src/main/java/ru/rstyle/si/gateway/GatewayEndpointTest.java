package ru.rstyle.si.gateway;

import static java.lang.System.out;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.commons.io.FileUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.rstyle.si.domain.Parcel;

public class GatewayEndpointTest {
	private ApplicationContext ctx = null;

	private ITradeGatewayAsync asyncTradeGateway = null;

	public GatewayEndpointTest() {
		ctx = new ClassPathXmlApplicationContext("endpoints-gateway-beans.xml");

		asyncTradeGateway = ctx.getBean("asyncTradeGateway",
				ITradeGatewayAsync.class);

		out.println("Async Gateway obtained: " + asyncTradeGateway);
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
		
		System.out.println("Trade Message published (Reply). "+ ft.getName());



	}

	public static void main(String[] args) {

		File file = new File("C://tmp//input//ActiveMQBrowser_2.5.2.8ForJDK1.6.zip");

		try {
			byte[] input = FileUtils.readFileToByteArray(file);
			GatewayEndpointTest test = new GatewayEndpointTest();
			Parcel parcel = new Parcel("ActiveMQBrowser_2.5.2.8ForJDK1.6.zip", input);
			test.publishTradeAsync(parcel);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
