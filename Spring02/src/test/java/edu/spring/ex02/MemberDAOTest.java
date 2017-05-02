package edu.spring.ex02;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.spring.ex02.domain.MemberVO;
import edu.spring.ex02.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MemberDAOTest {
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOTest.class);
	
	@Autowired
	private MemberDAO dao;
	
	@Test
	public void testMemberDAO() {
//		testSelectAll();	
//		testSelectByid();
//		testInsert();
		testUpdate();
	}
	
	private void testSelectAll() {
		List<MemberVO> list = dao.select_all();
		for(MemberVO vo : list){
			logger.info("���̵� : " + vo.getUserid() + "  ��й�ȣ : " + vo.getPwd() + "  �̸��� : " + vo.getEmail() + " ���� : " + vo.getActive());
		}
	}
	
	private void testSelectByid() {
		MemberVO vo = dao.select_by_id("admin");
		if (vo != null) {
			logger.info(vo.getUserid() + " : " + vo.getPwd() + " : " + vo.getEmail() + " : " + vo.getActive());
		}
	}
	
	private void testInsert() {
		MemberVO vo = new MemberVO("jy", "1111", "jy@edu.com", null);
		int result = dao.insert(vo);
		if(result == 1) {
			logger.info("��� insert�� �����߽��ϴ�");
		} else {
			logger.info("��� insert�� �����߽��ϴ�");
		}		
	}
	
	private void testUpdate() {
		MemberVO vo = new MemberVO("jy", "1111", "jy@gmail.com", null);
		int result = dao.update(vo);
		if(result == 1) {
			logger.info("��� update�� �����߽��ϴ�");
		} else {
			logger.info("��� update�� �����߽��ϴ�");
		}
	}

}
