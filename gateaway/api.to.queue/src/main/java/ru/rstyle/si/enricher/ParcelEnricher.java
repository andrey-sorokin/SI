package ru.rstyle.si.enricher;

import org.springframework.integration.Message;

import ru.rstyle.si.domain.Parcel;

public class ParcelEnricher {
	public String enrichHeader(Message m) {
		Parcel t = (Parcel) m.getPayload();
		return t.getName();
	}
}