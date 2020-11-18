package com.unibeam.practice.endpoints;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api")
public interface WordSearchRestPoint {

	@PostMapping(value = "/insert/{word}")
	ResponseEntity<Object> insertWord(@PathVariable("word") String word);
	
	@GetMapping(value = "/match/{word}")
	ResponseEntity<Object> matchWord(@PathVariable("word") String word);

	
}
