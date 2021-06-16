package com.codingdojo.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Counter {
	
	@RequestMapping("")
	public String home(HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
		if (count == null ) {
			session.setAttribute("count", 1);
			
		} else {
			count++;
			session.setAttribute("count", count);
		}
		return "home.jsp";
	}
	
	@RequestMapping("/counter")
	public String count(HttpSession session) {
		session.getAttribute("count");
		return "count.jsp";
		
	}
	
	@RequestMapping("/three")
	public String three(HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
		if (count == null ) {
			session.setAttribute("count", 1);
			
		} else {
			count+=2;
			session.setAttribute("count", count);
		}
		return "three.jsp";
	}
	
	@RequestMapping("/clear")
	public String clear(HttpSession session) {
		session.removeAttribute("count");
		return "redirect:/";
	}
}
