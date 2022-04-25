package com.example.testjob.service.Impl;

import com.example.testjob.common.MapperFunction;
import com.example.testjob.model.dto.SectorDTO;
import com.example.testjob.model.entity.UnderSectorOneEntity;
import com.example.testjob.repository.UnderSectorOneRepository;
import com.example.testjob.service.UnderSectorOneService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnderSectorOneServiceImpl implements UnderSectorOneService {

    private final UnderSectorOneRepository underSectorOneRepository;
    private final MapperFunction mapperFunction;

    public UnderSectorOneServiceImpl(UnderSectorOneRepository underSectorOneRepository, MapperFunction mapperFunction) {
        this.underSectorOneRepository = underSectorOneRepository;
        this.mapperFunction = mapperFunction;
    }

    @Override
    public boolean checkUnderSectorOneExistsById(Long id) {

        UnderSectorOneEntity referenceById = this.underSectorOneRepository
                .getById(id);

        return referenceById.getName() != null;
    }

    @Override
    public List<SectorDTO> getSpecificUnderSectorTwo(Long id) {
        UnderSectorOneEntity underSectorOneEntity = this.underSectorOneRepository
                .findByIdGraph(id).orElseThrow(() -> new UsernameNotFoundException("Doesn't exists in DB"));
        return mapperFunction.asSectorDTO(underSectorOneEntity).getChildren();
    }
}
