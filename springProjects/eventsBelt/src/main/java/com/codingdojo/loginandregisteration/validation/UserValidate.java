package com.codingdojo.loginandregisteration.validation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.codingdojo.loginandregisteration.models.User;
import com.codingdojo.loginandregisteration.repositories.UserRepository;

@Component
public class UserValidate implements Validator {
	@Autowired
	private UserRepository userRepository;
	 @Override
	    public boolean supports(Class<?> clazz) {
	        return User.class.equals(clazz);
	    }
	    
	    // 2
	    @Override
	    public void validate(Object target, Errors errors) {
	        User user = (User) target;
	        
	        if(userRepository.findByEmail(user.getEmail()) != null) {
	        	errors.rejectValue("email", "unique");
	        }
	        
	        if (!user.getPasswordConfirmation().equals(user.getPassword())) {
	            // 3
	            errors.rejectValue("passwordConfirmation", "Match");
	        }         
	    }
	}