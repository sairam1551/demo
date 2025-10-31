package com.example.demo.service;

import com.example.demo.dto.ActiveIndividualsCargo;
import com.example.demo.dto.ActiveIndividualsRequestDTO;
import com.example.demo.dto.ActiveIndividualsResponseDTO;
import com.example.demo.repository.ActiveIndividualsRepository;
import com.example.demo.util.FwCollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class ActiveIndividualsService {

    @Autowired
    private ActiveIndividualsRepository repository;

    public List<ActiveIndividualsResponseDTO> getActiveIndividuals(List<String> programCDs) {

        if(programCDs == null) {
            programCDs = FwCollectionUtils.emptyList();
        }

        if(programCDs.isEmpty()){
            programCDs = FwCollectionUtils.emptyList();
            programCDs.add("FS");
            programCDs.add("CASH");
        }

        List<ActiveIndividualsCargo> cargoList = repository.fetchActiveIndividualsCargo(programCDs);

        return transformCargoToResponseDTO(cargoList);
    }

    private List<ActiveIndividualsResponseDTO> transformCargoToResponseDTO(List<ActiveIndividualsCargo> cargoList){
        Map<String, ActiveIndividualsResponseDTO> resultMap = new LinkedHashMap<>();

        for(ActiveIndividualsCargo cargo : cargoList){
            String indvId = cargo.getIndvId();

            ActiveIndividualsResponseDTO dto = resultMap.get(indvId);

            if(dto == null){
                dto = new ActiveIndividualsResponseDTO();
                dto.setIndvId(cargo.getIndvId());
                dto.setCaseNum(cargo.getCaseNum());
                dto.setFirstName(cargo.getFirstName());
                dto.setHeadOfHouseHold(cargo.isHeadOfHouseHold());
                resultMap.put(indvId, dto);
            }

            String programCd = cargo.getProgramCD();
            if(programCd != null && !dto.getProgramCDs().contains(programCd)){
                dto.getProgramCDs().add(programCd);
            }
        }

        return new ArrayList<>(resultMap.values());
    }
}
