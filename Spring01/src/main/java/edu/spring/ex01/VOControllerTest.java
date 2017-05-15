package edu.spring.ex01;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.queryParam;

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
@WebAppConfiguration
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})

public class VOControllerTest {

	@Autowired
	private WebApplicationContext wac;
	private MockMvc mock;
	
	private static final Logger logger = LoggerFactory.getLogger(VOControllerTest.class);
	
	@Before
	public void beforeTest(){
		logger.info("beforeTest(); »£√‚");
		logger.info("wac : " + wac);
		logger.info("mock : " + mock);
		
		mock = MockMvcBuilders.webAppContextSetup(wac).build();				
	}
	
	@Test
	public void test() {
		RequestBuilder req = MockMvcRequestBuilders.post("/product2").param("pname", "apple").param("price", "10000");
		try {
			mock.perform(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}
	
	@After
	public void afterTest(){
		
	}
}
