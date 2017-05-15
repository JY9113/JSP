package edu.spring.ex03;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.spring.ex03.domain.ReplyVO;
import edu.spring.ex03.persistence.ReplyDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class ReplyDAOTest {
	
	private static final Logger logger = LoggerFactory.getLogger(ReplyDAOTest.class);
	
	@Autowired
	private ReplyDAO dao;
	
	@Test
	public void doTest() {
//		testInsert();
//		testSelectByBno();
//		testUpdate();
		testDelete();
	}
	
	private void testInsert() {
		ReplyVO vo = new ReplyVO(0, 1, "first reply", "1_replier", null);
		int result = dao.insert(vo);
		logger.info("insert result : "  + result);
	}
	
	private void testSelectByBno() {
		List<ReplyVO> list = dao.select(2);
		for(ReplyVO vo : list) {
			logger.info(vo.getRno() + " : " + vo.getBno() + " : " + vo.getRtext());
		}
	}
	
	private void testUpdate() {
		ReplyVO vo = new ReplyVO();
		vo.setRno(1);
		vo.setRtext("¼öÁ¤µÈ ´ñ±Û");
		int result = dao.update(vo);
		logger.info("update result : " + result);
	}
	
	private void testDelete() {
		int result = dao.delete(1);
		logger.info("delete result : " + result);
	}
}
