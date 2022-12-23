package com.dk.springboot.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.ErrorManager;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class AppExceptionHandler {
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<Object> invalidExceptionHnadler(MethodArgumentNotValidException ex)
	{		
		List<String> errorMessages = new ArrayList<>();
		ex.getFieldErrors().forEach(e-> errorMessages.add(e.getDefaultMessage()));
		return new ResponseEntity<Object>(errorMessages, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
