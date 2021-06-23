package com.codingdojo.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.dojosandninjas.models.Dojo;
import com.codingdojo.dojosandninjas.models.Ninja;
import com.codingdojo.dojosandninjas.services.DojoService;

@Controller
public class DojoController {
	private final DojoService dojoService;
	
	
	public DojoController(DojoService dojoService) {
		this.dojoService = dojoService;
	}
	
	@RequestMapping("/ninjas")
	public String show(Model model) {
		List<Ninja> ninja = dojoService.allNinjas();
		model.addAttribute("ninjas", ninja);
		return "show.jsp";
	}

	@RequestMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "newDojo.jsp";
	}
	
	@RequestMapping(value="/dojos/new", method=RequestMethod.POST)
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "newDojo.jsp";
		} else {
			dojoService.createDojo(dojo);
			return "redirect:/ninjas/new";
		}
	}
	
	@RequestMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja,Model model) {
		model.addAttribute("dojos", dojoService.allDojos());
		return "newNinja.jsp";
	}
	
	@RequestMapping(value="/ninjas/new",method=RequestMethod.POST)
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja,BindingResult result) {
		if (result.hasErrors()) {
			return "newNinja.jsp";
		} else {
			dojoService.createNinja(ninja);
			return "redirect:/ninjas";
		}
	}
	
	@RequestMapping("dojos/{id}")
	public String dojoShow(@PathVariable("id") Long id,Model model) {
		model.addAttribute("dojo", dojoService.getDojo(id));
		model.addAttribute("ninjas", dojoService.getDojo(id).getNinjas());
		return "dojoShow.jsp";
	}
	
	
}
