package com.example.demo.dto;

import com.example.demo.util.DateComparisons;

import java.time.LocalDateTime;

public class DcIndvResponseDTO {

    private final String indvId;
    private final LocalDateTime createdAt;

    // Primary constructor used by service
    public DcIndvResponseDTO(String indvId, LocalDateTime createdAt) {
        this.indvId = indvId;
        this.createdAt = createdAt;
    }

    public DcIndvResponseDTO(String indvId) {
        this.indvId = indvId;
        this.createdAt = DateComparisons.getLocalesTimestamp();
    }

    public String getIndvId() {
        return indvId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}