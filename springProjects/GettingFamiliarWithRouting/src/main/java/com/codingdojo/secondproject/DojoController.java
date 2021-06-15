package com.codingdojo.secondproject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
	@RequestMapping("/{dojo}")
	public String test1(@PathVariable("dojo") String track) {
		return "The " + track + " is awesome";
	}
	@RequestMapping("/{text}//")
	public String test2(@PathVariable("text") String track) {
		if (track.equals("burbank-dojo")) {
			return "Burbank Dojo is located in Southern California";
		}
		else {
			return "SJ dojo is the headquarters";
		}
	}
	
}