package br.com.mathewsalves.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mathewsalves.dto.CandidateDTO;
import br.com.mathewsalves.dto.CreditCardDTO;
import br.com.mathewsalves.entity.Candidate;
import br.com.mathewsalves.exception.BusinessException;
import br.com.mathewsalves.feignclients.CreditCardFeignClient;
import br.com.mathewsalves.repository.ICandidateRepository;
import br.com.mathewsalves.service.ICandidateService;
import br.com.mathewsalves.util.CandidateMapper;
import br.com.mathewsalves.util.MessageEnum;

@Service
public class CandidateService implements ICandidateService {

	@Autowired
	private ICandidateRepository repository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private CreditCardFeignClient client;

	@Override
	public CandidateDTO save(CandidateDTO candidateDTO) {
		candidateDTO.setPassword(passwordEncoder.encode(candidateDTO.getPassword()));
		return CandidateMapper.modelToDtoMap(repository.save(CandidateMapper.dtoToModelMap(candidateDTO)));
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public CandidateDTO update(CandidateDTO dto, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CandidateDTO findById(Integer id) {
		Optional<Candidate> candidate = repository.findById(id);

		if (candidate.isEmpty()) {
			throw new BusinessException(MessageEnum.ENTITY_NOT_FOUND.getValue(), HttpStatus.NOT_FOUND.value());
		}

		List<CreditCardDTO> creditCardDTO = client.findByCandidateId(id).getBody();
		CandidateDTO candidateDTO = CandidateMapper.modelToDtoMap(candidate.get());
		candidateDTO.getCreditCard().addAll(creditCardDTO);

		return candidateDTO;
	}

	@Override
	public CandidateDTO findByUsername(String username) {
		Optional<Candidate> candidate = repository.findByUsername(username);

		if (candidate.isEmpty()) {
			return null;
		}

		List<CreditCardDTO> creditCardDTO = client.findByCandidateId(candidate.get().getId()).getBody();
		CandidateDTO candidateDTO = CandidateMapper.modelToDtoMap(candidate.get());
		candidateDTO.getCreditCard().addAll(creditCardDTO);

		return candidateDTO;
	}

	@Override
	public CandidateDTO findByUsernameAndPassoword(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CandidateDTO findByEmail(String email) {
		Optional<Candidate> candidate = repository.findByEmail(email);

		if (candidate.isEmpty()) {
			return null;
		}

		List<CreditCardDTO> creditCardDTO = client.findByCandidateId(candidate.get().getId()).getBody();
		CandidateDTO candidateDTO = CandidateMapper.modelToDtoMap(candidate.get());
		candidateDTO.getCreditCard().addAll(creditCardDTO);

		return candidateDTO;
	}

	@Override
	public CandidateDTO findByEmailAuth(String emailUsername) {
		Optional<Candidate> candidate = repository.findByEmailOrUsername(emailUsername, emailUsername);

		if (candidate.isEmpty()) {
			return null;
		}

		return CandidateMapper.modelToDtoMap(candidate.get());
	}

	@Override
	public CandidateDTO findByCpf(String cpf) {
		Optional<Candidate> candidate = repository.findByCpf(cpf);

		if (candidate.isEmpty()) {
			return null;
		}

		List<CreditCardDTO> creditCardDTO = client.findByCandidateId(candidate.get().getId()).getBody();
		CandidateDTO candidateDTO = CandidateMapper.modelToDtoMap(candidate.get());
		candidateDTO.getCreditCard().addAll(creditCardDTO);

		return candidateDTO;
	}

	@Override
	@Transactional
	public void deleteByEmail(String email) {
		repository.deleteByEmail(email);
	}

	@Override
	public List<CandidateDTO> findAll() {
		
		List<CandidateDTO> candidates = CandidateMapper.modelListToDtoList(repository.findAll());
		List<CandidateDTO> candidatesResponse = new ArrayList<CandidateDTO>();

		if(!candidatesResponse.isEmpty()) {
			for(CandidateDTO candidate : candidates) {
				List<CreditCardDTO> creditCardDTO = client.findByCandidateId(candidate.getId()).getBody();

				candidate.getCreditCard().addAll(creditCardDTO);
				
				candidatesResponse.add(candidate);
			}
		}
		
		
		return candidatesResponse;
	}

}
