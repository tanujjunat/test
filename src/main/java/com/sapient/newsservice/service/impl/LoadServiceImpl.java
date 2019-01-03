package com.sapient.newsservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.newsservice.model.VehiclePollutionData;
import com.sapient.newsservice.service.LoadService;
import com.sapient.newsservice.util.LoadServiceUtil;

@Service
public class LoadServiceImpl implements LoadService{
	
	@Autowired
	LoadServiceUtil loadServiceUtil;
	
	@Override
	public VehiclePollutionData getResponseFromRestDB() {
		return loadServiceUtil.convertStringResponseToObject(loadServiceUtil.getVehiclePollutionDataFromRestDB());
		
	}

}
