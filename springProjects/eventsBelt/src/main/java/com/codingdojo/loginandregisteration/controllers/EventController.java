package com.codingdojo.loginandregisteration.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.loginandregisteration.models.Event;
import com.codingdojo.loginandregisteration.models.State;
import com.codingdojo.loginandregisteration.models.User;
import com.codingdojo.loginandregisteration.services.EventService;
import com.codingdojo.loginandregisteration.services.UserService;

@Controller
@RequestMapping("/events")
public class EventController {
	@Autowired
	private UserService userService;
	@Autowired
	private EventService eventService;

	public Long userSessionId(HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return null;
		} else {
			return (Long) session.getAttribute("userId");
		}
	}

	private String now() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(new Date());
	}

	@RequestMapping("")
	public String home(@ModelAttribute("event") Event event, Model model, HttpSession session) {
		Long userId = userSessionId(session);
		if (userId == null) {
			return "redirect:/";
		} else {
			User user = userService.findUserById(userId);
			model.addAttribute("usersStates", eventService.allEventsWithState(user.getState()));
			model.addAttribute("otherStates", eventService.allEventsNotState(user.getState()));
			model.addAttribute("user", user);
			model.addAttribute("now", now());
			model.addAttribute("states", State.States);
			return "events.jsp";
		}
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String createEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, Model model,
			HttpSession session, @RequestParam Map<String, String> body) {
		if (result.hasErrors()) {
			Long userId = userSessionId(session);
			User user = userService.findUserById(userId);
			model.addAttribute("usersStates", eventService.allEventsWithState(user.getState()));
			model.addAttribute("otherStates", eventService.allEventsNotState(user.getState()));
			model.addAttribute("user", user);
			model.addAttribute("now", now());
			model.addAttribute("states", State.States);
			return "events.jsp";
		} else {
			eventService.createEvent(event);
			return "redirect:/events";
		}
	}

	@RequestMapping("/{id}")
	public String showEvent(@PathVariable("id") Long id, Model model, HttpSession session) {
		Long userId = userSessionId(session);
		Event event = eventService.findById(id);
		if (userId == null) {
			return "redirect:/";
		}
		if (event == null) {
			return "redirect:/events";
		} else {
			model.addAttribute("event", event);
			model.addAttribute("userId", userId);
			return "showEvent.jsp";
		}
	}

	@RequestMapping(value = "/{id}/comment", method = RequestMethod.POST)
	public String createComment(@PathVariable("id") Long id, @RequestParam("comment") String comment,
			RedirectAttributes redi, HttpSession session) {
		Long userId = userSessionId(session);
		if (userId == null) {
			return "redirect:/";
		}
		if (comment.equals("")) {
			redi.addFlashAttribute("error", "Comment input must not be empty");
			return "redirect:/events" + id;
		} else {
			Event event = eventService.findById(id);
			User user = userService.findUserById(userId);
			eventService.comment(comment, user, event);
			return "redirect:/events/" + id;
		}
	}

	@RequestMapping("/{id}/edit")
	public String edit(@PathVariable("id") Long id, HttpSession session, Model model) {
		Long userId = userSessionId(session);
		Event event = eventService.findById(id);
		if (userId == null) {
			return "redirect:/";
		}
		if (event == null || !event.getPlanner().getId().equals(userId)) {
			return "redirect:/events";
		} else {
			model.addAttribute("event", event);
			model.addAttribute("states", State.States);
			model.addAttribute("userId", userId);
			return "edit.jsp";
		}
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("event") Event event,BindingResult result,@PathVariable("id") Long id,HttpSession session,Model model) {
		if(result.hasErrors()) {
			Long userId = userSessionId(session);
			model.addAttribute("event", event);
			model.addAttribute("states", State.States);
			model.addAttribute("userId", userId);
			return "edit.jsp";
		} else {
			eventService.updateEvent(event);
			return "redirect:/events";
		}
	}
	
	@RequestMapping("/{id}/delete")
	public String delete(@PathVariable("id") Long id) {
		eventService.deleteEvent(id);
		return "redirect:/events";
	}
	
	@RequestMapping("/{id}/a/{choice}")
	public String manage(@PathVariable("id") Long id,@PathVariable("choice") String choice,HttpSession session) {
		Long userId = userSessionId(session);
		Event event = eventService.findById(id);
		boolean isJoining = (choice.equals("join"));
		if(userId == null) {
			return "redirect:/";
		} else {
			User user = userService.findUserById(userId);
			eventService.manageAttendees(event, user, isJoining);
			return "redirect:/events";
		}
	}
	
	

}
