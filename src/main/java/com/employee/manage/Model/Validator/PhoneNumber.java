package com.employee.manage.Model.Validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PhoneNumberValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneNumber {
    String message() default "le numéro de téléphone doit commencer par \"032\", \"033\", \"034\" ou \"038\"";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default { };
}
