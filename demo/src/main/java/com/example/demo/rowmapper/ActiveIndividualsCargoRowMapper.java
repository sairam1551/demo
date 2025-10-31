package com.example.demo.rowmapper;

import com.example.demo.dto.ActiveIndividualsCargo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;

public class ActiveIndividualsCargoRowMapper implements RowMapper<ActiveIndividualsCargo> {

    @Override
    public ActiveIndividualsCargo mapRow(ResultSet rs, int rowNum) throws SQLException{
        ActiveIndividualsCargo cargo = new ActiveIndividualsCargo();
        cargo.setIndvId(rs.getString("indv_id"));
        cargo.setCaseNum(rs.getString("case_num"));
        cargo.setFirstName(rs.getString("first_name"));
        cargo.setHeadOfHouseHold(rs.getBoolean("is_head_of_household"));
        cargo.setProgramCD(rs.getString("program_cd"));
        return cargo;
    }
}
