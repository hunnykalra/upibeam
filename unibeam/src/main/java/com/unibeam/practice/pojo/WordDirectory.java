package com.unibeam.practice.pojo;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "word_directory")
public class WordDirectory {

	private String value;
	
	private Date creationDate;
	
	public WordDirectory() {
		creationDate = new Date();
	}
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	
}
