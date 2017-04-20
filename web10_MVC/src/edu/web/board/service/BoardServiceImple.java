package edu.web.board.service;

import java.util.ArrayList;
import java.util.List;

import edu.web.board.domain.BoardVO;
import edu.web.board.persistence.BoardDAO;
import edu.web.board.persistence.BoardDAOImple;

public class BoardServiceImple implements BoardService {

	// Singleton ������ ����
	private static BoardServiceImple instance;
	private BoardDAO dao;
	private BoardServiceImple() {
		dao = BoardDAOImple.getInstance();
		
	}
	
	public static BoardServiceImple getInstance() {
		if (instance == null) {
			instance = new BoardServiceImple();
		}
		
		return instance;
	}
	
	@Override
	public List<BoardVO> read() {
		System.out.println("BoardService.read() ȣ��");
		
		// DAO ��ü�� select �޼ҵ带 ȣ���ؼ� ArrayList�� ����
		List<BoardVO> list = dao.select();	
		
		return list;
	}
	
	@Override
	public int create(BoardVO vo) {
		System.out.println("BoardService.create() ȣ��");
		
		return dao.insert(vo);
	}
	
	@Override
	public BoardVO read(int bno) {
		System.out.println("BoardService.read(int bno) ȣ��");
				
		return dao.selectByBNO(bno);
	}

	@Override
	public int update(BoardVO vo) {
		System.out.println("BoardService.update(vo) ȣ��");
		
		return dao.update(vo);
	}
	
	@Override
	public int delete(int bno) {
		return dao.delete(bno);
	}
}
