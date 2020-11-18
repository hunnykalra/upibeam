package com.unibeam.practice.endpointImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.unibeam.practice.endpoints.WordSearchRestPoint;
import com.unibeam.practice.service.WordDirectoryServiceImpl;

@Component
public class WordSearchRestImpl implements WordSearchRestPoint {
	@Autowired
	WordDirectoryServiceImpl wordDirectoryServiceImpl;

	@Override
	public ResponseEntity<Object> insertWord(String word) {
		wordDirectoryServiceImpl.insertWordDirectory(word);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> matchWord(String word) {
		List<String> words = wordDirectoryServiceImpl.matchWordDirectory(word);
		Map<String, Object> map  = new HashMap<String, Object>();
		map.put("query", word);
		map.put("match", words);
		return new ResponseEntity<Object>(map, HttpStatus.OK);
	}

}
