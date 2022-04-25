package com.example.testjob.web;

import com.example.testjob.model.dto.SectorDTO;
import com.example.testjob.service.SectorService;
import com.example.testjob.service.UnderSectorOneService;
import com.example.testjob.service.UnderSectorTwoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/sector")
public class SectorController {

    private final SectorService sectorService;
    private final UnderSectorOneService underSectorOneService;
    private final UnderSectorTwoService underSectorTwoService;

    public SectorController(SectorService sectorService, UnderSectorOneService underSectorOneService, UnderSectorTwoService underSectorTwoService) {
        this.sectorService = sectorService;
        this.underSectorOneService = underSectorOneService;
        this.underSectorTwoService = underSectorTwoService;
    }


    @GetMapping(value = "/get")
    public ResponseEntity<Object> getAllSectors() {

        List<SectorDTO> allSectors = this.sectorService
                .getAllSectors();

        return ResponseEntity.ok().body(allSectors);
    }

    @GetMapping(value = "/get/one/{id}")
    public ResponseEntity<Object> getSpecificSectorOne(@PathVariable String id) {

        List<SectorDTO> specificUnderSectorOne = null;
        long resultLong = 0L;
        try {
           resultLong = Long.parseLong(id);
        } catch (NumberFormatException ex){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Please write in Long format !");
        }

        try {
            specificUnderSectorOne = this.sectorService
                    .getSpecificUnderSectorOne(resultLong);

        } catch (UsernameNotFoundException ex){

            return ResponseEntity.status(HttpStatus.CONFLICT).body("Couldn't find Sector one with that ID!");
        }

        return ResponseEntity.ok().body(specificUnderSectorOne);

    }

    @GetMapping(value = "/get/two/{id}")
    public ResponseEntity<Object> getSpecificSectorTwo(@PathVariable String id) {
        List<SectorDTO> specificUnderSectorTwo = null;
        long resultLong = 0L;
        try {
            resultLong = Long.parseLong(id);
        } catch (NumberFormatException ex){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Please write in Long format !");
        }

        try {
            specificUnderSectorTwo = this.underSectorOneService
                    .getSpecificUnderSectorTwo(resultLong);
        } catch (UsernameNotFoundException ex) {

            return ResponseEntity.status(HttpStatus.CONFLICT).body("Couldn't find Sector two with that ID!");
        }

        return ResponseEntity.ok().body(specificUnderSectorTwo);

    }

    @GetMapping(value = "/get/three/{id}")
    public ResponseEntity<Object> getSpecificSectorThree(@PathVariable String id) {
        List<SectorDTO> specificUnderSectorThree = null;
        long resultLong = 0L;
        try {
            resultLong = Long.parseLong(id);
        } catch (NumberFormatException ex){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Please write in Long format !");
        }

        try {
            specificUnderSectorThree = this.underSectorTwoService
                    .getSpecificUnderSectorThree(resultLong);
        } catch (UsernameNotFoundException ex){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Couldn't find Sector two with that ID!");
        }

        return ResponseEntity.ok().body(specificUnderSectorThree);
    }


}
