package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class DcProgramEnrollmentRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void insertProgramEnrollment(String caseNum, String programCd) {
        String sql = "INSERT INTO dc_program_enrollment (case_num, program_cd) VALUES (:caseNum, :programCd)";
        Map<String, Object> params = Map.of(
                "caseNum", caseNum,
                "programCd", programCd
        );
        jdbcTemplate.update(sql, params);
    }
}