package com.sapient.loadservice.service;

import org.springframework.stereotype.Component;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@Component
public class LoadService {

	public String getResponseFromRestDB() {
		String body = null;
		try {
			HttpResponse<String> jsonResponseFromRestDB = Unirest.get("https://tutorial-a111.restdb.io/rest/vehiclepollutiondata")
			.header("content-type", "application/json")
			.header("x-apikey", "d426afcf53d499d49217ce81b06b7cb3bb559")
			.header("cache-control", "no-cache").asString();
			if (jsonResponseFromRestDB.getStatus() == 200) {
				body = (String) jsonResponseFromRestDB.getBody();
			}			
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return body;
	}
}
