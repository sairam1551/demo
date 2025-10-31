package com.example.demo.dto;

import com.example.demo.util.DateComparisons;

import java.time.LocalDateTime;

public class DcIndvResponseDTO {

    private String indvId;

    private LocalDateTime createdAt;

    public DcIndvResponseDTO(){}

    public DcIndvResponseDTO(String indvId){
        this.indvId = indvId;
        this.createdAt = DateComparisons.getLocalesTimestamp();
    }

    public String getIndvId() {
        return indvId;
    }

    public void setIndvId(String indvId) {
        this.indvId = indvId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
