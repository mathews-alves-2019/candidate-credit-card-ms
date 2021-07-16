package br.com.mathewsalves.validator.annotation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.mathewsalves.validator.CheckEmailExists;

@Documented
@Retention(RUNTIME)
@Target({ FIELD, ANNOTATION_TYPE })
@Constraint(validatedBy = CheckEmailExists.class)
public @interface EmailExists {

	String message() default "O email informado já existe.";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
