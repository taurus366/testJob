package com.example.testjob.service;

import com.example.testjob.model.dto.SectorDTO;
import com.example.testjob.model.entity.UnderSectorTwoEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UnderSectorTwoService {

    boolean checkUnderSectorTwoExistsById(Long id);
    List<SectorDTO> getSpecificUnderSectorThree(Long id);
}
