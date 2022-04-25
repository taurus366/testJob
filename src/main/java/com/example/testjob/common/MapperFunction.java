package com.example.testjob.common;

import com.example.testjob.model.dto.SectorDTO;
import com.example.testjob.model.entity.SectorEntity;
import com.example.testjob.model.entity.UnderSectorOneEntity;
import com.example.testjob.model.entity.UnderSectorTwoEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MapperFunction {

    private final ModelMapper modelMapper;

    public MapperFunction(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }




    public SectorDTO asSectorDTO(Object objectEntity) {

        SectorDTO newSectorDTO = new SectorDTO();


        if (objectEntity instanceof SectorEntity) {

            ((SectorEntity) objectEntity).getUnderSectorOneEntities()
                    .forEach(underSectorOneEntity -> {
                        newSectorDTO
                                .getChildren()
                                .add(modelMapper.map(underSectorOneEntity, SectorDTO.class));
                    });

        } else if (objectEntity instanceof UnderSectorOneEntity) {
            System.out.println("works13");
            ((UnderSectorOneEntity) objectEntity).getUnderSectorTwoEntities()
                    .forEach(underSectorTwoEntity -> {
                        newSectorDTO
                                .getChildren()
                                .add(modelMapper.map(underSectorTwoEntity, SectorDTO.class));
                    });
        } else if (objectEntity instanceof UnderSectorTwoEntity) {
            System.out.println("works14");
            ((UnderSectorTwoEntity) objectEntity).getUnderSectorThreeEntities()
                    .forEach(underSectorThreeEntity -> {
                        newSectorDTO
                                .getChildren()
                                .add(modelMapper.map(underSectorThreeEntity, SectorDTO.class));
                    });
        }


        return newSectorDTO;
    }


}
