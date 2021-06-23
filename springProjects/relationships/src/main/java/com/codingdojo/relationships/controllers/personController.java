package com.codingdojo.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.relationships.models.License;
import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.services.LicenseService;

@Controller
public class personController {
	private final LicenseService licenseService;

	public personController(LicenseService licenseService) {
		this.licenseService = licenseService;
	}
	
	@RequestMapping("/")
	public String Index(Model model) {
		List<Person> people = licenseService.getAll();
		model.addAttribute("persons", people);
		return "index.jsp";
	}
	
	@RequestMapping("/persons/new")
	public String newPerson(@ModelAttribute("person") Person person) {
		return "newPerson.jsp";
	}
	
	@RequestMapping(value="/persons/new", method= RequestMethod.POST)
	public String createPerson(@Valid @ModelAttribute("person") Person person,BindingResult result){
		if (result.hasErrors()) {
			return "newPerson.jsp";
		} else {
			licenseService.createPerson(person);
			return "redirect:/licenses/new";
		}
	}
	
	@RequestMapping("/licenses/new")
	public String newLicense(@ModelAttribute("license") License license,Model model) {
		model.addAttribute("noLicense", licenseService.personWithNoLicense());
		return "newLicense.jsp";
	}
	
	@RequestMapping(value="/licenses/new", method= RequestMethod.POST)
	public String createLicense(@Valid @ModelAttribute("license") License license,BindingResult result,Model model) {
		if (result.hasErrors()) {
			return "newLicense.jsp";
		} else {
			licenseService.createLicense(license);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/persons/{id}")
	public String showPerson(@PathVariable("id") Long id,Model model) {
		model.addAttribute("person",licenseService.getPerson(id));
		return "show.jsp";
	}

}	
