package com.unibeam.practice.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.unibeam.practice.pojo.WordDirectory;

@Repository
public interface WordDrectoryRepository extends MongoRepository<WordDirectory, String> {

	@Query("{value: { $regex: ?0 } })")
	List<WordDirectory> findCustomByRegExValue(String value);

}
