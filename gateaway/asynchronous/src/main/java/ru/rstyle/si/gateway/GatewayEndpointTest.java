package ru.rstyle.si.gateway;

import static java.lang.System.out;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Future;

import org.apache.commons.io.FileUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GatewayEndpointTest {
	private ApplicationContext ctx = null;

	private ITradeGatewayAsync asyncTradeGateway = null;

	public GatewayEndpointTest() {
		ctx = new ClassPathXmlApplicationContext("endpoints-gateway-beans.xml");

		asyncTradeGateway = ctx.getBean("asyncTradeGateway",
				ITradeGatewayAsync.class);

		out.println("Async Gateway obtained: " + asyncTradeGateway);
	}

	public void publishTradeAsync(byte [] t) {

		Future<byte []> f = asyncTradeGateway.processTrade(t);

	}

	public static void main(String[] args) {

		File file = new File("C://tmp//input//readme.txt");

		try {
			byte[] input = FileUtils.readFileToByteArray(file);
			GatewayEndpointTest test = new GatewayEndpointTest();
			test.publishTradeAsync(input);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
