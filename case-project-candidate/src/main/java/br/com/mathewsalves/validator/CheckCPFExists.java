package br.com.mathewsalves.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mathewsalves.service.impl.CandidateService;
import br.com.mathewsalves.validator.annotation.CPFExists;

@Service
public class CheckCPFExists implements ConstraintValidator<CPFExists, String> {
	
	@Autowired
	private CandidateService service;

	@Override
	public void initialize(CPFExists constraintAnnotation) {
	}

	@Override
	public boolean isValid(String cpf, ConstraintValidatorContext constraintValidatorContext) {
		return service.findByCpf(cpf) == null;
	}
}
