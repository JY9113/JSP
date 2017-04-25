package edu.spring.ex01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController2 {
	private static final Logger logger = LoggerFactory.getLogger(SampleController2.class);
	
	@RequestMapping(value="/test1")
	public String test1(Model model, String username) {
		logger.info("test1() 호출 : username = " + username);
		model.addAttribute("username", username);
		return "param-test";
	}
	
	@RequestMapping(value="/test2")
	public String test2(Model model, int age){
		logger.info("test2() 호출 : age = " + age);
		model.addAttribute("age", age);
		return "param-test";
	}
	
	@RequestMapping(value="/test3")
	public String test3(Model model, String username, int age){
		logger.info("test3()호출 : username = " + username + " age = " + age);
		model.addAttribute("username", username);
		model.addAttribute("age", age);
		return "param-test";
	}
	
}
