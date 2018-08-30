package com.sapient.loadservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.loadservice.model.VehiclePollutionData;
import com.sapient.loadservice.service.LoadService;
import com.sapient.loadservice.util.LoadServiceUtil;

@Service
public class LoadServiceImpl implements LoadService{
	
	@Autowired
	LoadServiceUtil loadServiceUtil;
	
	@Override
	public VehiclePollutionData getResponseFromRestDB() {
		return loadServiceUtil.convertStringResponseToObject(loadServiceUtil.getVehiclePollutionDataFromRestDB());
		
	}

}
