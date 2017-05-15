package edu.spring.ex04.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
	
	private static final Logger logger =
			LoggerFactory.getLogger(BoardController.class);

	@RequestMapping(value = "/list",
			method = RequestMethod.GET)
	public void list() {
		logger.info("list() ȣ��");
		
		// �Խ����� ��ü ��� �˻� -> Model�� ���� -> View ����
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void register() {
		logger.info("register();ȣ��");
	}
	
	@RequestMapping(value="/test", method = RequestMethod.GET)
	public void test(String data1, String data2, Model model) {
		logger.info("test(); ȣ��");
		model.addAttribute("data1", data1);
		model.addAttribute("data2", data2);
	}
	
} // end class BoardController


















