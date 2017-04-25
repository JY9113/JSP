package edu.spring.ex01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// POJO : Plain Old Java Object
@Controller
// servlet-context.xml 파일에서
//	component-scanning의 대상으로 만들어 주는 어노테이션
// @Component 어노테이션을 사용해도 됨
public class SampleController1 {
	private static final Logger logger = LoggerFactory.getLogger(SampleController1.class);
	
	// context root 다음에 sample1을 치면 GET 방식으로 sample1()을 Handler Mappings에 등록
	
	//@RequestMapping 이라는 annotation 은 컨트롤러의 URL 매핑과 메소드(GET/POST)를 설정
	// value : URL 매핑
	// method : 요청 방식(GET, POST)
	// method 속성을 생략하면 GET/POST 모두 처리 가능
	@RequestMapping(value = "/sample1", method = RequestMethod.GET)
	public String sample1() {
		logger.info("sample1() 호출");
		// 컨트롤러 메소드 return 값의 의미 : 
		// ViewResolver에게 실제 View를 결정하도록(찾도록) : return 값을 가지고 jsp 를 찾는다
		// return 타입이 void 인 경우는 URL 매핑을 통해서 View를 찾음
		return "sample1";
	}
	
	// method가 없으므로 GET/POST 둘다 가능
	// 컨텍스트 루트 뒤에 sample2를 호출하면 sample2()를 호출해주세요
	// void인 경우에는 urlMapping으로 찾는다 /src/WEB-INF/views 밑에 sample2.jsp를 찾는다
	@RequestMapping(value = "/sample2")
	public void sample2() {
		logger.info("sample2() 호출");
	}
}
