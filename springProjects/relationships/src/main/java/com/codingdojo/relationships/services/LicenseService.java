package com.codingdojo.relationships.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.relationships.models.License;
import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.repositories.LicenseRepository;
import com.codingdojo.relationships.repositories.PersonRepository;

@Service
public class LicenseService {
	private final PersonRepository personRepository;
	private final LicenseRepository licenseRepository;
	
	public LicenseService(PersonRepository personRepository,LicenseRepository licenseRepository) {
		this.personRepository = personRepository;
		this.licenseRepository = licenseRepository;
	}
	
	public Person getPerson(Long id) {
		return personRepository.findById(id).orElse(null);
	}
	
	public List<Person> getAll() {
		return personRepository.findAll();
	}
	
	public Person createPerson(Person b) {
		return personRepository.save(b);
	}
	
	public License createLicense(License l) {
		l.setNumber(this.generateLicenseNumber());
		return licenseRepository.save(l);
	}
	public int generateLicenseNumber() {
		License l = licenseRepository.findTopByOrderByNumberDesc();
		if(l == null)
			return 1;
		int largestNumber = l.getNumber();
		largestNumber++;
		return (largestNumber);
	}
	
	public List<Person> personWithNoLicense() {
		return personRepository.findByLicenseIdIsNull();
	}
}
