package com.trip.admin.member;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class AdminService {

	@Autowired
	AdminDao adminDao;
	
	public void userInfo(Map<String, String> paramsMap) {
		log.info("AdminService -----");
		
		log.info("paramsMap : {} ", paramsMap);
		adminDao.insertInfo(paramsMap);
		
	}

}
