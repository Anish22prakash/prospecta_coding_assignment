package com.prospecta.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class globalException {
	
	@ExceptionHandler(notFoundException.class)
	public ResponseEntity<myErrorDetails> notFoundExceptionHandler(notFoundException nfe, WebRequest req){
	      
		myErrorDetails err= new myErrorDetails();
		err.setTstamp(LocalDateTime.now());
		err.setMessage(nfe.getMessage());
		err.setDescription(req.getDescription(false));
		
		return new ResponseEntity<myErrorDetails>(err,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(saveException.class)
	public ResponseEntity<myErrorDetails> saveExceptionHandler(saveException se, WebRequest req){
	      
		myErrorDetails err= new myErrorDetails();
		err.setTstamp(LocalDateTime.now());
		err.setMessage(se.getMessage());
		err.setDescription(req.getDescription(false));
		
		return new ResponseEntity<myErrorDetails>(err,HttpStatus.NOT_FOUND);
	} 
	
	

}
