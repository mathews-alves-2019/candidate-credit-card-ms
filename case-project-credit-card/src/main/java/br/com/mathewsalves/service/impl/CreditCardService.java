package br.com.mathewsalves.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mathewsalves.dto.CreditCardDTO;
import br.com.mathewsalves.entity.CreditCard;
import br.com.mathewsalves.repository.CreditCardRepository;
import br.com.mathewsalves.service.ICandidateService;
import br.com.mathewsalves.util.CreditCardMapper;

@Service
public class CreditCardService implements ICandidateService{
	
	@Autowired
	private CreditCardRepository repository;

	@Override
	public CreditCardDTO save(CreditCardDTO candidateDTO) {
		return CreditCardMapper.modelToDtoMap(repository.create(CreditCardMapper.dtoToModelMap(candidateDTO)));
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public CreditCardDTO update(CreditCardDTO dto, Integer id) {
		return CreditCardMapper.modelToDtoMap(repository.update(CreditCardMapper.dtoToModelMap(dto)));
	}

	@Override
	public CreditCardDTO findById(Integer id) {
		CreditCard creditCard = repository.findById(id);
		return CreditCardMapper.modelToDtoMap(creditCard);
	}
	
	@Override
	public CreditCardDTO findByCandidateId(Integer candidateId) {
		CreditCard creditCard = repository.findByCandidateId(candidateId);
		return CreditCardMapper.modelToDtoMap(creditCard);
	}

}
