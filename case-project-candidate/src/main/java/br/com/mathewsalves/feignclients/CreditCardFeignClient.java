package br.com.mathewsalves.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.mathewsalves.dto.CreditCardDTO;

@Component
@FeignClient(name="case-project-credit-card", path="/feign")
public interface CreditCardFeignClient {
	
	@GetMapping
	public ResponseEntity<List<CreditCardDTO>> findByCandidateId(@RequestParam int candidateId	);

}
