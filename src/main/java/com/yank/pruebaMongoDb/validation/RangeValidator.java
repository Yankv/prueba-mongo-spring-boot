package com.yank.pruebaMongoDb.validation;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RangeValidator implements ConstraintValidator<ValidRange, Object> {
    private String minField;
    private String maxField;
    private String message;

    @Override
    public void initialize(ValidRange annotation) {
        this.minField = annotation.minField();
        this.maxField = annotation.maxField();
        this.message = annotation.message();
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        if (obj == null)
            return true;

        BeanWrapper wrapper = new BeanWrapperImpl(obj);
        Object minValue = wrapper.getPropertyValue(minField);
        Object maxValue = wrapper.getPropertyValue(maxField);

        if (minValue == null || maxValue == null)
            return true;

        if (!(minValue instanceof Comparable) || !(maxValue instanceof Comparable)) {
            throw new IllegalArgumentException(
                    "The '%s' and '%s' fields must implemet Comparable"
                            .formatted(minField, maxField));
        }

        boolean valid = ((Comparable<Object>) minValue).compareTo(maxValue) <= 0;

        if (!valid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode(minField)
                    .addConstraintViolation();
        }

        return valid;
    }

}
