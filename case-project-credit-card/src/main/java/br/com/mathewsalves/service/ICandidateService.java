package br.com.mathewsalves.service;

import br.com.mathewsalves.dto.CreditCardDTO;

public interface ICandidateService {

	CreditCardDTO save(CreditCardDTO u);
	void delete(Integer id);
	CreditCardDTO update(CreditCardDTO dto, Integer id);
	CreditCardDTO findById(Integer id);
	CreditCardDTO findByCandidateId(Integer id);
}
