package com.example.demo.dto;

import com.example.demo.util.FwCollectionUtils;

import java.util.List;

public class ActiveIndividualsRequestDTO {

    public ActiveIndividualsRequestDTO(){
        this.programCDs = FwCollectionUtils.emptyList();
    }

    private List<String> programCDs;

    public List<String> getProgramCDs() {
        return programCDs;
    }

    public void setProgramCDs(List<String> programCDs) {
        this.programCDs = programCDs;
    }
}
