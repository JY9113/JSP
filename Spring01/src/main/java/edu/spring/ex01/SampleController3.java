package edu.spring.ex01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController3 {
	private static final Logger logger = LoggerFactory.getLogger(SampleController3.class);
	
	
    // 메소드 하나가 a, b, c 라는 url을 처리할 수는 있으나
    // url 이 같은데 메소드 이름을 다르게 만들 수는 없다. 
	@RequestMapping(value="/test4")
	public String test4(@ModelAttribute(name="username") String username) {
		logger.info("test4() 호출");
		return "param-test";
	}
	
	@RequestMapping(value="/test5")
	public String test5(@ModelAttribute(name = "username") String username, @ModelAttribute(name="age") int age) {
		logger.info("test5() 호출");
		return "param-test";
	}
}


