package com.codyortiz.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codyortiz.relationships.models.License;

@Repository
public interface LicenseRepository extends CrudRepository <License, Long> {

	//Finds all licenses 
	List<License> findAll();
}
