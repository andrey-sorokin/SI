package ru.rstyle.si.gateway;

import java.util.concurrent.Future;

public interface ITradeGatewayAsync {

	public Future<byte []> processTrade(byte [] t);
}
