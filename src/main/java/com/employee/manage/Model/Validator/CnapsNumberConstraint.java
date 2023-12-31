package com.employee.manage.Model.Validator;

import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = CnapsNumberValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CnapsNumberConstraint {
    String message() default "Cnaps number already exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
