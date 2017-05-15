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
		logger.info("testJSon1(); ȣ��");
		return "sample1";
	}
	
	@RequestMapping(value="/json2")
	@ResponseBody public String testJSon2() {
		logger.info("testJson2(); ȣ��");
		return "sample1";
	}
	
	// @ResponseBody : 
	// ��Ʈ�ѷ� �޼ҵ尡 �����ϴ� ���� ����(response) body �� �Ǿ �����ֶ�� ����
	// JSP(view)�� ��ġ�� �ʰ� �ٷ� Ŭ���̾�Ʈ���� ���޵�
	
	@RequestMapping(value="/json3")
	@ResponseBody public ProductVO testJson3() {
		logger.info("testJson3(); ȣ��");
		return new ProductVO("�౸��", 15000);
	}
}
