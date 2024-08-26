package com.trip.user.weather;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequestMapping("/weather")
public class WeatherController {

	@PostMapping("/getWeather")
    public String getWeather(@RequestBody Map<String, String>paramsMap) {
		log.info("[Weather] getWeather()");
        log.info("paramsMap :{}", paramsMap);
        
        return "Sunny"; 
	}
}
