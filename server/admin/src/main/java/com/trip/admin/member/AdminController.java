package com.trip.admin.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequestMapping("/admin")
public class AdminController {
    
	/* test용 코드 삭제해도 괜찮습니다 */
    @GetMapping("/test")
    public Object testAdmin(@RequestParam Map<String, String> paramsMap, HttpSession session) {
		log.info("testAdmin()");

		log.info("paramsMap : {} ", paramsMap);
		log.info("paramsMap's id : {} ", paramsMap.get("id")); // 이렇게 일정 값만 꺼낼 수도 있어
		log.info("session ID : {} ", session.getId());
		
		Map<String, Object> responseMap = new HashMap<>();
		// 오만가지 데이터를 담을 수 있어
		responseMap.put("data1", "집에");
		responseMap.put("data2", " ");
		responseMap.put("data3", "보내줘");
		
		return responseMap;
	}

}

