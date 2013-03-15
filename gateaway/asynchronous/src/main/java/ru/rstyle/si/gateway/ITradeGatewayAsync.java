package ru.rstyle.si.gateway;

import java.util.concurrent.Future;

import ru.rstyle.si.domain.Trade;

public interface ITradeGatewayAsync {

	public Future<Trade> processTrade(Trade t);
}
