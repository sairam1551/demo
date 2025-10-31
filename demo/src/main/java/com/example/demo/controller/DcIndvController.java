package com.example.demo.controller;

import com.example.demo.dto.DcIndvRequestDTO;
import com.example.demo.dto.DcIndvResponseDTO;
import com.example.demo.dto.FwaApiResponseDTO;
import com.example.demo.service.DcIndvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/individuals")
public class DcIndvController {

    @Autowired
    private DcIndvService service;

    @PostMapping
    public FwaApiResponseDTO<DcIndvResponseDTO> createIndividual(@RequestBody DcIndvRequestDTO request) {
        DcIndvResponseDTO response = service.createIndividual(request);
        return new FwaApiResponseDTO<>(response);
    }
}
