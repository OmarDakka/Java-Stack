package com.codingdojo.thecode;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SecretCode {

	@RequestMapping("")
	public String code() {
		return "home.jsp";
	}
	
	@RequestMapping(value="/code", method= RequestMethod.POST)
		public String secret(@RequestParam(value="code") String code) {
		if (code.equals("bushido")) {
			return "code.jsp";			
		} else {
			return "redirect:/createError";
		}
	}
	
	@RequestMapping("/createError")
    public String flashMessages(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("error", "You must train harder!");
        return "redirect:/";
    }
}
