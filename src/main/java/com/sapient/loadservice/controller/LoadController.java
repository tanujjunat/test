package com.sapient.loadservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.sapient.loadservice.service.LoadService;

@Controller
public class LoadController {
	
	@Autowired
	LoadService loadService;
	
	@RequestMapping(value="/load", method = RequestMethod.GET)
	public String showLoadPage(ModelMap model){
		return "load";
	}
	
	@RequestMapping(value="/load", method = RequestMethod.POST)
	public String showResponsePage(ModelMap model) {
		String body = loadService.getResponseFromRestDB();
		model.put("jsonResponse", body);
		return "response";
	}

}
