package com.example.testjob.model.validator;

import com.example.testjob.service.UnderSectorOneService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UnderSectorOneExistsValidator extends Throwable implements ConstraintValidator<UnderSectorOneExists, Long> {

    private final UnderSectorOneService underSectorOneService;

    public UnderSectorOneExistsValidator(UnderSectorOneService underSectorOneService) {
        this.underSectorOneService = underSectorOneService;
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {

        try {
            return this.underSectorOneService.checkUnderSectorOneExistsById(value);
        } catch (Exception ex) {
            return false;
        }

    }
}
