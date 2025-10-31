package com.example.demo.service;

import com.example.demo.dto.DcIndvCargo;
import com.example.demo.dto.DcIndvRequestDTO;
import com.example.demo.dto.DcIndvResponseDTO;
import com.example.demo.repository.DcCaseRepository;
import com.example.demo.repository.DcIndvRepository;
import com.example.demo.repository.DcProgramEnrollmentRepository;
import com.example.demo.util.DateComparisons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DcIndvService {

    @Autowired
    private DcIndvRepository repository;

    @Autowired
    private DcCaseRepository caseRepository;

    @Autowired
    private DcProgramEnrollmentRepository enrollmentRepository;

    public DcIndvResponseDTO createIndividual(DcIndvRequestDTO request) {

        validateRequest(request);


        if (!caseRepository.existsByCaseNum(request.getCaseNum())) {
            caseRepository.insertCase(request.getCaseNum(), request.isHeadOfHouseHold());

            for (String programCd : request.getProgramCDs()) {
                enrollmentRepository.insertProgramEnrollment(request.getCaseNum(), programCd);
            }
        }

        DcIndvCargo cargo = transformRequestToCargo(request);

        repository.insertIndividualMaster(cargo);
        repository.insertIndividualFromCargo(cargo);

        return transformCargoToResponse(cargo);
    }

    private void validateRequest(DcIndvRequestDTO request) {
        if (request.getIndvId() == null || request.getIndvId().isEmpty()) {
            throw new IllegalArgumentException("indv_id cannot be null");
        }
        if (request.getCaseNum() == null || request.getCaseNum().isEmpty()) {
            throw new IllegalArgumentException("case_num cannot be null");
        }
        if (request.getFirstName() == null || request.getFirstName().isEmpty()) {
            throw new IllegalArgumentException("first_name cannot be null");
        }
    }

    private DcIndvCargo transformRequestToCargo(DcIndvRequestDTO request) {
        DcIndvCargo cargo = new DcIndvCargo();
        cargo.setIndvId(request.getIndvId());
        cargo.setCaseNum(request.getCaseNum());
        cargo.setFirstName(request.getFirstName());
        cargo.setHeadOfHouseHold(request.isHeadOfHouseHold());
        cargo.setCreatedAt(DateComparisons.getLocalesTimestamp());
        return cargo;
    }

    private DcIndvResponseDTO transformCargoToResponse(DcIndvCargo cargo) {
        return new DcIndvResponseDTO(cargo.getIndvId(), cargo.getCreatedAt());
    }
}