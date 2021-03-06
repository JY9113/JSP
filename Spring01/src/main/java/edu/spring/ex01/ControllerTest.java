package edu.spring.ex01;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
// JUnit 테스트 클래스를 실행시킬 환경(클래스)
@WebAppConfiguration
// 웹 애플리케이션의 환경 설정 정보(예 : web.xml)을 사용함
@ContextConfiguration( locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
// 애플리케이션, 서브릿 컨텍스트(환경설정)을 사용함
public class ControllerTest {
	// @Inject : Java에서 DI(Dependency Injection?) 제공하는 annotation
	// @Autowired : spring에서 DI 기능을 제공하기 위한 annotation
	// 같은 기능
	
	
	@Autowired
	// 스프링 프레임워크에서 객체를 생성해서 주입(injection)하라고 설정
	private WebApplicationContext wac;
	
	// MVC 패턴의 앱을 테스트하는 mock-up 객체
	private MockMvc mock;

	
	private static final Logger logger = LoggerFactory.getLogger(ControllerTest.class);
	
	@Before
	// 실제 JUnit 테스트를 실행하기 전에 초기화 작업을 수행하는 메소드
	public void beforeTest() {
		logger.info("beforeTest 호출");
		logger.info("wac : " + wac);
		logger.info("mock : " + mock);
		// 컨트롤러 메소드에게 요청을 보낼 수 있는 mockup 객체 생성
		mock = MockMvcBuilders.webAppContextSetup(wac).build();
		// 실제 테스트를 수행하는 곳에서 mock-up 객체 사용
	}
	
	@Test
	// JUnit 테스트를 수행하는 메소드
	public void testSample2() {
		logger.info("testSample2 호출");
		// MockMvc 객체를 사용해서 컨트롤러 메소드에게
		// GET 또는 POST 리퀘스트(요청)를 전달
		RequestBuilder req = MockMvcRequestBuilders.post("/test3").param("username",  "Admin").param("age", "11");
		try {
			mock.perform(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	@After
	// JUnit 테스트 수행 후 호출되는 메소드
	public void afterTest() {
		logger.info("afterTest 호출");
	}
	
}
