package ru.rstyle.si.gateway;

import java.util.concurrent.Future;

import ru.rstyle.si.domain.Parcel;

public interface ITradeGatewayAsync {

	public Future<Parcel> processTrade(Parcel parcel);
}
