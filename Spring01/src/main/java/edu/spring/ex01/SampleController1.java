package edu.spring.ex01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// POJO : Plain Old Java Object
@Controller
// servlet-context.xml ���Ͽ���
//	component-scanning�� ������� ����� �ִ� ������̼�
// @Component ������̼��� ����ص� ��
public class SampleController1 {
	private static final Logger logger = LoggerFactory.getLogger(SampleController1.class);
	
	// context root ������ sample1�� ġ�� GET ������� sample1()�� Handler Mappings�� ���
	
	//@RequestMapping �̶�� annotation �� ��Ʈ�ѷ��� URL ���ΰ� �޼ҵ�(GET/POST)�� ����
	// value : URL ����
	// method : ��û ���(GET, POST)
	// method �Ӽ��� �����ϸ� GET/POST ��� ó�� ����
	@RequestMapping(value = "/sample1", method = RequestMethod.GET)
	public String sample1() {
		logger.info("sample1() ȣ��");
		// ��Ʈ�ѷ� �޼ҵ� return ���� �ǹ� : 
		// ViewResolver���� ���� View�� �����ϵ���(ã����) : return ���� ������ jsp �� ã�´�
		// return Ÿ���� void �� ���� URL ������ ���ؼ� View�� ã��
		return "sample1";
	}
	
	// method�� �����Ƿ� GET/POST �Ѵ� ����
	// ���ؽ�Ʈ ��Ʈ �ڿ� sample2�� ȣ���ϸ� sample2()�� ȣ�����ּ���
	// void�� ��쿡�� urlMapping���� ã�´� /src/WEB-INF/views �ؿ� sample2.jsp�� ã�´�
	@RequestMapping(value = "/sample2")
	public void sample2() {
		logger.info("sample2() ȣ��");
	}
}
