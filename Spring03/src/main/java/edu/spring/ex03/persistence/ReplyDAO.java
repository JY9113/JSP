package edu.spring.ex03.persistence;

import java.util.List;

import edu.spring.ex03.domain.ReplyVO;

public interface ReplyDAO {
	
	int insert(ReplyVO vo);
	List<ReplyVO> select(int bno);
	int update(ReplyVO vo);
	int delete(int rno);
	int getBno(int rno);
	
} // end interface ReplyDAO






