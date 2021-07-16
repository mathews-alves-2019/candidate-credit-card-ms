package br.com.mathewsalves.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mathewsalves.service.impl.CandidateService;
import br.com.mathewsalves.validator.annotation.UsernameExists;

@Service
public class CheckUsernameExists implements ConstraintValidator<UsernameExists, String> {
	
	@Autowired
	private CandidateService service;

	@Override
	public void initialize(UsernameExists constraintAnnotation) {
	}

	@Override
	public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
		return service.findByUsername(username) == null;
	}
}
