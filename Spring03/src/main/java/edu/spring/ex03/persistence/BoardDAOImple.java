package edu.spring.ex03.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.ex03.domain.BoardVO;
import edu.spring.ex03.pageutil.PageCriteria;


@Repository // @Component
// ���� ����(Persistence Layer)��  DB ���� ����� ����ϴ�
// Spring component bean���� �����
// ������ �����ӿ�ũ�� bean���� �����ϱ� ���ؼ���
// root-context.xml���� bean���� ����ؾ� ��
// <context:component-scan ... />
public class BoardDAOImple implements BoardDAO {

	private static final String NAMESPACE =
			"edu.spring.ex03.BoardMapper";
	private static final Logger logger =
			LoggerFactory.getLogger(BoardDAOImple.class);
	
	// MyBatis�� SqlSession�� ����ϱ� ���ؼ�
	// ������ �����ӿ�ũ�� ������ bean�� ����(injection)����
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<BoardVO> select() {
		logger.info("select() ȣ��");
		
		return sqlSession.selectList(NAMESPACE + ".select_all");
	}

	@Override
	public BoardVO select(int bno) {
		logger.info("select() ȣ��: bno=" + bno);
		return sqlSession.selectOne(NAMESPACE + ".select_by_bno", bno);
	}
	
	@Override
	public List<BoardVO> select(String userid) {
		userid = "%" + userid + "%";
		return sqlSession.selectList(NAMESPACE + ".select_by_userid", userid);
	}
	
	@Override
	public int insert(BoardVO vo) {
		logger.info("insert() ȣ��");
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}
	
	@Override
	public int update(BoardVO vo) {
		logger.info("update() ȣ��: bno=" + vo.getBno());
		return sqlSession.update(NAMESPACE + ".update", vo);
	}
	
	@Override
	public int delete(int bno) {
		logger.info("delete() ȣ��: bno=" + bno);
		return sqlSession.delete(NAMESPACE + ".delete", bno);
	}
	
	@Override
	public List<BoardVO> selectByTitleOrContent(String keyword) {
		logger.info("selectByTitleOrContent() ȣ��: keyword=" + keyword);
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
		return sqlSession.selectList(NAMESPACE + ".paging", criteria);
	}
	
	@Override
	public int updateReplyCnt(int amount, int bno) {
		Map<String, Integer> args = new HashMap<>();
		args.put("amount", amount);
		args.put("bno", bno);
		
		return sqlSession.update(NAMESPACE + ".update_replycnt", args);
	}
} // end class BoardDAOImple












