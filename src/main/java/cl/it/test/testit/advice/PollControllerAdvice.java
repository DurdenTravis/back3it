package cl.it.test.testit.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import cl.it.test.testit.controller.exception.BusinessException;

@ControllerAdvice
public class PollControllerAdvice {
	
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<String> handleEmptyInput(BusinessException businessException){
		
		return new ResponseEntity<String>(businessException.getErrorMessage(), HttpStatus.BAD_REQUEST);
	}

}
