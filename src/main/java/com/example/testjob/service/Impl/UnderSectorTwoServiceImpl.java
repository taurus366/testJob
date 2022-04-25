package com.example.testjob.service.Impl;

import com.example.testjob.common.MapperFunction;
import com.example.testjob.model.dto.SectorDTO;
import com.example.testjob.model.entity.UnderSectorTwoEntity;
import com.example.testjob.repository.UnderSectorTwoRepository;
import com.example.testjob.service.UnderSectorTwoService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnderSectorTwoServiceImpl implements UnderSectorTwoService {

    private final UnderSectorTwoRepository underSectorTwoRepository;
    private final MapperFunction mapperFunction;

    public UnderSectorTwoServiceImpl(UnderSectorTwoRepository underSectorTwoRepository, MapperFunction mapperFunction) {
        this.underSectorTwoRepository = underSectorTwoRepository;
        this.mapperFunction = mapperFunction;
    }

    @Override
    public boolean checkUnderSectorTwoExistsById(Long id) {

        UnderSectorTwoEntity referenceById = this.underSectorTwoRepository
                .getById(id);

        return referenceById.getName() != null;
    }

    @Override
    public List<SectorDTO> getSpecificUnderSectorThree(Long id) {

        UnderSectorTwoEntity underSectorTwoEntity = this.underSectorTwoRepository
                .findByIdGraph(id).orElseThrow( () -> new UsernameNotFoundException("Doesn't exists in DB"));


        return mapperFunction.asSectorDTO(underSectorTwoEntity).getChildren();
    }
}
