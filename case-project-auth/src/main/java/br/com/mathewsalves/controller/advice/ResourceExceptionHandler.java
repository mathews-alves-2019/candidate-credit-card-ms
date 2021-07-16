package br.com.mathewsalves.controller.advice;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.mathewsalves.exception.BusinessException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<StandardError> businessException(BusinessException e, HttpServletRequest request){
		StandardError err = new StandardError(e.getStatus(), LocalDateTime.now(), e.getMessage());
		
		return ResponseEntity.status(e.getStatus()).body(err);
	}

}
