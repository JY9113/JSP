package edu.spring.ex01;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//
//@Controller
//public class LoginController {
//	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
//	
//	@RequestMapping(value="/loginmain")
//	public String loginMain() {
//		return "login-form";
//	}
//	
//	@RequestMapping(value="/loginPOST", method=RequestMethod.POST)
//	public String loginPOST(@ModelAttribute(name="userid") String userid, @ModelAttribute(name="userpw") String userpw) {
//				
//		return "loginPOST";
//		
//	}
//}

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginGET() {
		logger.info("loginGET(); 호출");
		return "login-form";
	}
	
	@RequestMapping(value="/loginPOST", method=RequestMethod.POST)
	public String loginPOST(@ModelAttribute(name="userid") String userid, @ModelAttribute(name="userpw") String userpw) {
		logger.info("loginPOST(); 호출");
		return "loginPOST";
	}
}