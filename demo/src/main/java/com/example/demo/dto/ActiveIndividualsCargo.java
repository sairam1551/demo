package com.example.demo.dto;

import com.example.demo.util.DateComparisons;

import java.time.LocalDateTime;
import java.util.List;

public class ActiveIndividualsCargo {

    private String indvId;
    private String caseNum;
    private String firstName;
    private boolean headOfHouseHold;
    private String programCD;
    private LocalDateTime queriedAt;

    public ActiveIndividualsCargo() {
        this.queriedAt = DateComparisons.getLocalesTimestamp();
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


    public String getProgramCD() {
        return programCD;
    }

    public void setProgramCD(String programCD) {
        this.programCD = programCD;
    }


    public LocalDateTime getQueriedAt() {
        return queriedAt;
    }

    public void setQueriedAt(LocalDateTime queriedAt) {
        this.queriedAt = queriedAt;
    }
}
