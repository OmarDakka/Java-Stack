package com.codingdojo.studentroster.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.studentroster.models.Contact;
import com.codingdojo.studentroster.models.Student;
import com.codingdojo.studentroster.repositories.ContactRepository;
import com.codingdojo.studentroster.repositories.StudentRepository;

@Service
public class ApiService {
	
	private final ContactRepository contactRepository;
	private final StudentRepository studentRepository;
	
	
	public ApiService(ContactRepository contactRepository, StudentRepository studentRepository) {
		this.contactRepository = contactRepository;
		this.studentRepository = studentRepository;
	}
	
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public Contact createContact(Contact contact) {
		return contactRepository.save(contact);
	}
	
	public List<Student> allStudents(){
		return studentRepository.findAll();
	}
	
	public List<Student> studentWithContact(){
		return studentRepository.findByContactIdIsNull();
	}
	
	public List<Contact> allContacts(){
		return contactRepository.findAll();
	}
	
	
	
	
	
}
