package br.com.mathewsalves.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mathewsalves.entity.Candidate;

public interface ICandidateRepository extends JpaRepository<Candidate, Integer> {

	Optional<Candidate> findByUsername(String username);
    Optional<Candidate> findByEmailOrUsername(String email, String username);
    Optional<Candidate> findByEmail(String email);
    Optional<Candidate> findByCpf(String cpf);
    Optional<Candidate> findByUsernameAndPassword(String username, String password);
}
