package edu.spring.ex03.service;

import java.util.List;

import edu.spring.ex03.domain.ReplyVO;

// CRUD(Create, Read, Update, Delete)
public interface ReplyService {

	int create(ReplyVO vo);
	List<ReplyVO> read(int bno);
	int update(ReplyVO vo);
	int delete(int rno);
	
} // end interface ReplyService





