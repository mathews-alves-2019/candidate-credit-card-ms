package br.com.mathewsalves.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.mathewsalves.dto.CandidateDTO;
import br.com.mathewsalves.feignclients.CandidateFeignClient;
import br.com.mathewsalves.jwt.JwtUserFactory;

@Service
public class CandidateService implements UserDetailsService {

	@Autowired
	private CandidateFeignClient client;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<CandidateDTO> user = client.findByEmail(username).getBody();

		if (user.isPresent()) {
			return JwtUserFactory.create(user.get());
		}
		
		throw new UsernameNotFoundException("Email não encontrado.");
	}
}
