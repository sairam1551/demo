package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class DcCaseRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public boolean existsByCaseNum(String caseNum) {
        String sql = "SELECT COUNT(*) FROM dc_case WHERE case_num = :caseNum";
        Integer count = jdbcTemplate.queryForObject(sql, Map.of("caseNum", caseNum), Integer.class);
        return count != null && count > 0;
    }

    public void insertCase(String caseNum, boolean isHeadOfHousehold) {
        String sql = "INSERT INTO dc_case (case_num, status, is_head_of_household) VALUES (:caseNum, 'ACTIVE', :isHead)";
        Map<String, Object> params = Map.of(
                "caseNum", caseNum,
                "isHead", isHeadOfHousehold
        );
        jdbcTemplate.update(sql, params);
    }
}