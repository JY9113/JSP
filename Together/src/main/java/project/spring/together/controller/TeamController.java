package project.spring.together.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller 
@RequestMapping(value = {"/team"})
public class TeamController {

	@RequestMapping(value="/team_main", method=RequestMethod.GET)
	public void teamMain(){
		
	}
}
