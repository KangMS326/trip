package com.trip.admin.member;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
public class AdminDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void insertInfo(Map<String, String> paramsMap) {
        log.info("dao ----------------->>>>>>>>>");
        log.info("paramsMap : {} ", paramsMap);

        // SQL 쿼리 문자열
        String sql = "INSERT INTO MEMBER (" +
                "M_ID, M_PW, M_MAIL, M_PHONE, M_PROFILE, " +
                "M_IS_ALLOWED, M_GENDER, M_BIRTH, M_REG_DATE, M_MOD_DATE" +
                ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        // 파라미터 값
        Object[] params = new Object[]{
                paramsMap.get("m_id"),
                paramsMap.get("m_pw"),
                paramsMap.get("m_mail"),
                paramsMap.get("m_phone"),
                paramsMap.get("m_profile"),
                Integer.parseInt(paramsMap.get("m_is_allowed")),
                paramsMap.get("m_gender"),
                paramsMap.get("m_birth"),
                paramsMap.get("m_reg_date"),
                paramsMap.get("m_mod_date")
        };

        // 쿼리 실행
        jdbcTemplate.update(sql, params);
    }
}
