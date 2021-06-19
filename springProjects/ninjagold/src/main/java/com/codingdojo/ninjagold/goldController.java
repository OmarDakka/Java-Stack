package com.codingdojo.ninjagold;

import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.Random;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class goldController {

	
	@RequestMapping("")
	public String home(HttpSession session) {
		Integer gold = (Integer) session.getAttribute("gold");
		if (gold == null) {
			session.setAttribute("gold",0);
			session.setAttribute("activities", new ArrayList<String>());		}
		return "gold.jsp";
	}
	
	@RequestMapping(value="/process", method=RequestMethod.POST)
    public String processing(@RequestParam(value="building") String building,HttpSession session,Model model) {
        	if (building.equals("farm")) {
            Integer randFarm = getRandomGold(10,5);
            Integer gold = (Integer) session.getAttribute("gold");
			SimpleDateFormat dateFormat = new SimpleDateFormat("E, MMMM d, y 'at' h:mm a");
			String formattedDate = dateFormat.format(new java.util.Date());
    		ArrayList<String> temp_activities = (ArrayList<String>) session.getAttribute("activities");
            session.setAttribute("gold", gold + randFarm);
			temp_activities.add("You earned " + randFarm +" gold from the Farm on " + formattedDate);
			session.setAttribute("activities", temp_activities);
        	} else if (building.equals("cave")) {
        		Integer randCave = getRandomGold(10, 5);
        		Integer gold = (Integer) session.getAttribute("gold");
    			SimpleDateFormat dateFormat = new SimpleDateFormat("E, MMMM d, y 'at' h:mm a");
    			String formattedDate = dateFormat.format(new java.util.Date());
        		ArrayList<String> temp_activities = (ArrayList<String>) session.getAttribute("activities");
        		session.setAttribute("gold", gold+randCave);
    			temp_activities.add("You earned " + randCave +" gold from the Cave on " + formattedDate);
    			session.setAttribute("activities", temp_activities);
        	} else if (building.equals("house")) {
        		Integer randHouse = getRandomGold(5, 2);
        		Integer gold = (Integer) session.getAttribute("gold");
    			SimpleDateFormat dateFormat = new SimpleDateFormat("E, MMMM d, y 'at' h:mm a");
    			String formattedDate = dateFormat.format(new java.util.Date());
        		ArrayList<String> temp_activities = (ArrayList<String>) session.getAttribute("activities");
    			temp_activities.add("You earned " + randHouse +" gold from the House on " + formattedDate);
    			session.setAttribute("activities", temp_activities);
        		session.setAttribute("gold", gold+randHouse);
        	} else if (building.equals("casino")) {
        		Integer randCasino = getRandomGold(50, -50);
        		Integer gold = (Integer) session.getAttribute("gold");
    			SimpleDateFormat dateFormat = new SimpleDateFormat("E, MMMM d, y 'at' h:mm a");
    			String formattedDate = dateFormat.format(new java.util.Date());
        		ArrayList<String> temp_activities = (ArrayList<String>) session.getAttribute("activities");
        		if (randCasino < 0) {
    			temp_activities.add("You lost " + randCasino +" gold from the Casino on " + formattedDate);
        		} else {
        		temp_activities.add("You earned " + randCasino +" gold from the Casino on " + formattedDate);
        		}
        		session.setAttribute("gold", gold+randCasino);
    			session.setAttribute("activities", temp_activities);
        	} else if (building.equals("spa")) {
        		Integer randSpa = getRandomGold(-5, -20);
        		Integer gold = (Integer) session.getAttribute("gold");
        		SimpleDateFormat dateFormat = new SimpleDateFormat("E,MMM d, y 'at' h:mm a");
        		String formattedDate = dateFormat.format(new java.util.Date());
        		ArrayList<String> temp_activities = (ArrayList<String>) session.getAttribute("activities");
        		temp_activities.add("You lost " + randSpa + " gold from the Spa on " + formattedDate);
        		session.setAttribute("activities", temp_activities);
        		session.setAttribute("gold", gold+randSpa);
        	}
        	return "redirect:/";
}
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.removeAttribute("gold");
		session.removeAttribute("activities");
		return "redirect:/";
	}
	
	private Integer getRandomGold(int max,int min) {
		Random rand = new Random();
		int value = rand.nextInt((max-min)+1)+min;
		return value;
	}
}