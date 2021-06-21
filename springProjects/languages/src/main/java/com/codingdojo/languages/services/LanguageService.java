package com.codingdojo.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	public List<Language> allLanguages() {
		return languageRepository.findAll();
	}
	
	public Language createLanguage(Language b) {
		return languageRepository.save(b);
	}
	
	public Language findLanguage(Long id) {
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		if (optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		} else {
			return null;
		}
	}
	
	public Language updateLanguage(Language  b) {
		return languageRepository.save(b);
	}

	public Language  updateLanguage(Long id, String name,String creator,String currentVersion) {
		Optional<Language > temp = languageRepository.findById(id);
		if(temp != null) {
			temp.get().setName(name);
			temp.get().setCreator(creator);
			temp.get().setCurrentVersion(currentVersion);			
			return temp.get();
		}
		
		return null;
	}
	
	public void deleteLanguage(Long id) {
		languageRepository.deleteById(id);
	}
}
