package br.com.mathewsalves.service;

import java.util.List;

import br.com.mathewsalves.dto.CandidateDTO;

public interface ICandidateService {

	CandidateDTO save(CandidateDTO u);
	void delete(Integer id);
	void deleteByEmail(String email);
	CandidateDTO update(CandidateDTO dto, Integer id);
	CandidateDTO findById(Integer id);
	CandidateDTO findByUsername(String username);
	CandidateDTO findByCpf(String cpf);
	CandidateDTO findByEmail(String email);
	CandidateDTO findByEmailAuth(String email);
	CandidateDTO findByUsernameAndPassoword(String username, String password);
	List<CandidateDTO> findAll();
}
