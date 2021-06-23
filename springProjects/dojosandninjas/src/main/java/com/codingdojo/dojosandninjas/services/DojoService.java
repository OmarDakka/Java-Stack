package com.codingdojo.dojosandninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.dojosandninjas.models.Dojo;
import com.codingdojo.dojosandninjas.models.Ninja;
import com.codingdojo.dojosandninjas.repositories.DojoRepository;
import com.codingdojo.dojosandninjas.repositories.NinjaRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepository;
	private final NinjaRepository ninjaRepository;
	
	public DojoService(DojoRepository dojoRepository, NinjaRepository ninjaRepository) {
		this.dojoRepository = dojoRepository;
		this.ninjaRepository = ninjaRepository;
	}
	
	public Dojo getDojo(Long id) {
		return dojoRepository.findById(id).orElse(null);
	}
	
	public List<Dojo> allDojos(){
		return dojoRepository.findAll();
	}
	
	public List<Ninja> allNinjas(){
		return ninjaRepository.findAll();
	}

	public Dojo createDojo(Dojo b) {
		return dojoRepository.save(b);
		
	}
	
	public Ninja createNinja(Ninja b) {
		return ninjaRepository.save(b);
	}
	
	
}
