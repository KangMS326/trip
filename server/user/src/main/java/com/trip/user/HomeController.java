package com.trip.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.trip.weather.WeatherController;
import com.trip.weather.WeatherService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class HomeController {
	
	@Autowired
	WeatherService weatherService;

	@GetMapping("/")
	public String home() {
		
		log.info("user home");
		
		String nextPage = "userIndex";
		return nextPage;
		
	}
	
}
