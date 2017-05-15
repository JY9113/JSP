package edu.spring.ex03.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.ex03.domain.ReplyVO;

@Repository
public class ReplyDAOImple implements ReplyDAO {

	private static final String NAMESPACE =
			"edu.spring.ex03.ReplyMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(ReplyVO vo) {
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public List<ReplyVO> select(int bno) {
		return sqlSession.selectList(NAMESPACE + ".select_by_bno", bno);
	}
	
	@Override
	public int update(ReplyVO vo) {
		return sqlSession.update(NAMESPACE + ".update", vo);
	}
	
	@Override
	public int delete(int rno) {
		return sqlSession.delete(NAMESPACE + ".delete", rno);
	}
	
	@Override
	public int getBno(int rno) {
		return sqlSession.selectOne(NAMESPACE + ".get_bno", rno);
	}
} // end class ReplyDAOImple










