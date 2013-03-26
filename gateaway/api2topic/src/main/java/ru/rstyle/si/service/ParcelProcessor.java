package ru.rstyle.si.service;

import org.apache.log4j.Logger;

import ru.rstyle.si.domain.Parcel;

public class ParcelProcessor {

	private static final Logger logger = Logger
			.getLogger(ParcelProcessor.class);

	public Parcel receiveParcel(Parcel t) {

		logger.info("Received the Trade using Gateway:" + t.getName());

		return t;
	}

}
