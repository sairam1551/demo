package com.example.demo.dto;

import com.example.demo.util.FwCollectionUtils;

import java.util.List;

public class DcIndvRequestDTO {

    private String indvId;
    private String caseNum;
    private String firstName;
    private boolean headOfHouseHold;
    private List<String> programCDs;

    public DcIndvRequestDTO() {
        this.programCDs = FwCollectionUtils.emptyList();
    }

    public String getIndvId() {
        return indvId;
    }

    public void setIndvId(String indvId) {
        this.indvId = indvId;
    }

    public String getCaseNum() {
        return caseNum;
    }

    public void setCaseNum(String caseNum) {
        this.caseNum = caseNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public boolean isHeadOfHouseHold() {
        return headOfHouseHold;
    }

    public void setHeadOfHouseHold(boolean headOfHouseHold) {
        this.headOfHouseHold = headOfHouseHold;
    }

    public List<String> getProgramCDs() {
        return programCDs;
    }

    public void setProgramCDs(List<String> programCDs) {
        this.programCDs = programCDs;
    }
}
