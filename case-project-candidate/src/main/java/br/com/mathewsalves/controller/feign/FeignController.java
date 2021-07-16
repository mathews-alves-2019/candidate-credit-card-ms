package br.com.mathewsalves.controller.feign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.mathewsalves.dto.CandidateDTO;
import br.com.mathewsalves.service.impl.CandidateService;

@RestController
@RequestMapping(value = "/feign")
public class FeignController {

	@Autowired
	private CandidateService service;

	@GetMapping
	public ResponseEntity<CandidateDTO> findByEmail(@RequestParam String email) {
		var responseData = service.findByEmailAuth(email);
		return ResponseEntity.ok(responseData);
	}
}
