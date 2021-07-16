package br.com.mathewsalves.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.mathewsalves.dto.CandidateDTO;
import br.com.mathewsalves.entity.Candidate;
import br.com.mathewsalves.exception.BusinessException;
import br.com.mathewsalves.repository.ICandidateRepository;
import br.com.mathewsalves.service.ICandidateService;
import br.com.mathewsalves.util.CandidateMapper;
import br.com.mathewsalves.util.MessageEnum;

@Service
public class CandidateService implements ICandidateService{
	
	@Autowired
	private ICandidateRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

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
		
		if(candidate.isEmpty()) {
			throw new BusinessException(MessageEnum.ENTITY_NOT_FOUND.getValue(), HttpStatus.NOT_FOUND.value());
		}
		
		return CandidateMapper.modelToDtoMap(candidate.get());
	}

	@Override
	public CandidateDTO findByUsername(String username) {
		Optional<Candidate> candidate = repository.findByUsername(username);

		if(candidate.isEmpty()) {
			return null;
		}
		
		return CandidateMapper.modelToDtoMap(candidate.get());
	}

	@Override
	public CandidateDTO findByUsernameAndPassoword(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CandidateDTO findByEmail(String email) {
		Optional<Candidate> candidate = repository.findByEmail(email);

		if(candidate.isEmpty()) {
			return null;
		}
		
		return CandidateMapper.modelToDtoMap(candidate.get());
	}
	
	@Override
	public CandidateDTO findByEmailAuth(String emailUsername) {
		Optional<Candidate> candidate = repository.findByEmailOrUsername(emailUsername, emailUsername);

		if(candidate.isEmpty()) {
			return null;
		}
		
		return CandidateMapper.modelToDtoMap(candidate.get());
	}

	@Override
	public CandidateDTO findByCpf(String cpf) {
		Optional<Candidate> candidate = repository.findByCpf(cpf);

		if(candidate.isEmpty()) {
			return null;
		}
		
		return CandidateMapper.modelToDtoMap(candidate.get());
	}

}
