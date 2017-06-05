package project.spring.together.persistence;

import project.spring.together.domain.ChatVO;

public interface ChatDAO {
	
	int createChat(ChatVO vo);

}
