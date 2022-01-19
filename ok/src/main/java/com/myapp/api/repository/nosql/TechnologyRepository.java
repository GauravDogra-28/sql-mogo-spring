package com.myapp.api.repository.nosql;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.myapp.api.entities.nosql.Details;

public interface TechnologyRepository extends MongoRepository<Details, Integer> {
	
	List<Details> findByUserId(Integer userId);

}
