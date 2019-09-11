package com.codyortiz.relationships.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codyortiz.relationships.models.License;
import com.codyortiz.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
	private final LicenseRepository licenseRepository;
	
	private static String number = "00000"; 
	private int serverNum = 0;
	
	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}
	
	public List<License> findAll(){
		return (List<License>) licenseRepository.findAll();
	}
	
	public License createLicense(License l) {
		serverNum++;
		number = number + serverNum;
		l.setNumber(number);
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
	
	public void deleteLicense(Long id) {
		licenseRepository.deleteById(id);
	}
}
