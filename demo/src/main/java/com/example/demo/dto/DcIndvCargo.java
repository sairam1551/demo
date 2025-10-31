package com.example.demo.dto;

import com.example.demo.util.DateComparisons;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DcIndvCargo {


    private String indvId;
    private String caseNum;
    private String firstName;
    private boolean headOfHouseHold;
    private String status;
    private LocalDateTime createdAt;

    public DcIndvCargo() {
        this.status = "ACTIVE";
        this.createdAt = DateComparisons.getLocalesTimestamp();
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }




}
