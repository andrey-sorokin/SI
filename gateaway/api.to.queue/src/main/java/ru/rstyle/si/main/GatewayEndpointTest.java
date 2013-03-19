package ru.rstyle.si.main;

import static java.lang.System.out;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.commons.io.FileUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.rstyle.si.domain.Parcel;
import ru.rstyle.si.gateway.ITradeGatewayAsync;

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

		out.println("Trade Message published (Reply). " + ft.getName());
	}

	public static void main(String[] args) {

		try {
			String fileName = "C://tmp//input//тест.xml";
			File file = new File(fileName);
			byte[] input = FileUtils.readFileToByteArray(file);
			GatewayEndpointTest test = new GatewayEndpointTest();
			Parcel parcel = new Parcel("тест.xml", input);
			test.publishTradeAsync(parcel);

			/*fileName = "C://tmp//input//7z917-x64.msi";
			file = new File(fileName);
			input = FileUtils.readFileToByteArray(file);
			test = new GatewayEndpointTest();
			parcel = new Parcel(fileName, input);
			test.publishTradeAsync(parcel);*/
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
