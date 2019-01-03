package com.sapient.newsservice.util;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.sapient.newsservice.model.NewsData;

@Component
public class NewsServiceUtil {
	
		
	public String getNewsServiceFromRest(String country, String category, String keyword) {
		HttpResponse<String> jsonResponseFromRest = null;
		String newsData = null;
		String url = String.format("https://newsapi.org/v2/top-headlines?country=%s&category=%s&apiKey=ccaf5d41cc5140c984818c344edcc14d", country, category);
		try {
			jsonResponseFromRest = Unirest.get(url)
			.header("content-type", "application/json")
			.header("cache-control", "no-cache").asString();			
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (jsonResponseFromRest.getStatus() == 200) {
			newsData = jsonResponseFromRest.getBody();
		}
		
		return newsData;
	}

	public NewsData convertStringResponseToObject(String newsString) {
		// TODO Auto-generated method stub
		ObjectMapper objectM = new ObjectMapper();
		NewsData news= null;
		try {
		
			news = objectM.readValue(newsString, NewsData.class);
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
		return news;
	}

}
