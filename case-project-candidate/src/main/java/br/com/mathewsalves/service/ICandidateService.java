package br.com.mathewsalves.service;

import br.com.mathewsalves.dto.CandidateDTO;

public interface ICandidateService {

	CandidateDTO save(CandidateDTO u);
	void delete(Integer id);
	CandidateDTO update(CandidateDTO dto, Integer id);
	CandidateDTO findById(Integer id);
	CandidateDTO findByUsername(String username);
	CandidateDTO findByCpf(String cpf);
	CandidateDTO findByEmail(String email);
	CandidateDTO findByEmailAuth(String email);
	CandidateDTO findByUsernameAndPassoword(String username, String password);
}
