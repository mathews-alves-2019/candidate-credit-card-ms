package br.com.mathewsalves.validator.annotation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.mathewsalves.validator.CheckCPFValidator;

@Documented
@Retention(RUNTIME)
@Target({ FIELD, ANNOTATION_TYPE })
@Constraint(validatedBy = CheckCPFValidator.class)
public @interface CPFValidator {

	String message() default "O CPF informado é inválido.";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
