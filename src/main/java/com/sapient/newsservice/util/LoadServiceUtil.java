package com.sapient.newsservice.util;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.sapient.newsservice.model.VehiclePollutionData;

@Component
public class LoadServiceUtil {
	
	public String getVehiclePollutionDataFromRestDB() {
		HttpResponse<String> jsonResponseFromRestDB = null;
		String pollutionAlertsData = null;
		try {
			jsonResponseFromRestDB = Unirest.get("https://tutorial-a111.restdb.io/rest/alert")
			.header("content-type", "application/json")
			.header("x-apikey", "d426afcf53d499d49217ce81b06b7cb3bb559")
			.header("cache-control", "no-cache").asString();			
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (jsonResponseFromRestDB.getStatus() == 200) {
			pollutionAlertsData = jsonResponseFromRestDB.getBody();
		}
		
		return pollutionAlertsData;
	}

	public VehiclePollutionData convertStringResponseToObject(String vehiclePollutionDataFromRestDB) {
		// TODO Auto-generated method stub
		ObjectMapper objectM = new ObjectMapper();
		VehiclePollutionData vehiclePollutionData = null;
		try {
			vehiclePollutionDataFromRestDB = vehiclePollutionDataFromRestDB.substring(1);
			vehiclePollutionDataFromRestDB = vehiclePollutionDataFromRestDB.substring(0, vehiclePollutionDataFromRestDB.length() - 1);
			vehiclePollutionData = objectM.readValue(vehiclePollutionDataFromRestDB, VehiclePollutionData.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vehiclePollutionData;
	}

}
