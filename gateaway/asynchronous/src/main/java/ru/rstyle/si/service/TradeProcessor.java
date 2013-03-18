package ru.rstyle.si.service;

import ru.rstyle.si.domain.Parcel;

public class TradeProcessor {

	public Parcel receiveTrade(Parcel t) {
		System.out.println("Received the Trade using Gateway:"+t.getName());
	
		return t;
	}

}
