package com.employee.manage.Model.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {
    @Override
    public void initialize(PhoneNumber constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value != null && (value.startsWith("032") || value.startsWith("033") || value.startsWith("034") || value.startsWith("038"))) {
            return value.matches("\\d{10}");
        }
        return false;
    }
}
