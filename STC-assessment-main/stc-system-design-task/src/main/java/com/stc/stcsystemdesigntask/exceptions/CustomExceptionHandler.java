package com.stc.stcsystemdesigntask.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	
	// my custom exception when find entity by id and not found
	@ExceptionHandler(AccessFileException.class)
	protected ResponseEntity<Object> handleFileNotAccessableException(AccessFileException ex) {
		AppErrorResponse apiError = new AppErrorResponse(HttpStatus.FORBIDDEN);
		apiError.setMessage(ex.getMessage());
		return buildResponseEntity(apiError);
	}
	
	
	@ExceptionHandler(AppException.class)
	protected ResponseEntity<Object> handleEntityNotFound(AppException ex) {
		AppErrorResponse apiError = new AppErrorResponse(HttpStatus.BAD_REQUEST);
		apiError.setMessage(ex.getMessage());
		return buildResponseEntity(apiError);
	}
  
	    
	   
	
	
	private ResponseEntity<Object> buildResponseEntity(AppErrorResponse AppErrorResponse) {
		return new ResponseEntity<>(AppErrorResponse, AppErrorResponse.getStatus());
	}
}