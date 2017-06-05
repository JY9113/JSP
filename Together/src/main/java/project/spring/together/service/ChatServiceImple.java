package project.spring.together.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.spring.together.domain.ChatVO;
import project.spring.together.persistence.ChatDAO;

@Service
public class ChatServiceImple implements ChatService {
	
	private static final Logger logger = LoggerFactory.getLogger(ChatServiceImple.class);
	
	@Autowired
	private ChatDAO chatDao;
	
	@Override
	public int createChat(ChatVO vo) {
		logger.info("Service createChat 호출");
		return chatDao.createChat(vo);		
	}
	
	
	@Override
	public List<ChatVO> read(String team_name) {
		List<ChatVO> list = null;
		return list;
	}


}
