package br.com.mathewsalves.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.mathewsalves.validator.annotation.CreditCardValidator;

public class CheckCreditCard implements ConstraintValidator<CreditCardValidator, String> {

	@Override
	public void initialize(CreditCardValidator constraintAnnotation) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

		  var validateValue = value.replaceAll("[^0-9]", "");
		  var sum = 0;
		  var shouldDouble = false;
		  
		  for (var i = validateValue.length() - 1; i >= 0; i--) {
		    var digit = Character.getNumericValue(validateValue.charAt(i));
		    
		    if (shouldDouble) {
		      if ((digit *= 2) > 9) digit -= 9;
		    }

		    sum += digit;
		    shouldDouble = !shouldDouble;
		  }
		  return (sum % 10) == 0;
	}
}
