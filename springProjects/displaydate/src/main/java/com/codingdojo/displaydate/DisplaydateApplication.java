package com.codingdojo.displaydate;

import java.text.SimpleDateFormat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class DisplaydateApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisplaydateApplication.class, args);
	}
	
	@RequestMapping("/")
	public String home(){
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model model) {
		java.util.Date newDate = new java.util.Date();
		SimpleDateFormat dayNameFormat = new SimpleDateFormat("EEEE, d MMM yyyy");
		String strDayName = dayNameFormat.format(newDate);
		model.addAttribute("Date", strDayName);
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		java.util.Date newDate = new java.util.Date();
		SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
		String strTime = timeFormat.format(newDate);
		model.addAttribute("Time", strTime);
		return "time.jsp";
	}
	
}
