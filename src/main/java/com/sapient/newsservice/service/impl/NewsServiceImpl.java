package com.sapient.newsservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.newsservice.model.NewsData;
import com.sapient.newsservice.service.NewsService;
import com.sapient.newsservice.util.NewsServiceUtil;

@Service
public class NewsServiceImpl implements NewsService{
	
	@Autowired
	NewsServiceUtil newsServiceUtil;
	
	@Override
	public NewsData getResponseFromRest(String country, String category, String keyword) {
		
		return newsServiceUtil.convertStringResponseToObject(newsServiceUtil.getNewsServiceFromRest(country,category,keyword));
		
	}

}
