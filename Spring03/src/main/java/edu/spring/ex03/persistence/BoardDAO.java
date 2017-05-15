package edu.spring.ex03.persistence;

import java.util.List;

import edu.spring.ex03.domain.BoardVO;
import edu.spring.ex03.pageutil.PageCriteria;


public interface BoardDAO {

	public abstract List<BoardVO> select();
	public abstract BoardVO select(int bno);
	public abstract List<BoardVO> select(String userid);
	public abstract int insert(BoardVO vo);
	public abstract int update(BoardVO vo);
	public abstract int delete(int bno);
	public abstract List<BoardVO> selectByTitleOrContent(String keyword);
	public abstract int getTotalNumsOfRecords();
	public abstract List<BoardVO> select(PageCriteria criteria);
	public abstract int updateReplyCnt(int amount, int bno);
	
} // end interface BoardDAO








