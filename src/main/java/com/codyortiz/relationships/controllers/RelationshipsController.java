package com.codyortiz.relationships.controllers;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@RequestMapping(value="/persons/new", method=RequestMethod.POST)
	public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "Home.jsp";
		} else {
			personService.createPerson(person);
			return "redirect:/licenses/new/";
		}
	}

	@RequestMapping("/licenses/new/")
	public String newLicense(Model model,@ModelAttribute("license") License license){
		List<Person> persons = personService.allPersons();
		//System.out.println(Arrays.toString(persons.toArray()));
		model.addAttribute("persons", persons);
		return "License.jsp";
	}
	
	@RequestMapping(value="/licenses/new/", method=RequestMethod.POST)
	public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
		if(result.hasErrors()) {
			return "License.jsp";
		} else {
			licenseService.createLicense(license);
			return "redirect:/persons/new";
		}
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
