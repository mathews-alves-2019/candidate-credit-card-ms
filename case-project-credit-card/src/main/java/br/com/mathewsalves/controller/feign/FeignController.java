package br.com.mathewsalves.controller.feign;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.mathewsalves.dto.CreditCardDTO;
import br.com.mathewsalves.service.impl.CreditCardService;

@RestController
@RequestMapping(value = "/feign")
public class FeignController {

	@Autowired
	private CreditCardService service;

	@GetMapping
	public ResponseEntity<List<CreditCardDTO>> findByCandidateId(@RequestParam int candidateId) {
		var responseData = service.findByCandidateId(candidateId);
		return ResponseEntity.ok(responseData);
	}
}
