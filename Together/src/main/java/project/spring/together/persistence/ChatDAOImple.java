package project.spring.together.persistence;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.spring.together.domain.ChatVO;

@Repository
public class ChatDAOImple implements ChatDAO {
	private static final Logger logger = LoggerFactory.getLogger(ChatDAOImple.class);
	private static final String NAMESPACE = "project.spring.together.ChatMapper";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int createChat(ChatVO vo) {
		logger.info("createChat()");
		return sqlSession.insert(NAMESPACE + ".insert_chat", vo);		
	}
}
