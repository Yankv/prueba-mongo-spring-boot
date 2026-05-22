package com.yank.pruebaMongoDb.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

/**
 * Custom annotation for validating that a specified minimum field is less than
 * or equal to a maximum field.
 * Can be applied to any class containing the specified fields.
 */
@Constraint(validatedBy = RangeValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidRange {
    String message() default "Invalid range";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String minField();

    String maxField();
}
