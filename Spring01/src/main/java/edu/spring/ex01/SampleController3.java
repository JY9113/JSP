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
	
	
    // �޼ҵ� �ϳ��� a, b, c ��� url�� ó���� ���� ������
    // url �� ������ �޼ҵ� �̸��� �ٸ��� ���� ���� ����. 
	@RequestMapping(value="/test4")
	public String test4(@ModelAttribute(name="username") String username) {
		logger.info("test4() ȣ��");
		return "param-test";
	}
	
	@RequestMapping(value="/test5")
	public String test5(@ModelAttribute(name = "username") String username, @ModelAttribute(name="age") int age) {
		logger.info("test5() ȣ��");
		return "param-test";
	}
}


