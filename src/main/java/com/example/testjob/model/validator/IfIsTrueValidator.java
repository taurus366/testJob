package com.example.testjob.model.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IfIsTrueValidator implements ConstraintValidator<IfIsTrue,Boolean> {

    @Override
    public boolean isValid(Boolean value, ConstraintValidatorContext context) {
        return value;
    }
}
