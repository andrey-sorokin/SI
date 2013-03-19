package ru.rstyle.si.transformer;

import ru.rstyle.si.domain.Parcel;

public class ParcelTransformer {

	public byte [] transform(Parcel parcel){
	
		return parcel.getPayload();
		
	}
	
}
