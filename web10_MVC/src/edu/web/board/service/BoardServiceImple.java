package edu.web.board.service;

import java.util.ArrayList;
import java.util.List;

import edu.web.board.domain.BoardVO;
import edu.web.board.persistence.BoardDAO;
import edu.web.board.persistence.BoardDAOImple;

public class BoardServiceImple implements BoardService {

	// Singleton 디자인 패턴
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
		System.out.println("BoardService.read() 호출");
		
		// DAO 객체의 select 메소드를 호출해서 ArrayList를 생성
		List<BoardVO> list = dao.select();	
		
		return list;
	}
	
	@Override
	public int create(BoardVO vo) {
		System.out.println("BoardService.create() 호출");
		
		return dao.insert(vo);
	}
	
	@Override
	public BoardVO read(int bno) {
		System.out.println("BoardService.read(int bno) 호출");
				
		return dao.selectByBNO(bno);
	}

	@Override
	public int update(BoardVO vo) {
		System.out.println("BoardService.update(vo) 호출");
		
		return dao.update(vo);
	}
	
	@Override
	public int delete(int bno) {
		return dao.delete(bno);
	}
}
