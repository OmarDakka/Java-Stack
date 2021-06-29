package com.codingdojo.loginandregisteration.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.loginandregisteration.models.State;
import com.codingdojo.loginandregisteration.models.User;
import com.codingdojo.loginandregisteration.services.UserService;
import com.codingdojo.loginandregisteration.validation.UserValidate;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserValidate userValidate;
	
	@RequestMapping("/")
	public String home(@ModelAttribute("registration") User user,Model model) {
		model.addAttribute("states", State.States);
		return "home.jsp";
	}
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	public String register(@Valid @ModelAttribute("registration") User user,BindingResult result,HttpSession session) {
		userValidate.validate(user, result);
		if(result.hasErrors()) {
			return "home.jsp";
		} else {
			User newUser = userService.registerUser(user);
			session.setAttribute("userId", newUser.getId());
			return "redirect:/events";
		}
	}
	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public String login(@RequestParam("email") String email,@RequestParam("password") String password,HttpSession session,RedirectAttributes redi) {
		if(userService.authenticateUser(email, password)) {
			User user = userService.findByEmail(email);
			session.setAttribute("userId", user.getId());
			return "redirect:/events";
		} else {
			redi.addFlashAttribute("error", "Invalid Email/Password");
			return "redirect:/";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	
	}
}
