package edu.spring.ex01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.spring.ex01.domain.ProductVO;

@Controller
public class SampleJsonController {
	private static final Logger logger = LoggerFactory.getLogger(SampleJsonController.class);
	
	@RequestMapping(value="/json1")
	public String testJson1() {
		logger.info("testJSon1(); 호출");
		return "sample1";
	}
	
	@RequestMapping(value="/json2")
	@ResponseBody public String testJSon2() {
		logger.info("testJson2(); 호출");
		return "sample1";
	}
	
	// @ResponseBody : 
	// 컨트롤러 메소드가 리턴하는 값을 응답(response) body 에 실어서 보내주라는 설정
	// JSP(view)를 거치지 않고 바로 클라이언트에게 전달됨
	
	@RequestMapping(value="/json3")
	@ResponseBody public ProductVO testJson3() {
		logger.info("testJson3(); 호출");
		return new ProductVO("축구공", 15000);
	}
}
