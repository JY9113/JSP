package project.spring.together.service;

import java.util.List;

import project.spring.together.domain.ChatVO;

public interface ChatService {
	public abstract int createChat(ChatVO vo);
	List<ChatVO> read(String team_name);

}
