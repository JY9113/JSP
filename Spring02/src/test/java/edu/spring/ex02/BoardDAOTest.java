package edu.spring.ex02;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.spring.ex02.domain.BoardVO;
import edu.spring.ex02.pageutil.PageCriteria;
import edu.spring.ex02.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardDAOTest {
	private static final Logger logger =
			LoggerFactory.getLogger(BoardDAOTest.class);
	
	@Autowired
	private BoardDAO dao;
	
	@Test
	public void testDAO() {
//		testSelectAll();
//		testSelectByBno();
//		testInsert();
//		testSelectByUserId();
//		testUpdate();
//		testDelete();
//		testSelectByTitleOrContent();
//		testTotalNums();
		testPaging();
	}
	
	public void testSelectAll() {
		List<BoardVO> list = dao.select();
		for (BoardVO vo : list) {
			logger.info(vo.getBno() + " : " + vo.getTitle());
		}
	}
	
	public void testSelectByBno() {
		BoardVO vo = dao.select(1);
		if (vo != null) {
			logger.info(vo.getBno() + " : " + vo.getTitle());
		} else {
			logger.info("검색 결과 없음");
		}
	}
	
	public void testInsert() {
		BoardVO vo = new BoardVO(0, 
				"Spring-MyBatis 테스트", 
				"Spring-MyBatis 테스트",
				"admin",
				null);
		int result = dao.insert(vo);
		if (result == 1) {
			logger.info("insert 성공");
		} else {
			logger.info("insert 실패");
		}
	}

	public void testSelectByUserId() {
		List<BoardVO> list = dao.select("dmi");
		for (BoardVO vo : list) {
			logger.info(vo.getBno() + " : " + vo.getUserid());
		}
	}
	
	public void testUpdate() {
		BoardVO vo = new BoardVO(100, 
				"Spring-MyBatis 수정 테스트", 
				"Spring-MyBatis 수정 테스트", 
				null, null);
		int result = dao.update(vo);
		if (result == 1) {
			logger.info("수정 성공");
		} else {
			logger.info("수정 실패");
		}
	}
	
	public void testDelete() {
		int result = dao.delete(100);
		if (result == 1) {
			logger.info("삭제 성공");
		} else {
			logger.info("삭제 실패");
		}
	}
	
	public void testSelectByTitleOrContent() {
		List<BoardVO> list = dao.selectByTitleOrContent("안녕");
		for (BoardVO vo : list) {
			logger.info(vo.getTitle() + " : " + vo.getContent());
		}
	}
	
	public void testTotalNums() {
		int result = dao.getTotalNumsOfRecords();
		logger.info("# of records : " + result);
	}
	
	public void testPaging() {
		PageCriteria c = new PageCriteria(1,10);
		List<BoardVO> list = dao.select(c);
		for (BoardVO vo : list) {
			logger.info(vo.getBno() + " : " +  vo.getTitle());
		}
	}
} // end class BoardDAOTest













