package com.example.demo.repository;

import com.example.demo.dto.ActiveIndividualsCargo;
import com.example.demo.dto.ActiveIndividualsResponseDTO;
import com.example.demo.rowmapper.ActiveIndividualsCargoRowMapper;
import com.example.demo.util.FwCollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class ActiveIndividualsRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List<ActiveIndividualsCargo> fetchActiveIndividualsCargo(List<String> programCDs){
        String sql = """
            SELECT i.indv_id, i.first_name, ci.case_num, ci.is_head_of_household, p.program_cd
            FROM dc_case_individual ci
            JOIN dc_individual i ON ci.indv_id = i.indv_id
            JOIN dc_case c ON ci.case_num = c.case_num
            JOIN dc_program_enrollment p ON p.case_num = c.case_num
            WHERE c.status IN ('ACTIVE', 'APPROVED')
            AND ci.status = 'ACTIVE'
            AND ci.case_num IN(
            SELECT DISTINCT case_num FROM dc_program_enrollment 
            WHERE program_cd IN (:programCDs)
            )
            ORDER BY i.indv_id, p.program_cd;
            """;


        Map<String, Object> params = new HashMap<>();
        params.put("programCDs", programCDs);

        return jdbcTemplate.query(sql, params, new ActiveIndividualsCargoRowMapper());
    }
}
