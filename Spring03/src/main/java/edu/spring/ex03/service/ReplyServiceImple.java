package edu.spring.ex03.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.ex03.domain.ReplyVO;
import edu.spring.ex03.persistence.BoardDAO;
import edu.spring.ex03.persistence.ReplyDAO;

@Service
public class ReplyServiceImple implements ReplyService {

	@Autowired
	private ReplyDAO replyDao;
	@Autowired
	private BoardDAO boardDao;
	
	@Override
	public int create(ReplyVO vo) {
		int result = replyDao.insert(vo);
		if (result == 1) {
			result = boardDao.updateReplyCnt(1, vo.getBno());
		}
		
		return result; 
	}

	@Override
	public List<ReplyVO> read(int bno) {
		return replyDao.select(bno);
	}

	@Override
	public int update(ReplyVO vo) {
		return replyDao.update(vo);
	}

	@Override
	public int delete(int rno) {
		int bno = replyDao.getBno(rno);
		int result = replyDao.delete(rno);
		if (result == 1) {
			result = boardDao.updateReplyCnt(-1, bno);
		}
		
		return result;
	}

} // end class ReplyServiceImple














