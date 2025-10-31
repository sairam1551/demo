package com.example.demo.repository;

import com.example.demo.dto.DcIndvCargo;
import com.example.demo.dto.DcIndvRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DcIndvRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public String insertIndividualFromCargo(DcIndvCargo cargo){
        String sql = """
                INSERT INTO dc_case_individual(indv_id, case_num, status, is_head_of_household)
                VALUES(:indvId, :caseNum, :status, :isHeadOfHouseHold)
                """;

        Map<String, Object> params = new HashMap<>();

        params.put("indvId", cargo.getIndvId());
        params.put("caseNum", cargo.getCaseNum());
        params.put("status", cargo.getStatus());
        params.put("isHeadOfHouseHold", cargo.isHeadOfHouseHold());

        jdbcTemplate.update(sql, params);

        return cargo.getIndvId();
    }

    public void insertIndividualMaster(DcIndvCargo cargo){
        String sql = """
                INSERT INTO dc_individual(indv_id, first_name)
                VALUES(:indvId, :firstName)
                """;
        Map<String, Object> params = new HashMap<>();

        params.put("indvId", cargo.getIndvId());
        params.put("firstName", cargo.getFirstName());

        jdbcTemplate.update(sql,params);
    }
}
