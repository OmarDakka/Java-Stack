package com.codingdojo.loginandregisteration.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.loginandregisteration.models.Comment;
import com.codingdojo.loginandregisteration.models.Event;
import com.codingdojo.loginandregisteration.models.User;
import com.codingdojo.loginandregisteration.repositories.CommentRepository;
import com.codingdojo.loginandregisteration.repositories.EventRepository;

@Service
public class EventService {
	
	@Autowired
	private EventRepository eventRepository;
	@Autowired
	private CommentRepository commentRepository;
	
	public List<Event> allEventsWithState(String state) {
		return eventRepository.findByState(state);
	}
	
	public List<Event> allEventsNotState(String state) {
		return eventRepository.findByStateIsNot(state);
	}
	
	public Event findById(Long id) {
		return eventRepository.findById(id).orElse(null);
	}
	
	public Event createEvent(Event event) {
		return eventRepository.save(event);
	}
	
	public Event updateEvent(Event event) {
		return eventRepository.save(event);
	}
	
	public void comment(String content,User author,Event event) {
		commentRepository.save(new Comment(content,author,event));
	}
	
	public void deleteEvent(Long id) {
		eventRepository.deleteById(id);
	}
	
	public void manageAttendees(Event event, User user, boolean isJoining) {
		if(isJoining) {
			event.getAttendees().add(user);
		} else {
			event.getAttendees().remove(user);
		}
		eventRepository.save(event);
	}
}
