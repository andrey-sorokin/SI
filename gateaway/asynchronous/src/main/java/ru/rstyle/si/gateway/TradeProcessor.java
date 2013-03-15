package ru.rstyle.si.gateway;

import ru.rstyle.si.domain.Trade;


public class TradeProcessor {

	public Trade receiveTrade(Trade t) {
		System.out.println("Received the Trade using Gateway:"+t);
		t.setStatus("REPLY");
		return t;
	}

}
