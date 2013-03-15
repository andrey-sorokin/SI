package ru.rstyle.si.gateway;

import ru.rstyle.si.domain.Trade;

public interface ITradeGateway {

	public Trade processTrade(Trade t);
}