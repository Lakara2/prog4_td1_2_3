package com.employee.manage.Model.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.employee.manage.Repository.CinRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CinNumberValidator implements ConstraintValidator<CinNumberConstraint, String> {
    private CinRepository cinRepository;

    @Override
    public void initialize(CinNumberConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return cinRepository.getByCinNumber(value) == null;
    }
}
