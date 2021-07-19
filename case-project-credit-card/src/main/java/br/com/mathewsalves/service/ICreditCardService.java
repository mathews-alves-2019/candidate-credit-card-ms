package br.com.mathewsalves.service;

import java.util.List;

import br.com.mathewsalves.dto.CreditCardDTO;

public interface ICreditCardService {

	CreditCardDTO save(CreditCardDTO u);
	void delete(Integer id);
	CreditCardDTO update(CreditCardDTO dto, Integer id);
	CreditCardDTO findById(Integer id);
	List<CreditCardDTO> findByCandidateId(Integer id);
	List<CreditCardDTO> findAll();
}
