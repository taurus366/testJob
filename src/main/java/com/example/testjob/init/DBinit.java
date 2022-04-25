package com.example.testjob.init;

import com.example.testjob.model.dto.SectorDTO;

import com.example.testjob.model.entity.SectorEntity;
import com.example.testjob.model.entity.UnderSectorOneEntity;
import com.example.testjob.model.entity.UnderSectorThreeEntity;
import com.example.testjob.model.entity.UnderSectorTwoEntity;
import com.example.testjob.model.service.JsonSectorServiceModel;
import com.example.testjob.repository.SectorRepository;
import com.example.testjob.service.SectorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

@Component
public class DBinit implements CommandLineRunner {

    private final SectorService sectorService;
    private final SectorRepository sectorRepository;

    public DBinit(SectorService sectorService, SectorRepository sectorRepository) {
        this.sectorService = sectorService;
        this.sectorRepository = sectorRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        initSectors();
    }

    private void initSectors() {
        List<SectorDTO> allSectors = this.sectorService
                .getAllSectors();

        if (allSectors.size() > 0) {
            return;
        }

        ObjectMapper mapper = new ObjectMapper();
        Path path = Paths.get("src/main/resources/sectors.json");

        try {
            List<JsonSectorServiceModel> sectors = Arrays.asList(mapper.readValue(path.toFile(), JsonSectorServiceModel[].class));

            sectors
                    .forEach(sector -> {
                        SectorEntity newSector = new SectorEntity();
                        newSector
                                .setName(sector.getName())
                                .setCreated(Instant.now());

                        sector
                                .getChildren()
                                .forEach(sectorOne -> {

                                    UnderSectorOneEntity newUnderSectorOne = new UnderSectorOneEntity();
                                    newUnderSectorOne
                                            .setName(sectorOne.getName())
                                            .setCreated(Instant.now());

                                    sectorOne
                                            .getChildren()
                                            .forEach(sectorTwo -> {

                                                UnderSectorTwoEntity newUnderSectorTwo = new UnderSectorTwoEntity();
                                                newUnderSectorTwo
                                                        .setName(sectorTwo.getName())
                                                        .setCreated(Instant.now());

                                                sectorTwo
                                                        .getChildren()
                                                        .forEach(sectorThree -> {

                                                            UnderSectorThreeEntity newUnderSectorThree = new UnderSectorThreeEntity();
                                                            newUnderSectorThree
                                                                    .setName(sectorThree.getName())
                                                                    .setCreated(Instant.now());

                                                            newUnderSectorTwo
                                                                    .getUnderSectorThreeEntities()
                                                                    .add(newUnderSectorThree);


                                                        });

                                                newUnderSectorOne
                                                        .getUnderSectorTwoEntities()
                                                        .add(newUnderSectorTwo);
                                            });

                                    newSector
                                            .getUnderSectorOneEntities()
                                            .add(newUnderSectorOne);

                                });


                        this.sectorService
                                .addNewSector(newSector);

                    });

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
