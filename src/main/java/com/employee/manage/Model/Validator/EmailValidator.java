package com.employee.manage.Model.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.employee.manage.Repository.EmailRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EmailValidator implements ConstraintValidator<EmailConstraint, String> {
    private EmailRepository emailRepository;

    @Override
    public void initialize(EmailConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return emailRepository.getByAddress(value) == null;
    }
}
