package com.codingdojo.survey;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class survey {
	private String[] getLanguages() {
		return new String[] {
				"C#","Java","PHP","Python"
		};
	}
	
	private String[] getLocations() {
		return new String[] {
				"San Jose","New York","Dallas","Ramallah","Chicago"	
		};
	}
	
	@RequestMapping("")
	public String info(Model model) {
		model.addAttribute("languages", getLanguages());
		model.addAttribute("locations", getLocations());
		return "index.jsp";
	}

	@RequestMapping(value="/result",method = RequestMethod.POST)
	public String result(@RequestParam(value="name") String name,
							@RequestParam(value="location") String location,
							@RequestParam(value="language") String language,
							@RequestParam(value="comment", required=false) String comment, Model model) {
		model.addAttribute("result", new SurveyDojo(name,location,language,comment));
		return "result.jsp";
	}
}
