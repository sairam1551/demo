package com.example.demo.service;

import com.example.demo.dto.DcIndvCargo;
import com.example.demo.dto.DcIndvRequestDTO;
import com.example.demo.dto.DcIndvResponseDTO;
import com.example.demo.repository.DcIndvRepository;
import com.example.demo.util.DateComparisons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DcIndvService {

    @Autowired
    private DcIndvRepository repository;

    public DcIndvResponseDTO createIndividual(DcIndvRequestDTO request){
        
        validateRequest(request);

        DcIndvCargo cargo = transformRequestToCargo(request);
        
        repository.insertIndividualMaster(cargo);
        
        String indvId = repository.insertIndividualFromCargo(cargo);
        
        return transformCargoToResponse(cargo);
    }
    
    private void validateRequest(DcIndvRequestDTO request){
        if(request.getIndvId() == null || request.getIndvId().isEmpty()){
            throw new IllegalArgumentException("indv_id cannot be null");
        }
        if(request.getCaseNum() == null || request.getCaseNum().isEmpty()){
            throw new IllegalArgumentException(("case_num cannot be null"));
        }
        if(request.getFirstName() == null || request.getFirstName().isEmpty()){
            throw new IllegalArgumentException("first_name cannot be null");
        }
    }
    
    private DcIndvCargo transformRequestToCargo(DcIndvRequestDTO request){
        DcIndvCargo cargo = new DcIndvCargo();
        cargo.setIndvId(request.getIndvId());
        cargo.setCaseNum(request.getCaseNum());
        cargo.setFirstName(request.getFirstName());
        cargo.setHeadOfHouseHold(request.isHeadOfHouseHold());
        cargo.setCreatedAt(DateComparisons.getLocalesTimestamp());
        return cargo;
    }
    
    private DcIndvResponseDTO transformCargoToResponse(DcIndvCargo cargo){
        DcIndvResponseDTO response = new DcIndvResponseDTO();
        response.setIndvId(cargo.getIndvId());
        response.setCreatedAt(cargo.getCreatedAt());
        return response;
    }
}
