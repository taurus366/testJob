package com.example.testjob.model.validator;

import com.example.testjob.service.UnderSectorTwoService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UnderSectorTwoExistsValidator implements ConstraintValidator<UnderSectorTwoExists,Long> {

    private final UnderSectorTwoService underSectorTwoService;

    public UnderSectorTwoExistsValidator(UnderSectorTwoService underSectorTwoService) {
        this.underSectorTwoService = underSectorTwoService;
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {

        try {
        return this.underSectorTwoService.checkUnderSectorTwoExistsById(value);
        } catch (Exception ex){
            return false;
        }
    }
}
