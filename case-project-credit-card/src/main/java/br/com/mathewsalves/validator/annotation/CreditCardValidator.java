package br.com.mathewsalves.validator.annotation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.mathewsalves.validator.CheckCreditCard;

@Documented
@Retention(RUNTIME)
@Target({ FIELD, ANNOTATION_TYPE })
@Constraint(validatedBy = CheckCreditCard.class)
public @interface CreditCardValidator {

	String message() default "O número do cartão informado não é válido. Verifique se é uma das bandeiras aceitas ou se o formato está correto:"
							+ " Mastercard: XXXX XXXX XXXX XXXX"
							+ " American Express: XXXX XXXXXX XXXXX"
							+ " Visa: XXXX XXXX XXXX XXXX"
							+ " Discover: XXXX XXXX XXXX XXXX"
							+ " JCB: XXXX XXXX XXXX XXXX"
							+ " Diner’s Club: XXXX XXXXXX XXXX"
							+ " Maestro: XXXX XXXX XXXX XXXX"
							+ " Para testar considere gerar um número de cartão no site: https://www.4devs.com.br/gerador_de_numero_cartao_credito";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
