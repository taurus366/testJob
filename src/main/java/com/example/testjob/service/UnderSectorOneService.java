package com.example.testjob.service;

import com.example.testjob.model.dto.SectorDTO;

import java.util.List;

public interface UnderSectorOneService {

    boolean checkUnderSectorOneExistsById(Long id);
    List<SectorDTO> getSpecificUnderSectorTwo(Long id);
}
