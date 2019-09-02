package com.codyortiz.relationships.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codyortiz.relationships.models.License;
import com.codyortiz.relationships.models.Person;
import com.codyortiz.relationships.services.LicenseService;
import com.codyortiz.relationships.services.PersonService;

@Controller
public class RelationshipsController {
	
	private final PersonService personService;
	private final LicenseService licenseService; 
	
	public RelationshipsController(PersonService personService, LicenseService licenseService) {
		this.personService = personService;
		this.licenseService = licenseService;
	}
	
	@RequestMapping("/persons/new")
	public String newPerson(@ModelAttribute("person") Person person) {
		return "Home.jsp";
	}

	@RequestMapping("/licenses/new")
	public String newLicense(Model model,@ModelAttribute("license")License license){
		List<Person> persons = personService.allPersons();
		model.addAttribute("persons", persons);
		return "License.jsp";
	}
	
	@RequestMapping("/persons/{id}")
	public String showPerson(@PathVariable("id") Long id, Model model) {
		Person person = personService.findPerson(id);
		License license = licenseService.findLicense(id);
		model.addAttribute("person", person);
		model.addAttribute("license", license);
		return "Show.jsp";
	}
}
