package br.com.mathewsalves.feignclients;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.mathewsalves.dto.CandidateDTO;

@Component
@FeignClient(name="case-project-candidate", path="/feign")
public interface CandidateFeignClient {
	
	@GetMapping
	public ResponseEntity<Optional<CandidateDTO>> findByEmail(@RequestParam String email);

}
