package br.com.mathewsalves.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mathewsalves.dto.CreditCardDTO;
import br.com.mathewsalves.entity.CreditCard;
import br.com.mathewsalves.repository.CreditCardRepository;
import br.com.mathewsalves.service.ICreditCardService;
import br.com.mathewsalves.util.CreditCardMapper;

@Service
public class CreditCardService implements ICreditCardService{
	
	@Autowired
	private CreditCardRepository repository;
	@Autowired
	private CreditCardValidatorService validatorService;

	@Override
	public CreditCardDTO save(CreditCardDTO candidateDTO) {
		CreditCard creditCardEntity = CreditCardMapper.dtoToModelMap(candidateDTO);
		creditCardEntity.setCreditCardBrand(validatorService.checkSupported(creditCardEntity.getCardNumber()));
		return CreditCardMapper.modelToDtoMap(repository.create(creditCardEntity));
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
	public List<CreditCardDTO> findByCandidateId(Integer candidateId) {
		List<CreditCard> creditCard = repository.findByCandidateId(candidateId);
		return CreditCardMapper.modelListToDtoList(creditCard);
	}

	@Override
	public List<CreditCardDTO> findAll() {
		return CreditCardMapper.modelListToDtoList(repository.findAll());
	}

}
