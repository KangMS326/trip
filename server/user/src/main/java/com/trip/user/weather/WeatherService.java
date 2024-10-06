package com.trip.user.weather;

import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class WeatherService {
	
	@Value("${weather.api.key}")  //properties에 API KEY를 작성하고 그 값을 불러옴
	private String serviceKey;
	
	public String getShortTermForecast(double lat, double lon) throws Exception {
		log.info("[WeatherService] getShortTermForecast() ");
		
		
		log.info("위도 :{}, 경도 :{}", lat,lon);
		  // 격자 좌표 변환
		 String urlCoordinateTransformation = String.format(
			        "https://apihub.kma.go.kr/api/typ01/cgi-bin/url/nph-dfs_xy_lonlat?lon=%s&lat=%s&help=0&authKey=%s",
			        lon, lat, serviceKey
			    );

			    // 격자 좌표 변환 API 호출
			    HttpURLConnection conCoordinate = (HttpURLConnection) new URL(urlCoordinateTransformation).openConnection();
			    conCoordinate.setRequestMethod("GET");
			    conCoordinate.setRequestProperty("Content-Type", "application/json");

			    int responseCodeCoordinate = conCoordinate.getResponseCode(); // 응답 코드 확인
			    log.info("격자 좌표 변환 Response Code: {}", responseCodeCoordinate);
			    
			    long nx = 0;
			    long ny = 0;

			    if (responseCodeCoordinate == HttpURLConnection.HTTP_OK) { // 200 OK일 때만 읽기
			        BufferedReader in = new BufferedReader(new InputStreamReader(conCoordinate.getInputStream(), "EUC-KR"));
			        StringBuilder response = new StringBuilder();
			        String inputLine;

			        while ((inputLine = in.readLine()) != null) {
			            response.append(inputLine).append("\n"); // 각 줄을 줄바꿈과 함께 저장
			        }
			        in.close();

			        // 응답을 파싱하여 nx, ny 값을 추출
			        String responseString = response.toString();
			        log.info("결과는? -------> {}", responseString); 

			        // 응답에서 nx, ny 추출 (첫 번째 줄 건너뛰기)
			        String[] lines = responseString.split("\n"); // 줄 단위로 분리
			        if (lines.length > 2) { // 응답이 3줄 이상인지 확인
			            String[] parts = lines[2].trim().split(","); // 세 번째 줄을 콤마로 분리
			            if (parts.length >= 4) { // 응답이 예상보다 짧지 않은지 확인
			                try {
			                    nx = Long.parseLong(parts[2].trim()); // X 값
			                    ny = Long.parseLong(parts[3].trim()); // Y 값
			                } catch (NumberFormatException e) {
			                    log.error("격자 좌표 변환 중 오류 발생: {}", e.getMessage());
			                    return null; // 오류 발생 시 null 반환
			                }
			            } else {
			                log.error("응답 형식이 예상과 다릅니다: {}", responseString);
			            }
			        } else {
			            log.error("응답이 예상보다 짧습니다: {}", responseString);
			        }

			        log.info("변환된 격자 좌표: nx = {}, ny = {}", nx, ny);
			    } else {
			        log.error("격자 좌표 변환 API 호출 실패: 응답 코드 {}", responseCodeCoordinate);
			        return null; // 실패 시 null 반환
			    }

	    	    
	    
	    
		LocalDateTime now = LocalDateTime.now();
		log.info("현재 시간----> {}",now);
		
		String baseDate = now.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
		log.info("베이스 데이트------>>>> : {}", baseDate);
		
		// 현재 시각 정보
		int hour = now.getHour();
		int minute = now.getMinute();
		int baseHour;

		// 발표 시각 02, 05, 08, 11, 14, 17, 20, 23 중 가장 가까운 시간 선택
		if (hour >= 23 && minute >= 10) {
		    baseHour = 23;
		} else if (hour >= 20 && minute >= 10) {
		    baseHour = 20;
		} else if (hour >= 17 && minute >= 10) {
		    baseHour = 17;
		} else if (hour >= 14 && minute >= 10) {
		    baseHour = 14;
		} else if (hour >= 11 && minute >= 10) {
		    baseHour = 11;
		} else if (hour >= 8 && minute >= 10) {
		    baseHour = 8;
		} else if (hour >= 5 && minute >= 10) {
		    baseHour = 5;
		} else if (hour >= 2 && minute >= 10) {
		    baseHour = 2;
		} else {
		    // 발표된 지 10분이 지나지 않았거나 발표 전인 경우, 이전 발표 시각을 사용
		    if (hour >= 23) {
		        baseHour = 20;
		    } else if (hour >= 20) {
		        baseHour = 17;
		    } else if (hour >= 17) {
		        baseHour = 14;
		    } else if (hour >= 14) {
		        baseHour = 11;
		    } else if (hour >= 11) {
		        baseHour = 8;
		    } else if (hour >= 8) {
		        baseHour = 5;
		    } else if (hour >= 5) {
		        baseHour = 2;
		    } else {
		        baseHour = 23; // 자정 전인 경우, 이전 날 23:00 발표 시각
		    }

		    // 만약 자정 이전이라면 baseDate를 하루 전으로 변경
		    if (hour < 2 || (hour == 2 && minute < 10)) {
		        baseDate = now.minusDays(1).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
		    }
		}

		// baseTime을 "HH00" 형식으로 변환
		String baseTime = String.format("%02d00", baseHour);
		log.info("현재시각 : {}",baseTime);
		
		 String urlString = String.format(
		            "https://apihub.kma.go.kr/api/typ02/openApi/VilageFcstInfoService_2.0/getVilageFcst?pageNo=1&numOfRows=14&dataType=JSON&base_date=%s&base_time=%s&nx=%s&ny=%s&authKey=%s",
		            baseDate, baseTime, nx, ny, serviceKey
		        );
		 URL url = new URL(urlString);
		 log.info("url 뭐라고 찍히는지 확인 ============> : {}",url);
		
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Content-Type", "application/json");
		
		int responseCode = con.getResponseCode(); // 응답 코드 확인
		 log.info("Response Code: {}", responseCode);
		    
		    if (responseCode == HttpURLConnection.HTTP_OK) { // 200 OK일 때만 읽기
		        String encoding = "EUC-KR";
		        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), encoding));
		        String inputLine;
		        StringBuffer response = new StringBuffer();
		        
		        while ((inputLine = in.readLine()) != null) {
		            response.append(inputLine);
		        }
		        
		        in.close();
		        
		        log.info("여기 결과가 뭐가 나와????----->> {}", response.toString());
		        return null;
		       // return response.toString(); // 실제 응답을 반환
		    } else {
		        log.error("API 호출 실패: 응답 코드 {}", responseCode);
		        return null; // 실패시 null 반환
		    }
	}

}
