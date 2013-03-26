package ru.rstyle.si.service;

import ru.rstyle.si.domain.Parcel;

public class ParcelProcessor {

	public Parcel receiveParcel(Parcel t) {
		System.out.println("Received the Trade using Gateway:"+t.getName());
	
		return t;
	}

}
