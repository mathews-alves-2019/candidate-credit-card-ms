package br.com.mathewsalves.controller.creditcard;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mathewsalves.dto.CreditCardDTO;
import br.com.mathewsalves.model.Response;
import br.com.mathewsalves.service.impl.CreditCardService;

@RestController
@RequestMapping(value = "/")
public class CreditCardController {
	
	@Autowired
	private CreditCardService service;
	
	@PostMapping
	public ResponseEntity<Response> create(@Valid @RequestBody CreditCardDTO creditCardDTO, BindingResult result){
		if (result.hasErrors())	{
			List<String> errors = new ArrayList<>();
			result.getAllErrors().forEach(e -> errors.add(e.getDefaultMessage()));
			return ResponseEntity.ok(Response.builder()
									.status(HttpStatus.BAD_REQUEST.value())
									.dateTime(LocalDateTime.now())
									.errors(errors)
									.build());
		}
		
		return ResponseEntity.ok(Response.builder()
				.status(HttpStatus.OK.value())
				.dateTime(LocalDateTime.now())
				.data(service.save(creditCardDTO))
				.build());
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Response> delete(@PathVariable Integer id){

		service.delete(id);

		var response = Response.builder()
				.status(HttpStatus.OK.value())
				.dateTime(LocalDateTime.now())
				.build();
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Response> findById(@PathVariable Integer id) {
		var responseData = service.findById(id);

		 var response = Response.builder()
				 .status(HttpStatus.OK.value())
				 .dateTime(LocalDateTime.now())
				 .data(responseData)
				 .build();

		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value = "/candidate/{candidateId}")
	public ResponseEntity<Response> findByCandidateId(@PathVariable Integer candidateId) {
		var responseData = service.findByCandidateId(candidateId);

		 var response = Response.builder()
				 .status(HttpStatus.OK.value())
				 .dateTime(LocalDateTime.now())
				 .data(responseData)
				 .build();

		return ResponseEntity.ok(response);
	}
	
	@GetMapping
	public ResponseEntity<Response> findAll() {
		 var response = Response.builder()
				 .status(HttpStatus.OK.value())
				 .dateTime(LocalDateTime.now())
				 .data(service.findAll())
				 .build();

		return ResponseEntity.ok(response);
	}
}
