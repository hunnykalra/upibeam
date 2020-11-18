package com.unibeam.practice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.unibeam.practice.exception.WordNotFoundException;

@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(WordNotFoundException.class)
	public ResponseEntity<Object> wordNotFound(WordNotFoundException wordNotFoundException){
		return new ResponseEntity<Object>(wordNotFoundException.getMessage(),HttpStatus.NOT_FOUND);		
	}
}
