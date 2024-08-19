package com.trip.user.weather;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequestMapping("/weather")
public class WeatherController {

	@GetMapping("/getWeather")
    public String getWeather() {
        log.info("[Weather] getWeather()"); 
        
        return "Sunny"; 
	}
}
