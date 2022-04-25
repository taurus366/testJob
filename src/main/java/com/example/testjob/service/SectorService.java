package com.example.testjob.service;

import com.example.testjob.model.dto.SectorDTO;
import com.example.testjob.model.entity.SectorEntity;
import com.example.testjob.model.service.SectorServiceModel;

import java.util.List;

public interface SectorService {

    List<SectorDTO> getAllSectors();
    List<SectorDTO> getSpecificUnderSectorOne(Long id);
//    List<SectorDTO> getSpecificUnderSectorTwo(Long id);
//    List<SectorDTO> getSpecificUnderSectorThree(Long id);
    void addNewSector(SectorEntity sectorEntity);
    boolean checkSectorById(Long id);
}
