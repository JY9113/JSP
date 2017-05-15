package edu.spring.ex04.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.ex04.domain.MemberVO;

@Repository
public class MemberDAOImple implements MemberDAO {

	private static final String NAMESPACE = "edu.spring.ex04.MemberMapper";
	
	@Autowired
	private SqlSession sqlSession;
		
	@Override
	public MemberVO loginCheck(MemberVO vo) {
		return sqlSession.selectOne(NAMESPACE + ".login", vo);
	}
}
