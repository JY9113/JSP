package edu.spring.ex02.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import edu.spring.ex02.domain.BoardVO;
import edu.spring.ex02.pageutil.PageCriteria;
import edu.spring.ex02.persistence.BoardDAO;

//@Component
@Service
// ������ �����ӿ�ũ���� ���� ����(Service/Business layer)��
// ������Ʈ���� �˷��ִ� ������̼�
public class BoardServiceImple implements BoardService {

	private static final Logger logger =
			LoggerFactory.getLogger(BoardServiceImple.class);
	
	@Autowired
	private BoardDAO dao;
	
	@Override
	public int create(BoardVO vo) {
		logger.info("create() ȣ��");
		return dao.insert(vo);
	}

	@Override
	public List<BoardVO> read() {
		logger.info("read() ȣ��");
		return dao.select();
	}

	@Override
	public BoardVO read(int bno) {
		logger.info("read() ȣ��: bno=" + bno);
		return dao.select(bno);
	}

	@Override
	public int update(BoardVO vo) {
		logger.info("update() ȣ��");
		return dao.update(vo);
	}

	@Override
	public int delete(int bno) {
		logger.info("delete() ȣ��");
		return dao.delete(bno);
	}

	@Override
	public int getTotalNumsOfRecords() {
		return dao.getTotalNumsOfRecords();
	}
	
	@Override
	public List<BoardVO> read(PageCriteria criteria) {
		return dao.select(criteria);
	}
	
} // end class BoardServiceImple





