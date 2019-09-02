package com.codyortiz.relationships.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codyortiz.relationships.models.License;
import com.codyortiz.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
	private final LicenseRepository licenseRepository;
	
	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}
	
	public List<License> findAll(){
		return (List<License>) licenseRepository.findAll();
	}
	
	public License createLicense(License l) {
		return licenseRepository.save(l);
	}
	
	public License findLicense(Long id) {
		Optional<License> optionalLicense = licenseRepository.findById(id);
		if(optionalLicense.isPresent()) {
			return optionalLicense.get();
		} else {
			return null;
		}
	}
	
	public License addLicense(License l) {
		return licenseRepository.save(l);
	}
	
	public void deleteLicense(Long id) {
		licenseRepository.deleteById(id);
	}
}
