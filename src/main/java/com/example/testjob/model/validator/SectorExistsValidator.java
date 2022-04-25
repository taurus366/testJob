package com.example.testjob.model.validator;

import com.example.testjob.service.SectorService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SectorExistsValidator implements ConstraintValidator<SectorExists, Long> {

    private final SectorService sectorService;

    public SectorExistsValidator(SectorService sectorService) {
        this.sectorService = sectorService;
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {

        try {
            return this.sectorService.checkSectorById(value);
        } catch (Exception ex) {
            return false;
        }
    }
}
