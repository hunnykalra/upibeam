package com.unibeam.practice.service;

import java.util.List;

import com.unibeam.practice.pojo.WordDirectory;

public interface WordDirectoryService {

	public void insertWordDirectory(String word);
	
	public List<String> matchWordDirectory(String word);
}
