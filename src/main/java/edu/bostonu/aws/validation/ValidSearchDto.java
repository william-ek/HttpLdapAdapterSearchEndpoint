package edu.bostonu.aws.validation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = {SearchDtoValidator.class})
@Target({ TYPE })
@Retention(RUNTIME)
@Documented
public @interface ValidSearchDto {
    String message() default "At least one search attribute must be specified.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
