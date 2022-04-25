package com.example.testjob.model.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IfIsTrueValidator.class)
public @interface IfIsTrue {

    String message() default "User should accept the rules";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
