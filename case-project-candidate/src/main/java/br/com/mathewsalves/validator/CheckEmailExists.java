package br.com.mathewsalves.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mathewsalves.service.impl.CandidateService;
import br.com.mathewsalves.validator.annotation.EmailExists;

@Service
public class CheckEmailExists implements ConstraintValidator<EmailExists, String> {
	
	@Autowired
	private CandidateService service;

	@Override
	public void initialize(EmailExists constraintAnnotation) {
	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
		return service.findByEmail(email) == null;
	}
}
