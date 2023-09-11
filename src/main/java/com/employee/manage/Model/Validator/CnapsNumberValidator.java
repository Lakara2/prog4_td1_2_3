package com.employee.manage.Model.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.employee.manage.Repository.EmployeeRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CnapsNumberValidator implements ConstraintValidator<CnapsNumberConstraint, String> {
    private EmployeeRepository employeeRepository;
    @Override
    public void initialize(CnapsNumberConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return employeeRepository.getByCnapsNum(value) == null;
    }
}
