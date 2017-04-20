package edu.web.board.service;

import java.util.List;

import edu.web.board.domain.BoardVO;


// CRUD(Create, Read, Update, Delete)�� �̿���
// ����Ͻ� ����(���� �帧)�� ����
public interface BoardService {
	
	public abstract List<BoardVO> read();	
	public abstract int create(BoardVO vo);
	public abstract BoardVO read(int bno);
	public abstract int update(BoardVO vo);
	public abstract int delete(int bno);
}
