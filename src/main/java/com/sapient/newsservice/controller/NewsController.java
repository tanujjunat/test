package com.sapient.newsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sapient.newsservice.model.NewsData;
import com.sapient.newsservice.model.VehiclePollutionData;
import com.sapient.newsservice.service.impl.LoadServiceImpl;
import com.sapient.newsservice.service.impl.NewsServiceImpl;

@Controller
public class NewsController {
	
	@Autowired
	NewsServiceImpl newsService;
	
	@RequestMapping(value="/getNews", method = RequestMethod.GET)
	public String showLoadPage(ModelMap model){
		return "newsSearch";
	}
	
	@RequestMapping(value="/getNews", method = RequestMethod.POST)	
	public String showResponsePage(ModelMap model, @RequestParam String country, @RequestParam String category, @RequestParam String keyword) {
		NewsData news = newsService.getResponseFromRest(country,category,keyword);
		 
		model.put("country", country);
		model.put("category", category);
		model.put("keyword", keyword);
		model.put("articles", news.getArticles());
		return "topNews";
	}

}
