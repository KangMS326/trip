package com.trip.user.weather;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequestMapping("/weather")
public class WeatherController {
	@Autowired
	WeatherService weatherService;

	@PostMapping("/shortTermForecast")
    public String getShortTermForecast(@RequestBody Map<String, String>paramsMap) {
		log.info("[Weather] getShortTermForecast()");
        log.info("paramsMap :{}", paramsMap);
        try {
			double lat = Double.parseDouble(paramsMap.get("위도"));
			double lon = Double.parseDouble(paramsMap.get("경도"));
			
			String weatherDate = weatherService.getShortTermForecast(lat,lon);
			
			log.info("weatherDate : ", weatherDate);
			
		} catch (Exception e) {
			log.info(e);
		}
        
        return "Sunny"; 
	}
}
