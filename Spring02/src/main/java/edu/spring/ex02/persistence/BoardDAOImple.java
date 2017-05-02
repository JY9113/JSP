package edu.spring.ex02.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.ex02.domain.BoardVO;
import edu.spring.ex02.pageutil.PageCriteria;

@Repository // @Component
// 영속 계층(Persistence Layer)의  DB 관련 기능을 담당하는
// Spring component bean으로 등록함
// 스프링 프레임워크가 bean으로 생성하기 위해서는
// root-context.xml에서 bean으로 등록해야 함
// <context:component-scan ... />
public class BoardDAOImple implements BoardDAO {

	private static final String NAMESPACE = "edu.spring.ex02.BoardMapper";
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOImple.class);
	
	// MyBatis의 SqlSession을 사용하기 위해서
	// 스프링 프레임워크가 생성한 bean을 주입(injection)받음
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<BoardVO> select() {
		logger.info("select() 호출");
		
		return sqlSession.selectList(NAMESPACE + ".select_all");
	}

	@Override
	public BoardVO select(int bno) {
		logger.info("select() 호출: bno=" + bno);
		return sqlSession.selectOne(NAMESPACE + ".select_by_bno", bno);
	}
	
	@Override
	public List<BoardVO> select(String userid) {
		userid = "%" + userid + "%";
		return sqlSession.selectList(NAMESPACE + ".select_by_userid", userid);
	}
	
	@Override
	public int insert(BoardVO vo) {
		logger.info("insert() 호출");
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}
	
	@Override
	public int update(BoardVO vo) {
		logger.info("update() 호출: bno=" + vo.getBno());
		return sqlSession.update(NAMESPACE + ".update", vo);
	}
	
	@Override
	public int delete(int bno) {
		logger.info("delete() 호출: bno=" + bno);
		return sqlSession.delete(NAMESPACE + ".delete", bno);
	}
	
	@Override
	public List<BoardVO> selectByTitleOrContent(String keyword) {
		logger.info("selectByTitleOrContent() 호출: keyword=" + keyword);
//		String key = "%" + keyword + "%";
//		Map<String, String> args = new HashMap<>();
//		args.put("keyword", key);
		String args = "%" + keyword + "%";
		
		return sqlSession.selectList(NAMESPACE + ".select_by_title_content", args);
	}

	@Override
	public int getTotalNumsOfRecords() {
		return sqlSession.selectOne(NAMESPACE + ".total_count");
	}

	@Override
	public List<BoardVO> select(PageCriteria criteria) {
//		Map<String, Integer> args = new HashMap<>();
//		args.put("start", start);
//		args.put("end", end);
		// map 을 쓸때는 파라미터에 int start, int end
		
		return sqlSession.selectList(NAMESPACE + ".paging", criteria);
	}
} // end class BoardDAOImple












