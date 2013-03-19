package ru.rstyle.si.domain;

public class Parcel {
	private String name = null;

	private byte[] payload;

	
	public Parcel (String name, byte [] payload){
		this.name = name;
		this.payload = payload;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getPayload() {
		return payload;
	}

	public void setPayload(byte[] payload) {
		this.payload = payload;
	}
}
