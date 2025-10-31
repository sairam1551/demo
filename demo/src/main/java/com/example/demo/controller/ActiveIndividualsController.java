package com.example.demo.controller;

import com.example.demo.dto.ActiveIndividualsRequestDTO;
import com.example.demo.dto.ActiveIndividualsResponseDTO;
import com.example.demo.dto.FwaApiResponseDTO;
import com.example.demo.service.ActiveIndividualsService;
import com.example.demo.util.FwCollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cases")
public class ActiveIndividualsController {

    @Autowired
    private ActiveIndividualsService service;


    @GetMapping("/active-individuals")
    public FwaApiResponseDTO<List<ActiveIndividualsResponseDTO>> getActiveIndividuals(
        @RequestParam(required = false) List<String> programCDs){

        ActiveIndividualsRequestDTO request = new ActiveIndividualsRequestDTO();

        if(programCDs == null){
            programCDs = FwCollectionUtils.emptyList();
        }

        List<ActiveIndividualsResponseDTO> individuals = service.getActiveIndividuals(programCDs);
        return new FwaApiResponseDTO<>(individuals);
    }
}
