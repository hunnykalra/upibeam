package com.unibeam.practice.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unibeam.practice.exception.WordNotFoundException;
import com.unibeam.practice.pojo.WordDirectory;
import com.unibeam.practice.repo.WordDrectoryRepository;

@Service
public class WordDirectoryServiceImpl implements WordDirectoryService{
	
	@Autowired
	WordDrectoryRepository wordDrectoryRepository;

	@Override
	public void insertWordDirectory(String word) {
		WordDirectory wordDirectory  = new WordDirectory();
		wordDirectory.setValue(word);
		wordDrectoryRepository.insert(wordDirectory);		
	}

	@Override
	public List<String> matchWordDirectory(String word) {
		List<WordDirectory> wordDirectories = wordDrectoryRepository.findCustomByRegExValue(word);		
		if(wordDirectories.size()==0) {
			throw new WordNotFoundException("word not found");
		}
		return getThreeMaxScoreWords(wordDirectories);
	}
	
	private int getScore(String word) {
		int score = 0;
		for (char c : word.toCharArray())
			score += c;
		return score;
	}

	private List<String> getThreeMaxScoreWords(List<WordDirectory> wordDirectories) {	
		PriorityQueue<WordDirectory> priorityQueue = new PriorityQueue<WordDirectory>(new Comparator<WordDirectory>() {
			@Override
			public int compare(WordDirectory wd1, WordDirectory wd2) {
				return getScore(wd2.getValue()) - getScore(wd1.getValue());
			}
		});
		wordDirectories.forEach(wordDirectory -> priorityQueue.add(wordDirectory));
		List<String> res = new ArrayList<String>();
		res.add(priorityQueue.poll().getValue());
		res.add(priorityQueue.poll().getValue());
		res.add(priorityQueue.poll().getValue());
		return res;
	}

	
	
}
