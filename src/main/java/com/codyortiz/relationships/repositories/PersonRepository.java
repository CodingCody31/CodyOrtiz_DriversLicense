package com.codyortiz.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codyortiz.relationships.models.Person;

@Repository
public interface PersonRepository extends CrudRepository <Person, Long> {
	
	//Retrieves all persons
	List<Person> findAll();
}
