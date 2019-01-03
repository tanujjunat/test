package com.sapient.newsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sapient.newsservice.model.VehiclePollutionData;
import com.sapient.newsservice.service.impl.LoadServiceImpl;

@Controller
public class LoadController {
	
	@Autowired
	LoadServiceImpl loadService;
	
	@RequestMapping(value="/load", method = RequestMethod.GET)
	public String showLoadPage(ModelMap model){
		return "load";
	}
	
	@RequestMapping(value="/load", method = RequestMethod.POST)
	public String showResponsePage(ModelMap model) {
		VehiclePollutionData pollutionLevel = loadService.getResponseFromRestDB();
		 
		
		model.put("C6H6_level", pollutionLevel.getC6H6());
		model.put("CO2_level", pollutionLevel.getCO2());
		model.put("CO_level", pollutionLevel.getCO_gas());
		model.put("NH4_level", pollutionLevel.getNH4());
		model.put("NOX_level", pollutionLevel.getNOX());
		model.put("Date_Time", pollutionLevel.getDateTime());
		return "response";
	}

}
