package com.example.testjob.model.validator;

import com.example.testjob.service.UnderSectorThreeService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UnderSectorThreeExistsValidator implements ConstraintValidator<UnderSectorThreeExists, Long> {

    private final UnderSectorThreeService underSectorThreeService;

    public UnderSectorThreeExistsValidator(UnderSectorThreeService underSectorThreeService) {
        this.underSectorThreeService = underSectorThreeService;
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {

        try {
            return this.underSectorThreeService.checkUnderSectorThreeExistsById(value);
        } catch (Exception ex) {
            return false;
        }
    }
}
