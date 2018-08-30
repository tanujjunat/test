package com.sapient.loadservice.service;


import com.sapient.loadservice.model.VehiclePollutionData;

public interface LoadService {

	public VehiclePollutionData getResponseFromRestDB();
}
