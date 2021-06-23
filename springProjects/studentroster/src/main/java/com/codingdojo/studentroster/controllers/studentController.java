package com.codingdojo.studentroster.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.studentroster.models.Contact;
import com.codingdojo.studentroster.models.Student;
import com.codingdojo.studentroster.services.ApiService;

@Controller
public class studentController {
	
	private final ApiService apiService;

	public studentController(ApiService apiService) {
		this.apiService = apiService;
	}
	
	@RequestMapping("/students")
	public String main(Model model) {
		model.addAttribute("show",apiService.allStudents());
		return "index.jsp";
	}
	
	@RequestMapping("/students/new")
	public String newStudent(@ModelAttribute("student")Student student) {
		return "newStudent.jsp";
	}
	
	@RequestMapping(value="/students/new", method= RequestMethod.POST)
	public String createStudent(@Valid @ModelAttribute("student") Student student, BindingResult result) {
		if (result.hasErrors()) {
			return "newStudent.jsp";
		} else {
			apiService.createStudent(student);
			return "redirect:/students";
		}
	}
	
	@RequestMapping("/contacts/new")
	public String newContact(@ModelAttribute("contact")Contact contact,Model model) {
		model.addAttribute("stu",apiService.studentWithContact());
		return "newContact.jsp";
	}
	
	@RequestMapping(value="/contacts/new", method= RequestMethod.POST)
	public String createContact(@Valid @ModelAttribute("contact") Contact contact, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "newContact.jsp";
		} else {
			apiService.createContact(contact);
			return "redirect:/students";
		}
	}
	
}
