package com.example.testjob.service.Impl;

import com.example.testjob.common.MapperFunction;
import com.example.testjob.model.dto.SectorDTO;
import com.example.testjob.model.entity.SectorEntity;
import com.example.testjob.model.entity.UnderSectorTwoEntity;
import com.example.testjob.repository.UnderSectorOneRepository;
import com.example.testjob.repository.UnderSectorTwoRepository;
import com.example.testjob.service.SectorService;
import com.example.testjob.repository.SectorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SerctorServiceImpl implements SectorService {

    private final SectorRepository sectorRepository;
    private final ModelMapper modelMapper;
    private final UnderSectorOneRepository underSectorOneRepository;
    private final UnderSectorTwoRepository underSectorTwoRepository;
    private final MapperFunction mapperFunction;


    public SerctorServiceImpl(SectorRepository sectorRepository, ModelMapper modelMapper, UnderSectorOneRepository underSectorOneRepository, UnderSectorTwoRepository underSectorTwoRepository, MapperFunction mapperFunction) {
        this.sectorRepository = sectorRepository;
        this.modelMapper = modelMapper;
        this.underSectorOneRepository = underSectorOneRepository;
        this.underSectorTwoRepository = underSectorTwoRepository;
        this.mapperFunction = mapperFunction;
    }


    @Override
    public List<SectorDTO> getAllSectors() {

        return this.sectorRepository
                .findAll().stream()
                .map(sectorEntity -> modelMapper.map(sectorEntity,SectorDTO.class))
                .collect(Collectors.toList());
    }

    //    GET SECTOR CHILDREN NAME
    @Override
    public List<SectorDTO> getSpecificUnderSectorOne(Long id) {

        SectorEntity byName = this.sectorRepository
                .findByIdGraph(id).orElseThrow(() -> new UsernameNotFoundException("Doesn't exists in DB"));
        System.out.println(byName.getUnderSectorOneEntities().size());
        return mapperFunction.asSectorDTO(byName).getChildren();
    }



    @Override
    public void addNewSector(SectorEntity sectorEntity) {

        this.sectorRepository
                .save(sectorEntity);
    }

    @Override
    public boolean checkSectorById(Long id) {

        SectorEntity referenceById = this.sectorRepository
                .getById(id);



        return referenceById.getName() != null;
    }

//    private SectorDTO asSectorDTO(Object obj) {
//
//        SectorDTO newSectorDTO = new SectorDTO();
//
//
//        if (obj instanceof SectorEntity) {
//
//            ((SectorEntity) obj).getUnderSectorOneEntities()
//                    .forEach(underSectorOneEntity -> {
//                        newSectorDTO
//                                .getChildren()
//                                .add(modelMapper.map(underSectorOneEntity, SectorDTO.class));
//                    });
//
//        } else if (obj instanceof UnderSectorOneEntity) {
//            System.out.println("works13");
//            ((UnderSectorOneEntity) obj).getUnderSectorTwoEntities()
//                    .forEach(underSectorTwoEntity -> {
//                        newSectorDTO
//                                .getChildren()
//                                .add(modelMapper.map(underSectorTwoEntity, SectorDTO.class));
//                    });
//        } else if (obj instanceof UnderSectorTwoEntity) {
//            System.out.println("works14");
//            ((UnderSectorTwoEntity) obj).getUnderSectorThreeEntities()
//                    .forEach(underSectorThreeEntity -> {
//                        newSectorDTO
//                                .getChildren()
//                                .add(modelMapper.map(underSectorThreeEntity, SectorDTO.class));
//                    });
//        }
//
//
//        return newSectorDTO;
//    }
}
