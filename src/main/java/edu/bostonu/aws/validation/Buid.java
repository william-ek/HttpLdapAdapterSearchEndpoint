package edu.bostonu.aws.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = BuidValidator.class)
@Documented
public @interface Buid {

  String message() default "{BUID is invalid}";   /*TODO use a message source */

  Class<?>[] groups() default { };

  Class<? extends Payload>[] payload() default { };

}
