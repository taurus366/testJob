package com.example.testjob.model.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UnderSectorOneExistsValidator.class)
public @interface UnderSectorOneExists {

    String message() default "UnderSectorOne doesn't exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
